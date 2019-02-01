import java.awt.*;
import javax.swing.*;
public class FlappyBirdDisplay extends JPanel{
    int[][] walls;
    double y;
    int playerSize;
    int openingSize;
    public FlappyBirdDisplay(int p,int o){
        super();
        playerSize = p;
        openingSize = o;
    }
    public void draw(int[][] w, double Y){
        walls = w;
        y = Y;
        super.repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0,0,500,500);
        g.setColor(Color.RED);
        g.fillRect(100-playerSize,(int)(500-y-playerSize),playerSize*2,playerSize*2);
        g.setColor(Color.BLACK);
        for(int[] e: walls){
            g.fillRect(e[1]+100,0,1,e[0] - (openingSize/2-1));
            g.fillRect(e[1]+100,e[0] + (openingSize/2+1),1,500);
        }
    }
}