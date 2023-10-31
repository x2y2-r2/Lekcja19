public class Kot {
    String imie;

    public Kot(String imie) {
        this.imie = "Siersciuch " + imie;
    }

    @Override
    public String toString() {
        return "Kot{" +
                "imie='" + imie + '\'' +
                '}';
    }
}
