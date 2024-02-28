import java.util.Random;
import java.util.ArrayList;

public class LineChromosome extends BinaryChromosome {
	private ArrayList<int[]> points;
	public LineChromosome(ArrayList<int[]> points) {
		super(51);
		this.points = points;
	}
	private Random random = new Random();
	double generateNumber(int sign, int numerator, int denominator) {
		if (sign ==0) {
			sign = -1;
		}
		if( denominator ==0) {
			return 0;
		}
		else {
			return sign*(double)((double)numerator/(double)denominator);
		}
	}

	@Override
	public Chromosome crossover(Chromosome other) {
		
		return crossover ((LineChromosome) other, new LineChromosome(points));	    
		    
	}

	@Override
	public double getFitness() {
		double totalDistance = 0;
	    int signA = getNumber(0, 0);
	    int numeratorA = getNumber(1, 8);
	    int denominatorA = getNumber(9, 16);

	    int signB = getNumber(17, 17);
	    int numeratorB = getNumber(18, 25);
	    int denominatorB = getNumber(26, 33);

	    int signC = getNumber(34, 34);
	    int numeratorC = getNumber(35, 42);
	    int denominatorC = getNumber(43, 50);

	    // Generate numbers from the coefficients
	    double A = generateNumber(signA, numeratorA, denominatorA);
	    double B = generateNumber(signB, numeratorB, denominatorB);
	    double C = generateNumber(signC, numeratorC, denominatorC);
		//calculate total distance from each point to the line
		
		for (int i = 0; i<points.size();i++ ) {
			int[] coordinatePair= points.get(i);
			int x = coordinatePair[0];
			int y = coordinatePair[1];
			//this is calculated using the formula |Ax1 + By1 + C| / sqrt(A2 + B2).
	        double numerator = Math.abs(A * x + B * y + C);
	        double denominator = Math.sqrt(Math.pow(A, 2) + Math.pow(B, 2));
	        double distance = numerator / denominator;

	        totalDistance += distance;
		}
		double averageDistance = totalDistance /(double) points.size();
		return 1.0/(1.0+averageDistance);
	}
	//make a new method to validate a chromosome to see if it is good to go and not cause a division by 0
	public boolean validateChromosome() {
		int signA = getNumber(0,0);
		int numeratorA = getNumber(1,8);
		int denominatorA = getNumber(9,16);
		
		int signB = getNumber(17,17);
		int numeratorB = getNumber(18,25);
		int denominatorB = getNumber(26,33);
		
		int signC = getNumber(34,34);
		int numeratorC =getNumber(35,42);
		int denominatorC = getNumber(43,50);
		double numberA = generateNumber(signA,numeratorA,denominatorA);
		double numberB = generateNumber(signB,numeratorB,denominatorB);
		double numberC = generateNumber(signC,numeratorC,denominatorC);
		boolean status = true;
		if (numberA ==0 && numberB ==	0) {
			return false;
			
		};
		if (denominatorA == 0 || denominatorB == 0 || denominatorC == 0) {
		    return false;
		}

		
		return status;
	}



	@Override
	public void mutate(double mutationRate) {
		// TODO Auto-generated method stub
		
	}

}
