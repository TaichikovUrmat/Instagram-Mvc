package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="followers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

//последователь
public class Follower {
    @Id
    @GeneratedValue(generator = "followers_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "followers_gen",
            sequenceName = "followers_seq",
            allocationSize = 1
    )
    private Long id;

    @ElementCollection
    private List<Long> subscribers;      //  подписчики
    @ElementCollection
    private List<Long>  subscriptions;   // Подписки

    @OneToOne(mappedBy = "follower",cascade = CascadeType.PERSIST)
    private User user;



}
