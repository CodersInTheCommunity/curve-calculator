package us.richlandbombers.testcurver.data;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
/**
 * Handles the tables. Extends JPanel, put this directly in your application.
 * 
 * @author Brian Schnepp
 *
 */
public class Table extends JPanel
{
    /**
     * Constructs a new Table, which handles 3 values and turns them into Object
     * arrays for a JTable.
     * 
     * @param studentIDs
     *            Student ID numbers
     * @param scoredPoints
     *            Scored points
     * @param maxPoints
     *            Maximum possible points
     */
    public Table(long[] studentIDs, int[] scoredPoints, int[] maxPoints)
    {
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	// We need to buffer the values into these because primitives aren't
	// objects in Java.
	Object[] bfrIDs = new Object[studentIDs.length];
	Object[] bfrSPs = new Object[scoredPoints.length];
	Object[] bfrMPs = new Object[maxPoints.length];

	for (int i = 0; i < studentIDs.length; i++)
	{
	    bfrIDs[i] = studentIDs[i];
	}
	for (int i = 0; i < studentIDs.length; i++)
	{
	    bfrSPs[i] = scoredPoints[i];
	}
	for (int i = 0; i < studentIDs.length; i++)
	{
	    bfrMPs[i] = maxPoints[i];
	}

	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	model.addColumn("Student ID", bfrIDs);
	model.addColumn("Scored Points", bfrSPs);
	model.addColumn("Possible Points", bfrMPs);
	this.add(new JScrollPane(table));
    }
}
