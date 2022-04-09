import java.awt.geom.*;
import java.awt.*;


public class Boid {
    // static final Random r = new Random();
    double x = 0;
    double y = 0;
    
    //creates shape
    static final int size = 3;
    static final Path2D shape = new Path2D.Double();
    static {
        shape.moveTo(0, -size * 2);
        shape.lineTo(-size, size * 2);
        shape.lineTo(size, size * 2);
        shape.closePath();
    }

    //runs every frame
    void run(Graphics2D g) {
        update();
        draw(g);
    }

    //updates on that happen every frame
    void update(){
        x+=0.1;
        y+=0.1;
    }

    //draws the boid on screen
    void draw(Graphics2D g) {
        AffineTransform save = g.getTransform();
        g.translate(x, y);
        g.setColor(Color.white);
        g.fill(shape);
        g.setColor(Color.black);
        g.draw(shape);
 
        g.setTransform(save);
    }
}
