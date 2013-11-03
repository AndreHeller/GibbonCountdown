/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown;



/*******************************************************************************
 * The class {@code Main} is the main class of the project
 * that ...
 *
 * @author  André HELLER
 * @version 1.00 — mm/2013
 */
public class Main
{
    /***************************************************************************
     * Method starting the application.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args)
    {
        Countdown.getInstance();
    }


    /** Private constructor preventing instance creation.*/
    private Main() {}
}
