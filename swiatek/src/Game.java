import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;

    public Game(){
        new Window(WIDTH, HEIGHT, "dziwny dom", this);
        handler = new Handler();
        handler.addOrganism(new Chrzaszcz(20, 20, handler));
        handler.addOrganism(new Chrzaszcz(21, 20, handler));
        handler.addOrganism(new Chrzaszcz(21, 20, handler));
        handler.addOrganism(new Chrzaszcz(21, 35, handler));
        handler.addOrganism(new Chrzaszcz(21, 36, handler));
        handler.addOrganism(new Ser(13, 13, handler));
        handler.addOrganism(new Ser(13, 14, handler));
        handler.addOrganism(new Ser(33, 15, handler));
        handler.addOrganism(new Ser(33, 16, handler));
        handler.addOrganism(new Ser(4, 13, handler));
        handler.addOrganism(new Ser(4, 14, handler));
        handler.addOrganism(new Ser(1, 3, handler));
        handler.addOrganism((new Wirus(1,1, handler)));
        handler.addOrganism(new Mysz(23,24, handler));
        handler.addOrganism(new Mysz(25,25, handler));

    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running=true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 2;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        handler.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.darkGray);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(g);
        g.dispose();
        bs.show();
    }


    public static void main(String[] args){
        new Game();
    }
}