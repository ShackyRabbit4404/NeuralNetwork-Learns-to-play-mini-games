public class FlappyBirdMain{
    public static void main(String[] args){
        int[] struct = {3,5,1};
        GenerationManager gen = new GenerationManager(struct);
        gen.createNewGeneration();
        FlappyBird game = new FlappyBird();
        NeuralNetwork best = gen.Generation.get(0);
        for(int a = 0; a < 1000;a++){
            for(int b = 0; b < gen.Generation.size();b++){
                game.simulate(gen.Generation.get(b),true);
            }
            gen.sortGen();
            if(gen.Generation.get(0).getFitness() > best.getFitness()){
                best = gen.Generation.get(0);
            }
            System.out.println("Fitness: "+best.getFitness());
            gen.crossGeneration();
        }
    }
}