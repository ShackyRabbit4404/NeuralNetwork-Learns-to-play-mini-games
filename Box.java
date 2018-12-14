public class Box{
    private int X;
    private int Y;
    Box connected;
    boolean isConnected = false;
    public Box(int x, int y){
        X = x;
        Y = y;
    }
    public void connect(Box b){
        connected = b;
        isConnected = true;
    }
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public void setLocation(int x,int y){
        if(isConnected){
            connected.setLocation(X,Y);
        }
        X = x;
        Y = y;
    }
}