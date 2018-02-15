package simulation;

public abstract class AbstractEvent implements Event {
    protected double time_;
    /**
     * Constructor for AbstractEvent.
     */
    //public static char get_type();

    public AbstractEvent(double time) {
        // TODO implement the constructor
        this.time_ = time;
    }

    /**
     * Returns the time (in ticks) at which this event will occur.
     */
    @Override
    public double time() {
        // TODO implement this method
        return this.time_;
    }

    /**
     * Compares this object with the specified Event.
     */
    @Override
    public int compareTo(Event that) {
        // TODO implement this method
        if(that.time() > this.time_){
          return -1;
        }else if(that.time()== this.time_){
          return 0;
        }else{
          return 1;
        }
    }

}
