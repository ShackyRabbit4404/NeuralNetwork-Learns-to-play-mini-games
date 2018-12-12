import java.awt.*;
import javax.swing.*;
public class Display extends JComponent{
    int playerX;
    int playerY;
    int ballX;
    int ballY;
    public Display(){
        super();
    }
    public void draw(){
        super.repaint();
    }
    public void PaintComponent(Graphics g){
        super.paintComponent(g);
        
    }
}