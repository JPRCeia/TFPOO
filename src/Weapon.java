
public class Weapon extends ElementoBasico{
    public int damage;

    public Weapon (String id,String iconPath,int linInicial,int colInicial,Tabuleiro tabuleiro,int damage){
       super(id,iconPath, linInicial, colInicial, tabuleiro);
       this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }



    @Override
    public void acao(ElementoBasico outro) {
        throw new UnsupportedOperationException("Unimplemented method 'acao'");
    }
}
