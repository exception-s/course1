package lab2.pokemons;

import lab2.moves.LightScreen;
import lab2.moves.Substitute;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Ledian extends Pokemon {
    public Ledian(String name, int level) {
        super(name, level);
        setType(Type.BUG, Type.FLYING);
        setStats(40, 20, 30, 40, 80, 55);
        setMove(new Substitute(), new LightScreen());
    }
}
