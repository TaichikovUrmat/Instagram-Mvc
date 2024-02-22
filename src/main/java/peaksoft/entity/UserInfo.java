package peaksoft.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_Info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class UserInfo {
    @Id
    @GeneratedValue(generator = "user_Info_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "user_Info_gen",
            sequenceName = "user_Info_seq",
            allocationSize = 1

    )
    private Long id;
    private String  fullName;
    private String biography; // биография
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(length = 1000)
    private String image; // изображение

 }
