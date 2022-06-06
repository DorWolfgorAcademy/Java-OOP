package Logic;

import Logic.Character.Character;
import Logic.enums.UserSelection;
import Logic.side.SpecialSide;

import java.util.LinkedList;
import java.util.List;

public class GameLogic {
    private final List<Character> characters;
    private Character userCharacter;
    private Character computerCharacter;
    private boolean userTurn = true;

    public GameLogic() {
        characters = CharactersFactory.initCharacters();
    }

    public List<Character> getCharacters() {
        return characters;
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

    public void round(UserSelection userSelection) {
        if (userTurn) {
            makeAction(userCharacter, computerCharacter, userSelection);
        } else {

            makeAction(computerCharacter, userCharacter, userSelection);
        }
        decideOnTurnOfUser();
    }

    public void makeAction(Character attacker, Character defender, UserSelection userSelection) throws IllegalArgumentException{
        attacker.makeAction(defender,userSelection);
        if(attacker.getSide() instanceof SpecialSide s){
            s.deActivateSide(attacker.getStats(),defender.getStats());
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
