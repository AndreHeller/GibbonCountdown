/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.logic;

import com.gibbon.countdown.framework.IBroadcaster;
import com.gibbon.countdown.framework.ICountdown;
import com.gibbon.countdown.framework.IListener;
import com.gibbon.countdown.framework.IReactable;
import java.util.ArrayList;
import java.util.Collection;
import com.gibbon.countdown.gui.Show;





/*******************************************************************************
 * Instances of class {@code Time} represent ...
 *
 * @author  André HELLER
 * @version 0.00 — mm/20yy
 */
public class Time implements IReactable
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    private static boolean alive = true;

//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    private final MainTimer timer;


//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    private ICountdown countdown;

    private Show show;

    private int minute;

    private int second;

    private int hundreth;

//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public Time(Show show, int minutes, int seconds)
    {
        this.show = show;
        this.minute = minutes;
        this.second = seconds;
        this.hundreth = 0;

        timer = new MainTimer(this, 9);
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public String getTime(){
        String hundString = ""+hundreth;
        if(hundreth <= 9){
            hundString = "0" + hundreth;
        }

        String secString = ""+second;
        if(second <= 9){
            secString = "0" + second;
        }

        String minString = ""+minute;
        if(minute <= 9){
            minString = "0" + minute;
        }


        String time;

        time = minString + ":" + secString + ":" + hundString;

        return time;
    }
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     *
     */
    public void initialize(){
        timer.initialize();
    }


    public void pause(){
        if(alive){
           timer.stop();
        }
        else{
            timer.play(this);
        }
        alive = !alive;
    }


    /***************************************************************************
     *
     */
    @Override
    public void react()
    {
        if(hundreth == 0){
            if(second == 0){
                if(minute == 0){
                    timer.stop();
                    return;
                }
                minute--;
                second=60;
            }
            second--;
            hundreth = 100;
        }
        hundreth--;
    }


//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /*************************************************************************
//     * Testing method.
//     */
//    public static void test()
//    {
//        Time inst = new Time();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
