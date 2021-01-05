package ristinolla;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class RistinollaSovellus extends Application {

    public static void main(String[] args) {
        launch(RistinollaSovellus.class);
    }

    @Override
    public void start(Stage stage) {
        BorderPane asettelu = new BorderPane();
        Kayttoliittyma ruudukko = new Kayttoliittyma(asettelu, stage);
        ruudukko.lataaKayttoliittyma(asettelu, ruudukko);

        Scene pelinakyma = new Scene(asettelu);

        stage.setScene(pelinakyma);
        stage.setTitle("Ristinolla");
        stage.setWidth(263);
        stage.setHeight(345);
        stage.show();
    }
}
