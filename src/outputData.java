import java.util.ArrayList;

public class outputData
{
	private String leftSide;
	private ArrayList<String> rightSide;

	public outputData(String leftSide)
	{
		this.leftSide = leftSide;
		this.rightSide = new ArrayList<String>();
	}

	public String toString()
	{
		String result = leftSide + "->[";
		for (int i = 0; i < rightSide.size(); i++)
		{
			result += rightSide.get(i);
			if (i < rightSide.size() - 1)
			{
				result += ", ";
			}
		}
		result += "]";
		return result;
	}

	public String getLeftSide()
	{
		return leftSide;
	}

	public void setLeftSide(String leftSide)
	{
		this.leftSide = leftSide;
	}

	public ArrayList<String> getRightSide()
	{
		return rightSide;
	}

	public void setRightSide(ArrayList<String> rightSide)
	{
		this.rightSide = rightSide;
	}

}
