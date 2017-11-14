import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class correction {
	private static int boardSize = 9;
	private static int partitionSize = 3;
	private static int[][] vals = null;
	public static void correct(String filename) {
		//String filename = args[0];
		File inputFile = new File(filename);
		Scanner input = null;

		String temp = null;
		int count = 0;

		try {
			input = new Scanner(inputFile);
			temp = input.next();
			vals = new int[boardSize][boardSize];
			vals[0][0] = Integer.parseInt(temp);

			System.out.println("Input:");
			System.out.print(temp);
			int i = 0;
			int j = 1;
			while (input.hasNext()) {
				temp = input.next();
				count++;
				System.out.print(temp);
				if(String.valueOf(temp).length()==1){
					vals[i][j] = Integer.parseInt(temp);
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
				else{
					for (char ch : temp.toCharArray()) {
					    int digit = ch - '0';
					    vals[i][j] = digit;
					    j++;
					}
				if (j == boardSize) {
					j = 0;
					i++;
					System.out.println();
				}
				if (j == boardSize) {
					break;
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
