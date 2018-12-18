import java.util.*;
public class Snake{
    ArrayList<Box> tail;
    int headX;
    int headY;
    int tailX;
    int tailY;
    boolean growing = false;
    int[] direction;
    int foodX;
    int foodY;
    double score;
    double distance = 600;
    public Snake(){
        tail = new ArrayList<Box>();
        tail.add(new Box(1,1));
        direction = new int[4];
    }
    //0 == up
    //1 == right
    //2 == down
    //3 == left
    public int checkLeft(){
        turnLeft();
        if(checkStraight() == 1){
            turnRight();
            return 1;
        }
        turnRight();
        return 0;
    }
    public int checkRight(){
        turnRight();
        if(checkStraight() == 1){
            turnLeft();
            return 1;
        }
        turnLeft();
        return 0;
    }
    public int checkStraight(){
        if(direction[0] == 1){
            headY -= 10;
            if(checkCollition()){
                headY += 10;
                return 1;
            }
            headY += 10;
        }
        else if(direction[1] == 1){
            headX += 10;
            if(checkCollition()){
                headX -= 10;
                return 1;
            }
            headY -= 10;
        }
        else if(direction[2] == 1){
            headY += 10;
            if(checkCollition()){
                headY -= 10;
                return 1;
            }
            headY -= 10;
        }
        else{
            headX -= 10;
            if(checkCollition()){
                headX += 10;
                return 1;
            }
            headX += 10;
        }
        return 0;
    }
    public void reset(){
        headX = 50;
        headY = 50;
        direction = new int[4];
        direction[1] = 1;
        score = 0;
        distance = 600;
    }
    public boolean move(int d){
        
        System.out.println("");
        if(d == 0){
            turnLeft();
        }
        else if(d == 2){
            turnRight();
        }
        for(int i: direction){
            System.out.print(i+" ");
        }
        System.out.println("");
        if(direction[0] == 1){
            System.out.println("nort");
            headY -= 10;
        }
        else if(direction[1] == 1){
            System.out.println("east");
            headX += 10;
        }
        else if(direction[2] == 1){
            System.out.println("south");
            headY += 10;
        }
        else{
            System.out.println("west");
            headX -= 10;
        }
        tail.get(0).setLocation(headX,headY);
        if(growing){
            growing = false;
            tail.add(new Box(tailX,tailY));
            tail.get(tail.size() - 2).connect(tail.get(tail.size() - 1));
        }
        tailX = tail.get(tail.size() - 1).getX();
        tailY = tail.get(tail.size() - 1).getY();
        //System.out.println(Math.sqrt(Math.abs(Math.pow((foodX-headX),2)+Math.pow((foodY-headY),2))));
        if(Math.sqrt(Math.abs(Math.pow((foodX-headX),2)+Math.pow((foodY-headY),2))) < distance){
            distance = Math.sqrt(Math.abs(Math.pow((foodX-headX),2)+Math.pow((foodY-headY),2)));
            score += .1;
        }
        return false;
    }
    public void checkFoodCollide(){
        if(headX == foodX && headY == foodY){
            growing = true;
            setRandFoodLoc();
            score ++;
        }
    }
    public void setRandFoodLoc(){
        foodX = ((int)(Math.random()*50))*10+10;
        foodY = ((int)(Math.random()*50))*10+10;
        while(tailContains(foodX,foodY)){
            foodX = ((int)(Math.random()*50))*10+10;
            foodY = ((int)(Math.random()*50))*10+10;
        }
    }
    public boolean tailContains(int x,int y){
        for(Box b: tail){
            if(b.getX() == x && b.getY() == y){
                return true;
            }
        }
        return false;
    }
    public boolean checkCollition(){
        if(headX <= 0 || headX >= 510 || headY <= 0 || headY >= 510){
            return true;
        }
        for(int i = 1; i < tail.size(); i++){
            if(headX == tail.get(i).getX() && headY == tail.get(i).getY()){
                return true;
            }
        }
        return false;
    }
    public void turnRight(){
        for(int i = 0; i < direction.length; i++){
            if(direction[i] == 1){
                int temp = i+1;
                direction[i] = 0;
                if(temp == 4){
                    temp = 0;
                }
                direction[temp] = 1;
                break;
            }
        }
    }
    public void turnLeft(){
        for(int i = 0; i < direction.length; i++){
            if(direction[i] == 1){
                int temp = i-1;
                direction[i] = 0;
                if(temp == -1){
                    temp = 3;
                }
                direction[temp] = 1;
                break;
            }
        }
    }
    public void grow(){
        growing = true;
    }
}