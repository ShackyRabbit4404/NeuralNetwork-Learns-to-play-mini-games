import javax.swing.*;
public class PongMain{
    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100,100,500,500);
        Pong game = new Pong();
        PongDisplay display = new PongDisplay(game);
        frame.add(display);
        
    }
}