package pokemons;

import moves.AcidArmor;
import moves.BatonPass;
import moves.Blizzard;
import moves.FocusEnergy;
import ru.ifmo.se.pokemon.Type;

public class Musharna extends Munna {
    public Musharna(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(116, 55, 85, 107, 95, 29);
        setMove(new AcidArmor(), new Blizzard(), new FocusEnergy(), new BatonPass());
    }
}
