package pl.sda.hibernate.wypozyczenie.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Samochod {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String marka;
    private String model;
    private String nr_rej;
    private Integer ilosc_miejsc;

    @OneToMany(mappedBy = "samochod")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<Wypozyczenie> wypozyczenia;
}
