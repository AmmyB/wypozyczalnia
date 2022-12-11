package pl.sda.hibernate.wypozyczenie.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Klient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imie;
    private String nazwisko;
    private String nip;

    @OneToMany(mappedBy = "klient")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<Wypozyczenie> wypozyczenia;
}
