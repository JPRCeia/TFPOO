public class HealthPackage extends ElementoBasico{
    public Hero hero;
    public int health;

    public HealthPackage(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro,Hero hero){ 
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        this.health = 40;
        this.hero = hero;
    }

    public void heal(Hero hero){
       hero.health += health;
    }





    @Override
    public void acao(ElementoBasico outro) {
        throw new UnsupportedOperationException("Unimplemented method 'acao'");
    }
}
