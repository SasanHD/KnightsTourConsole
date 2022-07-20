package com.sasan;

import java.util.*;

public class TourC {
	
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
	
	//variables for move one.			
	static int posMoveOne=99;			
	static int minFuturePosMoveOne=99;  
	static int currentRowOne=0;			
	static int currentColumnOne=0;
	static int sumOfOne=0;
	
	//variables for move two.
	static int posMoveTwo=99;
	static int minFuturePosMoveTwo=99;
	static int currentRowTwo=0;
	static int currentColumnTwo=0;
	static int sumOfTwo=0;
	
	//variables for move three.
	static int posMoveThree=99;
	static int minFuturePosMoveThree=99;
	static int currentRowThree=0;
	static int currentColumnThree=0;
	static int sumOfThree=0;
	
	//variables for move four.
	static int posMoveFour=99;
	static int minFuturePosMoveFour=99;
	static int currentRowFour=0;
	static int currentColumnFour=0;
	static int sumOfFour=0;
		
	//variables for move five.
	static int posMoveFive=99;
	static int minFuturePosMoveFive=99;
	static int currentRowFive=0;
	static int currentColumnFive=0;
	static int sumOfFive=0;
	
	//variables for move six.
	static int posMoveSix=99;
	static int minFuturePosMoveSix=99;
	static int currentRowSix=0;
	static int currentColumnSix=0;
	static int sumOfSix=0;
		
	//variables for move seven.
	static int posMoveSeven=99;
	static int minFuturePosMoveSeven=99;
	static int currentRowSeven=0;
	static int currentColumnSeven=0;
	static int sumOfSeven=0;
	
	//variables for move eight.
	static int posMoveEight=99;
	static int minFuturePosMoveEight=99;
	static int currentRowEight=0;
	static int currentColumnEight=0;
	static int sumOfEight=0;
	
	//initialize sum variable. 
	static int minSum=0;
	
	//initialize heuristic variable. 
	static int minFuturePos=10;
	
	//initialize future heuristic variable. 
	static int futureMinPos=10;
	

	public static void main(String[] args) {
		
		//set the boards.
		chessBoard[currentRow][currentColumn]= knightPosition;
		heuristicBoard[currentRow][currentColumn]=10;

		
		int runs=1;
		do {

			runs++;
			
			//check all moves to get next, and the smallest future heuristic value.
			posMoveOne=checkMoveOne();
			posMoveTwo=checkMoveTwo();
			posMoveThree=checkMoveThree();
			posMoveFour=checkMoveFour();
			posMoveFive=checkMoveFive();
			posMoveSix=checkMoveSix();
			posMoveSeven=checkMoveSeven();
			posMoveEight=checkMoveEight();

			//sum both heuristic values to determine smallest possible move.		
			sumOfOne=posMoveOne + minFuturePosMoveOne;
			sumOfTwo=posMoveTwo + minFuturePosMoveTwo;
			sumOfThree=posMoveThree + minFuturePosMoveThree;
			sumOfFour=posMoveFour + minFuturePosMoveFour;
			sumOfFive=posMoveFive + minFuturePosMoveFive;
			sumOfSix=posMoveSix + minFuturePosMoveSix;
			sumOfSeven=posMoveSeven + minFuturePosMoveSeven;
			sumOfEight=posMoveEight + minFuturePosMoveEight;
			
			//Find minimum of all possible moves.
			minSum = Math.min(sumOfOne,Math.min(sumOfTwo,Math.min(sumOfThree,Math.min(sumOfFour,Math.min(sumOfFive,Math.min(sumOfSix,Math.min(sumOfSeven,sumOfEight)))))));
			
			//if no moves are left on the board, then minSum is 199.
			if(minSum==199) {
				
				//update Knight's position on the Chess board.
				chessBoard[currentRow][currentColumn]= knightPosition;
				
				//update knight's position on the heuristic board.
				heuristicBoard[currentRow][currentColumn]= 10;
				
				//exit the loop.
				break;
			}
			
			//move the Knight based on the smallest sum.
			if(sumOfOne==minSum) {
				currentRow += vertical [0] ;
				currentColumn += horizontal [0] ;
			}else if(sumOfTwo==minSum) {
				currentRow += vertical [1] ;
				currentColumn += horizontal [1] ;
			}else if(sumOfThree==minSum) {
				currentRow += vertical [2] ;
				currentColumn += horizontal [2] ;
			}else if(sumOfFour==minSum) {
				currentRow += vertical [3] ;
				currentColumn += horizontal [3] ;
			}else if(sumOfFive==minSum) {
				currentRow += vertical [4] ;
				currentColumn += horizontal [4] ;
			}else if(sumOfSix==minSum) {
				currentRow += vertical [5] ;
				currentColumn += horizontal [5] ;
			}else if(sumOfSeven==minSum) {
				currentRow += vertical [6] ;
				currentColumn += horizontal [6] ;
			}else if(sumOfEight==minSum) {
				currentRow += vertical [7] ;
				currentColumn += horizontal [7] ;
			}
			
			//move Knight to the new location, and update the Chess board.
			++knightPosition;
			chessBoard[currentRow][currentColumn]= knightPosition;
			
			//update knight's position on the heuristic board.
			heuristicBoard[currentRow][currentColumn]= 10;
	
		}while(runs!=64);
		
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
			

	} //end main method
	
	public static int checkMoveOne() {
		minFuturePosMoveOne=100;
		posMoveOne=99;
		currentRow += vertical [0] ;
		currentColumn += horizontal [0] ;
		
		//if the move is invalid, return current row and column to original position.
		if(currentRow<0 || currentColumn<0 || currentRow>7 || currentColumn>7 || chessBoard[currentRow][currentColumn] != 0 || heuristicBoard[currentRow][currentColumn] == 10)  {
			currentRow -= vertical [0] ;
			currentColumn -= horizontal [0] ;
			posMoveOne=99;
		//if the move is valid,get the position and coordinates.
		}
		
		else {		
			//since the move is valid, we reduce accessibility from our starting position to update the heuristic board.
			heuristicBoard[currentRow][currentColumn]-=1;
			
			posMoveOne=heuristicBoard[currentRow][currentColumn];
			currentRowOne=currentRow;
			currentColumnOne=currentColumn;			

			minFuturePosMoveOne=checkFuturePos(currentRow,currentColumn);
			
			//return the current row and column to the starting point, for checking the next possible move.
			currentRow -= vertical [0] ;
			currentColumn -= horizontal [0] ;
		}
		return posMoveOne;
	}
	
	public static int checkMoveTwo() {
		minFuturePosMoveTwo=100;
		posMoveTwo=99;
		currentRow += vertical [1] ;
		currentColumn += horizontal [1] ;
		
		//if the move is invalid, return current row and column to original position.
		if(currentRow<0 || currentColumn<0 || currentRow>7 || currentColumn>7 || chessBoard[currentRow][currentColumn] != 0 || heuristicBoard[currentRow][currentColumn] == 10)  {
			currentRow -= vertical [1] ;
			currentColumn -= horizontal [1] ;
			posMoveTwo=99;
		
		}
		//if the move is valid,get the position and coordinates.
		else {
			
			//since the move is valid, we reduce accessibility from our starting position to update the heuristic board.
			heuristicBoard[currentRow][currentColumn]-=1;
			
			posMoveTwo=heuristicBoard[currentRow][currentColumn];
			currentRowTwo=currentRow;
			currentColumnTwo=currentColumn;			

			minFuturePosMoveTwo=checkFuturePos(currentRow,currentColumn);
			
			//return the current row and column to the starting point, for checking the next possible move.
			currentRow -= vertical [1] ;
			currentColumn -= horizontal [1] ;
		}
		return posMoveTwo;
	}
	
	public static int checkMoveThree() {
		minFuturePosMoveThree=100;
		posMoveThree=99;
		currentRow += vertical [2] ;
		currentColumn += horizontal [2] ;
		
		//if the move is invalid, return current row and column to original position.
		if(currentRow<0 || currentColumn<0 || currentRow>7 || currentColumn>7 || chessBoard[currentRow][currentColumn] != 0 || heuristicBoard[currentRow][currentColumn] == 10)  {
			currentRow -= vertical [2] ;
			currentColumn -= horizontal [2] ;
			posMoveThree=99;
		
		}
		//if the move is valid,get the position and coordinates.
		else {
			
			//since the move is valid, we reduce accessibility from our starting position to update the heuristic board.
			heuristicBoard[currentRow][currentColumn]-=1;
			
			posMoveThree=heuristicBoard[currentRow][currentColumn];
			currentRowThree=currentRow;
			currentColumnThree=currentColumn;			
		
			minFuturePosMoveThree=checkFuturePos(currentRow,currentColumn);
			
			//return the current row and column to the starting point, for checking the next possible move.
			currentRow -= vertical [2] ;
			currentColumn -= horizontal [2] ;
		}
		return posMoveThree;
	}
	
	public static int checkMoveFour() {
		minFuturePosMoveFour=100;
		posMoveFour=99;
		currentRow += vertical [3] ;
		currentColumn += horizontal [3] ;
		
		//if the move is invalid, return current row and column to original position.
		if(currentRow<0 || currentColumn<0 || currentRow>7 || currentColumn>7 || chessBoard[currentRow][currentColumn] != 0 || heuristicBoard[currentRow][currentColumn] == 10)  {
			currentRow -= vertical [3] ;
			currentColumn -= horizontal [3] ;
			posMoveFour=99;
		}
		//if the move is valid,get the position and coordinates.
		else {
			
			//since the move is valid, we reduce accessibility from our starting position to update the heuristic board.
			heuristicBoard[currentRow][currentColumn]-=1;
			
			posMoveFour=heuristicBoard[currentRow][currentColumn];
			currentRowFour=currentRow;
			currentColumnFour=currentColumn;			
			
			minFuturePosMoveFour=checkFuturePos(currentRow,currentColumn);
			
			//return the current row and column to the starting point, for checking the next possible move.
			currentRow -= vertical [3] ;
			currentColumn -= horizontal [3] ;
		}
		return posMoveFour;
	}
	
	public static int checkMoveFive() {
		minFuturePosMoveFive=100;
		posMoveFive=99;
		currentRow += vertical [4] ;
		currentColumn += horizontal [4] ;
		
		//if the move is invalid, return current row and column to original position.
		if(currentRow<0 || currentColumn<0 || currentRow>7 || currentColumn>7 || chessBoard[currentRow][currentColumn] != 0 || heuristicBoard[currentRow][currentColumn] == 10)  {
			currentRow -= vertical [4] ;
			currentColumn -= horizontal [4] ;
			posMoveFive=99;		
		}
		//if the move is valid,get the position and coordinates.
		else {
			
			//since the move is valid, we reduce accessibility from our starting position to update the heuristic board.
			heuristicBoard[currentRow][currentColumn]-=1;
			
			posMoveFive=heuristicBoard[currentRow][currentColumn];
			currentRowFive=currentRow;
			currentColumnFive=currentColumn;			
			
			minFuturePosMoveFive=checkFuturePos(currentRow,currentColumn);
			
			//return the current row and column to the starting point, for checking the next possible move.
			currentRow -= vertical [4] ;
			currentColumn -= horizontal [4] ;
		}
		return posMoveFive;
	}
	
	public static int checkMoveSix() {
		minFuturePosMoveSix=100;
		posMoveSix=99;
		currentRow += vertical [5] ;
		currentColumn += horizontal [5] ;
		
		//if the move is invalid, return current row and column to original position.
		if(currentRow<0 || currentColumn<0 || currentRow>7 || currentColumn>7 || chessBoard[currentRow][currentColumn] != 0 || heuristicBoard[currentRow][currentColumn] == 10)  {
			currentRow -= vertical [5] ;
			currentColumn -= horizontal [5] ;
			posMoveSix=99;
		}
		//if the move is valid,get the position and coordinates.
		else {
			
			//since the move is valid, we reduce accessibility from our starting position to update the heuristic board.
			heuristicBoard[currentRow][currentColumn]-=1;
			
			posMoveSix=heuristicBoard[currentRow][currentColumn];
			currentRowSix=currentRow;
			currentColumnSix=currentColumn;			
			
			minFuturePosMoveSix=checkFuturePos(currentRow,currentColumn);
			
			//return the current row and column to the starting point, for checking the next possible move.
			currentRow -= vertical [5] ;
			currentColumn -= horizontal [5] ;
		}
		return posMoveSix;
	}
	
	
	public static int checkMoveSeven() {
		minFuturePosMoveSeven=100;
		posMoveSeven=99;
		currentRow += vertical [6] ;
		currentColumn += horizontal [6] ;
		
		//if the move is invalid, return current row and column to original position.
		if(currentRow<0 || currentColumn<0 || currentRow>7 || currentColumn>7 || chessBoard[currentRow][currentColumn] != 0 || heuristicBoard[currentRow][currentColumn] == 10)  {
			currentRow -= vertical [6] ;
			currentColumn -= horizontal [6] ;
			posMoveSeven=99;
		}
		//if the move is valid,get the position and coordinates.
		else {
			
			//since the move is valid, we reduce accessibility from our starting position to update the heuristic board.
			heuristicBoard[currentRow][currentColumn]-=1;
			
			posMoveSeven=heuristicBoard[currentRow][currentColumn];
			currentRowSeven=currentRow;
			currentColumnSeven=currentColumn;			

			minFuturePosMoveSeven=checkFuturePos(currentRow,currentColumn);
			
			//return the current row and column to the starting point, for checking the next possible move.
			currentRow -= vertical [6] ;
			currentColumn -= horizontal [6] ;
		}
		return posMoveSeven;
	}
	
	public static int checkMoveEight() {
		minFuturePosMoveEight=100;
		posMoveEight=99;
		currentRow += vertical [7] ;
		currentColumn += horizontal [7] ;
		
		//if the move is invalid, return current row and column to original position.
		if(currentRow<0 || currentColumn<0 || currentRow>7 || currentColumn>7 || chessBoard[currentRow][currentColumn] != 0 || heuristicBoard[currentRow][currentColumn] == 10)  {
			currentRow -= vertical [7] ;
			currentColumn -= horizontal [7] ;
			posMoveEight=99;
		}
		//if the move is valid,get the position and coordinates.
		else {
			
			//Since the move is valid, we reduce accessibility from our starting position to update the heuristic board.
			heuristicBoard[currentRow][currentColumn]-=1;
			
			posMoveEight=heuristicBoard[currentRow][currentColumn];
			currentRowEight=currentRow;
			currentColumnEight=currentColumn;			
				
			minFuturePosMoveEight=checkFuturePos(currentRow,currentColumn);
			
			//return the current row and column to the starting point, for checking the next possible move.
			currentRow -= vertical [7] ;
			currentColumn -= horizontal [7] ;
		}
		return posMoveEight;
	}
	
	public static int checkFuturePos(int row,int col) {
		//initialize control variable to 100.
		minFuturePos=100;
				
		//check all possible moves to get new moving coordinates.
		for(int move=0;move<8;move++) {
			row += vertical [move] ;
			col += horizontal [move] ;
			
			//if the move is invalid, return current row and column to original position.
			if(row<0 || col<0 || row>7 || col>7 || chessBoard[row][col] != 0 || heuristicBoard[row][col] == 10)  {
				row -= vertical [move] ;
				col -= horizontal [move] ;
				
			//if the move is valid, get the minimum future heuristic position.
			} else {
						if(heuristicBoard[row][col]<=minFuturePos) {
							minFuturePos=heuristicBoard[row][col];
						}
						
						//return the current row and column to the starting point, for checking the next possible move.
						row -= vertical [move] ;
						col -= horizontal [move] ;
					}			
		}
		return minFuturePos;
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
