package optimisation;

import optimisation.Genome;



public interface GenomeGenerator<Gene> {
	public Genome<Gene> build();
}