package lab2.pokemons;

import lab2.moves.Imprison;
import lab2.moves.ThunderShock;
import lab2.moves.Thunderbolt;
import lab2.moves.Wish;
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
