import javax.swing.*;
public class FlappyBird{
    int[] playerXY;
    double score;
    int[] map;
    JFrame frame;
    FlappyBirdDisplay display;
    double velocity;
    public FlappyBird(){
        frame = new JFrame();
        frame.setBounds(100,100,600,600);
        frame.setVisible(true);
        display = new FlappyBirdDisplay();
        frame.add(display);
    }
    public void reset(){
        playerXY = new int[2];
        playerXY[0] = 100;
        playerXY[1] = 250;
        score = 0;
        map = new int[3];
        velocity = 0;
        for(int i = 0; i < map.length;i++){
            map[i] = (int)(Math.random()*200+0.5);
        }
    }
    public double[] getInputData(){
        double ret[] = new double[3];
        ret[0] = 200-playerXY[0];
        ret[1] = playerXY[1];
        ret[2] = map[1];
        return ret;
    }
    public boolean checkCollition(){
        if(playerXY[1] <= 0 || playerXY[1] >= 490){
            return true;
        }
        for(double e: map){
            if((playerXY[1] >= e+50 || playerXY[1] <= e-50) && playerXY[0] <= 20){
                System.out.println("hit wall");
                return true;
            }
        }
        return false;
    }
    public void simulate(NeuralNetwork NN,boolean isVisible){
        reset();
        boolean contin = true;
        while(contin){
            int choice = (int)((NN.forwardPropagate(getInputData()))[0]+0.5);
            velocity ++;
            if(choice == 1){
                velocity = -20;
            }
            playerXY[0] += 3;
            if(playerXY[0] == 200){
                playerXY[0] = 0;
                score ++;
            }
            else if(playerXY[0] == 100){
                createNewWall();
            }
            playerXY[1] += velocity;
            if(checkCollition()){
                contin = false;
            }
            if(isVisible){
                display.draw(map,playerXY);
                try{
                    Thread.sleep(30);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        NN.setFitness((int)(score+0.5));
    }
    public void createNewWall(){
        for(int i = 1; i < map.length;i++){
            map[i-1] = map[i];
        }
        map[map.length-1] = (int)(Math.random()*200+0.5);
    }
}