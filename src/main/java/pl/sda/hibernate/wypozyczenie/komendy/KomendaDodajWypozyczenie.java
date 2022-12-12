package pl.sda.hibernate.wypozyczenie.komendy;

import pl.sda.hibernate.wypozyczenie.database.DataAccessObject;
import pl.sda.hibernate.wypozyczenie.model.Klient;
import pl.sda.hibernate.wypozyczenie.model.Samochod;
import pl.sda.hibernate.wypozyczenie.model.Wypozyczenie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KomendaDodajWypozyczenie implements Komenda {

    private DataAccessObject<Wypozyczenie> daoWypozycz = new DataAccessObject<Wypozyczenie>();
    private DataAccessObject<Samochod> daoSamochod = new DataAccessObject<Samochod>();
    private DataAccessObject<Klient> daoKlient = new DataAccessObject<Klient>();

    @Override
    public String getKomenda() {
        return "dodaj wypozyczenie";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id klienta");
        Long idK = Long.parseLong(Komenda.scanner.nextLine());

        System.out.println("Podaj id samochodu");
        Long idS = Long.parseLong(Komenda.scanner.nextLine());

        if (daoKlient.exists(Klient.class, idK) && daoSamochod.exists(Samochod.class, idS)) {

            System.out.println("Podaj date koncowa dd/MM/yyyy");
            LocalDate datas = LocalDate.parse(Komenda.scanner.nextLine());
            String text = datas.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate data_wypozyczenia = LocalDate.parse(text);

            System.out.println("Podaj numer umowy");
            String numer_umowy = Komenda.scanner.nextLine();

            System.out.println("Podaj cene wynajmu");
            Double cena_wynajmu = Double.parseDouble(Komenda.scanner.nextLine());

            Wypozyczenie wypozyczenie = Wypozyczenie.builder()
                    .data_wypozyczenia(data_wypozyczenia)
                    .numer_umowy(numer_umowy)
                    .cena_wynajmu(cena_wynajmu)
                    .build();
        } else {
            System.out.println("Id klienta lub Id samochodu nie istnieje!");
        }

    }
}
