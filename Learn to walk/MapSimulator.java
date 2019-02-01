public class MapSimulator{
    public void simulate(NeuralNetwork NN,boolean isVisible){
        boolean contin = true;
        int[][] map = getMap(1);
        while(contin){
            
        }
    }
    public int[][] getMap(int mapNum){
        if(mapNum == 1){
            int[][] map = {{1,1,1,1,1,1,1,1,1,1,1},
                           {1,0,0,0,0,0,0,0,0,0,1},
                           {1,0,0,0,0,0,0,0,0,0,1},
                           {1,0,0,1,1,1,1,1,0,0,1},
                           {1,0,0,1,1,1,1,1,0,0,1},
                           {1,0,0,1,1,1,1,1,0,0,1},
                           {1,0,0,1,1,1,1,1,0,0,1},
                           {1,0,0,1,1,1,1,1,0,0,1},
                           {1,0,0,0,0,0,0,0,0,0,1},
                           {1,0,0,0,0,0,0,0,0,0,1},
                           {1,1,1,1,1,1,1,1,1,1,1}};
            return map;
        }
        int[][] map = new int[20][20];
        return map;
    }
}