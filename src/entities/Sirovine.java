package entities;

/**
 *
 * @author Mila
 */
public class Sirovine {

    protected int sirovinaid;
    protected int dobavljacid;
    protected int skladisteid;
    protected String naziv_sirovine;
    protected int kolicina_sirovine;

    public Sirovine() {
    }

    public Sirovine(int sirovinaid, int dobavljacid, int skladisteid, String naziv_sirovine, int kolicina_sirovine) {
        this.sirovinaid = sirovinaid;
        this.dobavljacid = dobavljacid;
        this.skladisteid = skladisteid;
        this.naziv_sirovine = naziv_sirovine;
        this.kolicina_sirovine = kolicina_sirovine;
    }

    public int getSirovinaid() {
        return sirovinaid;
    }

    public void setSirovinaid(int sirovinaid) {
        this.sirovinaid = sirovinaid;
    }

    public int getDobavljacid() {
        return dobavljacid;
    }

    public void setDobavljacid(int dobavljacid) {
        this.dobavljacid = dobavljacid;
    }

    public int getSkladisteid() {
        return skladisteid;
    }

    public void setSkladisteid(int skladisteid) {
        this.skladisteid = skladisteid;
    }

    public String getNaziv_sirovine() {
        return naziv_sirovine;
    }

    public void setNaziv_sirovine(String naziv_sirovine) {
        this.naziv_sirovine = naziv_sirovine;
    }

    public int getKolicina_sirovine() {
        return kolicina_sirovine;
    }

    public void setKolicina_sirovine(int kolicina_sirovine) {
        this.kolicina_sirovine = kolicina_sirovine;
    }

    @Override
    public String toString() {
        return "Sirovine{" + "sirovinaid=" + sirovinaid + ", dobavljacid=" + dobavljacid + ", skladisteid=" + skladisteid + ", naziv_sirovine=" + naziv_sirovine + ", kolicina_sirovine=" + kolicina_sirovine + '}';
    }

}
