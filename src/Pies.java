import java.util.Objects;

public class Pies {
    private String imie;
    private int wiek;

    public Pies(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }

    public String getImie() {
        return imie;
    }

    public int getWiek() {
        return wiek;
    }

    @Override
    public String toString() {
        return "Pies{" +
                "imie='" + imie + '\'' +
                ", wiek=" + wiek +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pies pies = (Pies) o;
        return wiek == pies.wiek && Objects.equals(imie, pies.imie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, wiek);
    }

}
