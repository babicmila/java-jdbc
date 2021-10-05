package gui;

import database.Database;
import entities.VrstaSladoleda;
import java.sql.SQLException;
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

public class SladolediPrikaz extends Stage {

    private Database db = null;

    Label sl = new Label("ID proizvodnje");
    TextField proizvodnjaID = new TextField("");
    Label ime = new Label("Ime");
    TextField imeField = new TextField("");
    Label cena = new Label("Cena");
    TextField cenaField = new TextField("");

    Button sacuvaj = new Button("Sacuvaj");
    Button obrisi = new Button("Obrisi");
    Button nazad = new Button("Pocetna strana");

    TableView<VrstaSladoleda> tabela = new TableView<>();

    public SladolediPrikaz() {

        db = new Database();

        proizvodnjaID.setPrefWidth(200);
        // proizvodnjaID.setPrefWidth(200);
        imeField.setPrefWidth(200);
        cenaField.setPrefWidth(200);

        sacuvaj.setPrefWidth(100);
        obrisi.setPrefWidth(100);
        BorderPane root = new BorderPane();
        VBox vbox = new VBox(sl, proizvodnjaID, ime, imeField, cena, cenaField);
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
        Scene scene = new Scene(root, 500, 500);
        this.setScene(scene);
        this.setTitle("Zaposleni");
        this.show();

        tabela.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                VrstaSladoleda stari = tabela.getSelectionModel().getSelectedItem();
                proizvodnjaID.setText(stari.getProizvodnjaid() + "");
                imeField.setText(stari.getBrendirano_ime());
                cenaField.setText(stari.getCena() + "");
                sacuvaj.setText("Izmeni");
            }
        });

        sacuvaj.setOnAction(e -> {
            if (sacuvaj.getText().equals("Sacuvaj")) {
                try {
                    VrstaSladoleda s = new VrstaSladoleda();

                    s.setProizvodnjaid(Integer.parseInt(proizvodnjaID.getText()));
                    s.setBrendirano_ime(imeField.getText());
                    s.setCena(Integer.parseInt(cenaField.getText()));

                    db.dodajSladoled(s);
                    db.prikazTabeleSladoledi(tabela);
                    proizvodnjaID.clear();
                    imeField.clear();
                    cenaField.clear();

                    tabela.setItems(FXCollections.observableList(
                            db.sviSladoleda()));
                    util.Util.showInfoAlert("Sladoled uspesno kreiran.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                try {

                    VrstaSladoleda stari = tabela.getSelectionModel().getSelectedItem();
                    VrstaSladoleda noviSladoled = new VrstaSladoleda(Integer.parseInt(proizvodnjaID.getText()),
                            imeField.getText(), Integer.parseInt(cenaField.getText()));

                    db.azurirajSladoled(stari, noviSladoled);
                    db.prikazTabeleSladoledi(tabela);

                    tabela.setItems(FXCollections.observableList(db.sviSladoleda()));
                    sacuvaj.setText("Sacuvaj");
                    proizvodnjaID.clear();
                    imeField.clear();
                    cenaField.clear();

                    util.Util.showInfoAlert("Sladoled uspesno izmenjen");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        try {
            tabela.setItems(FXCollections.observableList(db.sviSladoleda()));
            db.prikazTabeleSladoledi(tabela);

            TableColumn<VrstaSladoleda, Integer> col1 = new TableColumn<>("ID proizvodnje");
            col1.setCellValueFactory(
                    new PropertyValueFactory<VrstaSladoleda, Integer>("proizvodnjaid"));

            TableColumn<VrstaSladoleda, String> col2 = new TableColumn<>("Ime");
            col2.setCellValueFactory(
                    new PropertyValueFactory<VrstaSladoleda, String>("brendirano_ime"));

            TableColumn<VrstaSladoleda, Integer> col3 = new TableColumn<>("Cena");
            col3.setCellValueFactory(
                    new PropertyValueFactory<VrstaSladoleda, Integer>("cena"));

            tabela.getColumns().addAll(col1, col2, col3);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        obrisi.setOnAction(e -> {
            if (tabela.getSelectionModel().getSelectedItem() != null) {
                try {
                    db.obrisiSladoled(tabela.getSelectionModel().getSelectedItem());
                    tabela.setItems(FXCollections.observableList(db.sviSladoleda()));
                    db.prikazTabeleSladoledi(tabela);
                    proizvodnjaID.clear();
                    imeField.clear();
                    cenaField.clear();
                    sacuvaj.setText("Sacuvaj");
                    util.Util.showInfoAlert("Sladoled uspesno obrisan");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                util.Util.showErrorAlert("Morate selektovati sladoled");
            }
        });
        nazad.setOnAction(e -> {
            new Main().start(this);
        });
    }
}
