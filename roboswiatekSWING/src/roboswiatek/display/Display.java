package roboswiatek.display;
import javax.swing.JFrame;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int width, height;
    public Display(String t, int w, int h){
        title = t;
        width = w;
        height = h;
        createDisplay();
    }
    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        frame.add(canvas);
        frame.pack();
    }
    public Canvas getCanvas(){ return canvas; }
}
