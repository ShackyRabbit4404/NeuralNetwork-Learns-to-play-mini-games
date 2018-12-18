import javax.swing.*;
import java.awt.*;
public class FlappyBirdDisplay extends JPanel{
    private int[] map;
    private int[] playerXY;
    public FlappyBirdDisplay(){
        super();
        map = new int[3];
        playerXY = new int[2];
    }
    public void draw(int[] m,int[] pxy){
        map = m;
        playerXY = pxy;
        super.repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0,0,500,500);
        g.setColor(Color.GRAY);
        for(int i = 0; i<map.length;i++){
            g.fillRect(200*i+(200-playerXY[0]),0,20,map[i]-50);
            g.fillRect(200*i+(200-playerXY[0]),map[i]+50,20,500-(map[i]+50));
        }
        g.setColor(Color.RED);
        g.fillRect(100,playerXY[1],10,10);
    }
}