import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Graph extends JPanel{
    private ArrayList<Integer>  data;
    public Graph(){
        super();
        data = new ArrayList<Integer>();
        data.add(0);
    }
    public void draw(int val){
        data.add(val);
        super.repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillRect(0,0,500,500);
        int range = Math.abs(getMaxVal()-getMinVal());
        g.setColor(Color.BLACK);
        for(int i = 0; i < data.size();i++){
            g.fillOval((500/data.size())*i,range );
        }
    }
    public int getMaxVal(){
        int largest = data.get(0);
        for(int e: data){
            if(e > largest){
                largest = e;
            }
        }
        return largest;
    }
    public int getMinVal(){
        int smallest = data.get(0);
        for(int e: data){
            if(e < smallest){
                smallest = e;
            }
        }
        return smallest;
    }
}