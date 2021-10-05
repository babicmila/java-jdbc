package entities;

/**
 *
 * @author Mila
 */
public class Proizvodnja {

    protected int proizvodnjaid;
    protected int fabrikaid;
    protected String naziv_prozivodnje;

    public Proizvodnja() {
    }

    public Proizvodnja(int proizvodnjaid, int fabrikaid, String naziv_prozivodnje) {
        this.proizvodnjaid = proizvodnjaid;
        this.fabrikaid = fabrikaid;
        this.naziv_prozivodnje = naziv_prozivodnje;
    }

    public int getProizvodnjaid() {
        return proizvodnjaid;
    }

    public void setProizvodnjaid(int proizvodnjaid) {
        this.proizvodnjaid = proizvodnjaid;
    }

    public int getFabrikaid() {
        return fabrikaid;
    }

    public void setFabrikaid(int fabrikaid) {
        this.fabrikaid = fabrikaid;
    }

    public String getNaziv_prozivodnje() {
        return naziv_prozivodnje;
    }

    public void setNaziv_prozivodnje(String naziv_prozivodnje) {
        this.naziv_prozivodnje = naziv_prozivodnje;
    }

    @Override
    public String toString() {
        return "Proizvodnja{" + "proizvodnjaid=" + proizvodnjaid + ", fabrikaid=" + fabrikaid + ", naziv_prozivodnje=" + naziv_prozivodnje + '}';
    }

}
