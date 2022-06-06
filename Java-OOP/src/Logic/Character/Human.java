package Logic.Character;

import Logic.enums.Type;
import Logic.side.Side;
import Logic.Stats;
import Logic.enums.Specie;
import Logic.enums.UserSelection;
import Logic.side.SpecialSide;

public class Human extends Character{

    public Human(Stats stats, String rank, Type type, String name, Side side) {
        super(stats, rank, type, name,side);
        stats.setCurPhysicalAttack((int) (stats.getPhysicalAttack()*1.2));
    }

    @Override
    public Specie getSpecie() {
        return Specie.Human;
    }

    @Override
    public void makeAction(Character defender, UserSelection userSelection) {
        switch (userSelection) {
            case Attack -> attack(defender);
            case Defend -> defence();
            case Slur, Moral -> {
                SpecialSide s = (SpecialSide) side;
                s.activeSide(this.stats, defender.stats);
            }
            default -> throw new IllegalArgumentException("The user selection is illegal.\n");
        }
    }

    public void resetStats(){
        super.resetStats();
        stats.setCurPhysicalAttack((int) (stats.getPhysicalAttack()*1.2));
    }

    @Override
    public String toString() {
        return super.toString() + "Specie=Human\n";
    }
}
