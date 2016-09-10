package us.richlandbombers.testcurver;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LabeledTextField extends JPanel
{

    private JTextField field;
    private JLabel label;

    public LabeledTextField(String name)
    {
	this(name, 6);
    }
    
    public LabeledTextField(String name, int sz)
    {
	this.field = new JTextField(sz);
	this.label = new JLabel(name);
	this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	this.add(label);
	this.add(field);
    }

    public JTextField getField()
    {
	return field;
    }
}


