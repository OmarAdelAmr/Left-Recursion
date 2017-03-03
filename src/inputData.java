import java.util.ArrayList;
import java.util.LinkedHashSet;

public class inputData
{
	private String leftSide;
	private rightSideClass rightSide;
	private ArrayList<String> allRightSide;

	public inputData(String leftSide)
	{
		this.leftSide = leftSide;
		this.rightSide = new rightSideClass();
		this.allRightSide = new ArrayList<String>();
	}

	public void splitRightSide()
	{
		LinkedHashSet<String> hs = new LinkedHashSet<>();
		hs.addAll(allRightSide);
		allRightSide.clear();
		allRightSide.addAll(hs);

		for (int i = 0; i < allRightSide.size(); i++)
		{
			if (allRightSide.get(i).startsWith(leftSide))
			{
				String tempAlpha = allRightSide.get(i).substring(leftSide.length());
				rightSide.addAlpha(tempAlpha);
			} else
			{
				rightSide.addBeta(allRightSide.get(i));
			}
		}
	}

	public String getLeftSide()
	{
		return leftSide;
	}

	public void setLeftSide(String leftSide)
	{
		this.leftSide = leftSide;
	}

	public rightSideClass getRightSide()
	{
		return rightSide;
	}

	public void setRightSide(rightSideClass rightSide)
	{
		this.rightSide = rightSide;
	}

	public ArrayList<String> getAllRightSide()
	{
		return allRightSide;
	}

	public void setAllRightSide(ArrayList<String> allRightSide)
	{
		this.allRightSide = allRightSide;
	}

}
