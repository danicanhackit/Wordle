import java.awt.Color;
import java.awt.Graphics;

public class Tile {
    int x, y, width, height;
    char letter;
    Color col;

    public Tile(){
        x = 0;
        y = 0;
        width = 50;
        height = 50;
        letter = 'a';
        col = Color.RED;
    }

    public Tile(int x, int y, char c){
        this.x = x;
        this.y = y;
        width = 100;
        height = 100;
        letter = c;
        col = Color.MAGENTA;
    }

    public void drawTile(Graphics g2d){
        g2d.setColor(col);
        g2d.fillRect(x, y, width, height);
        g2d.setColor(Color.BLACK);
        g2d.drawString(""+letter, x+width/2, y+height/2);
        g2d.setColor(Color.GRAY);
    }

    public void setLetter(char s){
        letter = s;
    }

    public char getLetter(){
        return letter;
    }

    public void setColor(Color c){
        col = c;
    }
}