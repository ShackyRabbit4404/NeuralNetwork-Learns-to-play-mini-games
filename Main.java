public class Main{
    public static void main(String[] args){
        int[] bStructure = {5,6,6,3};
        NeuralNetwork brain = new NeuralNetwork(bStructure);
        double[] inputs = {0.5,1,0.6,1,0.3};
        double[] outputs = brain.forwardPropagate(inputs);
        
        for(double e: outputs){
            System.out.print(e+" ");
        }
        
    }
}