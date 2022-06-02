package Logic.side;

import Logic.enums.EnumSide;

public class Natural extends Side {

    public EnumSide getSide() {
        return EnumSide.Natural;
    }

    @Override
    public String toString() {
        return "Natural\n";
    }
}
