import javax.swing.*;
public class tempPong{
    double[] cords;
    //[0] ballX, [1] ballY, [2] playerX
    double[] direction;
    //[0] xDirection, [1] yDirection
    JFrame frame;
    tempPongDisplay display;
    int movementSpeed;
    public tempPong(){
        frame = new JFrame();
        frame.setBounds(500,100,600,600);
        frame.setVisible(true);
        display = new tempPongDisplay();
        frame.add(display);
        movementSpeed = 3;
    }
    public void reset(){
        cords = new double[3];
        cords[0] = (int)(Math.random()*300+100.5);
        cords[1] = 20;
        cords[2] = 250;
        direction = new double[2];
        direction[0] = (float)(Math.random()*2-1);
        direction[1] = (float)(Math.random()*2-1);
    }
    public void simulate(NeuralNetwork NN,boolean isVisible){
        boolean contin = true;
        double score = 0;
        reset();
        while(contin){
            cords[0] += movementSpeed*direction[0];
            cords[1] += movementSpeed*direction[1];
            int choice = (int)(NN.forwardPropagate(cords)[0]+0.5);
            if(choice == 1){
                cords[2] += movementSpeed;
                if(cords[2] >= 400){
                    score -= 0.1;
                    cords[2] = 399;
                }
            }
            else{
                cords[2] -= movementSpeed;
                if(cords[2] <= 0){
                    score -= 0.1;
                    cords[2] = 1;
                }
            }
            if(cords[0] <= 0 || cords[0] >= 490){
                direction[0] *= -1;
            }
            if(cords[1] <= 0){
                direction[1] *= -1;
            }
            else if(cords[0]-cords[2] <= 100 && cords[0]-cords[2] >= 0 && cords[1] >= 469){
                direction[1] *= -1;
                score += 2;
                cords[1] = 468;
            }
            else if(cords[1] >= 469){
                contin = false;
            }
            if(isVisible){
                int[] temp = {(int)cords[0],(int)cords[1],(int)cords[2]};
                display.draw(temp,(int)(score+0.5));
                try{
                    Thread.sleep(5);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        NN.setFitness((int)(score+0.5));
    }
}