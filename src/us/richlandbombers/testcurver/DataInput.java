package us.richlandbombers.testcurver;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.gmail.bschneppdev.jvassister.guibasic.DisplayMessage;

@SuppressWarnings("serial")
public class DataInput extends JFrame
{
    private ArrayList<String> stIDs = new ArrayList<String>();
    private ArrayList<Integer> scPts = new ArrayList<Integer>();
    private ArrayList<Integer> mxPts = new ArrayList<Integer>();

    private LabeledTextField sID = new LabeledTextField("Name or Student ID");
    private LabeledTextField sPt = new LabeledTextField("Scored Points");
    private LabeledTextField mPt = new LabeledTextField("Maximum Points");

    private JPanel pnl;

    private boolean okToContinue = false;

    public DataInput()
    {
	super("Enter input data");
	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	pnl = new JPanel();
	pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
	pnl.add(sID);
	pnl.add(sPt);
	pnl.add(mPt);

	JPanel mnpnl = new JPanel(new BorderLayout());
	mnpnl.add(pnl, BorderLayout.CENTER);

	JPanel buttons = new JPanel();
	buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
	JButton next = new JButton("Next Student");
	JButton done = new JButton("Finished");
	JButton easyMode = new JButton("Easy Mode");

	next.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		int ok = DisplayMessage.displayMessage(new String[]
		{
	                "Are these values correct?"
		});
		if (ok == JOptionPane.YES_OPTION)
		{
		    if (!sID.getField().getText().equalsIgnoreCase("") || !sPt.getField().getText().equalsIgnoreCase("")
	                    || !mPt.getField().getText().equalsIgnoreCase(""))
		    {
			stIDs.add(sID.getField().getText());
			scPts.add(Integer.parseInt(sPt.getField().getText()));
			mxPts.add(Integer.parseInt(mPt.getField().getText()));
			mPt.getField().setText("");
			sPt.getField().setText("");
			sID.getField().setText("");
		    }
		}
	    }
	});

	easyMode.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		int ok = DisplayMessage.displayMessage(new String[]
		{
	                "Are you sure? Any previously inputted information will be lost."
		});
		if (ok == JOptionPane.YES_OPTION)
		{
		    DataInput.this.setVisible(false);
		    DataInput.this.remove(pnl);
		    JPanel newPanel = new JPanel();
		    newPanel.add(Box.createHorizontalGlue());
		    newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.X_AXIS));

		    JButton confirm = new JButton("Confirm");
		    confirm.addActionListener(new ActionListener()
	            {
			@Override
			public void actionPerformed(ActionEvent e)
			{
			    // TODO Auto-generated method stub
			}

	            });
		    newPanel.add(confirm);
		    newPanel.add(Box.createHorizontalGlue());
		    DataInput.this.add(newPanel);
		    DataInput.this.setVisible(true);
		}
	    }
	});

	done.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		int ok = DisplayMessage.displayMessage(new String[]
		{
	                "Is this the last student?"
		});
		if (ok == JOptionPane.YES_OPTION)
		{
		    if (!sID.getField().getText().equalsIgnoreCase("") || !sPt.getField().getText().equalsIgnoreCase("")
	                    || !mPt.getField().getText().equalsIgnoreCase(""))
		    {
			stIDs.add(sID.getField().getText().trim());
			scPts.add(Integer.parseInt(sPt.getField().getText().trim()));
			mxPts.add(Integer.parseInt(mPt.getField().getText().trim()));
			DataInput.this.dispose();
			okToContinue = true;
		    }
		}
	    }
	});

	buttons.add(Box.createHorizontalGlue());
	buttons.add(next);
	buttons.add(done);
	buttons.add(Box.createHorizontalGlue());
	mnpnl.add(buttons, BorderLayout.SOUTH);

	this.add(mnpnl);
	this.pack();
	this.setVisible(true);
    }

    public String[] getStudentIDs()
    {
	String[] ids = new String[stIDs.size()];
	for (int i = 0; i < ids.length; i++)
	{
	    ids[i] = stIDs.get(i);
	}
	return ids;
    }

    public int[] getScoredPoints()
    {
	int[] ids = new int[scPts.size()];
	for (int i = 0; i < ids.length; i++)
	{
	    ids[i] = scPts.get(i);
	}
	return ids;
    }

    public int[] getMaxPoints()
    {
	int[] ids = new int[mxPts.size()];
	for (int i = 0; i < ids.length; i++)
	{
	    ids[i] = mxPts.get(i);
	}
	return ids;
    }

    public boolean isOkToContinue()
    {
	return okToContinue;
    }
}
