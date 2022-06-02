package Logic.side;

import Logic.Stats;
import Logic.enums.enumSide;

public abstract class Side {
    public abstract String specialSide();
    public abstract enumSide getSide();
    public abstract void activeSide(Stats statsAttacker, Stats statsDefender);

    public abstract void deActivateSide(Stats statsAttacker, Stats statsDefender);
}
