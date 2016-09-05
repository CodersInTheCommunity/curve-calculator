import java.util.Scanner;
/**
 * Dan Avila
 * 
 * 9/4/2016
 * 0.0.1
 */
public class Curver
{
   public static void main(String[] args)
   {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter all of the test scores, in points, separated by a space.");
    String scores = sc.nextLine();
    System.out.println("How many points is the test worth?");
    double totalPoints = sc.nextDouble();
    System.out.println("What would you like the average test score to be in percent?");
    double avg = sc.nextDouble();
    double sum = 0;
    int stop = 0;
    int loc = 0;
    int totalScores = 0;
    int end = 0;
    double max = Double.MIN_VALUE;
    scores = scores.trim();
    while(stop < 1)
    {
        end = scores.indexOf(" ", loc);
        if(end>=0)
        {
        sum += Double.parseDouble(scores.substring(loc,end));
        if(Double.parseDouble(scores.substring(loc,end))> max)
        {
            max = Double.parseDouble(scores.substring(loc,end));
        }
        
        
        loc = end+1;
        totalScores++;
    }
    else
    {
        sum += Double.parseDouble(scores.substring(loc, scores.length()));
        if(Double.parseDouble(scores.substring(loc,scores.length()))> max)
        {
            max = Double.parseDouble(scores.substring(loc,scores.length()));
        }
       
        
        totalScores++;
        stop = 1;
    }
    }
    double testAveragePoints = sum/totalScores;
    double testAveragePercentage = testAveragePoints/totalPoints*100;
    double targetPoints = avg/100.0*totalPoints;
    double curve = targetPoints-testAveragePoints;
    if( curve>0)
    {
    System.out.println(" ");
    System.out.printf("To curve this test add %.2f points to each score.", curve);
    System.out.println(" ");
    System.out.println("Test Diagnostics:");
    System.out.println("Number of students who took this test: " + totalScores);
    System.out.printf("Average test score in points: %.2f", testAveragePoints);
     System.out.println(" ");
    System.out.printf("Average test score in percentage: %.2f" , testAveragePercentage);
     System.out.println(" ");
    System.out.println("The class high in points: "+ max);
   }
   else if( curve < 0)
   {
   System.out.println(" ");
    System.out.printf("To curve this test subtract %.2f points from each score.", (-1 * curve));
    System.out.println(" ");
    System.out.println("Test Diagnostics:");
    System.out.println("Number of students who took this test: " + totalScores);
    System.out.printf("Average test score in points: %.2f", testAveragePoints);
     System.out.println(" ");
    System.out.printf("Average test score in percentage: %.2f" , testAveragePercentage);
     System.out.println(" ");
    System.out.println("The class high in points: "+ max);
   }
   else if (curve == 0)
   {
   System.out.println(" ");
    System.out.println("This test doesn not need to be curved.");
    System.out.println("Test Diagnostics:");
    System.out.println("Number of students who took this test: " + totalScores);
    System.out.printf("Average test score in points: %.2f", testAveragePoints);
     System.out.println(" ");
    System.out.printf("Average test score in percentage: %.2f" , testAveragePercentage);
     System.out.println(" ");
    System.out.println("The class high in points: "+ max);
   }
}
}
