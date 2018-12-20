public class GMSpeedTest{
    public static void main(String[] args){
        int[] struct = {10,10,10};
        GenerationManager gen = new GenerationManager(struct);
        gen.createNewGeneration();
        long time = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            gen.crossGeneration();
        }
        System.out.println("Time: "+(System.nanoTime()-time));
    }
}