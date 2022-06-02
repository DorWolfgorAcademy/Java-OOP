package Logic.character;

import Logic.side.Side;
import Logic.Stats;
import Logic.enums.specie;
import Logic.enums.userSelection;

public class Mutant extends Character{

    boolean specialAttackOn;
    boolean specialAttackDone;//if special attack was in this round

    public Mutant(Stats stats, String rank, Logic.enums.type type, String name, Side side) {
        super(stats, rank, type, name,side);
        options.add("Special attack");
    }

    @Override
    public specie getSpecie() {
        return specie.Mutant;
    }

    @Override
    public void makeAction(Character defender, userSelection userSelection) {
        if (specialAttackOn == true) {
            specialAttack(defender);
        }
        switch (userSelection) {
            case Attack:
                Attack(defender);
                break;
            case Defend:
                Defence();
                break;
            case SpecialAbility:
                side.activeSide(this.stats,defender.stats);
                break;
            case SpecialAttack:
                specialAttackOn = true;
                break;
            default:
                throw new IllegalArgumentException("The user selection is illegal.\n");
        }
    }

    @Override
    public void Attack(Character character) {
        if(specialAttackDone){
            int damageCausedBySpecialAttack = damageCaused;
            Attack(character);
            damageCaused +=damageCausedBySpecialAttack;
        }
        else {
            Attack(character);
        }
    }

    public void specialAttack(Character character){
        int amountAdded = 0;
        amountAdded = (int) (this.stats.getCurPhysicalAttack()*(Math.random()));
        this.stats.setCurPhysicalAttack(this.stats.getCurPhysicalAttack()+amountAdded);
        specialAttackOn = false;
        super.Attack(character);
        this.stats.setCurPhysicalAttack(this.stats.getCurPhysicalAttack()-amountAdded);
        specialAttackDone = true;
    }


    @Override
    public String toString() {
        return super.toString() + "Specie=Mutant\n";
    }
}
