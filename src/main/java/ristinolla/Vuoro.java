package ristinolla;

public class Vuoro {

    private merkki vuorossa;

    public Vuoro() {
        this.vuorossa = merkki.X;
    }
    
    public merkki kenenVuoro() {
        return this.vuorossa;
    }

    public void seuraavaVuoro() {
        switch (this.vuorossa) {
            case X:
                this.vuorossa = merkki.O;
                break;
            case O:
                this.vuorossa = merkki.X;
                break;
        }
    }

    public enum merkki {
        X, O;
    }
    
    @Override
    public String toString() {
        return this.vuorossa.toString();
    }
}
