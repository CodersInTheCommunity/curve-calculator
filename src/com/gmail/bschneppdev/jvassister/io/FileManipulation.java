package com.gmail.bschneppdev.jvassister.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Handles some basic file operations. Most contents originate from
 * FreedomWriter, also written by Brian Schnepp.
 * 
 * @author Brian Schnepp
 *
 */
public final class FileManipulation
{
    private FileManipulation()
    {
    }

    /**
     * Grabs the content of a file, and returns it as a string. (Ripped from
     * FreedomWriter build 1024)
     * 
     * @param File
     *            "file"
     * @return String with contents of the file
     * @throws FileNotFoundException
     */
    public static String fileToStringAscii(File file) throws FileNotFoundException
    {
	Scanner scanner = new Scanner(file);
	String str = "";
	while (scanner.hasNextLine())
	{
	    str += scanner.nextLine() + '\n';
	}
	scanner.close();
	return str;
    }

    /**
     * Gets the content of a string, and dumps it into a File object. (Ripped
     * from FreedomWriter build 1024)
     * 
     * If the file being saved to does not exist, this method will create it for
     * you.
     * 
     * @param File
     *            "file"
     * @param String
     *            "content"
     * @throws IOException
     */
    public static void saveStringToFileAscii(File file, String content) throws IOException
    {
	BufferedWriter writer = null;
	String[] splits = content.split(System.lineSeparator());

	if (!file.exists())
	{
	    file.createNewFile();
	}

	FileWriter inner = null;
	inner = new FileWriter(file.getAbsolutePath());
	writer = new BufferedWriter(inner);
	for (String n : splits)
	{
	    inner.write(n);
	    inner.append('\n');
	    writer.append('\n');
	    writer.newLine();
	}
	writer.flush();
	writer.close();
    }

}
