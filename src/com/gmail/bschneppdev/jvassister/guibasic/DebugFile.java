package com.gmail.bschneppdev.jvassister.guibasic;

import java.util.Date;

import javax.swing.JOptionPane;

/**
 * Debug information, use this to log things down that don't need to go to output until an error happens.
 * Ripped from FreedomWriter/CurtainLib build 1021, version 2. (Created by Brian Schnepp)
 * @author Brian Schnepp
 *
 */
public final class DebugFile
{
    private DebugFile()
    {
    }

    private static String debugInfo;

    /**
     * Writes a new line to the debug file.
     * @param String "str"
     */
    public static void writeToDebug(String str)
    {
	debugInfo = debugInfo + '\n' + str;
    }
    
    /**
     * Writes a new line to the debug file, includes time as well.
     * @param String "str"
     */
    public static void writeToDebugTimestamp(String str)
    {
	long currentTime = System.currentTimeMillis();
	Date date = new Date(currentTime);
	String time = "[" + date + "] - ";
	DebugFile.writeToDebug(time + str);
    }
    
    /**
     * Reads debug messages as a message dialog box.
     */
    public static void readDebugMsg()
    {
	JOptionPane.showMessageDialog(null, debugInfo);
    }
    
    /**
     * Reads debug to standard output.
     */
    public static void readDebug()
    {
	System.out.println(debugInfo);
    }
    
    /**
     * Overwrites the debug message with a new String. Use this with caution!
     * @param String "str"
     */
    public static void overwriteDebug(String str)
    {
	debugInfo = str;
    }
    
    /**
     * Clears out the debug messages.
     */
    public static void clearDebug()
    {
	DebugFile.overwriteDebug("");
    }

}
