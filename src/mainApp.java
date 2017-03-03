import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class mainApp
{
	private static ArrayList<inputData> inputRules;
	private static ArrayList<outputData> outputRules = new ArrayList<outputData>();
	private static String fileName = "Sample3.in";

	public static void checkForCycles()
	{
		if (inputRules.size() > 0)
		{
			inputData splitFirstRule = inputRules.get(0);
			splitFirstRule.splitRightSide();
			inputRules.set(0, splitFirstRule);
		}

		for (int i = 1; i < inputRules.size(); i++)
		{
			inputData checkedRule = new inputData(inputRules.get(i).getLeftSide());
			for (int j = 0; j < i; j++)
			{
				for (int j2 = 0; j2 < inputRules.get(i).getAllRightSide().size(); j2++)
				{
					if (inputRules.get(i).getAllRightSide().get(j2).contains(inputRules.get(j).getLeftSide()))
					{
						boolean hasCircle = false;
						A: for (int k = 0; k < inputRules.get(j).getAllRightSide().size(); k++)
						{
							if (inputRules.get(j).getAllRightSide().get(k).contains(inputRules.get(i).getLeftSide()))
							{
								hasCircle = true;
								break A;
							}
						}
						if (hasCircle)
						{
							for (int k2 = 0; k2 < inputRules.get(j).getAllRightSide().size(); k2++)
							{
								String replacesRule = inputRules.get(i).getAllRightSide().get(j2).replaceAll(
										inputRules.get(j).getLeftSide(), inputRules.get(j).getAllRightSide().get(k2));
								checkedRule.getAllRightSide().add(replacesRule);
							}
						}
					} else
					{
						checkedRule.getAllRightSide().add(inputRules.get(i).getAllRightSide().get(j2));
					}
				}

			}
			checkedRule.splitRightSide();
			inputRules.set(i, checkedRule);
		}
	}

	public static void leftFactoring()
	{
		for (int i = 0; i < inputRules.size(); i++)
		{
			if (inputRules.get(i).getRightSide().getAlphas().size() == 0)
			{
				outputData tempOutData = new outputData(inputRules.get(i).getLeftSide());
				tempOutData.setRightSide(inputRules.get(i).getAllRightSide());
				outputRules.add(tempOutData);
			} else
			{
				outputData tempOutData1 = new outputData(inputRules.get(i).getLeftSide());
				ArrayList<String> tempOutData1RightSide = new ArrayList<String>();
				for (int j = 0; j < inputRules.get(i).getRightSide().getBetas().size(); j++)
				{
					tempOutData1RightSide.add(
							inputRules.get(i).getRightSide().getBetas().get(j) + inputRules.get(i).getLeftSide() + "'");
				}
				tempOutData1.setRightSide(tempOutData1RightSide);
				outputRules.add(tempOutData1);

				outputData tempOutData2 = new outputData(inputRules.get(i).getLeftSide() + "'");
				ArrayList<String> tempOutData1RightSide2 = new ArrayList<String>();
				for (int j = 0; j < inputRules.get(i).getRightSide().getAlphas().size(); j++)
				{
					tempOutData1RightSide2.add(inputRules.get(i).getRightSide().getAlphas().get(j)
							+ inputRules.get(i).getLeftSide() + "'");
				}
				tempOutData1RightSide2.add("!");
				tempOutData2.setRightSide(tempOutData1RightSide2);
				outputRules.add(tempOutData2);
			}
		}
	}

	public static void makeOutputFile(String fileName)
	{
		try
		{
			String output_file = fileName.replaceAll("\\D+", "");
			PrintWriter fw = new PrintWriter(new FileWriter("Sample" + output_file + ".out"));
			String output_file_content1 = "";
			String output_file_content2 = "";
			for (int i = 0; i < outputRules.size(); i++)
			{
				if (outputRules.get(i).getLeftSide().contains("'"))
				{
					output_file_content2 += outputRules.get(i).toString() + "\n";
				} else
				{
					output_file_content1 += outputRules.get(i).toString() + "\n";
				}
			}
			System.out.println(output_file_content1 + output_file_content2);
			fw.print(output_file_content1 + output_file_content2);
			fw.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		readDataFromFile x = new readDataFromFile(fileName);
		inputRules = x.getInput();
		checkForCycles();
		leftFactoring();
		makeOutputFile(fileName);
	}

}
