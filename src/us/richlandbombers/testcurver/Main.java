package us.richlandbombers.testcurver;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;


//JVassister was statically linked so you didn't need to throw it into a build script to get this to compile.
/**
 * Handles the GUI frontend of stuff.
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

    public static void main(String[] args)
    {
	Main prg = new Main();
	Main.window.getContentPane().add(Main.splitpn, BorderLayout.CENTER);
	Main.splitpn.add(Main.sliders, JSplitPane.RIGHT);
	Main.window.pack();
	Main.window.setVisible(true);
    }
    
    /**
     * Gets the main window from this class.
     * @return Main window
     */
    public static JFrame getWindow()
    {
	return window;
    }

    /**
     * Gets the split pane from this class.
     * @return Split pane
     */
    public static JSplitPane getSplitPane()
    {
	return splitpn;
    }

    /**
     * Gets the sliders instance of the program.
     * @return Sliders
     */
    public static Sliders getSliders()
    {
	return sliders;
    }
}
