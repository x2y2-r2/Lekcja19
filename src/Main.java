import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    //    Interfejsy z lambdami i streamy
    public static void main(String[] args) {

        List<Pies> psiaki = new ArrayList<>();
        psiaki.add(new Pies("Burek", 3));
        psiaki.add(new Pies("Azor", 1));
        psiaki.add(new Pies("Azor", 1));
        psiaki.add(new Pies("Azor", 1));
        psiaki.add(new Pies("Azor", 1));
        psiaki.add(new Pies("Reks", 5));
        psiaki.add(new Pies("Staszek", 2));
        psiaki.add(new Pies("Dexter", 10));

    //    1. Mamy liste psow, chcemy na jej podstawie stworzyc liste, w której sa psy tylko starsze niz 2 lata
        List<Pies> psyStarszeNiz2lata = new ArrayList<>();
        for (Pies pies : psiaki) {
            if (pies.getWiek() > 2) {
                psyStarszeNiz2lata.add(pies);
            }
        }
        psiWyswietlacz(psyStarszeNiz2lata);

//        wyrażenie lambda i stream

        List<Pies> psyStarszeNiz2Lata2 = psiaki.stream()
                .filter( p -> p.getWiek() > 2)          //jeżeli interfejs ma tylko jedną metodę do zaimplementowania, to możemy to zrobić za pomocą wyrażenia lambda
                .collect(Collectors.toList());

        psiWyswietlacz(psyStarszeNiz2Lata2);

        Krzykacz polski = new PolskiKrzykacz(); //Krzykacz jest interfejsem funkcyjnym, czyli takim który posiada tylko jedną metodę abstrakcyjną,
        // tworzymy klasę PolskiKrzykacz która implementuje interfejs Krzykacz i nadpisuje metodę bezparametrową krzykacz()
        polski.krzycz();

        Krzykacz krzykacz = () -> {                         // wywołanie wyrażenia lambda: () wywołanie funkcji bezargumentowej, w nawaisach "{}" znajduje się ciało metody abstrakcyjnej wywołanej w wyrażeniu
            System.out.println("AAAAAAAAAAAAA!!!!");
            System.out.println("BBBBBBBBBB!!!!!");
        };
        krzykacz.krzycz();

        System.out.println("===================");

        Krzykacz angielski = () -> System.out.println("You son of a b...."); // typ: interfejs funkcyjny — wyrażenie lambda implementująca funkcje
        Krzykacz niemiecki = () -> System.out.println("du Hurens...");
        Krzykacz hiszpanski = () -> System.out.println("tu hijo de pu..");

//        lista kszykaczy i ich wywołanie
        List<Krzykacz> krzykacze = new ArrayList<>();
        krzykacze.add(polski);
        krzykacze.add(angielski);
        krzykacze.add(niemiecki);
        krzykacze.add(hiszpanski);

        for (Krzykacz krzykacz1 : krzykacze) {
            krzykacz1.krzycz();
        }
        System.out.println("================");

        //        Stworz interfejs funkcyjny Krzykacz i ma krzyczec na dzieci
//        Jeden ma krzyczeć na Eryka, drugi na Maksa (jak macie swoje dzieci to możecie podać
//        tu ich imiona)
        Krzykacz krzyczMaks = () -> {
            System.out.println("Maaaaaaaksss!!!!!!!!");
        };
        Krzykacz krzyczEryk = () -> {
            System.out.println("Eryk, co mama do Ciebie mówiła??!!");
        };
        Krzykacz krzyczOlek = () -> {
            System.out.println("Eryk, co mama do Ciebie mówiła??!!");
        };

        List<Krzykacz> krzykaczNaDzieci = List.of(krzyczEryk, krzyczMaks, krzyczOlek);
        for (Krzykacz krzykacz3 : krzykaczNaDzieci) {
            krzykacz3.krzycz();
        }
//    2. Mamy liste psow, chcemy na jej podstawie stworzyc liste, w której sa tylko nie powtarzajace sie psy

        List<Pies> unikatowePsy = new ArrayList<>();
        for (Pies pies : psiaki) {
            if (!unikatowePsy.contains(pies)) {
                if (pies.getWiek() < 5) {
                    unikatowePsy.add(pies);
                }
            }
        }
        psiWyswietlacz(unikatowePsy);

        Stream<Pies> unikatowePsyStream = psiaki.stream()
                .filter(pies -> pies.getWiek() < 5)
                .distinct();  // usuwa powtórzenia
        // jeżeli dać typ List<Pies> a nie Stream<Pies> to możemy przerobić od razu na listę


        List<Pies> unikatowePsy2 = unikatowePsyStream
                .collect(Collectors.toList());

        psiWyswietlacz(unikatowePsy2);

        //    3. Mamy liste psow, chcemy policzyc ile mamy niepowtarzalnych psow

        List<Pies> unikatowe3 = new ArrayList<>();

        for (Pies pies : psiaki) {
            if (!unikatowe3.contains(pies)) {
                if (pies.getWiek() < 5) {
                    unikatowe3.add(pies);
                }
            }
        }

        System.out.println(unikatowe3.size());
//
//        long count = unikatowePsyStream
//                .count();
//        System.out.println(count);

        //    4. Mamy liste psow, chcemy znalezc najstarszego
//        Podejscie klasyczne

        Pies najstarszy = new Pies("a", 0); // punkt wyjścia do porównywania

        for (Pies pies : psiaki) {
            if(pies.getWiek() > najstarszy.getWiek()) {
                najstarszy = pies;
            }
        }
        System.out.println(najstarszy);

//        max w stream
        Pies pies = psiaki.stream()
                .max((pies1,pies2) -> pies1.getWiek() - pies2.getWiek())
                .get();

        System.out.println(pies);
        System.out.println("===============");

//      5. Mamy liste psow, chcemy z niej zrobić liste kotow o tym samym imieniu, ale tylko tych ktore
//    sa starsze niz 2 lata

//        Podejscie klasyczne

        List<Kot> koty = new ArrayList<>();
        for (Pies pies2 : psiaki) {
            koty.add(new Kot(pies2.getImie()));
        }

        kociWyswietlacz(koty);


//        map w streamie
        List<Kot> kotStream = psiaki.stream()
                .map(pies1 -> new Kot(pies1.getImie()))
                .collect(Collectors.toList());

        kociWyswietlacz(kotStream);



    }

    private static void kociWyswietlacz(List<Kot> koty) {
        System.out.println("==============");
        for (Kot kot : koty) {
            System.out.println(kot);
        }

        System.out.println("==============");

    }

    private static void psiWyswietlacz(List<Pies> psy) {
        System.out.println("==============");
        for (Pies pies : psy) {
            System.out.println(pies);
        }

        System.out.println("==============");

    }


}