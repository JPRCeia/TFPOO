public class Hero extends Personagem{
    public int health;
    public int damage;
    public Weapon weapon; 
    public Hero(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro, Weapon weapon) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        this.health = 100;
        this.damage = 20;
        this.weapon = weapon;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage + weapon.damage;
    }

}
