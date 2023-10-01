package lab2.pokemons;

import lab2.moves.AcidArmor;
import lab2.moves.Blizzard;
import lab2.moves.FocusEnergy;
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
