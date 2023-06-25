import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Tabuleiro extends JPanel {
    private static final int MAXLIN = 20;
    private static final int MAXCOL = 20;
    private ElementoBasico[][] celulas;

    private Personagem principal;

    public Tabuleiro() {
        super();
        // Cria o conjunto de células vazia e as insere no layout
        celulas = new ElementoBasico[MAXLIN][MAXCOL];
        this.setLayout(new GridLayout(MAXLIN, MAXCOL));
        for (int i = 0; i < MAXLIN; i++) {
            for (int j = 0; j < MAXCOL; j++) {

                celulas[i][j] = new Fundo("Fundo[" + i + "][" + j + "]", i, j, this);
                this.add(celulas[i][j]);
            }
        }
    }

    public static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = App.class.getResource("imagens/" + path);

        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            System.exit(0);
            return null;
        }
    }

    public static int getMaxlin() {
        return MAXLIN;
    }

    public static int getMaxcol() {
        return MAXCOL;
    }

    public boolean posicaoValida(int lin, int col) {
        if ((lin < 0) || (col < 0) ||
                (lin >= MAXLIN) || (col >= MAXCOL)) {
            return false;
        } else {
            return true;
        }
    }

    // Retorna referencia em determinada posição
    public ElementoBasico getElementoNaPosicao(int lin, int col) {
        if (!posicaoValida(lin, col)) {
            return null;
        }
        return celulas[lin][col];
    }

    public ElementoBasico insereElemento(ElementoBasico elemento) {
        int lin = elemento.getLin();
        int col = elemento.getCol();
        if (!posicaoValida(lin, col)) {
            throw new IllegalArgumentException("Posicao invalida:" + lin + " ," + col);
        }
        ElementoBasico elementoAnterior = celulas[lin][col];
        celulas[lin][col] = elemento;
        return elementoAnterior;
    }

    public void atualizaVisualizacao() {
        // Atualiza o conteúdo do JPanel (ver algo melhor)
        this.removeAll(); // erase everything from your JPanel
        this.revalidate();
        this.repaint();// I always do these steps after I modify my JPanel
        for (int i = 0; i < MAXLIN; i++) {
            for (int j = 0; j < MAXCOL; j++) {
                this.add(celulas[i][j]);
            }
        }
    }

    public void loadLevel(int nivel) {
        Path path1 = Paths.get(String.format("nivel%d.txt", nivel));
        try (BufferedReader reader = Files.newBufferedReader(path1)) {
            String line = null;
            int lin = 0;
            while ((line = reader.readLine()) != null) {
                for (int col = 0; col < MAXCOL; col++) {
                    if (line.charAt(col) != ' ') {
                        ElementoBasico elem = getElem(line.charAt(col), lin, col);
                        insereElemento(elem);
                    } else {
                        ElementoBasico elem = new Fundo("Fundo", lin, col, this);
                        insereElemento(elem);
                    }
                }
                lin++;
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    public ElementoBasico getElem(char elem, int lin, int col) {
        Random r = new Random();
        switch (elem) {
            case ' ':
                return new Fundo("Fundo", lin, col, this);
            case '^':
                return new Trap("Trap", "trap_jogo.png", lin, col, this, 10); // Adjust the damage value as needed
            case '*': {
                ElementoBasico anterior = new Fundo("Fundo", lin, col, this);
                principal = new Personagem("Herói", "heroi_jogo.png", lin, col, this);
                principal.setAnterior(anterior);
                return principal;
            }
            case 'M': {
                int monsterHealth = r.nextInt(50) + 50; // Random health between 50 and 100
                int monsterDamage = r.nextInt(10) + 1; // Random damage between 1 and 10
                return new Monstro("Monster", "monster_jogo.png", lin, col, this, monsterHealth, monsterDamage);
            }
            case 'T': {
                int trapDamage = r.nextInt(10) + 1; // Random damage between 1 and 10
                return new Trap("Trap", "trap_jogo.png", lin, col, this, trapDamage);
            }
            case 'W': {
                int weaponDamage = r.nextInt(10) + 1; // Random damage between 1 and 10
                return new Weapon("Weapon", "weapon_jogo.png", lin, col, this, weaponDamage);
            }
            default:
                throw new IllegalArgumentException("Personagem inválido: " + elem);
        }
    }

    // personagem = new Personagem("Feliz","icone.jpg",2,0,tabuleiro);
    // ElementoBasico anterior = tabuleiro.insereElemento(personagem);
    // personagem.setAnterior(anterior);

    // Pista pista1 = new Pista("Pista15",15,2,4,tabuleiro);
    // tabuleiro.insereElemento(pista1);
    // Pista pista2 = new Pista("Pista22",22,0,2,tabuleiro);
    // tabuleiro.insereElemento(pista2);
    // Eca eca = new Eca("Eca2215",2215,4,2,tabuleiro);
    // tabuleiro.insereElemento(eca);

    public Personagem getPrincipal() {
        return principal;
    }
}
