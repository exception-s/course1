package moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class Blizzard extends SpecialMove {
    public Blizzard() {
        super(Type.ICE, 110, 70);
    }

    private boolean flag;

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        int prob = (int)(Math.random() * 101);
        if (prob <= 10) {
            flag = true;
            Effect.freeze(pokemon);
        }
    }


    @Override
    protected String describe() {
        if (flag) return "Удача на вашей стороне, атака Blizzard замораживает и наносит урон";
        else return "Атака Blizzard наносит урон";
    }
}
