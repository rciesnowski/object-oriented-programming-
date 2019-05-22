package roboswiatek;
import roboswiatek.display.Display;

import java.awt.image.BufferStrategy;
import java.awt.Graphics;

public class Game implements Runnable {
    private Display display;
    public String title;
    public int width, height;

    public boolean running = false;
    public Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    public Game(String t, int w, int h){
        height = h;
        width = w;
        title = t;
    }

    private void init() {
        display = new Display(title, width, height);
    }
    private void tick(){}
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //draw here
        g.fillRect(0,0,width, height);
        //end
        bs.show();
        g.dispose();
    }
    public void run() {
        init();
        while(running){
            tick();
            render();
        }
        stop();
    }
    public synchronized void start() {
        if(running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop() {
        if(!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
