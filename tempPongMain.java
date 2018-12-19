public class tempPongMain{
    public static void main(String[] args){
        int[] struct = {3,10,1};
        GenerationManager gen = new  GenerationManager(struct);
        int numGen = 1000;
        tempPong game = new tempPong();
        gen.createNewGeneration();
        NeuralNetwork best = gen.Generation.get(0);
        for(int i = 0; i < numGen; i++){
            for(NeuralNetwork NN: gen.Generation){
                game.simulate(NN,false);
            }
            gen.sortGen();
            if(gen.Generation.get(0).getFitness() > best.getFitness()){
                best = gen.Generation.get(0);
            }
            System.out.println("Generation: "+(i+1));
            System.out.println("Best: "+best.getFitness());
            gen.crossGeneration();
        }
        game.simulate(best,true);
    }
}