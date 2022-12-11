package pl.sda.hibernate.wypozyczenie.komendy;

import pl.sda.hibernate.wypozyczenie.database.DataAccessObject;
import pl.sda.hibernate.wypozyczenie.model.Klient;

import java.util.List;

public class KomendaListaKlient implements Komenda{

    private DataAccessObject<Klient> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "Lista klient"; // co musimy wpisac, aby wyswietlilc komnde
    }

    @Override
    public void obsluga() {
        List<Klient> klienci = dao.findAll(Klient.class);
        klienci.forEach(System.out::println);
    }
}
