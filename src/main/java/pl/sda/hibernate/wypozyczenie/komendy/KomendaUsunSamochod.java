package pl.sda.hibernate.wypozyczenie.komendy;

import pl.sda.hibernate.wypozyczenie.database.DataAccessObject;
import pl.sda.hibernate.wypozyczenie.model.Klient;
import pl.sda.hibernate.wypozyczenie.model.Samochod;

public class KomendaUsunSamochod implements Komenda{

    private DataAccessObject<Samochod> dao = new DataAccessObject<Samochod>();

    @Override
    public String getKomenda() {
        return "usun samochod";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id samochodu, ktory chcesz usunac");
        Long id = Long.parseLong(Komenda.scanner.nextLine());


        if (dao.delete(Samochod.class, id)){
            System.out.println("Poprawnie usunieto samochod");
        } else {
            System.out.println("Nie udalo sie usunac samochodu!");
        }


    }
}
