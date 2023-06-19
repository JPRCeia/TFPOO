public class Hero extends Personagem{
    public int health;
    public int damage;
    public Weapon weapon; 
    public Hero(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        health = 100;
        damage = 20;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }
}
