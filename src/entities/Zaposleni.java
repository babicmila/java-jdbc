package entities;

import exception.ZaposleniException;

/**
 *
 * @author Mila
 */
public class Zaposleni {

    protected int zaposleniid;
    protected int ulogaid;
    protected int skladisteid;
    protected int proizvodnjaid;
    protected String ime_zaposlenog;
    protected String prezime_zaposlenog;
    protected String jmbg;

    public Zaposleni() {
    }

    public Zaposleni(int zaposleniid, int ulogaid, int skladisteid, int proizvodnjaid, String ime_zaposlenog,
            String prezime_zaposlenog, String jmbg) throws ZaposleniException {

        this.zaposleniid = zaposleniid;
        this.ulogaid = ulogaid;
        this.skladisteid = skladisteid;
        this.proizvodnjaid = proizvodnjaid;
        this.ime_zaposlenog = ime_zaposlenog;
        this.prezime_zaposlenog = prezime_zaposlenog;
        if (jmbg.length() == 13) {
            this.jmbg = jmbg;
        } else {
            throw new ZaposleniException("JMBG mora imati tacno 13 brojeva! ");
        }

    }

    public int getZaposleniid() {
        return zaposleniid;
    }

    public void setZaposleniid(int zaposleniid) {
        this.zaposleniid = zaposleniid;
    }

    public int getUlogaid() {
        return ulogaid;
    }

    public void setUlogaid(int ulogaid) {
        this.ulogaid = ulogaid;
    }

    public int getSkladisteid() {
        return skladisteid;
    }

    public void setSkladisteid(int skladisteid) {
        this.skladisteid = skladisteid;
    }

    public int getProizvodnjaid() {
        return proizvodnjaid;
    }

    public void setProizvodnjaid(int proizvodnjaid) {
        this.proizvodnjaid = proizvodnjaid;
    }

    public String getIme_zaposlenog() {
        return ime_zaposlenog;
    }

    public void setIme_zaposlenog(String ime_zaposlenog) {
        this.ime_zaposlenog = ime_zaposlenog;
    }

    public String getPrezime_zaposlenog() {
        return prezime_zaposlenog;
    }

    public void setPrezime_zaposlenog(String prezime_zaposlenog) {
        this.prezime_zaposlenog = prezime_zaposlenog;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) throws ZaposleniException {
        if (jmbg.length() == 13) {
            this.jmbg = jmbg;
        } else {
            throw new ZaposleniException("JMBG mora imati tacno 13 brojeva! ");
        }
    }

    @Override
    public String toString() {
        return "Zaposleni{" + "zaposleniid=" + zaposleniid + ", ulogaid=" + ulogaid + ", skladisteid=" + skladisteid + ", proizvodnjaid=" + proizvodnjaid + ", ime_zaposlenog=" + ime_zaposlenog + ", prezime_zaposlenog=" + prezime_zaposlenog + ", jmbg=" + jmbg + '}';
    }

}
