package Logic.side;

import Logic.Stats;
import Logic.enums.EnumSide;
import Logic.enums.UserSelection;

public class SuperVillain extends Side implements SpecialSide{
    private int turnsLeft = 0;
    private boolean active = false;

    @Override
    public UserSelection specialSide() {
        return UserSelection.Slur;
    }


    public EnumSide getSide() {
        return EnumSide.SuperVillain;
    }

    @Override
    public void activeSide(Stats statsAttacker, Stats statsDefender) {
        if(!active){
            double specialCause = 0.1;
            statsDefender.setCurphysicalDefence((int) (statsDefender.getCurphysicalDefence()-statsDefender.getPhysicalDefence()* specialCause));
            active = true;
        }
        turnsLeft = 4;
    }

    @Override
    public void deActivateSide(Stats statsAttacker, Stats statsDefender) {
        if (active) {
            turnsLeft--;
            if (turnsLeft == 0) {
                statsDefender.setCurphysicalDefence((int) (statsDefender.getCurphysicalDefence()+statsDefender.getPhysicalDefence()*0.1));
                active = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Super Villain\n";
    }
}
