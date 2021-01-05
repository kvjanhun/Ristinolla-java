package ristinolla;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Pelilogiikka {

    private final Vuoro vuoro;
    private Pelikirjanpito kirjanpito;

    public Pelilogiikka(Vuoro vuoro) {
        this.vuoro = vuoro;
    }

    public Button luoPainike(Label vuoroTeksti, int x, int y) {
        Button painike = new Button(" ");
        painike.setFont(Font.font("Monospaced", 40));
        painike.setOnMouseClicked(e -> {
            toiminto(painike, vuoroTeksti, x, y);
        });
        return painike;
    }

    private void toiminto(Button p, Label vT, int x, int y) {
        if (p.getText().equals(" ")) {
            if (!kirjanpito.voitto()) {
                pidaKirjaa(x, y);
                p.setText(kenenVuoro());
                this.vuoro.seuraavaVuoro();
                vT.setText("Vuoro: " + kenenVuoro());
                if (kirjanpito.voitto() || ruudukkoTaynna()) {
                    vT.setText("Loppu!");
                }
            }
        }
    }

    public String kenenVuoro() {
        return this.vuoro.toString();
    }

    public void luoKirjanpito(int halkaisija) {
        this.kirjanpito = new Pelikirjanpito(halkaisija);
    }

    public void pidaKirjaa(int x, int y) {
        this.kirjanpito.sijoita(kenenVuoro(), x, y);
    }

    public String taulukkoMerkkijonona() {
        return this.kirjanpito.toString();
    }

    public boolean ruudukkoTaynna() {
        return !taulukkoMerkkijonona().contains(" ");
    }
}
