import ru.ifmo.se.pokemon.*;
import pokemons.*;

public class lab2 {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon Pichu = new Pichu("Пичу", 10);
        Pokemon Munna = new Munna("Мунна", 10);
        Pokemon Musharna = new Musharna("Мушарна", 10);
        Pokemon Ledian = new Ledian("Ледиан", 10);
        Pokemon Whismur = new Whismur("Висмур", 10);
        Pokemon Loudred = new Loudred("Лаудред", 10);
        b.addAlly(Pichu);
        b.addAlly(Munna);
        b.addAlly(Musharna);
        b.addFoe(Ledian);
        b.addFoe(Whismur);
        b.addFoe(Loudred);
        b.go();
    }
}