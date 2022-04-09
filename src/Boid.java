import java.awt.geom.*;
import java.awt.*;
import static java.lang.Math.*;

public class Boid {
    // static final Random r = new Random();
    // double x = 0;
    // double y = 0;
    Vector2D position = new Vector2D(100,250);
    Vector2D v = new Vector2D(0,0.1);

    Vector2D c = new Vector2D(250,250);

    //creates shape
    static final int size = 10;
    static final Path2D shape = new Path2D.Double();
    static {
        shape.moveTo(0, -size * 2);
        shape.lineTo(-size, size * 2);
        shape.lineTo(size, size * 2);
        shape.closePath();
    }

    Boid(int x, int y){
        position.x = x;
        position.y = y;
    }

    Boid(int x, int y, Vector2D v){
        position.x = x;
        position.y = y;
        this.v = v;
    }

    //runs every frame
    void run(Graphics2D g) {
        update();
        draw(g);
    }

    //updates on that happen every frame
    void update(){
        Vector2D v2 = new Vector2D((Vector2D.sub(c, position)));
        double a = pow((v.mag()/(Vector2D.sub(c, position).mag())),2);
        v2.mult(a);
        v.add(v2);
        position.add(v);
    }

    //draws the boid on screen
    void draw(Graphics2D g) {
        AffineTransform save = g.getTransform();
        g.translate(position.x, position.y);
        g.rotate(v.heading() + PI / 2);
        g.setColor(Color.white);
        g.fill(shape);
        g.setColor(Color.black);
        g.draw(shape);
 
        g.setTransform(save);
    }
}
