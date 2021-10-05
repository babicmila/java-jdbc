package entities;

/**
 *
 * @author Mila
 */
public class Recept {

    protected int receptid;
    protected int sladoledid;
    protected String tekst_recepta;

    public Recept() {
    }

    public Recept(int receptid, int sladoledid, String tekst_recepta) {
        this.receptid = receptid;
        this.sladoledid = sladoledid;
        this.tekst_recepta = tekst_recepta;
    }

    public int getReceptid() {
        return receptid;
    }

    public void setReceptid(int receptid) {
        this.receptid = receptid;
    }

    public int getSladoledid() {
        return sladoledid;
    }

    public void setSladoledid(int sladoledid) {
        this.sladoledid = sladoledid;
    }

    public String getTekst_recepta() {
        return tekst_recepta;
    }

    public void setTekst_recepta(String tekst_recepta) {
        this.tekst_recepta = tekst_recepta;
    }

    @Override
    public String toString() {
        return "Recept{" + "receptid=" + receptid + ", sladoledid=" + sladoledid + ", tekst_recepta=" + tekst_recepta + '}';
    }

}
