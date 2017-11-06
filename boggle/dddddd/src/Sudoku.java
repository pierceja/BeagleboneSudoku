import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sudoku {
	
	private static int boardSize = 0;
	private static int partitionSize = 0;
	private static int[][] vals = null;

	public static void main(String[] args) {
		String filename = args[0];
		File inputFile = new File(filename);
		Scanner input = null;
		correction.correct(filename);
		File intermediatefile=new File("/home/debian/BeagleboneSudoku/boggle/dddddd/src/ImageCorrection.txt");

		int temp = 0;
		int count = 0;

		try {
			input = new Scanner(intermediatefile);
			temp = input.nextInt();
			boardSize = temp;
			partitionSize = (int) Math.sqrt(boardSize);
			System.out.println("Boardsize: " + temp + "x" + temp);
			vals = new int[boardSize][boardSize];

			System.out.println("Input:");
			int i = 0;
			int j = 0;
			while (input.hasNext()) {
				temp = input.nextInt();
				count++;
				System.out.printf("%3d", temp);
				vals[i][j] = temp;
				j++;
				if (j == boardSize) {
					j = 0;
					i++;
					System.out.println();
				}
				if (j == boardSize) {
					break;
				}
			}
			input.close();
		} catch (FileNotFoundException exception) {
			System.out.println("Input file not found: " + filename);
		}
		if (count != boardSize * boardSize)
			throw new RuntimeException("Incorrect number of inputs.");

		boolean solved = solve(0, 0);
		
		try {
            PrintWriter output;
               output = new PrintWriter("/home/debian/BeagleboneSudoku/boggle/solution.txt");
               // Output
               if (!solved) {
                      System.out.println("No solution found.");
                   output.println("No solution found.");
                   output.close();
                      return;
               }
               output.println(boardSize);
               System.out.println("\nOutput\n");
               for (int i = 0; i < boardSize; i++) {
                      for (int j = 0; j < boardSize; j++) {
                            System.out.printf("%3d", vals[i][j]);
                          output.printf("%3d", vals[i][j]);
                      }
                      System.out.println();
                   output.println();
               }      
          output.close();
        } catch (FileNotFoundException exception) {
               System.out.println(exception);
        }


	}



	private static boolean checkNum(int row, int line, int number) {
		for (int i = 0; i < boardSize; i++) {
			if (vals[row][i] == number || vals[i][line] == number) {
				return false;
			}
		}
		int tempRow = row / partitionSize;
		int tempLine = line / partitionSize;
		for (int i = 0; i < partitionSize; i++) {
			for (int j = 0; j < partitionSize; j++) {
				if (vals[tempRow * partitionSize + i][tempLine * partitionSize + j] == number) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean solve(int i, int j) {
		if (i == boardSize-1 && j == boardSize)
			return true;
		if (j == boardSize) {
			i++;
			j = 0;
		}
		if (vals[i][j] == 0) {
			for (int k = 1; k <= boardSize; k++) {
				if (checkNum(i, j, k)) {
					vals[i][j] = k;
					if (solve(i, j + 1))
						return true;
					vals[i][j] = 0;
				}
			}
		} else {
			if (solve(i, j + 1))
				return true;
		}
		return false;
	}


}
