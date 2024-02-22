package peaksoft.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="images")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Image {
    @Id
    @GeneratedValue(generator = "images_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "images_gen",
            sequenceName = "images_seq",
            allocationSize = 1)
    private Long id;

    @Column(length = 10000)
    private String imageURL;

   //***************** User *********************//
    @OneToMany(mappedBy = "image")
    private List<User>  user;

    //***************** Post *********************//
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Post post;


}
