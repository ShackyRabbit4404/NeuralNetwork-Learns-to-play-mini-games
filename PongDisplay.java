import java.awt.*;
import javax.swing.*;
public class PongDisplay extends JPanel{
    Pong game;
    GenerationManager Gen;
    public PongDisplay(Pong g){
        super();
        game = g;
        //Gen = gen;
    }
    public void draw(){
        super.repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,500,500);
        //g.drawString((String)Gen.genNum,10,520);
        g.setColor(Color.WHITE);
        g.drawRect(0,0,500,500);
        g.fillRect(game.getBallX(),game.getBallY(),5,5);
        g.fillRect(game.getPlayerX(),480, 100, 10);
        //g.drawString(g.getScore(),10,10);
    }
}