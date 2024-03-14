package moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class ThunderShock extends SpecialMove {
    public ThunderShock() {
        super(Type.ELECTRIC, 40, 100);
    }

    private boolean flag;

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        int prob = (int)(Math.random() * 101);
        if (prob <= 10) {
            flag = true;
            Effect.paralyze(pokemon);
        }
    }
    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }

    @Override
    protected String describe() {
        if (flag) return "Удача на Вашей стороне, атака ThunderShock парализует противника и наносит урон";
        else return "Атака ThunderShock наносит урон";
    }
}
