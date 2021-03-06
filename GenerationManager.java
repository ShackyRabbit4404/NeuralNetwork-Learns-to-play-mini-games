import java.util.*;
public class GenerationManager{
    int genNum = 1;
    ArrayList<NeuralNetwork> Generation;
    //The structure of the network
    int[] struct;
    public GenerationManager(int[] s){
        Generation = new ArrayList<NeuralNetwork>();
        struct = s;
    }
    public void createNewGeneration(){
        for(int i = 0; i < 20; i++){
            Generation.add(new NeuralNetwork(struct));
        }
    }
    public void sortGen(){
        ArrayList<NeuralNetwork> newGen = new ArrayList<NeuralNetwork>();
        newGen.add(Generation.get(0));
        for(int a = 1; a < Generation.size(); a++){
            boolean isLast = true;
            for(int b = 0; b < newGen.size(); b++){
                if(Generation.get(a).getFitness() > Generation.get(b).getFitness()){
                    newGen.add(b,Generation.get(a));
                    isLast = false;
                    break;
                }
            }
            if(isLast){
                newGen.add(Generation.get(a));
            }
        }
        Generation = newGen;
    }
    public void crossGeneration(){
        ArrayList<NeuralNetwork> newGen = new ArrayList<NeuralNetwork>();
        int numNewNetworks = 2;
        for(int i = 0; i < numNewNetworks; i++){
            newGen.add(new NeuralNetwork(struct));
        }
        for(int i = 0; i < Generation.size()-numNewNetworks; i++){
           newGen.add(cross(Generation.get(i%5),Generation.get((int)(Math.random()*Generation.size()))));
        }
        Generation = newGen;
        genNum += 1;
    }
    public NeuralNetwork cross(NeuralNetwork x, NeuralNetwork y){
        NeuralNetwork temp = new NeuralNetwork(struct);
        ArrayList<double[][]> w = temp.getWeights();
        for(int a = 0; a < w.size();a++){
            for(int b = 0; b < w.get(a).length;b++){
                for(int c = 0; c < w.get(a)[b].length;c++){
                    if(Math.random() > 0.5){
                        w.get(a)[b][c] = x.getWeights().get(a)[b][c];
                    }
                    else{
                        w.get(a)[b][c] = y.getWeights().get(a)[b][c];
                    }
                }
            }
        }
        return temp;
    }
}