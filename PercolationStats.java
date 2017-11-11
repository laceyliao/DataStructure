package percolationProblem;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import java.util.Scanner;
public class PercolationStats {
	private double[] threshold;
	public PercolationStats(int N , int T){
		if(N<=0 || T<= 0)
			throw new IllegalArgumentException();
		threshold = new double[T];
		for(int i=0 ; i<T ;i++){
			Percolation percosystem = new Percolation(N);
			int count = 0;
			do{
				int row = StdRandom.uniform(1, N+1);//return a number in [a,b)
				int col = StdRandom.uniform(1, N+1);
				if(percosystem.IsOpen(row, col))
					continue;
				else{
					percosystem.open(row, col);
					count++;
				}//else
			}while(!percosystem.percolates());
			threshold[i] = (double)count/(N*N);
		}//for
	}//constructor
	
	public double mean(){ // sample mean of percolation threshold
		return StdStats.mean(threshold);
	}
	
	public double stddev(){// sample standard deviation of percolation threshold
		return StdStats.stddev(threshold);
	}
	
	public double confidenceLo(){// returns lower bound of the 95% confidence interval
		return mean()-1.96*stddev()/Math.sqrt(threshold.length);
	}
	
	public double confidenceHi(){// returns upper bound of the 95% confidence interval
		return mean()+1.96*stddev()/Math.sqrt(threshold.length);
	}
	
	public static void main(String[] args){ 
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
	    int T = in.nextInt();
	  
		PercolationStats puf = new PercolationStats(N , T);
		System.out.println("mean = "+puf.mean());
		System.out.println("stddev = "+puf.stddev());
		System.out.println("confidenceLo = "+puf.confidenceLo());
		System.out.println("confidenceHi = "+puf.confidenceHi());
		in.close();
		
		
		
	}

}
