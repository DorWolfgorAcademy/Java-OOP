package Logic.side;

import Logic.Stats;
import Logic.enums.EnumSide;
import Logic.enums.UserSelection;

public class SuperHero extends Side implements SpecialSide {
    private int turnsLeft = 0;
    private boolean active = false;

    @Override
    public UserSelection specialSide() {
        return UserSelection.Moral;
    }

    @Override
    public EnumSide getSide() {
        return EnumSide.SuperHero;
    }

    @Override
    public void activeSide(Stats statsAttacker, Stats statsDefender) {
        if(!active){
            double specialCause = 0.1;
            statsAttacker.setCurPhysicalAttack((int) (statsAttacker.getCurPhysicalAttack()+statsAttacker.getPhysicalAttack()* specialCause));
            active = true;
        }
        turnsLeft = 3;
    }

    @Override
    public void deActivateSide(Stats statsAttacker, Stats statsDefender) {
        if (active) {
            turnsLeft--;
            if (turnsLeft == 0) {
                statsAttacker.setCurPhysicalAttack((int) (statsAttacker.getCurPhysicalAttack()-statsAttacker.getPhysicalAttack()*0.1));
                active = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Super Hero\n";
    }
}
