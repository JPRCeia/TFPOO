public class Monstro extends ElementoBasico {
    public int health;
    public int damage;

    public Monstro(String id,String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro, int health,int damage) {
        super(id,iconPath, linInicial, colInicial, tabuleiro);
        this.health = health;
        this.damage = damage;
    }


    @Override
    public void acao(ElementoBasico outro) {

    }
}
    
