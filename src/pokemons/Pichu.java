package pokemons;

import moves.Imprison;
import moves.ThunderShock;
import moves.Thunderbolt;
import moves.Wish;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Pichu extends Pokemon {
    public Pichu(String name, int level) {
        super(name, level);
        setType(Type.ELECTRIC);
        setStats(20, 40, 15, 35, 35, 60);
        setMove(new Thunderbolt(), new Wish(), new Imprison(), new ThunderShock());
    }
}
