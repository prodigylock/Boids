import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements ActionListener{
    
    final int w = 500;
    final int h = 500;
    final int tickRate = 64;

    Timer timer;

    //only boid in the scene
    Boid b = new Boid();


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
 
        b.run(g);
    }

    
}
