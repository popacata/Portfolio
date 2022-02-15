import classes.Datasource;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        Scanner scanner = new Scanner(System.in);

//        System.out.println("Inroduceti un Proprietar:");
//        System.out.println("-nume:");
//        String nume = scanner.nextLine();
//        System.out.println("-prenume: ");
//        String prenume = scanner.nextLine();
//        System.out.println("-varsta:");
//        String varsta = scanner.nextLine();
//        System.out.println("-categorie permis:");
//        String permis = scanner.nextLine();
//        datasource.insertProprietar(nume,prenume,Integer.parseInt(varsta),permis.charAt(0));
//
//        System.out.println("Introduceti o Asigurare:");
//        System.out.println("-nume ASIGURARE:");
//        String numeAsigurare = scanner.nextLine();
//        System.out.println("-Pret: ");
//        String pret = scanner.nextLine();
//        System.out.println("-data intocmire:");
//        System.out.println("An:");
//        String anI_A = scanner.nextLine();
//        System.out.println("Luna:");
//        String lunaI_A = scanner.nextLine();
//        System.out.println("Zi:");
//        String ziI_A = scanner.nextLine();
//        System.out.println("-data expirare:");
//        System.out.println("An:");
//        String anE_A = scanner.nextLine();
//        System.out.println("Luna:");
//        String lunaE_A = scanner.nextLine();
//        System.out.println("Zi:");
//        String ziE_A = scanner.nextLine();
//        datasource.insertAsigurare(numeAsigurare, Double.parseDouble(pret),LocalDate.of(Integer.parseInt(anI_A),Integer.parseInt(lunaI_A),Integer.parseInt(ziI_A)),LocalDate.of(Integer.parseInt(anE_A),Integer.parseInt(lunaE_A),Integer.parseInt(ziE_A)));
//
//
//        System.out.println("Introduceti un ITP:");
//        System.out.println("-nume statie ITP:");
//        String numeItp = scanner.nextLine();
//        System.out.println("-data intocmire:");
//        System.out.println("An:");
//        String anI_I = scanner.nextLine();
//        System.out.println("Luna:");
//        String lunaI_I = scanner.nextLine();
//        System.out.println("Zi:");
//        String ziI_I = scanner.nextLine();
//        System.out.println("-data expirare:");
//        System.out.println("An:");
//        String anE_I = scanner.nextLine();
//        System.out.println("Luna:");
//        String lunaE_I = scanner.nextLine();
//        System.out.println("Zi:");
//        String ziE_I = scanner.nextLine();
//        datasource.insertItp(numeItp,LocalDate.of(Integer.parseInt(anI_I),Integer.parseInt(lunaI_I),Integer.parseInt(ziI_I)),LocalDate.of(Integer.parseInt(anE_I),Integer.parseInt(lunaE_I),Integer.parseInt(ziE_I)));
//
//
//        System.out.println("Introduceti o Masina:");
//        System.out.println("-marca:");
//        String marca = scanner.nextLine();
//        System.out.println("-model:");
//        String model = scanner.nextLine();
//        System.out.println("-serie:");
//        String serie = scanner.nextLine();
//        System.out.println("-nr.matricol:");
//        String nrMatricol = scanner.nextLine();
//        System.out.println("-prima inmatriculare:");
//        System.out.println("An:");
//        String an_m = scanner.nextLine();
//        System.out.println("Luna:");
//        String luna_m = scanner.nextLine();
//        System.out.println("Zi:");
//        String zi_m = scanner.nextLine();
//        System.out.println("-itp_id:");
//        String itp_id = scanner.nextLine();
//        System.out.println("-asigurare_id:");
//        String asigurare_id = scanner.nextLine();
//        System.out.println("-proprietar_id:");
//        String proprietar_id = scanner.nextLine();
//        datasource.insertMasina(marca, model, serie, nrMatricol, LocalDate.of(Integer.parseInt(an_m),Integer.parseInt(luna_m),Integer.parseInt(zi_m)), Integer.parseInt(itp_id), Integer.parseInt(asigurare_id), Integer.parseInt(proprietar_id));



//        datasource.insertProprietar("Irina", "Florina", 27, 'B');
//        datasource.insertProprietar("Ion", "Tanase", 52, 'C');
//        datasource.insertProprietar("Vlad", "Miron", 31, 'B');
//
//        datasource.insertAsigurare("ASIROM", 1267.32, LocalDate.of(2021,1,3), LocalDate.of(2022,1, 2));
//        datasource.insertAsigurare("Tiriac_ASIG", 2100.12, LocalDate.of(2021,9,22), LocalDate.of(2022,9,21));
//        datasource.insertAsigurare("ASIROM", 1544.22, LocalDate.of(2021,6,16), LocalDate.of(2022,6,15));
//
//        datasource.insertItp("ITP-Iasi", LocalDate.of(2022,1,5), LocalDate.of(2023,1,4));
//        datasource.insertItp("ITP-SECTOR 6", LocalDate.of(2021,6,26), LocalDate.of(2021,6,25));
//        datasource.insertItp("ITP-SECTOR 1", LocalDate.of(2021,2,14), LocalDate.of(2021,2,13));
//
//        datasource.insertMasina("Dacia", "Logan", "VCXS4439800DC4", "IS-9-DDC", LocalDate.of(2019, 5, 28), 5,5,5);
//        datasource.insertMasina("Ford", "Transit", "HFD854300GDG09", "B-52-GDF", LocalDate.of(2019, 6,27),2,2,2);
//        datasource.insertMasina("BMW", "320", "HHGDK00987FS00", "B-13-BPS", LocalDate.of(2018, 2, 15), 3, 3, 3);



//        List<Asigurare> asigurares = datasource.queryAsigurare(Datasource.ORDER_BY_NONE);
//
//        if (asigurares == null) {
//            System.out.println("Nu sunt asigurari!");
//            return;
//        }
//        for (Asigurare asigurare: asigurares) {
//            System.out.println("ID = "+ asigurare.getId() + ", Nume asigurare = "+asigurare.getNumeAsigurare());
//        }



//        System.out.println("----resultAsigurare()-----");
//        datasource.resultAsigurare();
//        System.out.println("--------------------------------");
//
//        System.out.println("----resultItp()-----");
//        datasource.resultItp();
//        System.out.println("--------------------------------");
//
//        System.out.println("----valabilitateItp()-----");
//        datasource.valabilitateItp();
//        System.out.println("--------------------------------");
//
//        System.out.println("----valabilitateAsigurare()-----");
//        datasource.valabilitateAsigurare();
//        System.out.println("--------------------------------");
//
//        System.out.println("----resultMasina()-----");
//        datasource.resultMasina();
//        System.out.println("--------------------------------");
//
//
//        System.out.println("----resultProprietar()-----");
//        datasource.resultProprietar();
//        System.out.println("--------------------------------");


        datasource.itpuriValabile();
        System.out.println("--------------------------------");
        datasource.itpuriExpirate();
        System.out.println("--------------------------------");
        datasource.asigurariExpirate();
        System.out.println("--------------------------------");
        datasource.asigurariValabile();
        System.out.println("--------------------------------");


        scanner.close();
        datasource.close();

    }
}
