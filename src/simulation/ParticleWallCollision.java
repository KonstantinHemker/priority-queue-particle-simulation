package simulation;

public class ParticleWallCollision extends Collision {
  protected Wall w_;

  public ParticleWallCollision(Particle ps, Wall w, double t) {
    //Constructor of ParticleWallCollision
    //TO DO
    super(t,new Particle[1] {ps} );
    //Particle[] ps_ = new Particle[2];
    w_ = w;
  }

  public void happen(ParticleEventHandler peh){
      peh.reactTo(this);
      Particle.collide(ps_[0],w_);
  }

}
