package pl.sda.hibernate.wypozyczenie.komendy;

import pl.sda.hibernate.wypozyczenie.database.DataAccessObject;
import pl.sda.hibernate.wypozyczenie.model.Samochod;

public class KomendaDodajSamochod implements Komenda {

    private DataAccessObject<Samochod> dao = new DataAccessObject<Samochod>();

    @Override
    public String getKomenda() {
        return "dodaj samochod";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj marke");
        String marka = Komenda.scanner.nextLine();

        System.out.println("Podaj model");
        String model = Komenda.scanner.nextLine();

        System.out.println("Podaj numer rejestracyjny");
        String nr_rej = Komenda.scanner.nextLine();

        System.out.println("Podaj ilosc miejsc");
        String ilosc_miejscs = Komenda.scanner.nextLine();
        Integer ilosc_miejsc = Integer.parseInt(ilosc_miejscs);

        Samochod samochod = Samochod.builder()
                .marka(marka)
                .model(model)
                .nr_rej(nr_rej)
                .ilosc_miejsc(ilosc_miejsc)
                .build();

        dao.insert(samochod);

    }
}
