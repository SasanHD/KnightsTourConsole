package com.sasan;

import java.util.*;

public class TourB {
	
	//initialize possible Vertical and Horizontal moves.
	static int[] horizontal = {2,1,-1,-2,-2,-1,1,2};
	static int[] vertical = {-1,-2,-2,-1,1,2,2,1};
	
	//initialize Chess board.
	static int[][] chessBoard = new int[8][8];
	
	//initialize Heuristic board.
	static int[][] heuristicBoard = new int[][]{
		  { 2, 3, 4, 4, 4, 4, 3, 2},
		  { 3, 4, 6, 6, 6, 6, 4, 3},
		  { 4, 6, 8, 8, 8, 8, 6, 4},
		  { 4, 6, 8, 8, 8, 8, 6, 4},
		  { 4, 6, 8, 8, 8, 8, 6, 4},
		  { 4, 6, 8, 8, 8, 8, 6, 4},
		  { 3, 4, 6, 6, 6, 6, 4, 3},
		  { 2, 3, 4, 4, 4, 4, 3, 2}
		};
	
	//knight's position is 1.
	static int knightPosition=1;
		
	//give Knight a random starting position.
	static Random rNum = new Random();
	static int startingPos= rNum.nextInt(8);
	static int currentRow=startingPos;
	static int currentColumn=startingPos;
	
	//initialize the minimum heuristic number to a highest value.
	static int minPos=10;
	
	//initialize the row and column, for the smallest heuristic move.
	static int minCurrentRow=0;
	static int minCurrentColumn=0;
	
	//initialize variable to keep track of no possible moves left.
	static int noMovesLeftCounter=0;

	public static void main(String[] args) {
		
		//set Knight's starting position on the Chess board.
		chessBoard[currentRow][currentColumn]= knightPosition;
		
		//update the Heuristic board's occupied location to 10.
		heuristicBoard[currentRow][currentColumn]=minPos;
		
		//update the next move's row and column.
		updateHeuristicBoard();
				
		//initialize iteration variable.
		int tries=1;
		
		do {
			//assign the new moving coordinates.
			currentRow=minCurrentRow;
			currentColumn=minCurrentColumn;
			
			//update knight's position on the heuristic board.
			heuristicBoard[currentRow][currentColumn]=10; 
			
			//move Knight to the new location, and update Chess board.
			++knightPosition;
			chessBoard[currentRow][currentColumn]= knightPosition;
			
			//update the next move's row and column.
			updateHeuristicBoard();
			
			//check if the ending condition is met.
			if(noMovesLeftCounter==8) {
				break;
			}
			
			//increment iteration variable if possible move still exists.
			++tries;
			
		}while(tries!=65); 
		
		//print the output.
		System.out.print("/");
		for(int star=1;star<=65;star++) {
			System.out.print("*");
		}
		
		System.out.println();
		System.out.println("The tour ended with: "+knightPosition+" moves.");
		
		if(knightPosition<64) {
			System.out.println("This was not a full tour.");
		} else if(knightPosition==64) {
			System.out.println("This was a full tour!");
		}
		
		System.out.println();
		printBoard(chessBoard);
		System.out.println();
		
		for(int star=1;star<=65;star++) {
			System.out.print("*");
		}
		
		System.out.print("/");
	}
	
	public static void updateHeuristicBoard() {
		
		//initialize ending variable.
		noMovesLeftCounter=0; 
		
		//initialize minimum heuristic position to 10. 
		minPos=10;
		
		//check all possible 8 moves to get new moving coordinates.
		for(int move=0;move<8;move++) {
			currentRow += vertical [move] ;
			currentColumn += horizontal [move] ;
			
			//if the move is invalid, return current row and column to original position.
			if(currentRow<0 || currentColumn<0 || currentRow>7 || currentColumn>7 || chessBoard[currentRow][currentColumn] != 0 || heuristicBoard[currentRow][currentColumn] == 10)  {
				currentRow -= vertical [move] ;
				currentColumn -= horizontal [move] ;
				++noMovesLeftCounter; 
				
			//if the move is valid, get the new minimum position and coordinates.
			}else {
				if(heuristicBoard[currentRow][currentColumn]<=minPos) {
					minPos=heuristicBoard[currentRow][currentColumn];
					minCurrentRow=currentRow;
					minCurrentColumn=currentColumn;			
				}
				
				//since the move is valid, reduce accessibility from our starting position to update the heuristic board.
				heuristicBoard[currentRow][currentColumn]-=1;
				
				//return the current row and column to the starting point, for checking the next possible move.
				currentRow -= vertical [move] ;
				currentColumn -= horizontal [move] ;
			}
		}
	}
	
	public static void printBoard(int[][] board) {
		//row headers.
		System.out.print("        1");
		System.out.print("       2");
		System.out.print("       3");
		System.out.print("       4");
		System.out.print("       5");
		System.out.print("       6");
		System.out.print("       7");
		System.out.print("       8");
				
		System.out.println();
		System.out.println();
				
		for (int row = 0; row < board.length; row++) {
			//column headers.
			System.out.printf("%d",row+1);
			for (int col = 0; col < board[row].length; col++) {
				System.out.printf("%8d",board[row][col]);
			}
				    
			System.out.println();
		}
	}
}
