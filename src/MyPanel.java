import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements ActionListener{
    
    final int w = 500;
    final int h = 500;
    final int tickRate = 24;

    Timer timer;

    //only boid in the scene
    Boid b1 = new Boid(150,250,new Vector2D(0,0.1));
    Boid b2 = new Boid(350,250,new Vector2D(0,-0.1));
    Boid b3 = new Boid(50,250,new Vector2D(0,0.1));
    Boid b4 = new Boid(450,250,new Vector2D(0,-0.1));
    Boid b5 = new Boid(250,150,new Vector2D(-0.1,0));
    Boid b6 = new Boid(250,350,new Vector2D(0.1,0));
    Boid b7 = new Boid(250,50,new Vector2D(-0.1,0));
    Boid b8 = new Boid(250,450,new Vector2D(0.1,0));


    //creates panel
    MyPanel(){
        this.setPreferredSize(new Dimension(w,h));
        this.setBackground(new Color(49,49,53));

        //time delay is tick rate
        timer = new Timer(1/tickRate,this);
        timer.start();
    }



    //every time the timer triggers runs this
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        
    }

    //every time repaint triggers this triggers
    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
 
        b1.run(g);
        

        b2.run(g);
        b3.run(g);
        b4.run(g);
        b5.run(g);
        b6.run(g);
        b7.run(g);
        b8.run(g);
    }

    
}
