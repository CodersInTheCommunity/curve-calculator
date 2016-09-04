package us.richlandbombers.testcurver;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Sliders extends JPanel
{
    private SliderLine weightGrade;
    private BooleanBox alsoSubtract;

    // Add more later
    public Sliders()
    {
	super();
	weightGrade = new SliderLine("Average Grade");
	alsoSubtract = new BooleanBox("Also subtract");
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	this.add(Box.createVerticalGlue());
	this.add(weightGrade);
	this.add(alsoSubtract);
	this.add(Box.createVerticalGlue());
    }
}
