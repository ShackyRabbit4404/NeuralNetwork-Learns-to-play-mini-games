public class Main{
    public static void main(String[] args){
        int[] bStructure = {3,3,2};
        NeuralNetwork brain = new NeuralNetwork(bStructure);
        double[] inputs = {0.5,1,0.6};
        double[] outputs = brain.forwardPropagate(inputs);
        /*
        for(double e: outputs){
            System.out.print(e+" ");
        }
        */
    }
}