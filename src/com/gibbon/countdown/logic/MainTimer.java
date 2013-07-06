/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.logic;


import com.gibbon.countdown.framework.IListener;
import com.gibbon.countdown.framework.IReactable;
import java.util.Timer;
import java.util.TimerTask;



/*******************************************************************************
 * Intance třídy {@code SuperTimer} představují jednotlivé herní timery
 *
 * @author  André HELLER
 * @version 3.00 — 06/2013
 */
public class MainTimer extends Timer
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    private MyTask task;

//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    private int period;

    private int delay;

//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Konstruktor bez parametru delay. Bez zpoždění
     *
     * @param reactant
     * @param event
     * @param period
     */
    public MainTimer(IReactable reactant, int period)
    {
        this(reactant, period, 0);
    }

    /***************************************************************************
     * Konstruktor s nastavitelným zpožděním --> delay
     *
     * @param reactant reagující objekt
     * @param event herní událost
     * @param period časová perioda
     * @param delay zpoždení
     */
    public MainTimer(IReactable reactant, int period, int delay)
    {
        super();

        this.task = new MyTask(reactant);
        this.period = period;
        this.delay = delay;
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================


    /***************************************************************************
     *
     */
    public void initialize() {
        this.schedule(task, delay, period);
    }

    public void stop() {
        task.cancel();
        this.purge();
    }

    public void play(IReactable reactant){
        task = new MyTask(reactant);
        this.schedule(task, delay, period);
    }


//== EMBEDDED TYPES AND INNER CLASSES ==========================================

    private class MyTask extends TimerTask {

        private IReactable reactant;

        private MyTask(IReactable reactant)
        {
            this.reactant = reactant;
        }

        @Override
        public void run() {
            reactant.react();
        }
    }

//== TESTING CLASSES AND METHODS ===============================================
//
//    /*************************************************************************
//     * Testing method.
//     */
//    public static void test()
//    {
//        ArcTimer inst = new ArcTimer();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
