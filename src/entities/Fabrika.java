package entities;

/**
 *
 * @author Mila
 */
public class Fabrika {

    protected int fabrikaid;
    protected String naziv_fabrike;

    public Fabrika() {
    }

    public Fabrika(int fabrikaid, String naziv_fabrike) {
        this.fabrikaid = fabrikaid;
        this.naziv_fabrike = naziv_fabrike;
    }

    public int getFabrikaid() {
        return fabrikaid;
    }

    public String getNaziv_fabrike() {
        return naziv_fabrike;
    }

    public void setFabrikaid(int fabrikaid) {
        this.fabrikaid = fabrikaid;
    }

    public void setNaziv_fabrike(String naziv_fabrike) {
        this.naziv_fabrike = naziv_fabrike;
    }

    @Override
    public String toString() {
        return "Fabrika{" + "fabrikaid=" + fabrikaid + ", naziv_fabrike=" + naziv_fabrike + '}';
    }

}
