package entities;

/**
 *
 * @author Mila
 */
public class Dobavljac {

    protected int dobavljacid;
    protected String ime_dobavljaca;

    public Dobavljac() {
    }

    public Dobavljac(int dobavljacid, String ime_dobavljaca) {
        this.dobavljacid = dobavljacid;
        this.ime_dobavljaca = ime_dobavljaca;
    }

    public int getDobavljacid() {
        return dobavljacid;
    }

    public String getIme_dobavljaca() {
        return ime_dobavljaca;
    }

    public void setDobavljacid(int dobavljacid) {
        this.dobavljacid = dobavljacid;
    }

    public void setIme_dobavljaca(String ime_dobavljaca) {
        this.ime_dobavljaca = ime_dobavljaca;
    }

    @Override
    public String toString() {
        return "Dobavljac{" + "dobavljacid=" + dobavljacid + ", ime_dobavljaca=" + ime_dobavljaca + '}';
    }

}
