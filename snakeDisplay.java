import java.awt.*;
import javax.swing.*;
public class snakeDisplay extends JPanel{
    Snake snake;
    int genNum;
    public snakeDisplay(Snake s){
        super();
        snake = s;
    }
    public void setGenNum(int g){
        genNum = g;
    }
    public void draw(){
        super.repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillRect(0,0,520,520);
        g.setColor(Color.BLACK);
        g.fillRect(10,10,500,500);
        g.drawString("Generation Number: "+genNum,10,530);
        g.setColor(Color.RED);
        g.fillRect(snake.foodX,snake.foodY,10,10);
        g.setColor(Color.WHITE);
        for(Box b: snake.tail){
            g.fillRect(b.getX(),b.getY(),10,10);
        }
    }
}