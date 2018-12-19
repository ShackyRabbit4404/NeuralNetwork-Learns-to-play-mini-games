public class speedTest{
    public static void main(String[] args){
        int[] layers = {10,10};
        NeuralNetwork n = new NeuralNetwork(layers);
        long time = System.nanoTime();
        for(int i = 0; i < 100000;i++){
            double[] ins = new double[layers[0]];
            for(int a = 0; a < ins.length; a++){
               ins[a] = Math.random(); 
            }
            n.forwardPropagate(ins);
        }
        System.out.println("Time: "+(System.nanoTime()-time));
    }
}