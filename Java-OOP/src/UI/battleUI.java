package UI;

import Logic.GameLogic;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class battleUI {
    GameLogic logic;

    public battleUI(GameLogic logic) {
        this.logic = logic;
    }


    public void battle(){
        utils.clearConsoleScreen();
        System.out.println("Hello " + logic.getUserCharacter().getName() +"\n");
        while(logic.getComputerCharacter().isAlive()&&logic.getUserCharacter().isAlive()){
            if(logic.isUserTurn()){
                userTurn();
            }
            else{
                computerTurn();
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        if(logic.getComputerCharacter().isAlive()){
            System.out.println("You lost to " + logic.getComputerCharacter().getName() +" :(\n");
        }
        else{
            System.out.println("You have won ! :)\n ");
        }
    }

    public void userTurn(){
        boolean actionNotDone = true;
        System.out.println("Now it's Your turn\n");
        while(actionNotDone) {
            actionNotDone = false;
            String userSelection = getUserSelection();
            switch (userSelection) {
                case "Stats":
                    System.out.println(logic.getUserCharacter().getStats());
                    actionNotDone = true;
                    break;
                case "Name":
                    System.out.println(logic.getUserCharacter().getName());
                    actionNotDone = true;
                    break;
                default:
                    System.out.println("You chose " +userSelection +"!\n");
                    logic.round(userSelection);
                    System.out.println("The damage caused is "+logic.getUserCharacter().getDamageCaused()+"!\n");
            }
        }
    }

    public void computerTurn(){
        System.out.println("Now it's the turn of "+logic.getComputerCharacter().getName() +"\n");
        List<String> options = logic.getComputerCharacter().getOptions();
        Random rand = new Random();
        int selection = rand.nextInt(3,options.size());
        System.out.println("The computer chose "+options.get(selection-1)+"\n");
        logic.round(options.get(selection-1));
        System.out.println("The damage caused is "+logic.getComputerCharacter().getDamageCaused()+"\n");
    }

    public void showMenuOptions(){
        List<String> options = logic.getUserCharacter().getOptions();
        int i=1;
        for (String opt:options) {
            System.out.println(i+".) "+opt);
            i++;
        }
    }

    public String getUserSelection(){
        showMenuOptions();
        int selection = utils.getIntFromUser(1,logic.getUserCharacter().getOptions().size());
        return logic.getUserCharacter().getOptions().get(selection-1);
    }

}
