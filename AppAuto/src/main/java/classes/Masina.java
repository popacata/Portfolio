package classes;

import java.time.LocalDate;

public class Masina {
    private int id;
    private String marca;
    private String model;
    private String serie;
    private String nrMatricol;
    private String primaInmatriculare;
    private int itpId;
    private int asigurareId;
    private int propietarId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNrMatricol() {
        return nrMatricol;
    }

    public void setNrMatricol(String nrMatricol) {
        this.nrMatricol = nrMatricol;
    }

    public String getPrimaInmatriculare() {
        return primaInmatriculare;
    }

    public void setPrimaInmatriculare(String primaInmatriculare) {
        this.primaInmatriculare = primaInmatriculare;
    }

    public int getItpId() {
        return itpId;
    }

    public void setItpId(int itpId) {
        this.itpId = itpId;
    }

    public int getAsigurareId() {
        return asigurareId;
    }

    public void setAsigurareId(int asigurareId) {
        this.asigurareId = asigurareId;
    }

    public int getPropietarId() {
        return propietarId;
    }

    public void setPropietarId(int propietarId) {
        this.propietarId = propietarId;
    }
}
