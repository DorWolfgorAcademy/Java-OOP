package Logic;

import Logic.character.Alien;
import Logic.character.Character;
import Logic.character.Human;
import Logic.character.Mutant;
import Logic.enums.type;
import Logic.side.Side;
import Logic.side.SuperHero;
import Logic.side.SuperVillain;

import java.util.LinkedList;
import java.util.List;

public class GameLogic {
    private List<Character> characters = new LinkedList<Character>();
    private Character userCharacter;
    private Character computerCharacter;
    private boolean userTurn = true;

    public List<Character> getCharacters() {
        return characters;
    }

    public void initCharacters(){
        characters.add(new Mutant(new Stats(70, 90, 7,100), "XMen",
                type.Universal, "Dark Phoenix", new SuperVillain()));
        characters.add(new Human(new Stats(40, 50, 8,52), "Avengers",
                type.Combat, "Captain America", new SuperHero()));
        characters.add(new Alien(new Stats(30, 55, 7,87), "Guardians of the Galaxy",
                 type.Speed,"Gamorrah",new SuperHero() ));
//        characters.add(new Alien(new StatsChart(85.0, 85.0, 9), 0, 15,
//                "Titan", Type.UNIVERSAL, Side.SUPER_VILLAIN, "Thanos"));
//        characters.add(new Human(new StatsChart(40, 70, 7), 0, 1,
//                "Avengers", Type.BLAST, Side.SUPER_HERO, "Spider Man"));
//        characters.add(new Other(new StatsChart(60.0, 45.0, 7), 0, 90,
//                "Asgardian", Type.UNIVERSAL, Side.SUPER_VILLAIN, "Loki"));
//        characters.add(new Mutant(new StatsChart(65.0, 30.0, 10), 0, 85,
//                "XMen", Type.COMBAT, Side.NEUTRAL, "Deadpool"));
//        characters.add(new Human(new StatsChart(90.0, 90.0, 8), 0, 26,
//                "Avengers", Type.UNIVERSAL, Side.SUPER_HERO, "Wanda"));
//        characters.add(new Human(new StatsChart(30.0, 60.0, 6), 0, 87,
//                "Self", Type.SPEED, Side.SUPER_HERO, "Wasp"));
//        characters.add(new Mutant(new StatsChart(60.0, 80.0, 8), 0, 88,
//                "XMen", Type.COMBAT, Side.NEUTRAL, "Wolverine"));
    }

    public void round(String userSelection) {
        if (userTurn) {
            makeAction(userCharacter, computerCharacter, userSelection);
        } else {

            makeAction(computerCharacter, userCharacter, userSelection);
        }
        decideOnTurnOfUser();
    }

    public void makeAction(Character attacker, Character defender, String userSelection) throws IllegalArgumentException{
        boolean actionNotDone = true;
        while(actionNotDone) {
            actionNotDone = false;
            switch (userSelection) {
                case "Attack":
                    attacker.makeAction(defender, Logic.enums.userSelection.Attack);
                    break;
                case "Defend":
                    attacker.makeAction(defender, Logic.enums.userSelection.Defend);
                    break;
                case "Special attack":
                    attacker.makeAction(defender, Logic.enums.userSelection.SpecialAttack);
                    break;
                default:
                    attacker.makeAction(defender, Logic.enums.userSelection.SpecialAbility);
                    break;
            }
        }
    }



    private void decideOnTurnOfUser(){
        userTurn = userCharacter.getStats().getEnergy()<=Math.random()*(userCharacter.getStats().getEnergy()+computerCharacter.getStats().getEnergy());
    }


    public Character getUserCharacter() {
        return userCharacter;
    }

    public Character getComputerCharacter() {
        return computerCharacter;
    }

    public void setUserCharacter(Character userCharacter) {
        this.userCharacter = userCharacter;
    }

    public void setComputerCharacter(Character computerCharacter) {
        this.computerCharacter = computerCharacter;
    }

    public boolean isUserTurn() {
        return userTurn;
    }
}
