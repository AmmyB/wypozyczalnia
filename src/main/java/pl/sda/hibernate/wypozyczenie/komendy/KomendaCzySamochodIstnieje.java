package pl.sda.hibernate.wypozyczenie.komendy;

import pl.sda.hibernate.wypozyczenie.database.DataAccessObject;
import pl.sda.hibernate.wypozyczenie.model.Klient;
import pl.sda.hibernate.wypozyczenie.model.Samochod;

public class KomendaCzySamochodIstnieje  implements Komenda {


    private DataAccessObject<Samochod> dao = new DataAccessObject<Samochod>();

    @Override
    public String getKomenda() {
        return "czy samochod istnieje";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id samochodu");
        Long id = Long.parseLong(Komenda.scanner.nextLine());

        boolean exists = dao.exists(Samochod.class, id);
        System.out.println(exists);


    }
}
