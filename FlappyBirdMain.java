public class FlappyBirdMain{
    public static void main(String args[]){
        int[] struct = {4,3,1};
        GenerationManager gen = new GenerationManager(struct);
        FlappyBird game = new FlappyBird();
        int numGens = 100;
        gen.createNewGeneration();
        NeuralNetwork best = gen.Generation.get(0);
        for(int i = 0; i < numGens; i++){
            for(NeuralNetwork NN: gen.Generation){
                game.simulate(NN,false);
            }
            gen.sortGen();
            if(gen.Generation.get(0).getFitness() > best.getFitness()){
                best = gen.Generation.get(0);
            }
            if(best.getFitness() > 1000){
                System.out.println("Mastered");
                break;
            }
            gen.crossGeneration();
            System.out.println((i+1)+". Best: "+best.getFitness());
        }
        game.simulate(best,true);
    }
}