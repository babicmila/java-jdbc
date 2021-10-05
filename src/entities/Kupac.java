package entities;

/**
 *
 * @author Mila
 */
public class Kupac {

    protected int kupacid;
    protected String ime_kupca;

    public Kupac() {
    }

    public Kupac(int kupacid, String ime_kupca) {
        this.kupacid = kupacid;
        this.ime_kupca = ime_kupca;
    }

    public int getKupacid() {
        return kupacid;
    }

    public void setKupacid(int kupacid) {
        this.kupacid = kupacid;
    }

    public String getIme_kupca() {
        return ime_kupca;
    }

    public void setIme_kupca(String ime_kupca) {
        this.ime_kupca = ime_kupca;
    }

    @Override
    public String toString() {
        return "Kupac{" + "kupacid=" + kupacid + ", ime_kupca=" + ime_kupca + '}';
    }
}
