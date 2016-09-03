package com.gmail.bschneppdev.jvassister.guibasic;

import javax.swing.JOptionPane;

/**
 * Display information, used to quickly show a confirmation dialog. Ripped from
 * FreedomWriter/CurtainLib build 1021, version 2. (Created by Brian Schnepp)
 * 
 * @author Brian Schnepp
 *
 */
public final class DisplayMessage
{

    private DisplayMessage()
    {
    }

    /**
     * Displays a Confirm Dialog, with the text colored black.
     * 
     * @param String
     *            "message"
     * @return result from JOptionPane
     */
    public static int displayMessage(String[] message)
    {
	String atr = "";
	for (String n : message)
	{
	    atr += n + '\n';
	}
	return JOptionPane.showConfirmDialog(null, atr);
    }

    /**
     * Displays a Confirm Dialog, with the text colored white.
     * 
     * @param String
     *            "message"
     * @return result from JOptionPane
     */
    public static int displayMessageWhite(String[] message)
    {

	String atr = "";
	for (String n : message)
	{
	    atr += "<html><font color = \"ffffff\" + >" + n + "</font><html>" + '\n';
	}
	return JOptionPane.showConfirmDialog(null, atr);
    }
}
