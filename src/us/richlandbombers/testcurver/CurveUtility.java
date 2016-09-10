package us.richlandbombers.testcurver;

public class CurveUtility
{
    public static int calculate(int[] pts, int[] mxpts, double target, boolean subtractToo)
    {
	int points = 0;
	int addpoints = 0;
	
	// Grabs current average first
	for (int n : pts)
	{
	    points += n;
	}
	
	// Averages them
	double average = points / (double) mxpts.length;
	if (average >= target && !subtractToo)
	{
	    return addpoints;
	}
	
	// Uses magic to find points to add to everyone.
	double pcnt = target - average;
	System.out.println(pcnt / 100 + "");
	System.out.println(mxpts[0]);
	addpoints = (int) (pcnt / 100 * mxpts[0] - average);
	
	return addpoints;
    }
    
    public static int[] generateCol(int addpoints, int[] scores)
    {
	int[] newScores = new int[scores.length];
	for (int i = 0; i < scores.length; i++)
	{
	    newScores[i] = scores[i] + addpoints;
	}
	return newScores;
    }
    
    public static int[] dynamicCalculate(int[] pts, int[] mxpts, double target, boolean subtractToo)
    {
	//TODO, dynamic would add more points if your score was lower, or less points the higher it was from average.
	return mxpts;
    }
}
