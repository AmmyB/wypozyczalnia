package pl.sda.hibernate.wypozyczenie.komendy;

import pl.sda.hibernate.wypozyczenie.database.DataAccessObject;
import pl.sda.hibernate.wypozyczenie.model.Klient;

public class KomendaUsunklient implements Komenda{

    private DataAccessObject<Klient> dao = new DataAccessObject<>();
    @Override
    public String getKomenda() {
        return "Usun klient";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id klienta, ktorego chcesz usunac");
        Long id = Long.parseLong(Komenda.scanner.nextLine());

        if (dao.delete(Klient.class, id)){
            System.out.println("Poprawnie usunieto klienta");
        } else {
            System.out.println("Nie udalo sie usunac klienta!");
        }
    }
}
