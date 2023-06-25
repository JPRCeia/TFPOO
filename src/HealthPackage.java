public class HealthPackage extends ElementoBasico {
    public Hero hero;
    public int health;

    public HealthPackage(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro, int health) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void acao(ElementoBasico outro) {
        throw new UnsupportedOperationException("Unimplemented method 'acao'");
    }
}
