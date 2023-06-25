public class Monstro extends ElementoBasico {
    private int health;
    private int damage;
    private boolean defeated;

    public Monstro(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro, int health,
            int damage) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        this.health = health;
        this.damage = damage;
        this.defeated = false;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isDefeated() {
        return defeated;
    }

    public void setDefeated(boolean defeated) {
        this.defeated = defeated;
    }

    public void attack(Hero hero) {
        hero.setHealth(hero.getHealth() - damage);
        if (hero.getHealth() <= 0) {
            // The hero has been defeated
            // You can add logic here to handle game over
        }
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (outro instanceof Hero) {
            Hero hero = (Hero) outro;
            attack(hero);
            if (!isDefeated()) {
                hero.attack(this);
                if (isDefeated()) {
                    // The hero has defeated the monster
                    // You can add logic here to handle rewards or progression
                }
            }
        }
    }
}
