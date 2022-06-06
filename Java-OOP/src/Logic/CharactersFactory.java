package Logic;

import Logic.Character.Alien;
import Logic.Character.Character;
import Logic.Character.Human;
import Logic.Character.Mutant;
import Logic.enums.Type;
import Logic.side.SuperHero;
import Logic.side.SuperVillain;

import java.util.LinkedList;
import java.util.List;

public class CharactersFactory {
    public static List<Character> initCharacters(){
        List<Character> characters = new LinkedList<>();
        makeCharacters(characters);
        return characters;
    }

    static void makeCharacters(List<Character> characters) {
        characters.add(new Mutant(new Stats(70, 90, 7,100), "XMen",
                Type.Universal, "Dark Phoenix", new SuperVillain()));
        characters.add(new Human(new Stats(40, 50, 8,52), "Avengers",
                Type.Combat, "Captain America", new SuperHero()));
        characters.add(new Alien(new Stats(30, 55, 7,87), "Guardians of the Galaxy",
                Type.Speed,"Gamorrah",new SuperHero() ));
    }
}
