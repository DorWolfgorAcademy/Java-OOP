package UI;

import Logic.Character.Character;
import Logic.GameLogic;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static UI.Utils.getRandomNumber;
import static UI.Utils.initUserName;

public class GameUI {
    private final GameLogic logic = new GameLogic();
    private final BattleUI battle;
    private String userName;

    public GameUI(){
        battle = new BattleUI(logic);
    }

    public void gameOn(){
        userName = initUserName();
        boolean continuePlaying = true;
        while(continuePlaying){
            SelectionPhase();
            battle.battle();
            continuePlaying = Utils.getBooleanFromUser();
        }
        System.out.println("Thank you for playing!\n");
    }

    public void SelectionPhase() {
        System.out.println("Hello " + userName + "!\n please select 1 of the following characters(choose the number that represents the character):\n");
        List<Character> characters = logic.getCharacters();
        for (int i = 1; i <= characters.size(); i++) {
            System.out.println((i) + ".) " + characters.get(i-1).toString());
        }
        logic.setUserCharacter(characters.get(Utils.getIntFromUser(1, characters.size())-1));
        Utils.clearConsoleScreen();
        System.out.println("Great!\n you chose :" + logic.getUserCharacter().toString());
        int randomNumber = getRandomNumber(0, characters.size()-1);
        logic.setComputerCharacter(characters.get(randomNumber));
        System.out.println("Your opponent will be :" + logic.getComputerCharacter().toString());
        System.out.println("Good luck " + userName + "!");
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
