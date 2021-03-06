package Logic.side;

import Logic.Stats;
import Logic.enums.EnumSide;

public class SuperHero extends Side implements SpecialSide {

    private int turnsLeft = 0;
    private boolean active = false;

    @Override
    public String specialSide() {
        return "Slur affect";
    }

    @Override
    public EnumSide getSide() {
        return EnumSide.SuperHero;
    }

    @Override
    public void activeSide(Stats statsAttacker, Stats statsDefender) {
        if(!active){
            statsAttacker.setCurPhysicalAttack((int) (statsAttacker.getCurPhysicalAttack()+statsAttacker.getPhysicalAttack()*0.1));
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
        return "SuperHero\n";
    }
}
