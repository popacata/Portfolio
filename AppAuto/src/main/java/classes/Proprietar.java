package classes;

public class Proprietar {
    private int id;
    private String nume;
    private String prenume;
    private int varsta;
    private String cadegoriePermis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getCadegoriePermis() {
        return cadegoriePermis;
    }

    public void setCadegoriePermis(String cadegoriePermis) {
        this.cadegoriePermis = cadegoriePermis;
    }
}
