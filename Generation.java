public class Generation{
    NeuralNetwork[] gen;
    public Generation(int[] struct,int numPerGen){
        gen = new NeuralNetwork[numPerGen];
        for(int i = 0; i < numPerGen; i++){
            gen[i] = new NeuralNetwork(struct);
        }
    }
    public void sort(){
        for(int i = 0;i < gen.length;i++){
            for(int a = i+1; a < gen.length; a++){
                if(gen[i].getFitness() > 0){
                }
            }
        }
    }
}