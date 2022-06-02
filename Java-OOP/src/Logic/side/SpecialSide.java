package Logic.side;

import Logic.Stats;

public interface SpecialSide {
    String specialSide();
    void activeSide(Stats statsAttacker, Stats statsDefender);

    void deActivateSide(Stats statsAttacker, Stats statsDefender);
}
