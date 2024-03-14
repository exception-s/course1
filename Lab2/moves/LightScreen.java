package moves;

import ru.ifmo.se.pokemon.*;

public class LightScreen extends StatusMove {
    public LightScreen() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        Effect e = new Effect().turns(5).stat(Stat.SPECIAL_DEFENSE, +2);
        pokemon.addEffect(e);
    }

    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }

    @Override
    protected String describe() {
        return "Покемон применяет Light Screeen, повреждения от специальных атак понижаются наполовину в течение пяти ходов";
    }
}
