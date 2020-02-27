package no.hiof.larseknu.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Superhero> apex = new ArrayList<>();
        apex.add(new Superhero("Bangalore", "Anita Williams", 35));
        apex.add(new Superhero("Lifeline", "Ajay Che", 24));
        apex.add(new Superhero("Gibraltar", "Makao Gibralter", 30));
        apex.add(new Superhero("Caustic", "Alexander Nox", 48));
        apex.add(new Superhero("Bloodhound", "Unknown"));
        apex.add(new Superhero("Mirage", "Elliott Witt", 30));
        apex.add(new Superhero("Octane", "Octavio Silva", 24));
        apex.add(new Superhero("Pathfinder", "MRVN"));
        apex.add(new Superhero("Wraith", "Renee Blasey", 32));
        apex.add(new Superhero("Crypto", "Tae Joon Park", 31));
        apex.add(new Superhero("Wattson", "Natalie Paquette", 22));
        apex.add(new Superhero("Revenant", "Unknown", 288));

        Collections.sort(apex);

        System.out.println("*******ALL***********");
        //printConditionally(apex, s -> true);
        performConditionally(apex, s -> true, s -> System.out.println(s));

        System.out.println("\n********Starts with B*********");
        //printConditionally(apex, s -> s.getName().startsWith("B"));
        performConditionally(apex, s -> s.getName().startsWith("B"), s -> System.out.println(s));


        /*performConditionally(apex, s -> s.getAge() > 29, s ->  {
            int currentAge = s.getAge();
            s.setAge(currentAge + 1);
        });*/

        performConditionally(apex, s -> s.getAge() > 29, Superhero::addAYear);

        //apex.sort((s1, s2) -> s1.getAge() - s2.getAge());
        //apex.sort(Comparator.comparingInt(s -> s.getAge()));
        apex.sort(Comparator.comparingInt(Superhero::getAge));


        System.out.println("\n********Over 30*********");
        //printConditionally(apex, s -> s.getAge() > 30);
        performConditionally(apex, s -> s.getAge() > 30, System.out::println);
    }

    public static void printConditionally(List<Superhero> superheroes, Condition condition) {
        for (Superhero aSuperHero : superheroes) {
            // Gjør en eller annen form for filtrering ved hjelp av condition sin testmetode
            if(condition.test(aSuperHero)) {
                System.out.println(aSuperHero);
            }
        }
    }

    public static void performConditionally(List<Superhero> superheroes, Condition condition, Action action) {
        for (Superhero aSuperHero : superheroes) {
            // Gjør en eller annen form for filtrering ved hjelp av condition sin testmetode
            if (condition.test(aSuperHero)) {
                // Utfører en eller annen definert handling på superheltobjektet
                action.perform(aSuperHero);
            }
        }
    }
}

interface Condition {
    boolean test(Superhero s);
}

interface Action {
    void perform(Superhero s);
}

