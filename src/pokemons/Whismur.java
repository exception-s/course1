package pokemons;

import moves.LightScreen;
import moves.Substitute;
import moves.Tackle;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Whismur extends Pokemon {
    public Whismur(String name, int level) {
        super(name, level);
        setType(Type.NORMAL);
        setStats(64, 51, 23, 51, 23, 28);
        setMove(new Substitute(), new LightScreen(), new Tackle());
    }
}
