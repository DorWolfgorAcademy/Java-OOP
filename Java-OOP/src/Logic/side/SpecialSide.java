package Logic.side;

import Logic.Stats;
import Logic.enums.UserSelection;

public interface SpecialSide {
    UserSelection specialSide();
    void activeSide(Stats statsAttacker, Stats statsDefender);

    void deActivateSide(Stats statsAttacker, Stats statsDefender);
}
