package simulation;

public class ParticleWallCollision extends Collision {
  protected Wall w_;

  public ParticleWallCollision(Particle ps, Wall w, double t) {
    //Constructor of ParticleWallCollision
    //TO DO
    super(t,new Particle[] {ps} );
    //Particle[] ps_ = new Particle[2];
    this.w_ = w;
  }

  public void happen(ParticleEventHandler peh){
      Particle.collide(this.ps_[0],this.w_);
      peh.reactTo(this);
  }

}
