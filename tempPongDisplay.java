import java.awt.*;
import javax.swing.*;
public class tempPongDisplay extends JPanel{
    int ballWidth;
    int ballHeight;
    int[]  info;
    int score;
    public tempPongDisplay(){
        super();
        ballWidth = 10;
        ballHeight = 11;
        info = new int[3];
        score = 0;
    }
    public void draw(int[] i,int s){
        super.repaint();
        info = i;
        score = s;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,500,500);
        g.setColor(Color.WHITE);
        g.drawRect(0,0,500,500);
        g.fillRect(info[0],info[1],ballWidth,ballHeight);
        g.fillRect(info[2],480,100,5);
        g.drawString("Score: "+score,10,10);
    }
}