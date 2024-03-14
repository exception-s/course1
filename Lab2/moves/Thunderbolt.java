package moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class Thunderbolt extends SpecialMove {
    public Thunderbolt(){
        super(Type.ELECTRIC, 90, 100);
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
        if (flag) return "Удача на Вашей стороне, атака Thunderbolt парализует противника и наносит урон";
        else return "Атака Thunderbolt наносит урон";
    }
}
