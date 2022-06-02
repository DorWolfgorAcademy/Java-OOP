package Logic;

import Logic.Character.Alien;
import Logic.Character.Character;
import Logic.Character.Human;
import Logic.Character.Mutant;
import Logic.enums.Type;
import Logic.enums.UserSelection;
import Logic.side.SpecialSide;
import Logic.side.SuperHero;
import Logic.side.SuperVillain;

import java.util.LinkedList;
import java.util.List;

public class GameLogic {
    private final List<Character> characters = new LinkedList<>();
    private Character userCharacter;
    private Character computerCharacter;
    private boolean userTurn = true;

    public List<Character> getCharacters() {
        return characters;
    }

    public void initCharacters(){
        characters.add(new Mutant(new Stats(70, 90, 7,100), "XMen",
                Type.Universal, "Dark Phoenix", new SuperVillain()));
        characters.add(new Human(new Stats(40, 50, 8,52), "Avengers",
                Type.Combat, "Captain America", new SuperHero()));
        characters.add(new Alien(new Stats(30, 55, 7,87), "Guardians of the Galaxy",
                 Type.Speed,"Gamorrah",new SuperHero() ));
    }

    public void winInBattle(Character character){
        character.incLevel();
        userCharacter.resetStats();
        computerCharacter.resetStats();
    }

    public void changeStatsAccordingToType(){
        userCharacter.changeStatsAccordingToType(computerCharacter);
        computerCharacter.changeStatsAccordingToType(userCharacter);
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
                case "Attack" -> attacker.makeAction(defender, UserSelection.Attack);
                case "Defend" -> attacker.makeAction(defender, UserSelection.Defend);
                case "Special attack" -> attacker.makeAction(defender, UserSelection.SpecialAttack);
                default -> attacker.makeAction(defender, UserSelection.SpecialAbility);
            }
        }
        if(attacker.getSide() instanceof SpecialSide s){
            s.deActivateSide(attacker.getStats(),defender.getStats());
        }
        if(defender.getSide() instanceof SpecialSide s){
            s.deActivateSide(defender.getStats(),attacker.getStats());
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
