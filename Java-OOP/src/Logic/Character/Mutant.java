package Logic.Character;

import Logic.enums.Type;
import Logic.side.Side;
import Logic.Stats;
import Logic.enums.Specie;
import Logic.enums.UserSelection;
import Logic.side.SpecialSide;

public class Mutant extends Character{

    boolean specialAttackOn;
    boolean specialAttackDone;//if special attack was in this round

    public Mutant(Stats stats, String rank, Type type, String name, Side side) {
        super(stats, rank, type, name,side);
        options.add("Special attack");
    }

    @Override
    public Specie getSpecie() {
        return Specie.Mutant;
    }

    @Override
    public void makeAction(Character defender, UserSelection userSelection) {
        if (specialAttackOn) {
            specialAttack(defender);
        }
        switch (userSelection) {
            case Attack -> attack(defender);
            case Defend -> defence();
            case SpecialAbility -> {
                SpecialSide s = (SpecialSide) side;
                s.activeSide(this.stats, defender.stats);
            }
            case SpecialAttack -> specialAttackOn = true;
            default -> throw new IllegalArgumentException("The user selection is illegal.\n");
        }
    }

    @Override
    public void attack(Character character) {
        if(specialAttackDone){
            int damageCausedBySpecialAttack = damageCaused;
            attack(character);
            damageCaused +=damageCausedBySpecialAttack;
        }
        else {
            attack(character);
        }
    }

    public void specialAttack(Character character){
        int amountAdded;
        amountAdded = (int) (this.stats.getCurPhysicalAttack()*(Math.random()));
        this.stats.setCurPhysicalAttack(this.stats.getCurPhysicalAttack()+amountAdded);
        specialAttackOn = false;
        super.attack(character);
        this.stats.setCurPhysicalAttack(this.stats.getCurPhysicalAttack()-amountAdded);
        specialAttackDone = true;
    }


    @Override
    public String toString() {
        return super.toString() + "Specie=Mutant\n";
    }
}
