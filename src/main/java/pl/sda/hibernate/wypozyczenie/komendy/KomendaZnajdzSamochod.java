package pl.sda.hibernate.wypozyczenie.komendy;

import pl.sda.hibernate.wypozyczenie.database.DataAccessObject;
import pl.sda.hibernate.wypozyczenie.model.Samochod;

import java.util.Optional;

public class KomendaZnajdzSamochod implements Komenda {

    private DataAccessObject<Samochod> dao = new DataAccessObject<Samochod>();

    @Override
    public String getKomenda() {
        return "znajdz samochod";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id samochodu, ktory chcesz znalezc ");
        Long id = Long.parseLong(Komenda.scanner.nextLine());

        Optional<Samochod> samochod = dao.find(Samochod.class, id);
        samochod.ifPresent(System.out::println);

    }
}
