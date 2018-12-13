import javax.swing.*;
public class PongMain{
    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100,100,600,600);
        Pong game = new Pong();
        PongDisplay display = new PongDisplay(game);
        frame.add(display);
        game.reset();
        display.draw();
        GenerationManager Gen = new GenerationManager();
        Gen.createNewGeneration();
        for(NeuralNetwork NN: Gen.Generation){
            //make decisions
        }
        for(int i = 0; i < 20;i++){
            game.ballMove();
            display.draw();
            try{
                Thread.sleep(250);
            }
            catch(Exception e){
                System.out.println(e);
            }   
        }
    }
}