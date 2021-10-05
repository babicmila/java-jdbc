package entities;

/**
 *
 * @author Mila
 */
public class TipIzvestaja {

    protected int tipid;
    protected String opistipa;

    public TipIzvestaja() {
    }

    public TipIzvestaja(int tipid, String opistipa) {
        this.tipid = tipid;
        this.opistipa = opistipa;
    }

    public int getTipid() {
        return tipid;
    }

    public void setTipid(int tipid) {
        this.tipid = tipid;
    }

    public String getOpistipa() {
        return opistipa;
    }

    public void setOpistipa(String opistipa) {
        this.opistipa = opistipa;
    }

    @Override
    public String toString() {
        return "TipIzvestaja{" + "tipid=" + tipid + ", opistipa=" + opistipa + '}';
    }

}
