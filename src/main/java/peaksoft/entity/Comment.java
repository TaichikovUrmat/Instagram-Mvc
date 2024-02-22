package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name="comments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Comment {
    @Id
    @GeneratedValue(generator = "comments_gen", strategy = SEQUENCE)
    @SequenceGenerator(
            name = "comments_gen",
            sequenceName = "comments_seq",
            allocationSize = 1
    )
    private Long id;
    private String comment;

    private LocalDate createdAt = LocalDate.now();;

    //**************** Post *************************//

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Post posts;

    //**************** User *************************//
    @ManyToMany(cascade = {PERSIST,REFRESH},fetch = FetchType.EAGER)
    private List<User>  users = new ArrayList<>();

    //**************** User *************************//
    @OneToMany(mappedBy = "comments")
    private List<Like> like;

}
