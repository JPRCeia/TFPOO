public class Hero extends Personagem {
    public int health;
    public int damage;
    public Weapon weapon;
    public HealthPackage healthPackage;

    public Hero(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro, Weapon weapon,
            HealthPackage healthPackage) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        this.health = 100;
        this.damage = 20;
        this.weapon = weapon;
        this.healthPackage = healthPackage;
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

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setDamage(int damage) {
        this.damage = damage + weapon.getDamage();
    }

    public void heal(HealthPackage healthPackage) {
        this.health = +healthPackage.getHealth();
    }

}
