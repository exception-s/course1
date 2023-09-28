package moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Imprison extends StatusMove{
    public Imprison() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }

    @Override
    protected String describe() {
        return "Теперь противникам нельзя использовать те же атаки, что и у Pichu";
    }
}
