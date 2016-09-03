package com.gmail.bschneppdev.jvassister.util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Access user's default Internet browser. Ripped from FreedomWriter/CurtainLib
 * build 1021, version 2. (Created by Brian Schnepp)
 * 
 * @author Brian Schnepp
 *
 */
public final class InternetBrowser
{
    private InternetBrowser()
    {
    }

    /**
     * Requests the user's default browser to visit a page.
     * 
     * @param String
     *            "url", where do we point their browser to?
     */
    public static void requestBrowse(String url)
    {
	if (Desktop.isDesktopSupported())
	{
	    try
	    {
		Desktop.getDesktop().browse(new URI(url));
	    }
	    catch (IOException | URISyntaxException e)
	    {
		e.printStackTrace();
	    }
	}
    }
}
