import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class correction {
	private static int boardSize = 9;
	private static int partitionSize = 3;
	private static int[][] vals = null;

	public static void correct(String filename) {
		// String filename = args[0];
		File inputFile = new File(filename);
		Scanner input = null;

		String temp = null;
		int count = 0;

		try {
			input = new Scanner(inputFile).useDelimiter("'");
			vals = new int[boardSize][boardSize];
			System.out.println("Input:");
			int i = 0;
			int j = 0;
			while (input.hasNext()) {
				temp = input.next();
				count++;
				System.out.print(temp);
				for (char ch : temp.toCharArray()) {
					int digit = ch - '0';
					if (digit != -38) {
						if (digit == -16) {
							vals[i][j] = 0;
						} else if (digit == -35) {
							if(j!=boardSize && j!=0){
								for(int k=j;k<boardSize;k++){
									vals[i][k]=0;
								}
								j=8;
							}
							else{
								j=-1;
							}
						} else {
							vals[i][j] = digit;
						}
						j++;
						if (j == boardSize) {
							j = 0;
							i++;
							System.out.println();
						}
						if (i == boardSize) {
							break;

						}
					}
				}
			}

			input.close();
		} catch (FileNotFoundException exception) {
			System.out.println("Input file not found: " + filename);
		}
		try {
			PrintWriter output;
			output = new PrintWriter("/home/debian/BeagleboneSudoku/boggle/ImageCorrection.txt");
			// Output
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

}
