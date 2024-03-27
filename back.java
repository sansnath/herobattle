package herobattle;

public class back {
    private String name;
    private double hp;
    private double attack;
    private double defence;

    public back(String name, double hp, double attack, double defence) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
    }

    public back() {

    }

    public void setNama(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getHp() {
        return hp;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getAttack() {
        return attack;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }

    public double getDefence() {
        return defence;
    }
}
