package lab2.pokemons;

import lab2.moves.AcidArmor;
import lab2.moves.BatonPass;
import lab2.moves.Blizzard;
import lab2.moves.FocusEnergy;
import ru.ifmo.se.pokemon.Type;

public class Musharna extends Munna {
    public Musharna(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC);
        setStats(116, 55, 85, 107, 95, 29);
        setMove(new AcidArmor(), new Blizzard(), new FocusEnergy(), new BatonPass());
    }
}
