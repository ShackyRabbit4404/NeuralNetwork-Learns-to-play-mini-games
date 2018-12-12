import java.util.*;
public class GenerationManager{
    int genNum = 1;
    ArrayList<NeuralNetwork> Generation;
    //The structure of the network
    int[] struct = {3,3,2};
    public GenerationManager(){
        Generation = new ArrayList<NeuralNetwork>();
    }
    public void createNewGeneration(){
        
        for(int i = 0; i < 50; i++){
            Generation.add(new NeuralNetwork(struct));
        }
    }
    public void crossGeneration(){
        ArrayList<NeuralNetwork> newGen = new ArrayList<NeuralNetwork>();
        for(int i = 0; i < 2; i++){
            newGen.add(new NeuralNetwork(struct));
        }
        for(int i = 0; i < 48; i++){
            
        }
    }
}