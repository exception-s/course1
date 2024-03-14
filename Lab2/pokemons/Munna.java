package pokemons;

import moves.AcidArmor;
import moves.Blizzard;
import moves.FocusEnergy;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Munna extends Pokemon {
    public Munna(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(76, 25, 45, 67, 55, 24);
        setMove(new FocusEnergy(), new Blizzard(), new AcidArmor());
    }
}
