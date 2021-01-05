package ristinolla;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Kayttoliittyma {

    private Pelilogiikka logiikka;
    private GridPane ruudukko;
    private Vuoro vuoro;
    private Label pelitilanne;
    private final HBox alapalkki;

    public Kayttoliittyma(int ruudukonKoko, BorderPane asettelu, Stage stage) {
        this.vuoro = new Vuoro();
        this.pelitilanne = new Label("Vuoro: " + vuoro);
        muotoileTeksti(pelitilanne, 20);

        this.alapalkki = new HBox();
        luoAlapalkki(asettelu, stage);

        logiikka = new Pelilogiikka(vuoro);
        logiikka.luoKirjanpito(ruudukonKoko);

        this.ruudukko = new GridPane();
        ruudukko.setPadding(oletusPadding());
        for (int x = 0; x < ruudukonKoko; x++) {
            for (int y = 0; y < ruudukonKoko; y++) {
                ruudukko.add(logiikka.luoPainike(pelitilanne, x, y), x, y);
            }
        }
    }

    public Kayttoliittyma(BorderPane asettelu, Stage stage) {
        this(3, asettelu, stage);
    }

    public void lataaKayttoliittyma(BorderPane asettelu, Kayttoliittyma ruudukko) {
        asettelu.setTop(getPelitilanne());
        asettelu.setCenter(getRuudukko());
        asettelu.setBottom(getAlapalkki());
    }

    public GridPane getRuudukko() {
        return ruudukko;
    }

    public Vuoro getVuoro() {
        return vuoro;
    }

    public Label getPelitilanne() {
        return pelitilanne;
    }

    public HBox getAlapalkki() {
        return this.alapalkki;
    }

    private void muotoileTeksti(Label label, int fonttikoko) {
        label.setFont(Font.font("Monospaced", fonttikoko));
        label.setPadding(new Insets(5, 0, 5, 20));
    }

    private Insets oletusPadding() {
        return new Insets(5, 5, 5, 5);
    }

    private void luoAlapalkki(BorderPane asettelu, Stage stage) {
        Label valikonSelite = new Label("Koko: ");
        muotoileTeksti(valikonSelite, 12);

        ChoiceBox kokoValikko = new ChoiceBox();
        kokoValikko.getItems().addAll(3, 4, 5);
        kokoValikko.setValue(3);

        Button uusiPeli = new Button("Uusi peli");
        uusiPeli.setOnMouseClicked(e -> {
            Kayttoliittyma uusiRuudukko = new Kayttoliittyma((int) kokoValikko.getValue(), asettelu, stage);
            asettelu.setTop(uusiRuudukko.getPelitilanne());
            asettelu.setCenter(uusiRuudukko.getRuudukko());
            switch ((int) kokoValikko.getValue()) {
                case 3:
                    stage.setWidth(263);
                    stage.setHeight(345);
                    break;
                case 4:
                    stage.setWidth(343);
                    stage.setHeight(418);
                    break;
                case 5:
                    stage.setWidth(422);
                    stage.setHeight(495);
                    break;
                default:
                    break;
            }
        });
        alapalkki.getChildren().addAll(uusiPeli, valikonSelite, kokoValikko);
        alapalkki.setPadding(oletusPadding());
        alapalkki.setAlignment(Pos.CENTER);
        alapalkki.setSpacing(10);
    }

}
