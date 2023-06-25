public class Trap extends ElementoBasico {
    private int damage;

    public Trap(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro, int damage) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (outro instanceof Hero) {
            Hero hero = (Hero) outro;
            hero.setHealth(hero.getHealth() - damage);
            if (hero.getHealth() <= 0) {
                // The hero has been defeated
                // You can add logic here to handle game over
            }
        }
    }
}
