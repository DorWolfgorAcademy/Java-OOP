package Logic;

public class Stats {
    private final int physicalAttack;
    private int curPhysicalAttack;
    private final int physicalDefence;
    private int curphysicalDefence;
    private final int energy;
    private final int HP;
    private int curHP;

    public Stats(int physicalAttack, int physicalDefence, int energy, int HP) {
        this.physicalAttack = physicalAttack;
        this.physicalDefence = physicalDefence;
        this.energy = energy;
        this.HP = HP;
        resetCurStats();
    }

    public void resetCurStats(){
        curHP = HP;
        curphysicalDefence = physicalDefence;
        curPhysicalAttack = physicalAttack;
    }


    public int getPhysicalAttack() {
        return physicalAttack;
    }


    public int getPhysicalDefence() {
        return physicalDefence;
    }


    public int getEnergy() {
        return energy;
    }


    public int getCurPhysicalAttack() {
        return curPhysicalAttack;
    }

    public void setCurPhysicalAttack(int curPhysicalAttack) {
        this.curPhysicalAttack = curPhysicalAttack;
    }

    public int getCurphysicalDefence() {
        return curphysicalDefence;
    }

    public void setCurphysicalDefence(int curphysicalDefence) {
        this.curphysicalDefence = curphysicalDefence;
    }

    public int getCurHP() {
        return curHP;
    }

    public void setCurHP(int curHP) {
        this.curHP = curHP;
    }


    @Override
    public String toString() {
        return "stats:\n" +
                "physicalAttack=" +  curPhysicalAttack +
                ", physicalDefence=" + curphysicalDefence +
                ", energy=" + energy +
                ", HP=" + curHP +  '\n';
    }
}
