package entities;

public class Uloga {

    public int ulogaid;
    public String naziv;

    public Uloga() {
    }

    public Uloga(int ulogaid, String naziv) {
        this.ulogaid = ulogaid;
        this.naziv = naziv;
    }

    public int getUlogaid() {
        return ulogaid;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setUlogaid(int ulogaid) {
        this.ulogaid = ulogaid;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Uloga{" + "ulogaid=" + ulogaid + ", naziv=" + naziv + '}';
    }

}
