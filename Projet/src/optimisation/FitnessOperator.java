package optimisation;

import optimisation.Genome;



public interface FitnessOperator<Gene> {
	double fit(Genome<Gene>  g);
}