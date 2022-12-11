package pl.sda.hibernate.wypozyczenie.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data // gettery settery, toString,
@Entity // informacja, dla hibernate ze to jest tabela
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Wypozyczenie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate data_wypozyczenia;

    private LocalDate data_koncowa;
    private String numer_umowy;
    private Double cena_wynajmu;


    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Samochod samochod;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Klient klient;

    @OneToOne(mappedBy = "wypozyczenie")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Zwrot zwrot;

}
