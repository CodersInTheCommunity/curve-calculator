
/**
 * Curve calculator for grading tests.
 * 
 * @author Coders in the Community
 * @version 0.0.1
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.UIManager.*;

public class Calculator extends JFrame
{    
	private JTextField field;
	private JTextField f;
	private JTextField d;
	private JButton button;
	
	public Calculator()
	{
		intiUI();
	}
	
	public final void intiUI()
	{
		setLayout(null);
		JLabel target = new JLabel("Target");
		target.setBounds(10,50,80,20);
		
		JLabel ave = new JLabel("Average:");
		ave.setBounds(10,65,80,20);
		
		JLabel pos = new JLabel("Possible");
		pos.setBounds(10,80,100,50);
		
		JLabel points = new JLabel("Points:");
		points.setBounds(10,95,100,50);
		
		JLabel scores = new JLabel("Scores:");
		scores.setBounds(10,120,100,50);
		
		//Target Average
		field = new JTextField();
		field.setBounds(120,50,80,30);
		
		//Possible Points
		f = new JTextField();
		f.setBounds(120,95,80,30);    
		
		//Real Scores
		d = new JTextField();
		d.setBounds(120,135,80,30);
		
		JLabel ans = new JLabel();
		ans.setBounds(50,280,500,50);
		
		button = new JButton("Get Curve");
		button.setBounds(98,210,125,25);
		button.setEnabled(true);
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{                
				if(field.getText().length() > 0 && f.getText().length() > 0 && d.getText().length() > 0)
				{
					ArrayList<Double> scores = new ArrayList<Double>();   
					String aver = field.getText();
					for(int i = 0; i < 150; i++)
					{
						if(aver.charAt(i) == ',')
						{
							final int value = Integer.parseInt(aver.substring(i, aver.indexOf(',')));
							System.out.println(value);
						}
					}

					
//                     double average
//              		double sum = 0;
//             		for(int k = 0; k< scores.size(); k++) 
//             		{
//             		    sum += scores.get(k);
//             		}
//             		return sum/scores.size()-average;
				}
				else
				{
					ans.setText("You must complete all fields.");
				}
			}
		});
		
		
		setTitle("Curve Calculator");
		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(target);
		add(ave);
		add(pos);
		add(points);
		add(scores);
		add(field);
		add(f);
		add(d);
		add(button);
		add(ans);
	}
	
	public static void main (String[] args)
	{                
		SwingUtilities.invokeLater(new Runnable() 
		{

			public void run() 
			{
			try {
				for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
						UIManager.setLookAndFeel(info.getClassName());
						break;
					}
				}
			} catch (Exception e) {

			}
				Calculator f = new Calculator();
				f.setVisible(true);
			}
		});
	}
}
