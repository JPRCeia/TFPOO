public class HealthPackage extends ElementoBasico {
    private int healingAmount;

    public HealthPackage(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro,
            int healingAmount) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        this.healingAmount = healingAmount;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (outro instanceof Hero) {
            Hero hero = (Hero) outro;
            hero.heal(healingAmount);
            System.out.println("Hero's health restored. Remaining health: " + hero.getHealth());
        }
    }
}
