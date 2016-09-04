package us.richlandbombers.testcurver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class BooleanBox extends JPanel
{
    private JCheckBox box;
    private JLabel name;
    private JTextField val;

    public BooleanBox()
    {
	this("Unnamed Value");
    }

    public BooleanBox(String title)
    {
	this(title, 0, 100);
    }

    public BooleanBox(String title, int min, int max)
    {
	this(title, min, max, false);
    }

    public BooleanBox(String title, int min, int max, boolean def)
    {
	super();
	//this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	box = new JCheckBox();
	name = new JLabel(title);
	val = new JTextField(def + "", 5);

	box.addChangeListener(new ChangeListener()
	{
	    @Override
	    public void stateChanged(ChangeEvent e)
	    {
		val.setText(box.isSelected() + "");
	    }
	});

	val.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		box.setSelected(Boolean.parseBoolean(val.getText()));
	    }
	});

	this.add(name);
	this.add(box);
	this.add(val);
    }
}
