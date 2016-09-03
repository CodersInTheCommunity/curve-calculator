package com.gmail.bschneppdev.jvassister.graphics;

import java.awt.Color;

/**
 * Handles some basic things regarding colors.
 * 
 * @author Brian Schnepp
 * 
 */
public final class BasicColor
{

    private BasicColor()
    {
    }

    /**
     * Inverts the colors. (White becomes black)
     * 
     * @param Color
     *            "color"
     * @return inverted color value
     */
    public static Color invertColor(Color color)
    {
	// Normalizes the colors.
	double nRed = (double) color.getRed() / 255;
	double nBlue = (double) color.getBlue() / 255;
	double nGreen = (double) color.getGreen() / 255;

	// Inverts them. (This does not hue shift.)
	double invRed = 1 - nRed;
	double invBlue = 1 - nBlue;
	double invGreen = 1 - nGreen;

	// Returns the inverted color.
	return new Color((int) (invRed * 255), (int) (invBlue * 255), (int) (invGreen * 255));
    }

    /**
     * Inverts the hue of a color. (Blue becomes orange, doesn't change
     * brightness)
     * 
     * @param Color
     *            "color"
     * @return Hue inverted color
     */
    public static Color invertHue(Color color)
    {
	float[] hsvVal = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getRed(), null);
	float hue = hsvVal[0];
	float sat = hsvVal[1];
	float bri = hsvVal[2];

	float invHue = 1 - hue;

	return new Color(Color.HSBtoRGB(invHue, sat, bri));
    }

    /**
     * Shifts the hue of a color. (Blue becomes orange, doesn't change
     * brightness)
     * 
     * @param Color
     *            "color"
     * @param double
     *            "amt" (How far. If you use out of 255, cast to float and
     *            divide by 255.)
     * @return Hue inverted color
     */
    public static Color shiftHue(Color color, float amt)
    {
	float[] hsvVal = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getRed(), null);
	float hue = hsvVal[0];
	float sat = hsvVal[1];
	float bri = hsvVal[2];

	float invHue = hue + amt;

	return new Color(Color.HSBtoRGB(invHue, sat, bri));
    }
}
