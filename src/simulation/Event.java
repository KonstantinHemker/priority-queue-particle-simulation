package simulation;

public interface Event extends Comparable<Event>{

    public double time();

    public char get_type();

    public void happen(ParticleEventHandler h);

    public Particle[] getParticles();

    public boolean isValid();

}
