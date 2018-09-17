/****************************
ZId     : Z1817929
Name    : Swathi Prakasha
Course  : CSCI 680-E1
Assign  : 2
****************************/
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.IOException;

public class Hw2 {

	public static void main(String[] args) throws IOException {

		int recordCount = 0;

		// Check on the parameters passed or not
		if (args.length != 1) {
			System.out.printf("Error: no argument received, pass the filename as an argument\n");
			System.exit(-1);
		}
		Path path = Paths.get(args[0]); // path object created based on the										// command line argument
		try {
			Scanner inputFile = new Scanner(path); // Reading the file

			System.out.println("Input file is:" + path);
			// looping till the file has nextline to read
			while (inputFile.hasNextLine()) {
				recordCount += 1; // for debugging
				int numOfDays, flag = 0;
				int arrDate[] = { 13, 32, 1800 }, i = 0;

				// get a line from the file
				String inputLine = inputFile.nextLine();
				Scanner line = new Scanner(inputLine);
				System.out.print("\n" + inputLine);

				// check for data in the line. If its empty line, come out of
				// the loop and continue with reading next line.
				if (line.hasNext() == false) {
					System.out.print("\t\tLine is empty");
					continue;
				}

				// get the first data from the line scanner, parsing it to a
				// another scanner'date'
				Scanner date = new Scanner(line.next());
				// delimiter is used to break the pattern.
				date.useDelimiter("/ *");

				// expecting 3 data in the date, the while loop is to just to
				// read the date and store it in the different variables
				while (date.hasNext() || i < 3) {
					// checking the data is integer type or not
					if (date.hasNextInt() == false) {
						System.out.print("\tInvalid date");
						flag = 1;
						break;
					}

					// checking if the date has more than 3 fields
					if (i >= 3) {
						System.out.print("\tInvalid date type,date has more fields ");
						flag = 2;
						break;
					}

					// reading the data into the arrDate[]
					arrDate[i] = date.nextInt();
					i++;
				}

				date.close();
				// if the date is already found to be invalid no need to proceed
				// further validation
				if (flag > 0) {
					continue;
				}
				// check on month range
				if (arrDate[0] > 12 || arrDate[0] < 1) {
					System.out.print("\t Month is out of range");
					continue;
				}

				 // check on date range for leap year 

				 if (arrDate[0] == 2 && (Dte.leapYearChk(arrDate[2]) == true)){
						if(arrDate[1] > (Dte.monthData[arrDate[0] - 1].daysOfMonth +1)|| arrDate[1] < 1) {
							System.out.print("\tDay is out of range");
							continue;
						}
					}

				// Check on date range

				 else if (arrDate[1] > Dte.monthData[arrDate[0] - 1].daysOfMonth || arrDate[1] < 1) {
					System.out.print("\tDay is out of range");
					continue;
				}
			  

				if (arrDate[2] < 1801) {
					System.out.print("\tyear is out of range");
					continue;
				}

				// reading the next content of the line : days to increment/
				// decrement
				if (line.hasNext() == false) {
					System.out.print("\tNo Increment/Decrement Value");
					continue;
				}

				// check on the next content is integer type or not :days to
				// increment/ decrement
				if (line.hasNextInt() == false) {
					System.out.print("\tNon numeric Increment/Decrement value found");
					continue;
				}

				numOfDays = line.nextInt();

				// check whether the increment/decrement value is positive
				// integer or not//
				if (numOfDays < 0) {
					System.out.print("\tIncrement/Decrement is non positive integer");
					continue;
				}

				if (line.hasNext() == true) {
					System.out.print("\tExcess data");
					continue;
				}
                //Creating class Dte objects
				Dte a = new Dte(arrDate[0], arrDate[1], arrDate[2]); 
				Dte b = new Dte(arrDate[0], arrDate[1], arrDate[2]);

				// calling the member function - for addition 
				a.addDays(numOfDays);
				System.out.print("\t" + a);
				
				// calling the member function - for subtraction 
				b.subDays(numOfDays);
				System.out.print("\t" + b);
				

				line.close();

			}
			inputFile.close();
		} // end of try

		catch (NoSuchFileException fileException) {
			System.out.println("File doesnot exists !");
			fileException.printStackTrace();
			System.exit(1);
		} catch (NoSuchElementException elementException) {
			System.out.println("File improperly formed. Terminating.");
			System.exit(1);
		} catch (IllegalStateException stateException) {
			System.out.println("Error reading from file. Terminating.");
			System.exit(1);
		}

		System.out.println("\n\nNo. of records = " + recordCount);

	} // end of main
	
} // end of Hw2
