package classes;

import java.time.LocalDate;

public class Asigurare {
    private int id;
    private String numeAsigurare;
    private double pret;
    private String dataIntocmireAsigurare;
    private String dataExpirareAsigurare;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeAsigurare() {
        return numeAsigurare;
    }

    public void setNumeAsigurare(String numeAsigurare) {
        this.numeAsigurare = numeAsigurare;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getDataIntocmireAsigurare() {
        return dataIntocmireAsigurare;
    }

    public void setDataIntocmireAsigurare(String dataIntocmireAsigurare) {
        this.dataIntocmireAsigurare = dataIntocmireAsigurare;
    }

    public String getDataExpirareAsigurare() {
        return dataExpirareAsigurare;
    }

    public void setDataExpirareAsigurare(String dataExpirareAsigurare) {
        this.dataExpirareAsigurare = dataExpirareAsigurare;
    }

}
