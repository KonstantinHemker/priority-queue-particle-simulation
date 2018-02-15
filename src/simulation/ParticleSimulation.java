package simulation;

import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import utils.MinPriorityQueue;
import utils.List;

public class ParticleSimulation implements Runnable, ParticleEventHandler{

    private static final long FRAME_INTERVAL_MILLIS = 40;
    private final MinPriorityQueue<Event> queue_;
    private final ParticlesModel          model;
    private final ParticlesView           screen;
    private double current_time=0;

    /**
     * Constructor.
     */
    public ParticleSimulation(String name, ParticlesModel m) {
        // TODO implement constructor
        this.model = m;
        this.screen = new ParticlesView(name,m);
        Tick t_ = new Tick(1);
        this.queue_ = new MinPriorityQueue();
        this.queue_.add(t_);
        Iterable<Collision> cs = this.model.predictAllCollisions(this.current_time);
        for (Collision item : cs){
          this.queue_.add(item);
        }
    }

    /**
     * Runs the simulation.
     */
    @Override
    public void run() {
        try {
            SwingUtilities.invokeAndWait(screen);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Event c = this.queue_.remove();

        if(c.isValid()){
          this.model.moveParticles(c.time()-this.current_time);
          this.current_time = c.time();
          c.happen(this);
        }
      }

    private void add_collisions(Particle p, Collision c){
      Iterable<Collision> cs = this.model.predictCollisions(p, c.time());
      for (Collision item : cs){
        this.queue_.add(item);
      }
    }

    @Override
    public void reactTo(Collision c) {
      Particle[] ps_;
      ps_ = c.getParticles();
      /*
      this.queue_.add( (Event) this.model.predictCollisions(ps_[0], c.time()));
      this.queue_.add( (Event) this.model.predictCollisions(ps_[1], c.time()));*/
      add_collisions(ps_[0],c);
      add_collisions(ps_[1],c);
    }

    @Override
    public void reactTo(Tick t) {
      try {
            // thread to sleep for 1000 milliseconds
            Thread.sleep(this.FRAME_INTERVAL_MILLIS);
         } catch (Exception e) {
            System.out.println(e);
         }
      //java.lang.Thread.sleep(this.FRAME_INTERVAL_MILLIS);
      this.screen.update();
      this.queue_.add( (Event) new Tick(this.current_time + 1));
    }

}
