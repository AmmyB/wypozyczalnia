package pl.sda.hibernate.wypozyczenie.komendy;

import pl.sda.hibernate.wypozyczenie.database.DataAccessObject;
import pl.sda.hibernate.wypozyczenie.model.Samochod;

import java.util.List;

public class KomedaListaSamochodow implements Komenda{

    private DataAccessObject<Samochod> dao = new DataAccessObject<Samochod>();

    @Override
    public String getKomenda() {
        return "Lista samochodow";
    }

    @Override
    public void obsluga() {

        List<Samochod> samochody = dao.findAll(Samochod.class);
        samochody.forEach(System.out::println);

    }
}
