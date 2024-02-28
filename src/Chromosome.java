
public interface Chromosome {
	Chromosome crossover(Chromosome other);
	double getFitness();
	boolean validateChromosome();
	void mutate(double mutationRate);

}