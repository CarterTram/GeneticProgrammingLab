import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Population {
	private Random random = new Random();
	private List<Chromosome> chromosomes;
	private double mutationRate;
	//initialize the population
	public Population() {
		chromosomes = new ArrayList<>();
	}
	
	//add chromosome method
	public void addChromosome(Chromosome chromosome) {
		chromosomes.add(chromosome);
	}
	public void setMutationRate(double mutationRate) {
		this.mutationRate = mutationRate;
	}
	public Chromosome evaluate() {
		Chromosome mostFit = chromosomes.get(0);
		double maxFit = mostFit.getFitness();
		
		for (Chromosome chromosome : chromosomes) {
			double fitness = chromosome.getFitness();
			if (fitness>maxFit) {
				maxFit = fitness;
				mostFit = chromosome;
			}
		}
		return mostFit;
	}
	//breeding new population
	public void breed() {
		List <Chromosome> newChromosomes = new ArrayList<Chromosome>();
		Chromosome leastFit = chromosomes.get(0);
		double leastFitness = leastFit.getFitness();
		//get the lowest fintess of the population
		for (Chromosome chromosome : chromosomes) {
			double fitness = chromosome.getFitness();
			if (fitness<leastFitness) {
				leastFitness = fitness;
				leastFit = chromosome;
			}
		}
		ArrayList<Chromosome> selectParents = new ArrayList<>();
		//assigning breeding tickets to chromosome
		//ArrayList<Integer> tickets = new ArrayList<Integer>();
		for (Chromosome chromosome : chromosomes) {
			double fitness = chromosome.getFitness();
			double determinant = fitness/leastFitness;
			int ticketCount = (int) (determinant);
			//add the specific chromosome into selectParents as many times as the tickets it has.
			for (int i =1; i<=ticketCount;i++) {
				
				selectParents.add(chromosome);
				
			}
		}
		
		//breed a new population using the lottery system, also eliminate problematic chromosomes now
		int newPopulationSize = 0;
		if (selectParents.size()>0) {
		while (newChromosomes.size()!= chromosomes.size()) {
			Chromosome parent1 = selectParents.get(random.nextInt(0,selectParents.size()));
			Chromosome parent2 = selectParents.get(random.nextInt(0,selectParents.size()));
			Chromosome child = parent1.crossover(parent2);
			child.mutate(mutationRate);
			boolean check = child.validateChromosome();
			if (check == true) {
	
			newChromosomes.add(child);
			}
		
		}
		chromosomes = newChromosomes;
		
	}}

//	@Override
//	public String toString() {
//		
//	}
}
