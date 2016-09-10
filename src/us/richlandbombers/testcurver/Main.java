package us.richlandbombers.testcurver;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import us.richlandbombers.testcurver.data.Table;

//JVassister was statically linked so you didn't need to throw it into a build script to get this to compile.

/**
 * Handles the GUI frontend of stuff. BUGS: - Inputting only 1 student causes
 * Table to freak out and we end up with an exception.
 * 
 * @author Brian Schnepp
 *
 */
public class Main
{
    /**
     * Main JFrame, static so that it can be accessible from other classes
     * easilly.
     */
    private static JFrame window = new JFrame("Curver");
    /* Content of the main JFrame */
    private static JSplitPane splitpn = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    private static Sliders sliders = new Sliders();

    private static String[] sIDs; // ahhh rush!
    private static int[] sPts;
    private static int[] mPts;

    public static void main(String[] args)
    {

	for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
	{
	    if ("Nimbus".equals(info.getName()))
	    {
		try
		{
		    UIManager.setLookAndFeel(info.getClassName());
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException
		        | UnsupportedLookAndFeelException exception)
		{
		    exception.printStackTrace();
		}
		break;
	    }
	}

	Main.window.getContentPane().add(Main.splitpn, BorderLayout.CENTER);
	Main.splitpn.add(Main.sliders, JSplitPane.RIGHT);
	DataInput input = new DataInput();
	checkOK(input);
	sIDs = input.getStudentIDs();
	sPts = input.getScoredPoints();
	mPts = input.getMaxPoints();
	Table tbl = new Table(sIDs, sPts, mPts);

	sliders.getCurve().addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		JFrame scoresheet = new JFrame("Curved Scores");
		scoresheet.setLayout(new BorderLayout());
		scoresheet.add(new JScrollPane(new Table(sIDs,
	                CurveUtility.generateCol(
	                        CurveUtility.calculate(sPts, mPts, sliders.getTarget(), sliders.getSubtract()), sPts),
	                mPts)), BorderLayout.CENTER);
		JMenuBar jmb = new JMenuBar();
		JMenu jm = new JMenu("Save");
		jmb.add(jm);
		scoresheet.add(jmb, BorderLayout.NORTH);
		scoresheet.pack();
		scoresheet.setVisible(true);
	    }
	});

	Main.splitpn.add(tbl, JSplitPane.LEFT);
	Main.window.pack();
	Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Main.window.setVisible(true);
    }

    public static void checkOK(DataInput input)
    {
	if (input.isOkToContinue())
	{
	    return;
	}
	else
	{
	    try
	    {
		Thread.sleep(80);
	    }
	    catch (InterruptedException exception)
	    {
		exception.printStackTrace();
	    }
	    checkOK(input);
	}
    }

    /**
     * Gets the main window from this class.
     * 
     * @return Main window
     */
    public static JFrame getWindow()
    {
	return window;
    }

    /**
     * Gets the split pane from this class.
     * 
     * @return Split pane
     */
    public static JSplitPane getSplitPane()
    {
	return splitpn;
    }

    /**
     * Gets the sliders instance of the program.
     * 
     * @return Sliders
     */
    public static Sliders getSliders()
    {
	return sliders;
    }

    public static void setStudentIDs(String[] v)
    {
	Main.sIDs = v;
    }

    public static void setScoredPoints(int[] v)
    {
	Main.sPts = v;
    }

    public static void setMaxPoints(int[] v)
    {
	Main.mPts = v;
    }
}
