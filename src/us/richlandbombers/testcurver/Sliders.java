package us.richlandbombers.testcurver;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Sliders extends JPanel
{
    private SliderLine weightGrade;
    private BooleanBox alsoSubtract;
    private JButton curve;

    // Add more later
    public Sliders()
    {
	super();
	weightGrade = new SliderLine("Average Grade");
	alsoSubtract = new BooleanBox("Also subtract");
	curve = new JButton("Curve!");
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	this.add(Box.createVerticalGlue());
	this.add(weightGrade);
	this.add(alsoSubtract);
	this.add(Box.createVerticalGlue());
	this.add(curve);
    }
    
    public double getTarget()
    {
	return weightGrade.getWht();
    }
    
    public boolean getSubtract()
    {
	return alsoSubtract.getSub();
    }
    
    public JButton getCurve()
    {
	return this.curve;
    }
}
