package com.gmail.bschneppdev.jvassister.basic;

import java.util.ArrayList;

/**
 * Handles conversion between ArrayLists and Arrays.
 * 
 * @author Brian Schnepp
 */
public class ArrayUtility
{

    private ArrayUtility()
    {
    }

    /**
     * Quickly converts an array of Objects to an ArrayList of Objects.
     * 
     * @param Object[]
     *            "array"
     * @return ArrayList of all values in array
     */
    public static ArrayList<Object> arrayToArrayList(Object[] array)
    {
	ArrayList<Object> returnedList = new ArrayList<Object>();
	for (Object n : array)
	{
	    returnedList.add(n);
	}
	return returnedList;
    }

    /**
     * Quickly convert an ArrayList of Objects to an array of Objects.
     * 
     * @param ArrayList
     *            "list"
     * @return Object[] array
     */
    public static Object[] arrayListToArray(ArrayList<Object> list)
    {
	Object[] array = new Object[list.size()];
	for (int i = 0; i < array.length; i++)
	{
	    array[i] = list.get(i);
	}
	return array;
    }
}
