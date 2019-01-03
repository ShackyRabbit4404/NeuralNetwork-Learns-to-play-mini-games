import javax.swing.*;
public class PongMain{
    public static void main(String[] args){
        int[] struct = {3,5,1};
        GenerationManager gen = new  GenerationManager(struct);
        int numGen = 5000;
        Pong game = new Pong();
        gen.createNewGeneration();
        NeuralNetwork best = gen.Generation.get(0);
        
        JFrame bestrgraph = new JFrame("Best raw score over generations");
        bestrgraph.setSize(500,500);
        bestrgraph.setResizable(false);
        bestrgraph.setVisible(true);
        bestrgraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StatisticsGraph brg = new StatisticsGraph(bestrgraph,500,500);
        bestrgraph.add(brg);
        brg.setVisible(true);
        brg.addPoint(0,0);
        
        for(int i = 0; i < numGen; i++){
            for(NeuralNetwork NN: gen.Generation){
                game.simulate(NN,false);
            }
            gen.sortGen();
            if(gen.Generation.get(0).getFitness() > best.getFitness()){
                best = gen.Generation.get(0);
            }
            if(best.getFitness() >= 10000){
                System.out.println("Mastered");
                break;
            }
            gen.crossGeneration();
            if(i%200 == 0){
                brg.addPoint(i,best.getFitness());
            }
        }
        brg.addPoint(numGen,best.getFitness());
        game.simulate(best,true);
    }
}