package simulation;

public abstract class Collision extends AbstractEvent{
    protected Particle[] ps_ = new Particle[2];
    protected double[] hits_ = new double[2];
    /**
     * Constructor for Collision
     */
    public Collision(double t, Particle[] ps) {
        // TODO implement constructor
        super(t);
        for (int i=0;i<ps.length;i++){
          ps_[i] = ps[i];
          hits_[i] = ps[i].collisions();
        }
    }
    @Override
    public char get_type(){
      return 'c';
    }

    /**
     * Returns true if this Collision is (still) valid.
     */
    @Override
    public boolean isValid() {
      for (int i=0;i<ps_.length;i++){
        //Olli: Shouldn't this simply test whether hits_ is larger than zero and since indicating that one of the particles/ one particle colided since creation
        if(hits_[i] == ps_[i].collisions()){
        //if(hits_[i] > 0){
            return true;
        }
      }
      return false;
    }

    /**
     * Returns an array containing the Particles involved in this Collision.
     */
    @Override
    public Particle[] getParticles() {
        // TODO implement this method
        return ps_;
    }
}
