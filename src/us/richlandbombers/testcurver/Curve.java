package us.richlandbombers.testcurver;

import java.util.ArrayList;

/**
 * Coders in the Community, 
 * Making the world a better place one line at a time.
 * 
 * @author Dan Avila, Brian Schnepp
 */

public class Curve
{
    private static ArrayList<Double> scores = new ArrayList<Double>();

    public static double getPoints()
    {
	return getPoints(80.0);
    }
    
    public static double getPoints(double trgt)
    {
	double sum = 0;
	for (int k = 0; k < scores.size(); k++)
	{
	    sum += scores.get(k);
	}
	return sum / scores.size() - trgt;
    }
}
