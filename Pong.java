public class Pong{
    double[] ballCords;
    double[] ballDirection;
    double[] playerCords;
    public Pong(){
        ballCords = new double[2];
        playerCords = new double[2];
        playerCords[1] = 480;
        ballDirection = new double[2];
        //slope of the ball
        ballDirection[0] = 1;
        //right == 1, left == -1
        ballDirection[1] = 1;
    }
    public void reset(){
        ballDirection[0] = -.25;
        ballDirection[1] = -1;
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
    }
    public boolean ballMove(){
        ballCords[0] += 3*ballDirection[0];
        ballCords[1] += 3*ballDirection[1];
        if(ballCords[0] <= 0 || ballCords[0] >= 500){
            ballDirection[0] = ballDirection[0]*-1;
        }
        if((ballCords[1] >= 480 && ballCords[0]-playerCords[0] <= 100) || ballCords[1] <= 0){
            ballDirection[1] = ballDirection[1]*-1;
        }
        else if(ballCords[1] >= 480){
            return false;
        }   
        return true;
    }
}