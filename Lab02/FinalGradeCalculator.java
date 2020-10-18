/*
 * Written by Warren Beagle
 * Lab02: Final Grade Calculator
 */
import java.io.*;
import java.util.Scanner;
public class FinalGradeCalculator {
	
	//public static final String DELIM = "\n";
	//public static final int FIELD_AMT = 1; //Columns
	int labSum = 0;
	int labCount = 0;
	int lowestHW = 0;
	int hwSum = 0;
	int hwCount = 0;
	int exam1Sum = 0;
	int exam1Count = 0;
	int exam2Sum = 0;
	int exam2Count = 0;
	int labExam1Sum = 0;
	int labExam1Count = 0;
	int labExam2Sum = 0;
	int labExam2Count = 0;
	int finalSum = 0;
	int finalCount = 0;
	int ecSum = 0;
	int ecCount = 0;
	boolean isLabs = false;
	boolean isHW = false;
	boolean isExam1 = false;
	boolean isExam2 = false;
	boolean isLabExam1 = false;
	boolean isLabExam2 = false;
	boolean isFinal = false;
	boolean isEC = false;
	
	public static void main(String[] args) 
	{
		FinalGradeCalculator fgc = new FinalGradeCalculator();
		// TODO Auto-generated method stub
		fgc.readGradeFile("./other.txt");
		System.out.println("Your lab average is: " + (fgc.labSum/fgc.labCount));
		System.out.println("Your homework average is " + (fgc.hwSum/fgc.hwCount));
		System.out.println("Your first exam is " + (fgc.exam1Sum/fgc.exam1Count));
		System.out.println("Your first lab exam is " + (fgc.labExam1Sum/fgc.labExam1Count));
		System.out.println("Your second exam is " + (fgc.exam2Sum/fgc.exam2Count));
		System.out.println("Your second lab exam is " + (fgc.labExam2Sum/fgc.labExam2Count));
		System.out.println("Your extra work total is " + (fgc.ecSum * 0.02) + " points");
		System.out.println("Your final is " + (fgc.finalSum/fgc.finalCount));
		double lab = (fgc.labSum/fgc.labCount) * 0.2;
		double hw = (fgc.hwSum/fgc.hwCount) * 0.3;
		double exam1 = (fgc.exam1Sum/fgc.exam1Count) * 0.1;
		double exam2 = (fgc.exam2Sum/fgc.exam2Count) * 0.1;
		double labExam1 =  (fgc.labExam1Sum/fgc.labExam1Count) * 0.1;
		double labExam2 =  (fgc.labExam2Sum/fgc.labExam2Count) * 0.1;
		double finalN =  (fgc.finalSum/fgc.finalCount) * 0.1;
		double ec =  (fgc.ecSum * 0.02);
		double finalGrade = Math.ceil(lab + hw + exam1 + exam2 + labExam1 + labExam2 + finalN + ec);
 		System.out.println("Your raw total is " + finalGrade);
 		String letterGrade = " ";
 		if(finalGrade >= 90)
 		{
 			letterGrade = "A";
 		}
 		else if(finalGrade <= 89 && finalGrade >= 85)
 		{
 			letterGrade = "B+";
 		}
 		else if(finalGrade <= 84 && finalGrade >= 80)
 		{
 			letterGrade = "B";
 		}
 		else if(finalGrade <= 79 && finalGrade >= 75)
 		{
 			letterGrade = "C+";
 		}
 		else if(finalGrade <= 74 && finalGrade >= 70)
 		{
 			letterGrade = "C";
 		}
 		else if(finalGrade <= 69 && finalGrade >= 65)
 		{
 			letterGrade = "D+";
 		}
 		else if(finalGrade <= 64 && finalGrade >= 60)
 		{
 			letterGrade = "D";
 		}
 		else
 		{
 			letterGrade = "F";
 		}
 		System.out.println("Your final grade is " + letterGrade);
	}
	
	public void readGradeFile(String fileName)
	{
		if(fileName == null)
		{
			return;
		}
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName)); //File Scanner
			int numGrades = 0;
			while(fileScanner.hasNextLine())
			{
				numGrades++;
				fileScanner.nextLine();
			}
			if(numGrades == 0)
			{
				fileScanner.close();
				return;
			}
			fileScanner = new Scanner(new File(fileName)); //Reset the scanner to the top
			//Second pass read the elements
			String fileLine;
			while(fileScanner.hasNextLine())
			{
				/*boolean isLabs;
				boolean isHW;
				boolean isExam1;
				boolean isExam2;
				boolean isLabExam1;
				boolean isLabExam2;
				boolean isFinal;
				boolean isEC;*/
				fileLine = fileScanner.nextLine();
				if(fileLine.equalsIgnoreCase("labs"))
				{
					isLabs = true;
					isHW = false;
					isExam1 = false;
					isExam2 = false;
					isLabExam1 = false;
					isLabExam2 = false;
					isFinal = false;
					isEC = false;
				}
				else if(fileLine.equalsIgnoreCase("homework"))
				{
					isLabs = false;
					isHW = true;
					isExam1 = false;
					isExam2 = false;
					isLabExam1 = false;
					isLabExam2 = false;
					isFinal = false;
					isEC = false;
				}
				else if(fileLine.equalsIgnoreCase("exam 1"))
				{
					isLabs = false;
					isHW = false;
					isExam1 = true;
					isExam2 = false;
					isLabExam1 = false;
					isLabExam2 = false;
					isFinal = false;
					isEC = false;
				}
				else if(fileLine.equalsIgnoreCase("exam 2"))
				{
					isLabs = false;
					isHW = false;
					isExam1 = false;
					isExam2 = true;
					isLabExam1 = false;
					isLabExam2 = false;
					isFinal = false;
					isEC = false;
				}
				else if(fileLine.equalsIgnoreCase("lab exam 1"))
				{
					isLabs = false;
					isHW = false;
					isExam1 = false;
					isExam2 = false;
					isLabExam1 = true;
					isLabExam2 = false;
					isFinal = false;
					isEC = false;
				}
				else if(fileLine.equalsIgnoreCase("lab exam 2"))
				{
					isLabs = false;
					isHW = false;
					isExam1 = false;
					isExam2 = false;
					isLabExam1 = false;
					isLabExam2 = true;
					isFinal = false;
					isEC = false;
				}
				else if(fileLine.equalsIgnoreCase("final"))
				{
					isLabs = false;
					isHW = false;
					isExam1 = false;
					isExam2 = false;
					isLabExam1 = false;
					isLabExam2 = false;
					isFinal = true;
					isEC = false;
				}
				else if(fileLine.equalsIgnoreCase("extra credit"))
				{
					isLabs = false;
					isHW = false;
					isExam1 = false;
					isExam2 = false;
					isLabExam1 = false;
					isLabExam2 = false;
					isFinal = false;
					isEC = true;
				}
				else
				{
					if(isLabs == true)
					{
						labSum += Integer.parseInt(fileLine);
						labCount ++;
					}
					else if(isHW == true)
					{
						if(Integer.parseInt(fileLine) <= lowestHW)
						{
							lowestHW = Integer.parseInt(fileLine);
						}
						else
						{
							hwSum += Integer.parseInt(fileLine);
							hwCount ++;
						}
					}
					else if(isExam1 == true)
					{
						exam1Sum += Integer.parseInt(fileLine);
						exam1Count ++;
					}
					else if(isExam2 == true)
					{
						exam2Sum += Integer.parseInt(fileLine);
						exam2Count ++;
					}
					else if(isLabExam1 == true)
					{
						labExam1Sum += Integer.parseInt(fileLine);
						labExam1Count ++;
					}
					else if(isLabExam2 == true)
					{
						labExam2Sum += Integer.parseInt(fileLine);
						labExam2Count ++;
					}
					else if(isFinal == true)
					{
						finalSum += Integer.parseInt(fileLine);
						finalCount ++;
					}
					else if(isEC == true)
					{
						ecSum += Integer.parseInt(fileLine);
						ecCount ++;
					}
				}
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
