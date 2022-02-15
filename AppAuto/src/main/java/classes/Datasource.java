package classes;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    private static final String DB_NAME = "auto.db";
    private static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Cata\\IdeaProjects\\AppAuto\\" + DB_NAME;

    private static final String TABLE_PROPRIETAR = "proprietar";
    private static final String COLUMN_PROPRIETAR_ID = "id";
    private static final String COLUMN_NUME = "nume";
    private static final String COLUMN_PRENUME = "prenume";
    private static final String COLUMN_VARSTA = "varsta";
    private static final String COLUMN_CATEORIE_PERMIS = "categoriePermis";
    private static final int INDEX_PROPRIETAR_ID = 1;
    private static final int INDEX_NUME = 2;
    private static final int INDEX_PRENUME = 3;
    private static final int INDEX_VARSTA = 4;
    private static final int INDEX_CATEORIE_PERMIS = 5;

    private static final String TABLE_ITP = "itp";
    private static final String COLUMN_ITP_ID = "id";
    private static final String COLUMN_NUME_STATIE_ITP = "numeStatieITP";
    private static final String COLUMN_DATA_INTOCMIRE_ITP = "dataIntocmireITP";
    private static final String COLUMN_DATA_EXPIRARE_ITP = "dataExpirareITP";
    private static final int INDEX_ITP_ID = 1;
    private static final int INDEX_NUME_STATIE_ITP = 2;
    private static final int INDEX_DATA_INTOCMIRE_ITP = 3;
    private static final int INDEX_DATA_EXPIRARE_ITP = 4;

    private static final String TABLE_ASIGURARE = "asigurare";
    private static final String COLUMN_ASIGURARE_ID = "id";
    private static final String COLUMN_NUME_ASIGURARE = "numeAsigurare";
    private static final String COLUMN_PRET = "pret";
    private static final String COLUMN_DATA_INTOCMIRE_ASIGURARE = "dataIntocmireAsigurare";
    private static final String COLUMN_DATA_EXPIRARE_ASIGURARE = "dataExpirareAsigurare";
    private static final int INDEX_ASIGURARE_ID = 1;
    private static final int INDEX_NUME_ASIGURARE = 2;
    private static final int INDEX_PRET = 3;
    private static final int INDEX_DATA_INTOCMIRE_ASIGURARE = 4;
    private static final int INDEX_DATA_EXPIRARE_ASIGURARE = 5;

    private static final String TABLE_MASINA = "masina";
    private static final String COLUMN_MASINA_ID = "id";
    private static final String COLUMN_MARCA = "marca";
    private static final String COLUMN_MODEL = "model";
    private static final String COLUMN_SERIE = "serie";
    private static final String COLUMN_NR_MATRICOL = "nrMatricol";
    private static final String COLUMN_PRIMA_INMATRICULARE = "primaInmatriculare";
    private static final String COLUMN_ITP = "itp";
    private static final String COLUMN_ASIGURARE = "asigurare";
    private static final String COLUMN_PROPRIETAR = "proprietar";
    private static final int INDEX_MASINA_ID = 1;
    private static final int INDEX_MARCA = 2;
    private static final int INDEX_MODEL = 3;
    private static final int INDEX_SERIE = 4;
    private static final int INDEX_NR_MATRICOL = 5;
    private static final int INDEX_PRIMA_INMATRICULARE = 6;
    private static final int INDEX_MASINA_ITP = 7;
    private static final int INDEX_MASINA_ASIGURARE = 8;
    private static final int INDEX_MASINA_PROPRIETAR =9 ;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    private Connection conn;
    private Statement statement;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            statement = conn.createStatement();
//            statement.execute("DROP TABLE IF EXISTS "+ TABLE_PROPRIETAR);    //Sterge acest tabel daca exista
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_PROPRIETAR +
                                "("+ COLUMN_PROPRIETAR_ID +" INTEGER PRIMARY KEY, "+
                                COLUMN_NUME +" TEXT, "+
                                COLUMN_PRENUME +" TEXT, "+
                                COLUMN_VARSTA +" INTEGER, "+
                                COLUMN_CATEORIE_PERMIS +" TEXT)");

//            statement.execute("DROP TABLE IF EXISTS "+ TABLE_ITP);      //Sterge acest tabel daca exista
            statement.execute("CREATE TABLE IF NOT EXISTS "+ TABLE_ITP +
                                "("+ COLUMN_ITP_ID +" INTEGER PRIMARY KEY, "+
                                COLUMN_NUME_STATIE_ITP +" TEXT, "+
                                COLUMN_DATA_INTOCMIRE_ITP +" DATE, "+
                                COLUMN_DATA_EXPIRARE_ITP +" DATE)");

//            statement.execute("DROP TABLE IF EXISTS "+ TABLE_ASIGURARE);    //Sterge acest tabel daca exista
            statement.execute("CREATE TABLE IF NOT EXISTS "+ TABLE_ASIGURARE +
                                "("+ COLUMN_ASIGURARE_ID +" INTEGER PRIMARY KEY, "+
                                COLUMN_NUME_ASIGURARE +" TEXT, "+
                                COLUMN_PRET +" DOUBLE, "+
                                COLUMN_DATA_INTOCMIRE_ASIGURARE +" DATE, "+
                                COLUMN_DATA_EXPIRARE_ASIGURARE +" DATE)");

//            statement.execute("DROP TABLE IF EXISTS "+ TABLE_MASINA);     //Sterge acest tabel daca exista
            statement.execute("CREATE TABLE IF NOT EXISTS "+ TABLE_MASINA +
                                "("+ COLUMN_MASINA_ID +" INTEGER PRIMARY KEY, "+
                                COLUMN_MARCA +" TEXT, "+
                                COLUMN_MODEL +" TEXT, "+
                                COLUMN_SERIE +" TEXT, "+
                                COLUMN_NR_MATRICOL +" TEXT, "+
                                COLUMN_PRIMA_INMATRICULARE +" DATE, "+
                                COLUMN_ITP +" INTEGER, "+
                                COLUMN_ASIGURARE +" INTEGER, "+
                                COLUMN_PROPRIETAR +" INTEGER)");
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: "+ e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (conn!=null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: "+ e.getMessage());
        }
    }


    public void insertProprietar(String nume, String prenume, int varsta,
                                         char categoriePermis) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_PROPRIETAR +
                " (" + COLUMN_NUME +", "+
                COLUMN_PRENUME +", "+
                COLUMN_VARSTA +", "+
                COLUMN_CATEORIE_PERMIS +") " +
                "VALUES('"+ nume +"', '"+ prenume +"', "+ varsta +", '"+ categoriePermis +"')");
    }

    public void insertItp(String numeStatieITP, LocalDate dataIntocmireITP,
                                  LocalDate dataExpirareITP) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_ITP +
                " (" + COLUMN_NUME_STATIE_ITP +", "+
                COLUMN_DATA_INTOCMIRE_ITP +", "+
                COLUMN_DATA_EXPIRARE_ITP +") " +
                "VALUES('"+ numeStatieITP +"', '"+ dataIntocmireITP +"', '"+ dataExpirareITP +"')");
    }

    public void insertAsigurare(String numeAsigurare, double pret, LocalDate dataIntocmireAsigurare,
                                        LocalDate dataExpirareAsigurare) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_ASIGURARE +
                " (" + COLUMN_NUME_ASIGURARE +", "+
                COLUMN_PRET +", "+
                COLUMN_DATA_INTOCMIRE_ASIGURARE +", "+
                COLUMN_DATA_EXPIRARE_ASIGURARE +") " +
                "VALUES('"+ numeAsigurare +"', "+ pret +", '"+ dataIntocmireAsigurare +"', '"+ dataExpirareAsigurare +"')");
    }

    public void insertMasina (String marca, String model, String serie, String nrMatricol,
                                      LocalDate primaInmatriculare, int itp, int asigurare, int proprietar) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_MASINA +
                " (" + COLUMN_MARCA +", "+
                COLUMN_MODEL +", "+
                COLUMN_SERIE +", "+
                COLUMN_NR_MATRICOL +", "+
                COLUMN_PRIMA_INMATRICULARE +", "+
                COLUMN_ITP +", "+
                COLUMN_ASIGURARE +", "+
                COLUMN_PROPRIETAR +") " +
                "VALUES('"+ marca +"', '"+ model +"', '"+ serie +"', '"+ nrMatricol +"', '"+ primaInmatriculare +"', "+ itp +
                ", "+ asigurare +", "+ proprietar +")");
    }





   public List<Asigurare> queryAsigurare(int sortOrder) {

        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ASIGURARE);
        if (sortOrder != ORDER_BY_NONE){
            sb.append(" ORDER BY ");
            sb.append(COLUMN_NUME_ASIGURARE);
            sb.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC){
                sb.append("DESC");
            }else {
                sb.append("ASC");
            }
        }

        try(Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sb.toString())) {

            List<Asigurare> asigurares = new ArrayList<>();
            while (resultSet.next()){
                Asigurare asigurare = new Asigurare();
                asigurare.setId(resultSet.getInt(INDEX_ASIGURARE_ID));
                asigurare.setNumeAsigurare(resultSet.getString(2));
                asigurare.setPret(resultSet.getDouble(3));
                asigurare.setDataIntocmireAsigurare(resultSet.getString(4));
                asigurare.setDataExpirareAsigurare(resultSet.getString(5));
                asigurares.add(asigurare);
            }
            return asigurares;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
   }

   private List<ITP> queryITP(){
       StringBuilder sb = new StringBuilder("SELECT * FROM "+ TABLE_ITP);

       try(Statement statement = conn.createStatement();
           ResultSet resultSet = statement.executeQuery(sb.toString())) {

           List<ITP> itps = new ArrayList<>();
           while (resultSet.next()){
               ITP itp = new ITP();
               itp.setId(resultSet.getInt(INDEX_ITP_ID));
               itp.setNumeStatieITP(resultSet.getString(INDEX_NUME_STATIE_ITP));
               itp.setDataIntocmireITP(resultSet.getString(INDEX_DATA_INTOCMIRE_ITP));
               itp.setDataExpirareITP(resultSet.getString(INDEX_DATA_EXPIRARE_ITP));
               itps.add(itp);
           }
           return itps;

       } catch (SQLException e) {
           System.out.println("Query failed: " + e.getMessage());
           return null;
       }
   }

   private List<Proprietar> queryProprietar() {
        StringBuilder sb = new StringBuilder("SELECT * FROM " + TABLE_PROPRIETAR);

        try (Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sb.toString())) {
            List<Proprietar> proprietars = new ArrayList<>();
            while (resultSet.next()){
                Proprietar proprietar = new Proprietar();
                proprietar.setId(resultSet.getInt(INDEX_PROPRIETAR_ID));
                proprietar.setNume(resultSet.getString(INDEX_NUME));
                proprietar.setPrenume(resultSet.getString(INDEX_PRENUME));
                proprietar.setVarsta(resultSet.getInt(INDEX_VARSTA));
                proprietar.setCadegoriePermis(resultSet.getString(INDEX_CATEORIE_PERMIS));
                proprietars.add(proprietar);
            }
            return proprietars;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
   }

   private List<Masina> queryMasina() {
        try( Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_MASINA)) {
            List<Masina> masinas = new ArrayList<>();
            while (resultSet.next()) {
                Masina masina = new Masina();
                masina.setId(resultSet.getInt(INDEX_MASINA_ID));
                masina.setMarca(resultSet.getString(INDEX_MARCA));
                masina.setModel(resultSet.getString(INDEX_MODEL));
                masina.setSerie(resultSet.getString(INDEX_SERIE));
                masina.setNrMatricol(resultSet.getString(INDEX_NR_MATRICOL));
                masina.setPrimaInmatriculare(resultSet.getString(INDEX_PRIMA_INMATRICULARE));
                masina.setItpId(resultSet.getInt(INDEX_ITP_ID));
                masina.setAsigurareId(resultSet.getInt(INDEX_ASIGURARE_ID));
                masina.setPropietarId(resultSet.getInt(INDEX_PROPRIETAR_ID));
                masinas.add(masina);
            }
            return masinas;

        } catch (SQLException e) {
            System.out.println("Query failed " +e.getMessage());
            return null;
        }

   }



   public  void resultAsigurare() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_ASIGURARE);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(COLUMN_ASIGURARE_ID) + " " +
                    resultSet.getString(COLUMN_NUME_ASIGURARE) + " " +
                    resultSet.getBoolean(COLUMN_PRET) + " " +
                    resultSet.getString(COLUMN_DATA_INTOCMIRE_ASIGURARE) + " " +
                    resultSet.getString(COLUMN_DATA_EXPIRARE_ASIGURARE));
        }
       if (resultSet == null) {
           System.out.println("Nu sunt Asigurari!");
           return;
       }
   }

   public void resultItp() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_ITP);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(COLUMN_ITP_ID) + " " +
                   resultSet.getString(COLUMN_NUME_STATIE_ITP) + " " +
                   resultSet.getString(COLUMN_DATA_INTOCMIRE_ITP) + " " +
                   resultSet.getString(COLUMN_DATA_EXPIRARE_ITP));
       }
       if (resultSet == null) {
               System.out.println("Nu sunt ITP-uri!");
               return;
       }
//       List<ITP> itps = queryITP();
//       for (ITP itp : itps) {
//           System.out.println("ID = " + itp.getId() + ", Nume Statie ITP = " + itp.getNumeStatieITP());
//       }
    }

   public void resultProprietar() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_PROPRIETAR);

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(COLUMN_PROPRIETAR_ID) + " " +
                    resultSet.getString(COLUMN_NUME) + " " +
                    resultSet.getString(COLUMN_PRENUME) + " " +
                    resultSet.getInt(COLUMN_VARSTA) + " " +
                    resultSet.getString(COLUMN_CATEORIE_PERMIS));
        }
        if (resultSet == null) {
            System.out.println("Nu sunt ITP-uri!");
            return;
        }
//        List<Proprietar> proprietars = queryProprietar();
//        for (Proprietar proprietar : proprietars) {
//            System.out.println("ID = " + proprietar.getId() + ", Nume Proprietar = " + proprietar.getNume());
//        }
    }

    public void resultMasina() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_MASINA);

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " +
                    resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " +
                    resultSet.getString(4) + " " +
                    resultSet.getString(5) + " " +
                    resultSet.getString(6) + " " +
                    resultSet.getInt(7) + " " +
                    resultSet.getInt(8) + " " +
                    resultSet.getInt(9));
        }
        if (resultSet == null) {
            System.out.println("Nu sunt Masini!");
            return;
        }
    }

   public void valabilitateItp () {
        List<ITP> itps = queryITP();
        for (ITP itp : itps){
            System.out.println("ITP-ul este facuta la: " + itp.getNumeStatieITP() + ", intocmit la data: "+itp.getDataIntocmireITP()+", si este valabil pana la data: "+ itp.getDataExpirareITP());
            if(LocalDate.parse(itp.getDataExpirareITP()).isAfter(java.time.LocalDate.now())){
                System.out.println("ID = "+ itp.getId() +" ITP Valabil! " + itp.getDataExpirareITP());
            } else if(LocalDate.parse(itp.getDataExpirareITP()).isEqual(java.time.LocalDate.now())){
                System.out.println("ID = "+ itp.getId() +" ITP Valabil! " + itp.getDataExpirareITP());
            } else {
                System.out.println("ID = "+ itp.getId() +" Valabilitate ITP-ului expirat! "+ itp.getDataExpirareITP());
            }
        }
   }

   public void valabilitateAsigurare () {
        List<Asigurare> asigurares = queryAsigurare(ORDER_BY_NONE);
        for (Asigurare asigurare: asigurares){
            System.out.println("Asigurarea este facuta la: " + asigurare.getNumeAsigurare() + ", intocmit la data: "+asigurare.getDataIntocmireAsigurare()+", si este valabil pana la data: "+ asigurare.getDataExpirareAsigurare());
            if(LocalDate.parse(asigurare.getDataExpirareAsigurare()).isAfter(java.time.LocalDate.now())){
                System.out.println("ID = "+ asigurare.getId() +" Asigurare Valabil! " + asigurare.getDataExpirareAsigurare());
            } else if(LocalDate.parse(asigurare.getDataExpirareAsigurare()).isEqual(java.time.LocalDate.now())){
                System.out.println("ID = "+ asigurare.getId() +" Asigurare Valabil! " + asigurare.getDataExpirareAsigurare());
            } else {
                System.out.println("ID = "+ asigurare.getId() +" Valabilitate Asigurarii expirat! "+ asigurare.getDataExpirareAsigurare());
            }
        }
    }

   public void itpuriValabile() throws SQLException{
        List<ITP> itps = queryITP();
        System.out.println("Uematoarele ITP-uri sunt valabile: ");
        for (ITP itp : itps){
            if(LocalDate.parse(itp.getDataExpirareITP()).isAfter(java.time.LocalDate.now()) ||
                    LocalDate.parse(itp.getDataExpirareITP()).isEqual(java.time.LocalDate.now())) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_MASINA + " INNER JOIN " + TABLE_PROPRIETAR +" ON " + TABLE_MASINA+ "."+
                        TABLE_PROPRIETAR + " = "+ TABLE_PROPRIETAR+"."+COLUMN_PROPRIETAR_ID +" WHERE "+ TABLE_PROPRIETAR+"."+COLUMN_PROPRIETAR_ID+" = "+itp.getId());
                System.out.println("ID = " + itp.getId() + " -- Valabil pana la: " + itp.getDataExpirareITP() + " pentru: " + resultSet.getString(2) +" "+
                        resultSet.getString(3) +" -> "+ resultSet.getString(11) +" "+ resultSet.getString(12));
            }
        }
   }

   public void itpuriExpirate() throws SQLException{
       List<ITP> itps = queryITP();
       System.out.println("Uematoarele ITP-uri sunt expirate: ");
       for (ITP itp : itps){
           if(LocalDate.parse(itp.getDataExpirareITP()).isBefore((java.time.LocalDate.now()))) {
               ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_MASINA + " INNER JOIN " + TABLE_PROPRIETAR +" ON " + TABLE_MASINA+ "."+
                       TABLE_PROPRIETAR + " = "+ TABLE_PROPRIETAR+"."+COLUMN_PROPRIETAR_ID +" WHERE "+ TABLE_PROPRIETAR+"."+COLUMN_PROPRIETAR_ID+" = "+itp.getId());
               System.out.println("ID = " + itp.getId() + " -- a fost valabil pana la: " + itp.getDataExpirareITP() + " pentru: " + resultSet.getString(2) +" "+
                       resultSet.getString(3) +" -> "+ resultSet.getString(11) +" "+ resultSet.getString(12));
           }
       }
   }

   public void asigurariValabile() throws SQLException{
        List<Asigurare> asigurares = queryAsigurare(ORDER_BY_NONE);
       System.out.println("Uematoarele Asigurari sunt valabile: ");
       for (Asigurare asigurare: asigurares){
           if(LocalDate.parse(asigurare.getDataExpirareAsigurare()).isAfter(java.time.LocalDate.now()) ||
                   LocalDate.parse(asigurare.getDataExpirareAsigurare()).isEqual(java.time.LocalDate.now())){
               ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_MASINA + " INNER JOIN " + TABLE_PROPRIETAR +" ON " + TABLE_MASINA+ "."+
                       TABLE_PROPRIETAR + " = "+ TABLE_PROPRIETAR+"."+COLUMN_PROPRIETAR_ID +" WHERE "+ TABLE_PROPRIETAR+"."+COLUMN_PROPRIETAR_ID+" = "+asigurare.getId());

               System.out.println("ID = "+ asigurare.getId() +" -- Valabil pana la: " + asigurare.getDataExpirareAsigurare() + ", pentru: " + resultSet.getString(2) +" "+
                       resultSet.getString(3) +" -> "+ resultSet.getString(11) +" "+ resultSet.getString(12));
           }
       }
   }

   public void asigurariExpirate() throws SQLException{
       List<Asigurare> asigurares = queryAsigurare(ORDER_BY_NONE);
       System.out.println("Uematoarele Asigurari sunt expirate: ");
       for (Asigurare asigurare: asigurares){
           if(LocalDate.parse(asigurare.getDataExpirareAsigurare()).isBefore(java.time.LocalDate.now())){
               ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_MASINA + " INNER JOIN " + TABLE_PROPRIETAR +" ON " + TABLE_MASINA+ "."+
                       TABLE_PROPRIETAR + " = "+ TABLE_PROPRIETAR+"."+COLUMN_PROPRIETAR_ID +" WHERE "+ TABLE_PROPRIETAR+"."+COLUMN_PROPRIETAR_ID+" = "+asigurare.getId());
               System.out.println("ID = "+ asigurare.getId() +" -- a fost valabil pana la: " + asigurare.getDataExpirareAsigurare() + " , pentru: " + resultSet.getString(2) +" "+
                       resultSet.getString(3) +" -> "+ resultSet.getString(11) +" "+ resultSet.getString(12));
           }
       }
   }

}
