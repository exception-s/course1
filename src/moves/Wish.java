package moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Wish extends StatusMove {
    public Wish() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        if (pokemon.getHP() < (int)(pokemon.getStat(Stat.HP)/2)) pokemon.setMod(Stat.HP, -((int)(pokemon.getStat(Stat.HP)/2 - pokemon.getHP())));
    }

    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }

    @Override
    protected String describe() {
        return "восстановил себе здоровье до половины";
    }
}
