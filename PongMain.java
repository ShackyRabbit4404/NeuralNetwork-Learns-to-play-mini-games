import javax.swing.*;
import java.util.*;
public class PongMain{
    public static void main(String args[]){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100,100,600,600);
        Pong game = new Pong();
        GenerationManager Gen = new GenerationManager();
        PongDisplay display = new PongDisplay(game,Gen);
        frame.add(display);
        //display.draw();
        Gen.createNewGeneration();
        int[] netStruct = {4,3,2};
        NeuralNetwork best = Gen.Generation.get(0);
        for(int a = 0; a < 1000; a++){
            int networkNum = 1;
            for(NeuralNetwork NN: Gen.Generation){
                boolean contin = true;
                game.reset();
                game.setNetworkNumber(networkNum);
                while(contin){
                    int highest = 0;
                    double[] choices = NN.forwardPropagate(game.getInputData());
                    for(int  i= 0; i < choices.length; i++){
                        if(choices[i] > choices[highest]){
                            highest = i;
                        }
                    }
                    if (highest == 0){
                        game.playerMove(-3);
                    }
                    else{
                        game.playerMove(3);
                    }
                    if(!game.ballMove()){
                        contin = false;
                    }
                    if(game.getScore() > 50000 || game.getScore() < -1000){
                        break;
                    }
                    /*
                    display.draw();
                    
                    try{
                        Thread.sleep(1);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    */
                }
                NN.setFitness(game.getScore());
                networkNum += 1;
            }
            System.out.println("Generation Number: "+ Gen.genNum);
            Gen.sortGen();
            if(Gen.Generation.get(0).getFitness() > best.getFitness()){
                best = Gen.Generation.get(0);
            }
            System.out.println("Best: "+ best.getFitness());
            Gen.crossGeneration();
        }
        System.out.print("[");
        for(double[][] a: best.getWeights()){
            System.out.print("[");
            for(double[] b: a){
                for(double c: b){
                    System.out.print(c + ", ");
                }
                System.out.println("],");
            }
            System.out.print("]");
            System.out.println("---------------");
        }
        System.out.println("Score: "+best.getFitness());
        runBest(best);
    }
    public static void runSpecificNetwork(){
        ArrayList<double[][]> w = new ArrayList<double[][]>();
        double[][] l1 = {};
        double[][] l2 = {};
        int[] struct = {};
        NeuralNetwork best = new NeuralNetwork(struct);
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100,100,600,600);
        Pong game = new Pong();
        GenerationManager Gen = new GenerationManager();
        PongDisplay display = new PongDisplay(game,Gen);
        frame.add(display);
        boolean contin = true;
        while(contin){
            int highest = 0;
            double[] choices = best.forwardPropagate(game.getInputData());
            for(int  i= 0; i < choices.length; i++){
                if(choices[i] > choices[highest]){
                    highest = i;
                }
            }
            if (highest == 0){
                game.playerMove(-3);
            }
            else{
                game.playerMove(3);
            }
            if(!game.ballMove()){
                contin = false;
            }
            if(game.getScore() > 50000 || game.getScore() < -1000){
                break;
            }
            display.draw();
            
            try{
                Thread.sleep(1);
            }
            catch(Exception e){
                System.out.println(e);
            }
                    
         }
        
    }
    public static void runBest(NeuralNetwork b){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100,100,600,600);
        Pong game = new Pong();
        GenerationManager Gen = new GenerationManager();
        PongDisplay display = new PongDisplay(game,Gen);
        frame.add(display);
        display.draw();
        Gen.createNewGeneration();
        int[] netStruct = {4,3,3};
        NeuralNetwork best = Gen.Generation.get(0);
        boolean contin = true;
        game.reset();
        while(contin){
            int highest = 0;
            double[] choices = b.forwardPropagate(game.getInputData());
            for(int  i= 0; i < choices.length; i++){
                if(choices[i] > choices[highest]){
                    highest = i;
                }
            }
            if (highest == 0){
                game.playerMove(-3);
            }   
            else if(highest == 2){
                game.playerMove(3);
            }
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