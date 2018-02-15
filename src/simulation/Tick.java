package simulation;

public class Tick extends AbstractEvent{
    //Olli: Does not make sense to have it here since it is inherited from AbstractEvent
    //protected double time_;

    /**
     * Constructor for Collision
     */
    public Tick(double t){
        // TODO implement constructor
        super(t);
    }
    @Override
    public char get_type(){
      return 't';
    }


    /**
     * Returns true if this Collision is (still) valid.
     */
    @Override
    public boolean isValid(){
        return true;
    }

    public void happen(ParticleEventHandler peh){

      peh.reactTo(this);
    }

    public Particle[] getParticles() {
      return new Particle[0];

    }


}
