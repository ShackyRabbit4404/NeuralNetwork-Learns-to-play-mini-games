public class Pong{
    double[] ballCords;
    double[] ballDirection;
    double[] playerCords;
    private double score;
    private int networkNumber;
    private int prevMove = 0;
    public Pong(){
        ballCords = new double[2];
        playerCords = new double[2];
        playerCords[1] = 480;
        ballDirection = new double[2];
        //slope of the ball
        ballDirection[0] = 1;
        //right == 1, left == -1
        ballDirection[1] = 1;
        score = 0;
    }
    public void setNetworkNumber(int i){
        networkNumber = i;
    }
    public int getNetworkNumber(){
        return networkNumber;
    }
    public int getScore(){
        return (int)(score+0.5);
    }
    public double[] getInputData(){
        double[] ret = {((double)ballCords[0])/500,((double)ballCords[1])/500,((double)playerCords[0])/500,(double)480/500};
        return ret;
    }
    public void reset(){
        ballDirection[0] = Math.random()+.25;
        ballDirection[1] = Math.random()+.25;
        ballCords[0] = (Math.random()*480)+10;
        ballCords[1] = 10;
        playerCords[0] = 200;
        playerCords[1] = 480;
        score = 0;
        prevMove = 0;
    }
    public int getBallX(){
        return (int)(ballCords[0]+0.5);
    }
    public int getBallY(){
        return (int)(ballCords[1]+0.5);
    }
    public int getPlayerX(){
        return (int)(playerCords[0]+0.5);
    }
    public void playerMove(double direction){
        playerCords[0] += direction;
        if((direction > 0 && prevMove != 1)||(direction < 0 && prevMove != -1)){
            score += 0.5;
        }
        if(direction > 0){
            prevMove = 1;
        }
        else{
            prevMove = -1;
        }
        if(playerCords[0] < 0){
            playerCords[0] = 0;
            if(prevMove < 0){
                score -= .1;
            }
        }
        else if(playerCords[0] > 400){
            playerCords[0] = 400;
            if(prevMove > 0){
                score -= .1;
            }
        }
    }
    public boolean ballMove(){
        ballCords[0] += 3*ballDirection[0];
        ballCords[1] += 3*ballDirection[1];
        /*
        if(ballCords[1] <= 0){
            ballDirection[0] *= -1;
        }
        else if(ballCords[1] >= 475){
            if(){
                
            }
        }
        */
        if(ballCords[1] >= 475 && ballCords[0]-playerCords[0] <= 100 && ballCords[0]-playerCords[0] >= 0){
            ballDirection[1] = ballDirection[1]*-1;
            score += 2;
            ballCords[1] = 474;
        }
        else if(ballCords[1] <= 0){
            ballDirection[1] = ballDirection[1]* -1;
        }
        else if(ballCords[1] >= 480){
            return false;
        } 
        if(ballCords[0] <= 0 || ballCords[0] >= 495){
            ballDirection[0] = ballDirection[0]*-1;
        }
          
        return true;
    }
}