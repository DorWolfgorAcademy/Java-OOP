package Logic.side;

import Logic.Stats;
import Logic.enums.enumSide;

public class Natural extends Side {
    @Override
    public String specialSide() {
        return null;
    }

    @Override
    public enumSide getSide() {
        return enumSide.Natural;
    }

    @Override
    public void activeSide(Stats statsAttacker, Stats statsDefender) {
        throw new IllegalArgumentException("There is no special ability.");
    }

    @Override
    public void deActivateSide(Stats statsAttacker, Stats statsDefender) {
        throw new IllegalArgumentException("There is no special ability.");
    }


    @Override
    public String toString() {
        return "Natural\n";
    }
}
