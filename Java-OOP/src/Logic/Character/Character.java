package Logic.Character;

import Logic.side.Side;
import Logic.Stats;
import Logic.enums.Specie;
import Logic.enums.Type;
import Logic.enums.UserSelection;
import Logic.side.SpecialSide;

import java.util.LinkedList;
import java.util.List;

public abstract class Character {
    protected Stats stats;
    protected int level;
    protected String rank;
    protected Type type;
    protected String name;
    protected boolean defence = false;
    protected Side side;
    protected int damageCaused;
    protected List<String> options = new LinkedList<>();



    public Character(Stats stats, String rank, Type type, String name, Side side) {
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
        if(side instanceof SpecialSide s){
            options.add(s.specialSide());
        }
    }

    public abstract Specie getSpecie();
    public abstract void makeAction(Character defender, UserSelection userSelection);
    public void resetStats(){
        stats.resetCurStats();
    }

    public boolean isAlive(){
        return stats.getCurHP()>0;
    }

    public void attack(Character character){//returns the amount of HP that's caused
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
        if(this.type == Type.Universal||character.type== Type.Universal){
            return;
        }
        if((this.type == Type.Blast&&character.type == Type.Combat)||
                (this.type == Type.Combat&&character.type == Type.Speed)||
                (this.type == Type.Speed&&character.type == Type.Blast)){
            this.stats.setCurPhysicalAttack((int) (this.stats.getPhysicalAttack()*0.1 + this.stats.getCurPhysicalAttack()));
        }
    }

    public void defence(){
        damageCaused = 0;
        defence = true;
    }

    public String sayItsName(){
        if(!(side instanceof SpecialSide)){
            return name + "\nI'm Natural!\n";
        }
        return name;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public void incLevel() {
        level++;
    }

    public String getName() {
        return name;
    }

    public Side getSide() {
        return side;
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
                stats.toString() +
                "level=" + level + "\n" +
                "rank=" + rank + "\n" +
                "type=" + type.toString() + "\n"+
                "side=" + side.toString();
    }
}
