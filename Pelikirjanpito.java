package ristinolla;

import java.util.ArrayList;

public final class Pelikirjanpito {

    private final String[][] taulukko;

    public Pelikirjanpito(int halkaisija) {
        this.taulukko = new String[halkaisija][halkaisija];
        for (int x = 0; x < halkaisija; x++) {
            for (int y = 0; y < halkaisija; y++) {
                sijoita(" ", x, y);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < taulukko.length; x++) {
            for (int y = 0; y < taulukko.length; y++) {
                sb.append(anna(x, y));
            }
        }
        return sb.toString();
    }

    public String anna(int x, int y) {
        return this.taulukko[x][y];
    }

    public void sijoita(String merkki, int x, int y) {
        this.taulukko[x][y] = merkki;
    }

    public boolean voitto() {
        ArrayList<String> merkit = new ArrayList<>();
        for (int x = 0; x < taulukko.length; x++) {
            for (int y = 0; y < taulukko.length; y++) {
                merkit.add(taulukko[x][y]);
            }
            if (merkit.stream().allMatch(s -> s.equals("X"))
                    || merkit.stream().allMatch(s -> s.equals("O"))) {
                return true;
            }
            merkit.clear();
        }
        for (int y = 0; y < taulukko.length; y++) {
            for (int x = 0; x < taulukko.length; x++) {
                merkit.add(taulukko[x][y]);
            }
            if (merkit.stream().allMatch(s -> s.equals("X"))
                    || merkit.stream().allMatch(s -> s.equals("O"))) {
                return true;
            }
            merkit.clear();
        }
        for (int i = 0; i < taulukko.length; i++) {
            merkit.add(taulukko[i][i]);
        }
        if (merkit.stream().allMatch(s -> s.equals("X"))
                || merkit.stream().allMatch(s -> s.equals("O"))) {
            return true;
        }
        merkit.clear();
        int r = taulukko.length - 1;
        for (int i = 0; i < taulukko.length; i++) {
            merkit.add(taulukko[r][i]);
            r--;
        }
        if (merkit.stream().allMatch(s -> s.equals("X"))
                || merkit.stream().allMatch(s -> s.equals("O"))) {
            return true;
        }
        return false;
    }
}
