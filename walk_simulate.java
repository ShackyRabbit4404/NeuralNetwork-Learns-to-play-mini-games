import org.jbox2d.p5.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.dynamics.joints.*;
import org.jbox2d.collision.*;
import org.jbox2d.dynamics.contacts.*;
public class walk_simulate extends processing.core.PApplet{
    Physics world;
    public walk_simulate(){
        world = new Physics(this,500,500);
        physics.setDensity((float)0);
        physics.createRect((float)0,(float)480,(float)500,(float)500);
        physics.setDensity((float)1);
        physics.createRect(200,200,300,300);
        for(int i = 0; i < 500; i++){
            world.draw();
            
        }
    }
}