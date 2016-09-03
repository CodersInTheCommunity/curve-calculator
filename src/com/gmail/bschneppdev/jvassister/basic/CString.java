package com.gmail.bschneppdev.jvassister.basic;

/**
 * Highly compatible utility module for treating Java Strings more like C-Style
 * Strings.
 * 
 * @author Brian Schnepp
 */
public final class CString
{
    /**
     * Concatenate two strings together.
     * 
     * @param String
     *            "dest"
     * @param String
     *            "src"
     * @return new concatenated String
     */
    public static String strcat(String dest, String src)
    {
	return (dest += src).toString();
    }

    /**
     * Concatenate two strings together, up to n length.
     * 
     * @param String
     *            "dest"
     * @param String
     *            "src"
     * @param int
     *            "n"
     * @return new concatenated String
     */
    public static String strncat(String dest, String src, int n)
    {
	for (int i = 0; i < n; i++)
	{
	    dest += src.charAt(i);
	}
	return dest;
    }

    /**
     * Returns substring of src, starting where find is found.
     * 
     * @param String
     *            "src"
     * @param String
     *            "find"
     * @return Substring of found string, null if not found.
     */
    public static String strstr(String src, String find)
    {
	int ind = src.indexOf(find);
	if (ind > 0)
	{
	    return src.substring(ind);
	}
	return null;
    }

    /**
     * Calls String's string.length() method on a string, and returns it.
     * 
     * @param String
     *            "string"
     * @return integer with string length.
     */
    public static int strlen(String string)
    {
	return string.length();
    }

    /**
     * Compares the two strings, returns a value based on the first character
     * that they do not share.
     * 
     * @param String
     *            "string1"
     * @param String
     *            "string2"
     * @return 0 if identical, 1 is string1's character is greater, -1 is
     *         string2's character is greater at the first occurrence of
     *         differing.
     */
    public static int strcmp(String string1, String string2)
    {
	int commonLength = CharUtility.commonLength(string1, string2);
	for (int i = 0; i < commonLength; i++)
	{
	    if (string1.charAt(i) > string2.charAt(i))
	    {
		return 1;
	    }
	    else if (string1.charAt(i) < string2.charAt(i))
	    {
		return -1;
	    }
	}
	if (string1.length() > string2.length())
	{
	    return 1;
	}
	else if (string1.length() < string2.length())
	{
	    return -1;
	}
	return 0;
    }

    /**
     * Finds the first occurrence of the character c in string. If not found,
     * returns null;
     * 
     * @param String
     *            "string"
     * @param char
     *            "c"
     * @return String after character c is found.
     */
    public static String strchr(String string, char c)
    {
	return CString.strstr(string, Character.toString(c));
    }

    /**
     * Finds out how long string1 has characters not included in string2. Does
     * not work as strcpsn - no letter shifting occurs.
     * 
     * @param String
     *            "string1"
     * @param String
     *            "string2"
     * @return index at which string1 and string2 have the same character.
     */
    public static int strunilen(String string1, String string2)
    {
	int length = 0;
	String vals = CharUtility.diffStringPreserveSpacing(string1, string2);
	for (int i = 0; i < vals.length(); i++)
	{
	    if (vals.charAt(i) == '_')
	    {
		break;
	    }
	    ++length;
	}
	return length;
    }

    /**
     * Gets the content of string and places them in a new array, arr, then
     * returns it.
     * 
     * @param String
     *            "string"
     * @return char[] arr
     */
    public static char[] stringToCharArray(String string)
    {
	char[] arr = new char[string.length() + 1];
	for (int i = 0; i < string.length(); i++)
	{
	    arr[i] = string.charAt(i);
	}
	arr[string.length()] = '\0';
	return arr;
    }

    /**
     * Converts an array of characters into a string. The implementation of this
     * class cuts down on memory use slightly.
     * 
     * @param char[]
     *            "arr"
     * @return new String
     */
    public static String charArrayToString(char[] arr)
    {
	StringBuilder str = new StringBuilder(arr.length);
	for (char n : arr)
	{
	    if (n == '\0')
	    {
		break;
	    }
	    str.append(n);
	}
	return str.toString();
    }
}
