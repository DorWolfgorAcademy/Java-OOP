package Logic.character;

import Logic.side.Side;
import Logic.Stats;
import Logic.enums.specie;
import Logic.enums.userSelection;

public class Human extends Character{

    public Human(Stats stats, String rank, Logic.enums.type type, String name, Side side) {
        super(stats, rank, type, name,side);
        stats.setCurPhysicalAttack((int) (stats.getPhysicalAttack()*1.2));
    }

    @Override
    public specie getSpecie() {
        return specie.Human;
    }

    @Override
    public void makeAction(Character defender, userSelection userSelection) {
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
            default:
                throw new IllegalArgumentException("The user selection is illegal.\n");
        }
    }

    public void resetStats(){
        resetStats();
        stats.setCurPhysicalAttack((int) (stats.getPhysicalAttack()*1.2));
    }

    @Override
    public String toString() {
        return super.toString() + "Specie=Human\n";
    }
}
