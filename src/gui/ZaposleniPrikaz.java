package gui;

import database.Database;
import entities.Zaposleni;
import exception.ZaposleniException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Mila
 */
public class ZaposleniPrikaz extends Stage {

    private Database db = null;

    Label ul = new Label("ID uloge");
    TextField ulogaID = new TextField();
    Label sk = new Label("ID skladista");
    TextField skladisteID = new TextField();
    Label idpr = new Label("ID proizvodnje");
    TextField proizvodnjaID = new TextField();
    Label im = new Label("Ime");
    TextField imeZap = new TextField();
    Label pr = new Label("Prezime");
    TextField prezimeZap = new TextField();
    Label jm = new Label("Jmbg");
    TextField jmbgField = new TextField();

    Button sacuvaj = new Button("Sacuvaj");
    Button obrisi = new Button("Obrisi");
    Button nazad = new Button("Pocetna strana");

    TableView<Zaposleni> tabela = new TableView<>();
    Zaposleni noviZaposleni = new Zaposleni();

    public ZaposleniPrikaz() {

        db = new Database();

        ulogaID.setPrefWidth(200);
        skladisteID.setPrefWidth(200);
        proizvodnjaID.setPrefWidth(200);

        sacuvaj.setPrefWidth(100);
        obrisi.setPrefWidth(100);
        BorderPane root = new BorderPane();
        VBox vbox = new VBox(ul, ulogaID, sk, skladisteID, idpr, proizvodnjaID, im, imeZap, pr, prezimeZap, jm, jmbgField);
        vbox.setAlignment(Pos.CENTER);
        HBox hbox = new HBox(sacuvaj, obrisi, nazad);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(5));
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        GridPane grid = new GridPane();
        grid.add(vbox, 0, 1);
        grid.add(hbox, 0, 3);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
        root.setCenter(grid);
        root.setBottom(tabela);
        Scene scene = new Scene(root, 550, 700);
        this.setScene(scene);
        this.setTitle("Zaposleni");
        this.show();

        tabela.getSelectionModel().selectedItemProperty().addListener(e -> {
            noviZaposleni = tabela.getSelectionModel().getSelectedItem();
            ulogaID.setText(noviZaposleni.getUlogaid() + "");
            skladisteID.setText(noviZaposleni.getSkladisteid() + "");
            proizvodnjaID.setText(noviZaposleni.getProizvodnjaid() + "");
            imeZap.setText(noviZaposleni.getIme_zaposlenog());
            prezimeZap.setText(noviZaposleni.getPrezime_zaposlenog());
            jmbgField.setText(noviZaposleni.getJmbg());

            sacuvaj.setText("Izmeni");
        });

        sacuvaj.setOnAction(e -> {
            if (sacuvaj.getText().equals("Sacuvaj")) {
                try {
                    Zaposleni z = new Zaposleni();
                    z.setUlogaid(Integer.parseInt(ulogaID.getText()));
                    z.setSkladisteid(Integer.parseInt(skladisteID.getText()));
                    z.setProizvodnjaid(Integer.parseInt(proizvodnjaID.getText()));
                    z.setIme_zaposlenog(imeZap.getText());
                    z.setPrezime_zaposlenog(prezimeZap.getText());
                    if (jmbgField.getLength() == 13) {
                        z.setJmbg(jmbgField.getText());
                    } else {
                        util.Util.showInfoAlert("JMBG mora imati tacno 13 karaktera!");
                        throw new ZaposleniException("JMBG mora imati tacno 13 karaktera!");
                    }

                    db.dodajZaposlenog(z);
                    db.prikazTabeleZaposlenih(tabela);

                    ulogaID.clear();
                    skladisteID.clear();
                    proizvodnjaID.clear();
                    imeZap.clear();
                    prezimeZap.clear();
                    jmbgField.clear();

                    tabela.setItems(FXCollections.observableList(db.sviZaposleni()));
                    util.Util.showInfoAlert("Zaposleni uspesno kreiran.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ZaposleniException ex) {
                    ex.printStackTrace();
                }
            } else {
                try {
                    noviZaposleni.setUlogaid(Integer.parseInt(ulogaID.getText()));
                    noviZaposleni.setSkladisteid(Integer.parseInt(skladisteID.getText()));
                    noviZaposleni.setProizvodnjaid(Integer.parseInt((proizvodnjaID.getText())));
                    noviZaposleni.setIme_zaposlenog(imeZap.getText());
                    noviZaposleni.setPrezime_zaposlenog(prezimeZap.getText());
                    noviZaposleni.setJmbg(jmbgField.getText());

                    db.azurirajZaposlenog(noviZaposleni);
                    db.prikazTabeleZaposlenih(tabela);
                    ulogaID.clear();
                    skladisteID.clear();
                    proizvodnjaID.clear();
                    imeZap.clear();
                    prezimeZap.clear();
                    jmbgField.clear();

                    tabela.setItems(FXCollections.observableList(db.sviZaposleni()));
                    sacuvaj.setText("Sacuvaj");

                    util.Util.showInfoAlert("Zaposleni uspesno izmenjen");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ZaposleniException ex) {
                    ex.printStackTrace();
                }
            }
        });

        try {
            tabela.setItems(FXCollections.observableList(db.sviZaposleni()));
            db.prikazTabeleZaposlenih(tabela);

            TableColumn<Zaposleni, Integer> col1 = new TableColumn<>("ID uloge");
            col1.setCellValueFactory(
                    new PropertyValueFactory<Zaposleni, Integer>("ulogaid"));

            TableColumn<Zaposleni, Integer> col2 = new TableColumn<>("ID skladista");
            col2.setCellValueFactory(
                    new PropertyValueFactory<Zaposleni, Integer>("skladisteid"));

            TableColumn<Zaposleni, Integer> col3 = new TableColumn<>("ID proizvodnje");
            col3.setCellValueFactory(
                    new PropertyValueFactory<Zaposleni, Integer>("proizvodnjaid"));

            TableColumn<Zaposleni, String> col4 = new TableColumn<>("Ime");
            col4.setCellValueFactory(
                    new PropertyValueFactory<Zaposleni, String>("ime_zaposlenog"));

            TableColumn<Zaposleni, String> col5 = new TableColumn<>("Prezime");
            col5.setCellValueFactory(
                    new PropertyValueFactory<Zaposleni, String>("prezime_zaposlenog"));

            TableColumn<Zaposleni, String> col6 = new TableColumn<>("JMBG");
            col6.setCellValueFactory(
                    new PropertyValueFactory<Zaposleni, String>("jmbg"));

            tabela.getColumns().addAll(col1, col2, col3, col4, col5, col6);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ZaposleniException ex) {
            ex.printStackTrace();
        }

        obrisi.setOnAction(e -> {
            if (tabela.getSelectionModel().getSelectedItem() != null) {
                try {
                    db.obrisiZaposlenog(tabela.getSelectionModel().getSelectedItem());
                    tabela.setItems(FXCollections.observableList(db.sviZaposleni()));
                    db.prikazTabeleZaposlenih(tabela);
                    util.Util.showInfoAlert("Zaposleni uspesno obrisan");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ZaposleniException ex) {
                    Logger.getLogger(ZaposleniPrikaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                util.Util.showErrorAlert("Morate selektovati zaposlenog");
            }
        }
        );

        nazad.setOnAction(e -> {
            new Main().start(this);
        });
    }
}
