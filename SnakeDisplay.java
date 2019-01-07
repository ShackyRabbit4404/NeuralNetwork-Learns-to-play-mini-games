import java.awt.*;
import javax.swing.*;
import java.util.*;
public class SnakeDisplay extends JPanel{
    ArrayList<int[]> snake;
    int[] foodXY;
    //board length/width
    int blw;
    public SnakeDisplay(){
        super();
        snake = new ArrayList<int[]>();
        foodXY = new int[2];
        blw = 400;
    }
    public void draw(ArrayList<int[]> s,int[] fc){
        super.repaint();
        snake = s;
        foodXY = fc;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        System.out.println("Snake: "+snake.size());
        g.setColor(Color.GRAY);
        g.fillRect(0,0,blw,blw);
        g.setColor(Color.BLACK);
        g.fillRect(blw/20,blw/20,blw-(blw/20*2),blw-(blw/20*2));
        g.setColor(Color.RED);
        g.fillRect(foodXY[0]*(blw/20),foodXY[1]*(blw/20) ,blw/20,blw/20);
        g.setColor(Color.WHITE);
        for(int[] i: snake){
            g.fillRect(i[0]*(blw/20),i[1]*(blw/20),blw/20,blw/20);
            System.out.print("("+i[0]+","+i[1]+") ");
        }
        System.out.println("");
    }
}