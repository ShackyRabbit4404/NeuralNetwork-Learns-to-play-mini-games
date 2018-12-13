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
        boolean contin = true;
        while(contin){
            if(!game.ballMove()){
                contin = false;
            }
            display.draw();
            try{
                Thread.sleep(10);
            }
            catch(Exception e){
                System.out.println(e);
            }   
        }
    }
}