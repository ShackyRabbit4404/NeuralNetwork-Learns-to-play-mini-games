import javax.swing.*;
public class SnakeMain{
    public static void main(String[] args){
        Snake game = new Snake();
        int[] struct = {8,7,5,4};
        GenerationManager gen = new GenerationManager(struct);
        gen.createNewGeneration();
        NeuralNetwork best = gen.Generation.get(0);
        /*
        JFrame bestrgraph = new JFrame("Best network overall");
        bestrgraph.setSize(500,500);
        bestrgraph.setResizable(false);
        bestrgraph.setVisible(true);
        bestrgraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StatisticsGraph brg = new StatisticsGraph(bestrgraph,500,500);
        bestrgraph.add(brg);
        brg.setVisible(true);
        brg.addPoint(0,0);
        */
        int numGens = 100;
        for(int i = 0; i < numGens; i++){
            for(NeuralNetwork NN: gen.Generation){
                game.simulate(NN,false);
            }
            gen.sortGen();
            if(gen.Generation.get(0).getFitness() > best.getFitness()){
                best = gen.Generation.get(0);
            }
            System.out.println("Fitness: "+ best.getFitness());
            gen.crossGeneration();
            //brg.addPoint(i+1,best.getFitness());
        }
        game.simulate(best,true);
    }
}