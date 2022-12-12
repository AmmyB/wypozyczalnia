package pl.sda.hibernate.wypozyczenie;

import org.hibernate.Session;
import pl.sda.hibernate.wypozyczenie.database.HibernateUtil;
import pl.sda.hibernate.wypozyczenie.komendy.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Komenda> listaKomend = new ArrayList<>(List.of(

                new KomendaDodajKlient(),
                new KomendaListaKlient(),
                new KomendaZnajdzKlient(),
                new KomendaCzyKlientIstnieje(),
                new KomendaUsunklient(),
                new KomendaZnajdzKlient(),
                new UpdateKlient(),
                new KomendaDodajSamochod(),
                new KomedaListaSamochodow(),
                new UpdateSamochod(),
                new KomendaZnajdzSamochod(),
                new KomendaUsunSamochod(),
                new KomendaCzySamochodIstnieje(),
                new KomendaDodajWypozyczenie()


        ));

        String komenda;
        do {
            System.out.println("Lista dostępnych komend:");
            for (int i = 0; i < listaKomend.size(); i++) {
                System.out.println((i + 1) + ". " + listaKomend.get(i).getKomenda());
            }
            System.out.println("Podaj komende: ");
            komenda = Komenda.scanner.nextLine();
            for (Komenda dostepnaKomenda : listaKomend) {
                if (dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)) {
                    dostepnaKomenda.obsluga();
                }

            }

        } while (!komenda.equalsIgnoreCase("exit"));
    }
}
