package Logic;

public class Stats {
    private int physicalAttack;
    private int curPhysicalAttack;
    private int physicalDefence;
    private int curphysicalDefence;
    private int energy;
    private int HP;
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

    public void setPhysicalAttack(int physicalAttack) {
        this.physicalAttack = physicalAttack;
    }

    public int getPhysicalDefence() {
        return physicalDefence;
    }

    public void setPhysicalDefence(int physicalDefence) {
        this.physicalDefence = physicalDefence;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
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
        return "Your stats are:\n" +
                "physicalAttack=" +  curPhysicalAttack +
                ", physicalDefence=" + curphysicalDefence +
                ", energy=" + energy +
                ", HP=" + curHP +  '\n';
    }
}
