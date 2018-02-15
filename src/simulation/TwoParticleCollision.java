package simulation;

public class TwoParticleCollision extends Collision {

  public TwoParticleCollision(Particle p1, Particle p2,double t) {
    super(t, new Particle[] {p1, p2});
  }

    public void happen(ParticleEventHandler peh){
        peh.reactTo(this);
        Particle.collide(this.ps_[0],this.ps_[1]);
    }
}
