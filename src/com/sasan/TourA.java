package com.sasan;

import java.util.*;

public class TourA {

	public static void main(String[] args) {
		
		//initialize Chess board.
		int[][] chessBoard = new int[8][8];
		
		//initialize possible Vertical and Horizontal moves.
		int[] horizontal = {2,1,-1,-2,-2,-1,1,2};
		int[] vertical = {-1,-2,-2,-1,1,2,2,1};
		
		//knight's position is 1
		int knightPosition=1;
		
		//give Knight a random starting position.
		Random starting = new Random();
		int startingPos= starting.nextInt(8);
		int currentRow=startingPos;
		int currentColumn=startingPos;
		
		//set the board.
		chessBoard[currentRow][currentColumn]= knightPosition;
	
		//number of iterations.
		int moveTries=0;
		
		do {
			//give Knight a random move.
			Random rNum = new Random();
			int move= rNum.nextInt(8);
			currentRow += vertical [move] ;
			currentColumn += horizontal [move] ;
			
			//If the move is invalid, return Knight to it's original position.
			if(currentRow<0 || currentColumn<0 || currentRow>7 || currentColumn>7 || chessBoard[currentRow][currentColumn] != 0 ) {
				currentRow -= vertical [move] ;
				currentColumn -= horizontal [move] ;		
			}	
			//If the move is valid, update it's current position on the board.
			else {
				++knightPosition;
				chessBoard[currentRow][currentColumn]= knightPosition;
			}
			
			//increment iterations.
			++moveTries;
			
		}while(moveTries!=64); //64 indicates a full tour.
		
		//print the output.
		System.out.print("/");
		for(int star=1;star<=65;star++) {
			System.out.print("*");
		}
		
		System.out.println();
		System.out.println("Sample 1");
		System.out.println("The tour ended with: "+knightPosition+" moves.");
		
		if(knightPosition<64) {
			System.out.println("This was not a full tour.");
		}
		else if(knightPosition==64) {
			System.out.println("This was not a full tour.");
		}
		
		System.out.println();
		printBoard(chessBoard);
		System.out.println();
		
		//sample 2.
		
		//initialize chess board to 0.
		for (int row = 0; row < chessBoard.length; row++)
		{
			for (int col = 0; col < chessBoard[row].length; col++)
		    {
				chessBoard[row][col] = 0; 
		    }
		}
		
		//knight's position is 1.
		knightPosition=1;
				
		//give Knight a random starting position.	
		startingPos= starting.nextInt(8);
		currentRow=startingPos;
		currentColumn=startingPos;
		chessBoard[currentRow][currentColumn]= knightPosition;
			
		//number of iterations.
		moveTries=0;
		
		do {
			//give Knight a random move.
			Random rNum = new Random();
			int move= rNum.nextInt(8);
			currentRow += vertical [move] ;
			currentColumn += horizontal [move] ;
			
			//if the move is invalid, return Knight to it's original position.
			if(currentRow<0 || currentColumn<0 || currentRow>7 || currentColumn>7 || chessBoard[currentRow][currentColumn] != 0 ) {
				currentRow -= vertical [move] ;
				currentColumn -= horizontal [move] ;
			
			}
			//if the move is valid, update it's current position on the board.
			else {
				++knightPosition;
				chessBoard[currentRow][currentColumn]= knightPosition;
			}
			
			//increment iterations.
			++moveTries;
			
		}while(moveTries!=64); //64 indicates a full tour.
		
		//print the output.
		System.out.println("Sample 2");
		System.out.println("The tour ended with: "+knightPosition+" moves.");
		
		if(knightPosition<64) {
			System.out.println("This was not a full tour.");
		}
		else if(knightPosition==64) {
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
	
	//method to print the board.
	public static void printBoard(int[][] board) {
		//Row headers
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
