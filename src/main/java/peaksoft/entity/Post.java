package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name="posts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Post {
    @Id
    @GeneratedValue(generator = "posts_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "posts_gen",
            sequenceName = "posts_seq",
            allocationSize = 1)

    private Long id;
    private String title; // аталышы
    private String description;  // описание
    private LocalDate createdAt = LocalDate.now();


    //************* User ******************//
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private User user;


    //************* Image ******************//
   @OneToMany(mappedBy = "post",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Image> images;


    //************* Comment ******************//
    @OneToMany (mappedBy = "posts",cascade = {PERSIST},fetch = FetchType.EAGER)
    private List<Comment> comment;


    //************* Like ******************//
    @OneToMany(mappedBy = "posts",cascade = {PERSIST})
    private List<Like> likes;


    @Transient
    private String imageUrl;

    public void addImage(Image image){
        if (images == null)images = new ArrayList<>();
        images.add(image);
    }





    public void addComment(Comment comment) {
        if (this.comment == null) this.comment = new ArrayList<>();
        this.comment.add(comment);
    }
}
