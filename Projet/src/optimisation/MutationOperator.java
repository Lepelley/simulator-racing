package optimisation;

import optimisation.Genome;


public interface MutationOperator<Gene> {
	void mute(Genome<Gene> g);
}