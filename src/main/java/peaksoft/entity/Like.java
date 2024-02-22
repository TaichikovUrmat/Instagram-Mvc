package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="likes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Like {
    @Id
    @GeneratedValue(generator = "likes_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "likes_gen",
            sequenceName = "likes_seq",
            allocationSize = 1
    )
    private Long id;
    private Boolean is_Like;

    //*************** Comment **********************//
    @ManyToOne
    private Comment comments;

    //*************** Post **********************// ;
    @ManyToOne
    private Post posts;




}
