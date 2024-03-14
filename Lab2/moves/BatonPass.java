package moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class BatonPass extends StatusMove {
    public BatonPass() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }

    @Override
    protected String describe() {
        return "Покемон использовал атаку Baton Pass";
    }
}
