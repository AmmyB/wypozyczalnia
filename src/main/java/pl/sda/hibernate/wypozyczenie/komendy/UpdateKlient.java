package pl.sda.hibernate.wypozyczenie.komendy;

import pl.sda.hibernate.wypozyczenie.database.DataAccessObject;
import pl.sda.hibernate.wypozyczenie.model.Klient;

public class UpdateKlient implements Komenda{

    private DataAccessObject<Klient> dao = new DataAccessObject<>();
    @Override
    public String getKomenda() {
        return "update klient";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id klienta, dla ktorego chcesz zrobic update");
        Long id = Long.parseLong(Komenda.scanner.nextLine());

        System.out.println("Podaj imie");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj nazwisko");
        String nazwisko = Komenda.scanner.nextLine();

        System.out.println("Podaj nip");
        String nip = Komenda.scanner.nextLine();

        Klient klient = Klient.builder()
                .imie(imie)
                .nazwisko(nazwisko)
                .nip(nip)
                .id(id)
                .build();

        dao.update(Klient.class, id, klient);
    }
}
