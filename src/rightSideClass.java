import java.util.ArrayList;

public class rightSideClass
{
	private ArrayList<String> alphas;
	private ArrayList<String> betas;

	public rightSideClass()
	{
		this.alphas = new ArrayList<String>();
		this.betas = new ArrayList<String>();
	}

	public void addAlpha(String alpha)
	{
		this.alphas.add(alpha);
	}

	public void addBeta(String beta)
	{
		this.betas.add(beta);
	}

	public ArrayList<String> getAlphas()
	{
		return alphas;
	}

	public void setAlphas(ArrayList<String> alphas)
	{
		this.alphas = alphas;
	}

	public ArrayList<String> getBetas()
	{
		return betas;
	}

	public void setBetas(ArrayList<String> betas)
	{
		this.betas = betas;
	}

}
