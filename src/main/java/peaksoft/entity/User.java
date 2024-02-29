package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(generator = "users_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "users_gen",
            sequenceName = "users_seq",
            allocationSize = 1
    )

    private Long id;
    private String user_name;
    private String password;
    private String email;
    private  int phone_number;


    //************   Follower  *******************//
    @OneToOne(cascade = {CascadeType.PERSIST,REMOVE})
    private  Follower follower;

    //************* UserInfo ******************//
    @OneToOne(cascade = {PERSIST,REMOVE,REFRESH},fetch = FetchType.EAGER)
    private  UserInfo userInfo;
    //************* Image ******************//
    @ManyToOne(cascade = PERSIST)
    private Image image;
    //************* Post ******************//
    @OneToMany(mappedBy = "user",cascade = {PERSIST,REMOVE,REFRESH},fetch = FetchType.EAGER)
    private List<Post> posts;

    //************* Comment ******************//
    @ManyToMany(cascade = {CascadeType.PERSIST,REMOVE,REFRESH},fetch = FetchType.EAGER)
    private List<Comment> comments;


    public void addComment(Comment comment) {
        if (this.comments == null) this.comments = new ArrayList<>();
        this.comments.add(comment);
    }
}
