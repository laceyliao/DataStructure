package percolationProblem;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private WeightedQuickUnionUF matrix;
	private boolean[] OpenBlock;
	private int N;
	
	public Percolation(int N){//constructor
		this.N=N;
		if(N>0){
			matrix = new WeightedQuickUnionUF(N*N +2);
			OpenBlock = new boolean[N*N + 2];
			for(int i=1;i<=N*N;i++)
				OpenBlock[i]=false;
			OpenBlock[0] = true;
			OpenBlock[N*N + 1] = true;
		}
		else
			throw new IllegalArgumentException();
	}
	
    private boolean IsInMatrix(int x,int y){//check if the point is valid
    	if(x<=0 || x>N) return false;
    	else if(y<=0 || y>N) return false;
    	else 
    		return true;
    }
    
    public boolean IsOpen(int x, int y){//check if the point is open
    	return OpenBlock[ (x-1)*N + y ]==true;
    }
    
    public void open(int x,int y){//open the point
    	if(IsInMatrix(x,y)){
    		OpenBlock[ (x-1)*N + y ] = true;
    		if(x==1){//the point is on the top
        		matrix.union(0, (x-1)*N + y );
        	}
        	else if(x==N){
        		matrix.union( N*N + 1 , (x-1)*N + y );
        	}
        	
        	if(IsInMatrix(x, y-1) && IsOpen(x,y-1))//check if its left point is open
        		matrix.union( (x-1)*N + y, (x-1)*N + y-1);
        	
        	if(IsInMatrix(x, y+1) && IsOpen(x,y+1))//check if its right point is open
        		matrix.union( (x-1)*N + y,  (x-1)*N + y+1);
        	
        	if(IsInMatrix(x-1, y) && IsOpen(x-1,y))//check if its upper point is open
        		matrix.union( (x-1)*N + y, (x-2)*N + y);
        	
        	if(IsInMatrix(x+1, y) && IsOpen(x+1, y))//check if its lower point is open
        		matrix.union( (x-1)*N + y, x*N + y);
    	}
    	else
			throw new IndexOutOfBoundsException();
    }
    
    public boolean IsFull(int x, int y){//check if the point is full
    	return matrix.connected(0,(x-1)*N + y );
    }
    
    public boolean percolates(){//check if the system is full
    	return matrix.connected(0, N*N+1);
    }
}


