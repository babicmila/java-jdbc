package entities;

import java.util.Date;

/**
 *
 * @author Mila
 */
public class Porudzbina {

    protected int porudzbinaid;
    protected int kupacid;
    protected int skladisteid;
    protected String ime_narucenog_proizvoda;
    protected int kolicina_narucenog_proizvoda;
    protected Date vreme_nar;
    protected Date vremeisporuke;

    public Porudzbina() {
    }

    public Porudzbina(int porudzbinaid, int kupacid, int skladisteid, String ime_narucenog_proizvoda, int kolicina_narucenog_proizvoda, Date vreme_nar, Date vremeisporuke) {
        this.porudzbinaid = porudzbinaid;
        this.kupacid = kupacid;
        this.skladisteid = skladisteid;
        this.ime_narucenog_proizvoda = ime_narucenog_proizvoda;
        this.kolicina_narucenog_proizvoda = kolicina_narucenog_proizvoda;
        this.vreme_nar = vreme_nar;
        this.vremeisporuke = vremeisporuke;
    }

    public int getPorudzbinaid() {
        return porudzbinaid;
    }

    public void setPorudzbinaid(int porudzbinaid) {
        this.porudzbinaid = porudzbinaid;
    }

    public int getKupacid() {
        return kupacid;
    }

    public void setKupacid(int kupacid) {
        this.kupacid = kupacid;
    }

    public int getSkladisteid() {
        return skladisteid;
    }

    public void setSkladisteid(int skladisteid) {
        this.skladisteid = skladisteid;
    }

    public String getIme_narucenog_proizvoda() {
        return ime_narucenog_proizvoda;
    }

    public void setIme_narucenog_proizvoda(String ime_narucenog_proizvoda) {
        this.ime_narucenog_proizvoda = ime_narucenog_proizvoda;
    }

    public int getKolicina_narucenog_proizvoda() {
        return kolicina_narucenog_proizvoda;
    }

    public void setKolicina_narucenog_proizvoda(int kolicina_narucenog_proizvoda) {
        this.kolicina_narucenog_proizvoda = kolicina_narucenog_proizvoda;
    }

    public Date getVreme_nar() {
        return vreme_nar;
    }

    public void setVreme_nar(Date vreme_nar) {
        this.vreme_nar = vreme_nar;
    }

    public Date getVremeisporuke() {
        return vremeisporuke;
    }

    public void setVremeisporuke(Date vremeisporuke) {
        this.vremeisporuke = vremeisporuke;
    }

    @Override
    public String toString() {
        return "Porudzbina{" + "porudzbinaid=" + porudzbinaid + ", kupacid=" + kupacid + ", skladisteid=" + skladisteid + ", ime_narucenog_proizvoda=" + ime_narucenog_proizvoda + ", kolicina_narucenog_proizvoda=" + kolicina_narucenog_proizvoda + ", vreme_nar=" + vreme_nar + ", vremeisporuke=" + vremeisporuke + '}';
    }

}
