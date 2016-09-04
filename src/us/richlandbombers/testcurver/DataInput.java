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
    private ArrayList<Long> stIDs = new ArrayList<Long>();
    private ArrayList<Integer> scPts = new ArrayList<Integer>();
    private ArrayList<Integer> mxPts = new ArrayList<Integer>();

    private LabeledTextField sID = new LabeledTextField("Student ID");
    private LabeledTextField sPt = new LabeledTextField("Scored Points");
    private LabeledTextField mPt = new LabeledTextField("Maximum Points");

    private boolean okToContinue = false;

    public DataInput()
    {
	super("Enter input data");
	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	JPanel pnl = new JPanel();
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
		    stIDs.add(Long.parseLong(sID.getField().getText()));
		    scPts.add(Integer.parseInt(sPt.getField().getText()));
		    mxPts.add(Integer.parseInt(mPt.getField().getText()));
		    mPt.getField().setText("");
		    sPt.getField().setText("");
		    sID.getField().setText("");
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
		    stIDs.add(Long.parseLong(sID.getField().getText()));
		    scPts.add(Integer.parseInt(sPt.getField().getText()));
		    mxPts.add(Integer.parseInt(mPt.getField().getText()));
		    DataInput.this.dispose();
		    okToContinue = true;
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

    public long[] getStudentIDs()
    {
	long[] ids = new long[stIDs.size()];
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
