package entities;

import java.util.Date;

/**
 *
 * @author Mila
 */
public class Izvestaj {

    protected int izvestajid;
    protected int skladisteid;
    protected int proizvodnjaid;
    protected int tipid;
    protected Date datum;
    protected String imesirovine;
    protected int kolicinasirovine;
    protected String imeproizvoda;
    protected int kolicinaproizvoda;
    protected int kolicinaproizvedenogsladoleda;
    protected int kolicinautrosenihsirovina;

    public Izvestaj() {
    }

    //izvestaj o zalihama sirovina
    public Izvestaj(int izvestajid, int skladisteid, int tipid, Date datum, String imesirovine, int kolicinasirovine) {
        this.izvestajid = izvestajid;
        this.skladisteid = skladisteid;
        this.tipid = tipid;
        this.datum = datum;
        this.imesirovine = imesirovine;
        this.kolicinasirovine = kolicinasirovine;
    }

    //izvestaj o kolicini proizvoda
    public Izvestaj(int izvestajid, int tipid, Date datum, String imeproizvoda, int kolicinaproizvoda) {
        this.izvestajid = izvestajid;
        this.tipid = tipid;
        this.datum = datum;
        this.imeproizvoda = imeproizvoda;
        this.kolicinaproizvoda = kolicinaproizvoda;
    }

    //izvestaj o proizvedenom
    public Izvestaj(int izvestajid, int proizvodnjaid, int tipid, Date datum, String imeproizvoda, int kolicinaproizvedenogsladoleda, int kolicinautrosenihsirovina) {
        this.izvestajid = izvestajid;
        this.proizvodnjaid = proizvodnjaid;
        this.tipid = tipid;
        this.datum = datum;
        this.imeproizvoda = imeproizvoda;
        this.kolicinaproizvedenogsladoleda = kolicinaproizvedenogsladoleda;
        this.kolicinautrosenihsirovina = kolicinautrosenihsirovina;
    }

    public int getIzvestajid() {
        return izvestajid;
    }

    public int getSkladisteid() {
        return skladisteid;
    }

    public int getProizvodnjaid() {
        return proizvodnjaid;
    }

    public int getTipid() {
        return tipid;
    }

    public Date getDatum() {
        return datum;
    }

    public String getImesirovine() {
        return imesirovine;
    }

    public int getKolicinasirovine() {
        return kolicinasirovine;
    }

    public String getImeproizvoda() {
        return imeproizvoda;
    }

    public int getKolicinaproizvoda() {
        return kolicinaproizvoda;
    }

    public int getKolicinaproizvedenogsladoleda() {
        return kolicinaproizvedenogsladoleda;
    }

    public int getKolicinautrosenihsirovina() {
        return kolicinautrosenihsirovina;
    }

    public void setIzvestajid(int izvestajid) {
        this.izvestajid = izvestajid;
    }

    public void setSkladisteid(int skladisteid) {
        this.skladisteid = skladisteid;
    }

    public void setProizvodnjaid(int proizvodnjaid) {
        this.proizvodnjaid = proizvodnjaid;
    }

    public void setTipid(int tipid) {
        this.tipid = tipid;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public void setImesirovine(String imesirovine) {
        this.imesirovine = imesirovine;
    }

    public void setKolicinasirovine(int kolicinasirovine) {
        this.kolicinasirovine = kolicinasirovine;
    }

    public void setImeproizvoda(String imeproizvoda) {
        this.imeproizvoda = imeproizvoda;
    }

    public void setKolicinaproizvoda(int kolicinaproizvoda) {
        this.kolicinaproizvoda = kolicinaproizvoda;
    }

    public void setKolicinaproizvedenogsladoleda(int kolicinaproizvedenogsladoleda) {
        this.kolicinaproizvedenogsladoleda = kolicinaproizvedenogsladoleda;
    }

    public void setKolicinautrosenihsirovina(int kolicinautrosenihsirovina) {
        this.kolicinautrosenihsirovina = kolicinautrosenihsirovina;
    }

}
