public class Pong{
    double[] ballCords;
    double[] ballDirection;
    double[] playerCords;
    private int score;
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
    public int getScore(){
        return score;
    }
    public double[] getInputData(){
        double[] ret = {((double)ballCords[0])/500,((double)ballCords[1])/500,((double)playerCords[0])/500,(double)480/500};
        return ret;
    }
    public void reset(){
        ballDirection[0] = Math.random()*2-1;
        ballDirection[1] = Math.random()*2-1;
        ballCords[0] = 10;
        ballCords[1] = 10;
        playerCords[0] = 200;
        playerCords[1] = 480;
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
        if(playerCords[0] < 0){
            playerCords[0] = 0;
        }
        else if(playerCords[0] > 400){
            playerCords[0] = 400;
        }
    }
    public boolean ballMove(){
        ballCords[0] += 3*ballDirection[0];
        ballCords[1] += 3*ballDirection[1];
        if(ballCords[0] <= 0 || ballCords[0] >= 500){
            ballDirection[0] = ballDirection[0]*-1;
        }
        if((ballCords[1] >= 480 && ballCords[0]-playerCords[0] <= 100 && ballCords[0]-playerCords[0] >= 0) || ballCords[1] <= 0){
            ballDirection[1] = ballDirection[1]*-1;
            score += 1;
        }
        else if(ballCords[1] >= 480){
            return false;
        }   
        return true;
    }
}