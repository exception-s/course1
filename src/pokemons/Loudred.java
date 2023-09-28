package pokemons;

import moves.Attract;
import moves.LightScreen;
import moves.Substitute;
import moves.Tackle;
import ru.ifmo.se.pokemon.Type;

public class Loudred extends Whismur {
    public Loudred(String name, int level) {
        super(name, level);
        setType(Type.NORMAL);
        setStats(84, 71, 43, 71, 43, 48);
        setMove(new Substitute(), new LightScreen(), new Tackle(), new Attract());
    }
}
