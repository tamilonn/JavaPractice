package com.datastructure;

/**
 * This program creates NXN magic squares of odd number.
 * @author tamil
 *
 */
public class MagicSquare {
	
	private int size = 0;
	private int[][] square = null;

	public MagicSquare(int i) {
		this.size = i;
		create();
	}
	
	public static void main(String[] args) {
		
		MagicSquare ms = new MagicSquare(3);
		ms.print();
		
	}
	
	public int[][] create(){
		
		if (size <= 0 || (size % 2) == 0){
			System.out.println("Magic square must be non zero and ODD number only");
			System.exit(0);
		}
		
		square = new int[size][size];		
		
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				square[i][j] = 0;
			}
		}
		
		int totalNumbers = size * size;
		int currNumber = 1;
		
		int row = 0,tempRow = 0;
		int col = 0,tempCol = 0;
		
		while ( currNumber <= totalNumbers ){
			
			if (currNumber == 1 ){
				row = 0;
				col = size / 2; //find the first row mid column
				square[row][col] = currNumber;
				
			} else {
				tempRow = row;
				tempCol = col;
				
				//find cell where row = (row -1) and col = col + 1.  (Move up and take right)
				row = row - 1;
				col = col + 1;
				if (row < 0 ){
					row = size - 1;
				}
				if (col == size){
					col = 0;
				}
				if(square[row][col] > 0 ){
					row = tempRow + 1;
					col = tempCol;
				}
				
				square[row][col] = currNumber;
			}
			
			
			
			currNumber++;
		}
		
		
		return square;
	}
	
	public void print(){
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				System.out.print(square[i][j] + "  ");
			}
			System.out.println("");
		}
	}



	
}
