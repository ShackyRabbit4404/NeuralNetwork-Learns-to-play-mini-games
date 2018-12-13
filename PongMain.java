import javax.swing.*;
public class PongMain{
    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100,100,600,600);
        Pong game = new Pong();
        PongDisplay display = new PongDisplay(game);
        frame.add(display);
        display.draw();
        GenerationManager Gen = new GenerationManager();
        Gen.createNewGeneration();
        for(int a = 0; a < 5; a++){
            for(NeuralNetwork NN: Gen.Generation){
                boolean contin = true;
                game.reset();
                while(contin){
                    int highest = 0;
                    double[] choices = NN.forwardPropagate(game.getInputData());
                    for(int  i= 0; i < choices.length; i++){
                        if(choices[i] > choices[highest]){
                            highest = i;
                        }
                    }
                    if (highest == 0){
                        game.playerMove(-5);
                    }
                    else if(highest == 2){
                        game.playerMove(5);
                    }
                    if(!game.ballMove()){
                        contin = false;
                    }
                    display.draw();
                    try{
                        Thread.sleep(5);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                }
                NN.setFitness(game.getScore());
            }
            Gen.sortGen();
            Gen.crossGeneration();
        }
    }
}