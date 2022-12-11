package pl.sda.hibernate.wypozyczenie.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Zwrot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    private LocalDateTime data_czas_zwrotu;

    private String notatka;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Wypozyczenie wypozyczenie;

}
