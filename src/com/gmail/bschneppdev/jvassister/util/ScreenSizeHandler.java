package com.gmail.bschneppdev.jvassister.util;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 * Get user's monitor's size. Ripped from FreedomWriter/CurtainLib build 1021,
 * version 2. (Created by Brian Schnepp)
 * 
 * @author Brian Schnepp
 *
 */
public final class ScreenSizeHandler
{
    private ScreenSizeHandler()
    {
    }

    private static int width;
    private static int length;

    /**
     * Width of the monitor at startup of the program.
     */
    public static final int intWidth = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
            .getDisplayMode().getWidth();
    /**
     * Height of the monitor at startup of the program.
     */
    public static final int intHeight = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
            .getDisplayMode().getHeight();

    /**
     * This method gets the default screen device's dimensions, and returns an
     * array with the sizes. Call this is you believe the user changed their
     * default monitor. (This ignores current monitor)
     * 
     * @return int[], where index 0 is width, and index 1 is length/height.
     */
    public static int[] setup()
    {
	int[] size = new int[2];
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int width = gd.getDisplayMode().getWidth();
	int length = gd.getDisplayMode().getHeight();
	size[0] = width;
	size[1] = length;
	return size;
    }

    /**
     * After setup() was performed, get what is called as width.
     * 
     * @return int width
     */
    public static int getWidth()
    {
	return width;
    }

    /**
     * After setup() was performed, get what it called as length/height.
     * 
     * @return
     */
    public static int getLength()
    {
	return length;
    }
}
