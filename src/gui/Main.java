package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Mila
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        BorderPane pane = new BorderPane();
        BorderPane pane2 = new BorderPane();
        VBox vbox = new VBox();
        vbox.setSpacing(15);
        Button sladolediBtn = new Button("Sladoledi");
        Button zaposleniBtn = new Button("Zaposleni");
        // Button kupciBtn = new Button("Kupci");
        //Button sirovineBtn = new Button("Sirovine");

        ImageView logo = new ImageView(getClass().getResource("sladoled.jpg").toExternalForm());

        vbox.getChildren().addAll(sladolediBtn, zaposleniBtn);
        vbox.setAlignment(Pos.CENTER);

        pane.setCenter(vbox);
        pane2.setCenter(logo);
        pane.setTop(pane2);
        Scene scene = new Scene(pane, 300, 400);

        sladolediBtn.setOnAction(e -> {
            primaryStage.hide();
            new SladolediPrikaz();
        });

        zaposleniBtn.setOnAction(e -> {
            primaryStage.hide();
            new ZaposleniPrikaz();
        });

        primaryStage.setTitle("Fabrika sladoleda");
        primaryStage.setScene(scene);
        Image image = new Image("/gui/sladoled.jpg");
        primaryStage.getIcons().add(image);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

}
