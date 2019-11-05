package modelCalculator;

public class Suma {
    private int primul_numar;
    private int nr_2;

    public int getPrimul_numar() {
        return primul_numar;
    }

    public void setPrimul_numar(int primul_numar) {
        this.primul_numar = primul_numar;
    }

    public int getNr_2() {
        return nr_2;
    }

    public void setNr_2(int nr_2) {
        this.nr_2 = nr_2;
    }

    @Override
    public String toString() {
        return "Suma{" +
                "primul_numar=" + primul_numar +
                ", nr_2=" + nr_2 +
                '}';
    }
}
