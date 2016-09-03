import java.util.ArrayList;

/*
 * Coders in the Community
 * 
 * Dan Avila
 * Making the world a better place one line at a time.
 */

public class Curve 
{
	ArrayList<Double> scores= new ArrayList<Double>();   
	public double getPoints() 
	{
		double average = 80;
		double sum = 0;
		for(int k = 0; k< scores.size(); k++) 
		{
			sum += scores.get(k);
		}
		return sum/scores.size()-average;
	}
}


