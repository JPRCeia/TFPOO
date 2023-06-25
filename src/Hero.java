public class Hero extends Personagem {
    private int health;
    private int damage;
    private Weapon weapon;

    public Hero(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro, Weapon weapon) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        this.health = 100;
        this.damage = 20;
        this.weapon = weapon;
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

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void attack(Monstro monster) {
        monster.setHealth(monster.getHealth() - (damage + weapon.getDamage()));
        if (monster.getHealth() <= 0) {
            monster.setDefeated(true);
        }
    }

    public void heal(int amount) {
        health += amount;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (outro instanceof Monstro) {
            Monstro monster = (Monstro) outro;
            attack(monster);
            System.out.println("Hero attacked the monster.");
            if (monster.isDefeated()) {
                System.out.println("Monster defeated.");
            } else {
                monster.attack(this);
                if (health <= 0) {
                    // The hero has been defeated
                    // You can add logic here to handle game over
                } else {
                    System.out.println("Hero's remaining health: " + health);
                }
            }
        }
    }
}
