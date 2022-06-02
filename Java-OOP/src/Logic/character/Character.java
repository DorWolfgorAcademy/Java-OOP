package Logic.character;

import Logic.side.Side;
import Logic.Stats;
import Logic.enums.enumSide;
import Logic.enums.specie;
import Logic.enums.type;
import Logic.enums.userSelection;

import java.util.LinkedList;
import java.util.List;

public abstract class Character {
    protected Stats stats;
    protected int level;
    protected String rank;
    protected type type;
    protected String name;
    protected boolean defence = false;
    protected Side side;
    protected int damageCaused;
    protected List<String> options = new LinkedList<String>();



    public Character(Stats stats, String rank, Logic.enums.type type, String name, Side side) {
        this.stats = stats;
        this.rank = rank;
        this.type = type;
        this.name = name;
        this.side = side;
        level = 0;
        makeOptions();
    }

    private void makeOptions(){
        options.add("Stats");
        options.add("Name");
        options.add("Attack");
        options.add("Defend");
        if(side.specialSide() !=null){
            options.add(side.specialSide());
        }
    }

    public abstract specie getSpecie();
    public abstract void makeAction(Character defender, userSelection userSelection);
    public void resetStats(){
        stats.resetCurStats();
    }

    public boolean isAlive(){
        return stats.getCurHP()>0;
    }

    public void Attack(Character character){//returns the amount of HP that's caused
        if(character.defence){
            character.defence=false;
            if(Math.random()<=0.7){
                damageCaused = 0;
                return;
            }
        }
        double v = 1-(character.stats.getCurphysicalDefence() / 100.0);
        damageCaused = (int) (this.stats.getCurPhysicalAttack()* v);
        character.stats.setCurHP(character.stats.getCurHP()-damageCaused);
    }

    public void changeStatsAccordingToType(Character character){
        if(this.type == Logic.enums.type.Universal||character.type== Logic.enums.type.Universal){
            return;
        }
        if((this.type == Logic.enums.type.Blast&&character.type == Logic.enums.type.Combat)||
                (this.type == Logic.enums.type.Combat&&character.type == Logic.enums.type.Speed)||
                (this.type == Logic.enums.type.Speed&&character.type == Logic.enums.type.Blast)){
            this.stats.setCurPhysicalAttack((int) (this.stats.getPhysicalAttack()*0.1 + this.stats.getCurPhysicalAttack()));
        }
    }

    public void Defence(){
        damageCaused = 0;
        defence = true;
    }

    public String sayItsName(){
        if(side.getSide() == enumSide.Natural){
            return name + "\nI'm Natural!\n";
        }
        return name;
    }

    public String showItsStats(){
        return stats.toString();
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public int getLevel() {
        return level;
    }

    public void incLevel() {
        level++;
    }

    public void decLevel() {
        level--;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Logic.enums.type getType() {
        return type;
    }

    public void setType(Logic.enums.type type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isDefence() {
        return defence;
    }

    public void setDefence(boolean defence) {
        this.defence = defence;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public int getDamageCaused() {
        return damageCaused;
    }

    public List<String> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return "Character name=" + name + "\n"+
                "stats=" + stats.toString() +
                "level=" + level + "\n" +
                "rank=" + rank + "\n" +
                "type=" + type.toString() + "\n"+
                "side=" + side.toString() + "\n";
    }
}
