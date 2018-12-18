import javax.swing.*;
public class SnakeMain{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100,100,600,600);
        Snake game = new Snake();
        snakeDisplay display = new snakeDisplay(game);
        frame.add(display);
        int[] struct = {7,4,3};
        GenerationManager gen = new GenerationManager(struct);
        gen.createNewGeneration();
        int numGens = 10;
        int genNum = 1;
        NeuralNetwork best = gen.Generation.get(0);
        game.reset();
        /*
        for(int i = 0; i < 10;i++){
            game.move(2);
            display.draw();
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println(e);
            }
            game.move(1);
            display.draw();
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        */
        for(int a = 0; a < numGens; a++){
            display.setGenNum(genNum);
            for(NeuralNetwork NN: gen.Generation){
                game.reset();
                game.setRandFoodLoc();
                boolean contin = true;
                int numMove = 0;
                double prevScore = 0;
                while(contin){
                    if(numMove > 500){
                        break;
                    }
                    if(game.score > prevScore){
                        numMove = 0;
                        prevScore = game.score;
                    }
                    int left = game.checkLeft();
                    int straight = game.checkStraight();
                    int right = game.checkRight();
                    double[] inputs = {(game.headX-10)/500,(game.headY-10)/500,(game.foodX-10)/500,(game.foodY-10)/500,left,straight,right};
                    double[] choices = NN.forwardPropagate(inputs);
                    int largest = 0;
                    for(int i = 0; i < choices.length; i++){
                        if(choices[i] > choices[largest]){
                            largest = i;
                        }
                    }
                    //System.out.println(largest);
                    display.draw();
                    if(game.move(largest)){
                        contin = false;
                    }
                    try{
                        Thread.sleep(200);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    //System.out.println("("+game.foodX+","+game.foodY+")");
                    numMove++;
                }
                NN.setFitness((int)(game.score+0.5));
            }
            gen.sortGen();
            System.out.println(gen.Generation.get(0).getFitness());
            if(gen.Generation.get(0).getFitness() > best.getFitness()){
                best = gen.Generation.get(0);
            }
            gen.crossGeneration();
            genNum ++;
        }
    }
    
}