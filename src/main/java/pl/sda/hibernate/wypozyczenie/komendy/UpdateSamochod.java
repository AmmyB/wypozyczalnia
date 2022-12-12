package pl.sda.hibernate.wypozyczenie.komendy;

import pl.sda.hibernate.wypozyczenie.database.DataAccessObject;
import pl.sda.hibernate.wypozyczenie.model.Samochod;

public class UpdateSamochod implements Komenda {

    private DataAccessObject<Samochod> dao = new DataAccessObject<Samochod>();

    @Override
    public String getKomenda() {
        return "update samochod";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id samochodu dla ktorego chcesz zrobic update");
        Long id = Long.parseLong(Komenda.scanner.nextLine());

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

        dao.update(Samochod.class, id, samochod);


    }
}
