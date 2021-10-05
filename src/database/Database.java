package database;

import entities.Dobavljac;
import entities.Kupac;
import entities.Sirovine;
import entities.VrstaSladoleda;
import entities.Zaposleni;
import exception.ZaposleniException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TableView;

public class Database {

    private static String url = "jdbc:mysql://localhost:3306/fabrikasladoleda";
    private static String username = "root";
    private static String password = "";

    private Connection con;

    // public static Database db = new Database(); 
    public void dodajSladoled(VrstaSladoleda s) throws SQLException {

        con = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = con.prepareStatement(
                "insert into vrsta_sladoleda(proizvodnjaid, brendirano_ime, cena) "
                + "values(?,?,?)");
        //statement.setInt(1, s.getSladoledid());
        statement.setInt(1, s.getProizvodnjaid());
        statement.setString(2, s.getBrendirano_ime());
        statement.setInt(3, s.getCena());

        statement.execute();

        con.close();
    }

    public void obrisiSladoled(VrstaSladoleda s) throws SQLException {

        con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(
                "delete from vrsta_sladoleda where sladoledid = ?");
        stmt.setInt(1, s.getSladoledid());
        stmt.execute();
        con.close();
    }

    public void azurirajSladoled(VrstaSladoleda stari, VrstaSladoleda novi) throws SQLException {

        con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(
                "update vrsta_sladoleda set proizvodnjaid = ?, brendirano_ime = ?, cena = ?"
                + " where sladoledid = ? "
        );

        stmt.setInt(1, novi.getProizvodnjaid());
        stmt.setString(2, novi.getBrendirano_ime());
        stmt.setInt(3, novi.getCena());
        stmt.setInt(4, stari.getSladoledid());
        stmt.execute();
        con.close();
    }

    public void dodajZaposlenog(Zaposleni z) throws SQLException {

        con = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = con.prepareStatement(
                "insert into zaposleni(zaposleniid, ulogaid, skladisteid, proizvodnjaid, ime_zaposlenog,"
                + " prezime_zaposlenog, jmbg) "
                + "values(?,?,?,?,?,?,?)");

        statement.setInt(1, z.getZaposleniid());
        statement.setInt(2, z.getUlogaid());
        statement.setInt(3, z.getSkladisteid());
        statement.setInt(4, z.getProizvodnjaid());
        statement.setString(5, z.getIme_zaposlenog());
        statement.setString(6, z.getPrezime_zaposlenog());
        statement.setString(7, z.getJmbg());

        statement.execute();
        con.close();
    }

    public void obrisiZaposlenog(Zaposleni z) throws SQLException {

        con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(
                "delete from zaposleni where zaposleniid = ?");
        stmt.setInt(1, z.getZaposleniid());
        stmt.execute();
        con.close();
    }

    public void azurirajZaposlenog(Zaposleni z) throws SQLException {

        con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(
                "update zaposleni set ulogaid = ?, skladisteid = ?, proizvodnjaid = ?, ime_zaposlenog = ?,"
                + " prezime_zaposlenog = ?, jmbg = ? where zaposleniid = ?"
        );

        stmt.setInt(1, z.getUlogaid());
        stmt.setInt(2, z.getSkladisteid());
        stmt.setInt(3, z.getProizvodnjaid());
        stmt.setString(4, z.getIme_zaposlenog());
        stmt.setString(5, z.getPrezime_zaposlenog());
        stmt.setString(6, z.getJmbg());
        stmt.setInt(7, z.getZaposleniid());

        stmt.execute();
        con.close();
    }

    public void dodajKupca(Kupac k) throws SQLException {

        con = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = con.prepareStatement(
                "insert into kupac(kupacid, ime_kupca) "
                + "values(?,?)");
        statement.setInt(1, k.getKupacid());
        statement.setString(2, k.getIme_kupca());

        statement.execute();

        con.close();
    }

    public void obrisiKupca(Kupac k) throws SQLException {
        con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(
                "delete from kupac where kupacid = ?");
        stmt.setInt(1, k.getKupacid());
        stmt.execute();
        con.close();
    }

    public void azurirajKupca(Kupac k) throws SQLException {

        con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(
                "update kupac set ime_kupca = ?,"
                + " where kupacid = ?"
        );

        stmt.setString(1, k.getIme_kupca());
        stmt.setInt(2, k.getKupacid());
        stmt.execute();
        con.close();
    }

    public void dodajSirovinu(Sirovine s) throws SQLException {

        con = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = con.prepareStatement(
                "insert into sirovine(sirovinaid, dobavljacid, skladisteid, naziv_sirovine, kolicina_sirovine) "
                + "values(?,?,?,?,?)");

        statement.setInt(1, s.getSirovinaid());
        statement.setInt(2, s.getDobavljacid());
        statement.setInt(3, s.getSkladisteid());
        statement.setString(4, s.getNaziv_sirovine());
        statement.setInt(5, s.getKolicina_sirovine());

        statement.execute();
        con.close();
    }

    public void obrisiSirovinu(Sirovine s) throws SQLException {

        con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(
                "delete from sirovine where sirovinaid = ?");
        stmt.setInt(1, s.getSirovinaid());

        stmt.execute();
        con.close();
    }

    public void azurirajSirovinu(Sirovine s) throws SQLException {

        con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(
                "update sirovine set dobavljacid = ?, skladisteid = ?, naziv_sirovine = ?, kolicina_sirovine = ?"
                + " where sirovinaid = ?"
        );

        stmt.setInt(1, s.getDobavljacid());
        stmt.setInt(2, s.getSkladisteid());
        stmt.setString(3, s.getNaziv_sirovine());
        stmt.setInt(4, s.getKolicina_sirovine());

        stmt.execute();
        con.close();
    }

    public void dodajDobavljaca(Dobavljac d) throws SQLException {

        con = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = con.prepareStatement(
                "insert into dobavlja(dobavljacid, ime_dobavljaca) "
                + "values(?,?)");
        statement.setInt(1, d.getDobavljacid());
        statement.setString(2, d.getIme_dobavljaca());
        statement.execute();

        con.close();
    }

    public List<VrstaSladoleda> sviSladoleda() throws SQLException {

        con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement("select * from vrsta_sladoleda");

        ResultSet set = stmt.executeQuery();
        List<VrstaSladoleda> sladoledi = new ArrayList<>();
        while (set.next()) {
            sladoledi.add(new VrstaSladoleda(
                    set.getInt("sladoledid"),
                    set.getInt("proizvodnjaid"),
                    set.getString("brendirano_ime"),
                    set.getInt("cena")));
        }
        con.close();
        return sladoledi;
    }

    public List<Zaposleni> sviZaposleni() throws SQLException, ZaposleniException {

        con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(
                "select * from zaposleni");
        ResultSet set = stmt.executeQuery();
        List<Zaposleni> zaposleni = new ArrayList<>();
        while (set.next()) {
            zaposleni.add(new Zaposleni(
                    set.getInt("zaposleniid"),
                    set.getInt("ulogaid"),
                    set.getInt("skladisteid"),
                    set.getInt("proizvodnjaid"),
                    set.getString("ime_zaposlenog"),
                    set.getString("prezime_zaposlenog"),
                    set.getString("jmbg")));
        }
        con.close();
        return zaposleni;
    }

    public List<Kupac> sviKupci() throws SQLException {
        con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(
                "select * from kupac");
        ResultSet set = stmt.executeQuery();
        List<Kupac> kupci = new ArrayList<>();
        while (set.next()) {
            kupci.add(new Kupac(
                    set.getInt("kupacid"),
                    set.getString("ime_kupca")));
        }
        con.close();
        return kupci;
    }

    public List<Sirovine> sveSirovine() throws SQLException {
        con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(
                "select * from sirovine");
        ResultSet set = stmt.executeQuery();
        List<Sirovine> sirovine = new ArrayList<>();
        while (set.next()) {
            sirovine.add(new Sirovine(
                    set.getInt("sirovinaid"),
                    set.getInt("dobavljavid"),
                    set.getInt("skladisteid"),
                    set.getString("naziv_sirovine"),
                    set.getInt("kolicina_sirovine")
            ));
        }
        con.close();
        return sirovine;
    }

    public void prikazTabeleSladoledi(TableView<VrstaSladoleda> tabelarniPrikaz) throws SQLException {

        tabelarniPrikaz.getItems().clear();

        con = DriverManager.getConnection(url, username, password);

        String query = "SELECT * FROM vrsta_sladoleda";
        Statement st = (Statement) con.createStatement();

        ResultSet resultSet = st.executeQuery(query);

        while (resultSet.next()) {

            VrstaSladoleda s = new VrstaSladoleda(resultSet.getInt("sladoledid"), resultSet.getInt("proizvodnjaid"),
                    resultSet.getString("brendirano_ime"), resultSet.getInt("cena"));

            tabelarniPrikaz.getItems().add(s);
        }
        con.close();
    }

    public void prikazTabeleZaposlenih(TableView<Zaposleni> tabelarniPrikaz) throws SQLException, ZaposleniException {

        tabelarniPrikaz.getItems().clear();

        con = DriverManager.getConnection(url, username, password);

        String query = "SELECT * FROM zaposleni";
        Statement st = (Statement) con.createStatement();

        ResultSet resultSet = st.executeQuery(query);

        while (resultSet.next()) {

            Zaposleni z = new Zaposleni(resultSet.getInt("zaposleniid"), resultSet.getInt("ulogaid"),
                    resultSet.getInt("skladisteid"), resultSet.getInt("proizvodnjaid"),
                    resultSet.getString("ime_zaposlenog"), resultSet.getString("prezime_zaposlenog"),
                    resultSet.getString("jmbg"));

            tabelarniPrikaz.getItems().add(z);
        }

        con.close();

    }

    public void prikazTabeleKupaca(TableView<Kupac> tabelarniPrikaz) throws SQLException {

        tabelarniPrikaz.getItems().clear();

        con = DriverManager.getConnection(url, username, password);

        String query = "SELECT * FROM kupac";
        Statement st = (Statement) con.createStatement();

        ResultSet resultSet = st.executeQuery(query);

        while (resultSet.next()) {

            Kupac k = new Kupac(resultSet.getInt("kupacid"), resultSet.getString("ime_kupca"));

            tabelarniPrikaz.getItems().add(k);
        }

        con.close();
    }

}
