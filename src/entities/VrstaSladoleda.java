package entities;

/**
 *
 * @author Mila
 */
public class VrstaSladoleda {

    protected int sladoledid;
    protected int proizvodnjaid;
    protected String brendirano_ime;
    protected int cena;

    public VrstaSladoleda() {
    }

    public VrstaSladoleda(int sladoledid, int proizvodnjaid, String brendirano_ime, int cena) {
        this.sladoledid = sladoledid;
        this.proizvodnjaid = proizvodnjaid;
        this.brendirano_ime = brendirano_ime;
        this.cena = cena;
    }

    public VrstaSladoleda(int proizvodnjaid, String brendirano_ime, int cena) {
        this.proizvodnjaid = proizvodnjaid;
        this.brendirano_ime = brendirano_ime;
        this.cena = cena;
    }

    public int getSladoledid() {
        return sladoledid;
    }

    public void setSladoledid(int sladoledid) {
        this.sladoledid = sladoledid;
    }

    public int getProizvodnjaid() {
        return proizvodnjaid;
    }

    public void setProizvodnjaid(int proizvodnjaid) {
        this.proizvodnjaid = proizvodnjaid;
    }

    public String getBrendirano_ime() {
        return brendirano_ime;
    }

    public void setBrendirano_ime(String brendirano_ime) {
        this.brendirano_ime = brendirano_ime;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "VrstaSladoleda{" + "sladoledid=" + sladoledid + ", proizvodnjaid=" + proizvodnjaid + ", brendirano_ime=" + brendirano_ime + ", cena=" + cena + '}';
    }
}
