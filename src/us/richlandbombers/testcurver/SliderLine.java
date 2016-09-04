package us.richlandbombers.testcurver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This handles a specific line for the sliders, so we can cram more content
 * without having boxes all over the place.
 * 
 * @author Brian Schnepp
 */
@SuppressWarnings("serial")
public class SliderLine extends JPanel
{
    private JSlider slider;
    private JLabel name;
    private JTextField val;

    public SliderLine()
    {
	this("Unnamed Slider");
    }

    public SliderLine(String title)
    {
	this(title, 0, 100);
    }

    public SliderLine(String title, int min, int max)
    {
	this(title, min, max, 80);
    }

    public SliderLine(String title, int min, int max, int def)
    {
	super();
	//this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	slider = new JSlider(min, max, def);
	name = new JLabel(title);
	val = new JTextField(def + "", 5);

	slider.addChangeListener(new ChangeListener()
	{
	    @Override
	    public void stateChanged(ChangeEvent e)
	    {
		val.setText(slider.getValue() + "");
	    }
	});

	val.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		slider.setValue(Integer.parseInt(val.getText()));
	    }
	});

	this.add(name);
	this.add(slider);
	this.add(val);
    }
}
