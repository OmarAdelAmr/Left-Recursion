import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class readDataFromFile
{
	ArrayList<inputData> input = new ArrayList<inputData>();

	public readDataFromFile(String input_data_file_name)
	{
		try
		{
			FileReader fr = new FileReader(input_data_file_name);
			BufferedReader br = new BufferedReader(fr);
			String currentLine;
			while ((currentLine = br.readLine()) != null)
			{
				inputData temp = new inputData(currentLine);
				currentLine = br.readLine();
				String[] rightSideArr = currentLine.split("\\|");
				temp.setAllRightSide(new ArrayList<String>(Arrays.asList(rightSideArr)));
				this.input.add(temp);
			}
			br.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public ArrayList<inputData> getInput()
	{
		return input;
	}

	public void setInput(ArrayList<inputData> input)
	{
		this.input = input;
	}

}
