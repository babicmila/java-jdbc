package entities;

/**
 *
 * @author Mila
 */
public class Skladiste {

    protected int skladisteid;
    protected String namena_skladista;
    protected int kolicina_sirovineIlisladoleda;
    protected String ime_sirovineIlisladoleda;

    public Skladiste() {
    }

    public Skladiste(int skladisteid, String namena_skladista, int kolicina_sirovineIlisladoleda, String ime_sirovineIlisladoleda) {
        this.skladisteid = skladisteid;
        this.namena_skladista = namena_skladista;
        this.kolicina_sirovineIlisladoleda = kolicina_sirovineIlisladoleda;
        this.ime_sirovineIlisladoleda = ime_sirovineIlisladoleda;
    }

    public int getSkladisteid() {
        return skladisteid;
    }

    public void setSkladisteid(int skladisteid) {
        this.skladisteid = skladisteid;
    }

    public String getNamena_skladista() {
        return namena_skladista;
    }

    public void setNamena_skladista(String namena_skladista) {
        this.namena_skladista = namena_skladista;
    }

    public int getKolicina_sirovineIlisladoleda() {
        return kolicina_sirovineIlisladoleda;
    }

    public void setKolicina_sirovineIlisladoleda(int kolicina_sirovineIlisladoleda) {
        this.kolicina_sirovineIlisladoleda = kolicina_sirovineIlisladoleda;
    }

    public String getIme_sirovineIlisladoleda() {
        return ime_sirovineIlisladoleda;
    }

    public void setIme_sirovineIlisladoleda(String ime_sirovineIlisladoleda) {
        this.ime_sirovineIlisladoleda = ime_sirovineIlisladoleda;
    }

    @Override
    public String toString() {
        return "Skladiste{" + "skladisteid=" + skladisteid + ", namena_skladista=" + namena_skladista + ", kolicina_sirovineIlisladoleda=" + kolicina_sirovineIlisladoleda + ", ime_sirovineIlisladoleda=" + ime_sirovineIlisladoleda + '}';
    }

}
