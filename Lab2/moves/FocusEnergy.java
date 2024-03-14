package moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class FocusEnergy extends StatusMove{
    public FocusEnergy(){
        super(Type.NORMAL, 0, 0);
    }

    protected double calcCriticalHit(Pokemon att, Pokemon def) {
        return 2 * att.getStat(Stat.SPEED)/512;
    }

    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }

    @Override
    protected String describe() {
        return "шанс критического удара повышается благодаря FocusEnergy";
    }
}
