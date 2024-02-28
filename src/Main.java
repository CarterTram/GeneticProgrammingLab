import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Main {

	public static void main(String[] args) {
	      ArrayList<int[]> points = new ArrayList<int[]>();

	        JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setDialogTitle("Select Points File");

	        int returnValue = fileChooser.showOpenDialog(null);

	        if (returnValue == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            String filePath = selectedFile.getAbsolutePath();

	            // Read points from the selected file
	            try {
	                Scanner scanner = new Scanner(selectedFile);
	                while (scanner.hasNextInt()) {
	                    int x = scanner.nextInt();
	                    int y = scanner.nextInt();
	                    int[] point = {x, y};
	                    points.add(point);
	                }
	                scanner.close();
	            } catch (FileNotFoundException e) {
	                System.err.println("File not found: " + e.getMessage());
	            }

	        }
				
		Population population = new Population();
		population.setMutationRate(0.2);
		int populationSize = 1000;
		for (int i = 0; i<populationSize; i++) {
			LineChromosome chromosome = new LineChromosome(points);
			//generate a random chromosome from BinaryChromosome
			chromosome.randomize();
			boolean check  = chromosome.validateChromosome();
			if (check)
			population.addChromosome(chromosome);
		}
		
		int generation = 0;
		double bestFitness = 0;
		
		while (generation <1000 && bestFitness <0.9999) {
			Chromosome mostFit = population.evaluate();
			bestFitness = mostFit.getFitness();
			population.breed();
			generation++;
			System.out.println(generation);
			System.out.println(bestFitness);
		}
		System.out.print("Problem solved in "+generation+" generations.");
		
		
		
//		Chromosome mostFitChromosome = population.evaluate();
//		int signA = mostFitChromosome.bits[0];
//		int numeratorA = mostFitChromosome.getNumber(1,8);
//		int denominatorA = mostFitChromosome.getNumber(9,16);
//		
//		int signB = mostFitChromosome.bits[17];
//		int numeratorB = mostFitChromosome.getNumber(18,25);
//		int denominatorB = mostFitChromosome.getNumber(26,33);
//		
//		int signC = mostFitChromosome.bits[34];
//		int numeratorC = mostFitChromosome.getNumber(35,42);
//		int denominatorC = mostFitChromosome.getNumber(43,50);
			
		}
		
	}


