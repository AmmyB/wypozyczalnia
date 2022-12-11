package pl.sda.hibernate.wypozyczenie.komendy;

import pl.sda.hibernate.wypozyczenie.database.DataAccessObject;
import pl.sda.hibernate.wypozyczenie.model.Klient;

public class KomendaCzyKlientIstnieje implements Komenda{

    private DataAccessObject<Klient> dao = new DataAccessObject<>();
    @Override
    public String getKomenda() {
        return "update klient";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id klienta");
        Long id = Long.parseLong(Komenda.scanner.nextLine());

        boolean exists = dao.exists(Klient.class, id);
        System.out.println(exists);
    }
}
