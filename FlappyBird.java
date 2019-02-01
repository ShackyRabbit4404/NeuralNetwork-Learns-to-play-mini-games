import javax.swing.*;
public class FlappyBird{
    JFrame frame;
    FlappyBirdDisplay display;
    int playerY;
    final double gravity;
    double velocity;
    int[][] walls;
    int playerSize;
    int wallOpeningSize;
    int fitness;
    public FlappyBird(){
        playerSize = 5;
        wallOpeningSize = 20;
        frame = new JFrame();
        display = new FlappyBirdDisplay(playerSize,wallOpeningSize);
        frame.add(display);
        gravity = -0.5;
        reset();
    }
    public void generateWalls(){
        walls = new int[5][2];
        for(int i = 0; i < walls.length; i++){
            walls[i][0] = ((int)Math.random()*300)+100;
        }
        for(int i = 1; i < walls.length+1; i++){
            walls[i-1][1] = 100*i;
        }
    }
    public void updateWalls(){
        for(int[] i : walls){
            i[1] -= 1;
        }
        if(walls[0][1] <= -5){
            fitness += 5;
            for(int i = 0; i < walls.length-1; i++){
                int[] temp = walls[i+1];
                walls[i] = temp;
            }
            walls[walls.length-1][0] = (int)(Math.random()*300)+100;
            walls[walls.length-1][1] = walls[walls.length-2][1] + 100;
        }
    }
    private void reset(){
        playerY = 250;
        velocity = 0;
        generateWalls();
        fitness = 0;
    }
    public double[] getInputVals(){
        double[] vals = new double[4];
        //velocity, bird height, distance to the next wall, height of the opening in the wall
        vals[0] = velocity;
        vals[1] = playerY;
        vals[2] = walls[0][1];
        vals[3] = walls[0][0];
        return vals;
    }
    public void flap(){
        velocity += 10;
    }
    public boolean checkCollision(){
        if(walls[0][1] <= playerSize && (Math.abs(playerY-walls[0][0]) > wallOpeningSize/2 || playerY < 0 || playerY > 500)){
            return true;
        }
        return false;
    }
    public void simulate(NeuralNetwork NN,boolean isVisible){
        reset();
        boolean contin = true;
        while(contin){
            double[] choice = NN.forwardPropagate(getInputVals());
            if(choice[0] > 0.5){
                flap();
            }
            velocity += gravity;
            updateWalls();
            playerY += velocity;
            if(checkCollision()){
                contin = false;
            }
            if(isVisible){
                display.draw(walls,playerY);
                try{
                    Thread.sleep(17);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        NN.setFitness(fitness);
    }
}