package com.gmail.bschneppdev.jvassister.basic;

/**
 * Utility for String manipulation based on individual characters.
 * 
 * @author Brian Schnepp
 */
public final class CharUtility
{
    /**
     * Cuts a String after a particular length. If 'length' is an invalid value,
     * returns original string.
     * 
     * @param String
     *            "string"
     * @param int
     *            "length"
     * @return String truncated after length.
     */
    public static String cutoffString(String string, int length)
    {
	if (string.length() <= length || length < 1)
	{
	    return string;
	}
	else
	{
	    return string.substring(0, length);
	}
    }

    /**
     * Returns which characters in string1 are not equal to characters in
     * string2 at the same position. Note that characters after the common
     * length of both of them in string2 are not noted.
     * 
     * @param String
     *            "string1"
     * @param String
     *            "string2"
     * @return Characters present in string1 not present in string2
     */
    public static String diffString(String string1, String string2)
    {
	String newStr = "";
	int lenMin = commonLength(string1, string2);
	for (int i = 0; i < lenMin; i++)
	{
	    if (string1.charAt(i) != string2.charAt(i))
	    {
		newStr += string1.charAt(i);
	    }
	}
	newStr += string1.substring(lenMin);
	return newStr;
    }

    /**
     * Returns which characters in string1 are not equal to characters in
     * string2, but where equal, replaced with an underscore. Note that
     * characters after the common length of both of them in string2 are not
     * noted.
     * 
     * @param String
     *            "string1"
     * @param String
     *            "string2"
     * @return Characters present in string1 not present in string2, with
     *         spacing preserved.
     */
    public static String diffStringPreserveSpacing(String string1, String string2)
    {
	String newStr = "";
	int lenMin = commonLength(string1, string2);
	for (int i = 0; i < lenMin; i++)
	{
	    if (string1.charAt(i) != string2.charAt(i))
	    {
		newStr += string1.charAt(i);
	    }
	    else
	    {
		newStr += "_";
	    }
	}
	newStr += string1.substring(lenMin);
	return newStr;
    }

    /**
     * Check which string is shorter - return the common length between them.
     * 
     * @param String
     *            "string1"
     * @param String
     *            "string2"
     * @return Shortest length between both strings
     */
    public static int commonLength(String string1, String string2)
    {
	if (string1.length() < string2.length())
	{
	    return string1.length();
	}
	return string2.length();
    }

    /**
     * Returns a copy of the string where all lowercase characters become
     * uppercase.
     * 
     * @param String
     *            "string", string to modify
     * @return New string with only uppercase characters.
     */
    public static String lowerToUpper(String string)
    {
	int length = string.length();
	String str = "";
	for (int i = 0; i < length; i++)
	{
	    if (!isUpperCase(string.charAt(i)))
	    {
		str += (char) (string.charAt(i) - 32);
	    }
	    else
	    {
		str += string.charAt(i);
	    }
	}
	return str;
    }

    /**
     * Returns a copy of the string where all uppercase characters become
     * lowercase.
     * 
     * @param String
     *            "string", string to modify.
     * @return New string with only lowercase characters.
     */
    public static String upperToLower(String string)
    {
	int length = string.length();
	String str = "";
	for (int i = 0; i < length; i++)
	{
	    if (isUpperCase(string.charAt(i)))
	    {
		str += (char) (string.charAt(i) | 0b00100000); // Force it to
		                                               // always be set
	    }
	    else
	    {
		str += string.charAt(i);
	    }
	}
	return str;
    }

    /**
     * Shifts the ASCII value of every letter in a string.
     * 
     * @param String
     *            "str", string to be copied and modified.
     * @param int
     *            "val", how much do we manipulate the characters?
     * @return Shifted string
     */
    public static String letterShift(String str, int val)
    {
	String string = "";
	for (int i = 0; i < str.length(); i++)
	{
	    char c = (char) (str.charAt(i) + val);
	    string += c;
	}
	return string;
    }

    /**
     * Shifts the ASCII value of every letter in a string, except special
     * characters.
     * 
     * @param String
     *            "str", string to be copied and modified.
     * @param int
     *            "val", how much do we manipulate the characters?
     * @return Shifted string
     */
    public static String letterShiftPreserveSpecial(String str, int val)
    {
	String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String string = "";
	for (int i = 0; i < str.length(); i++)
	{
	    char c = 0;
	    for (int k = 0; k < validChars.length(); k++)
	    {
		c = str.charAt(i);
		if (str.charAt(i) == validChars.charAt(k))
		{
		    c += val;
		    break;
		}
	    }
	    string += c;
	}
	return string;
    }

    /**
     * Shifts the ASCII value of every letter in a string. String str (the first
     * parameter) is the String to be shifted. The integer next to it will be
     * how much it will shift. The last string is for characters you wish to
     * preserve.
     * 
     * @param String
     *            "str", string to be copied and modified.
     * @param int
     *            "val", how much do we manipulate the characters?
     * @param preserve
     *            "preserve", characters which shouldn't be changed.
     * @return Shifted string
     */
    public static String letterShiftPreserveListed(String str, int val, String preseve)
    {
	String string = "";
	for (int i = 0; i < str.length(); i++)
	{
	    char c = 0;
	    for (int k = 0; k < preseve.length(); k++)
	    {
		c = str.charAt(i);
		if (str.charAt(i) == preseve.charAt(k))
		{
		    c += val;
		    break;
		}
	    }
	    string += c;
	}
	return string;
    }

    /**
     * Checks if a specific character is uppercase or not.
     * 
     * @param char
     *            "c"
     * @return true if uppercase, false otherwise.
     */
    public static boolean isUpperCase(char c)
    {
	if (c <= 'z' && c >= 'a')
	{
	    return false;
	}
	return true;
    }
}
