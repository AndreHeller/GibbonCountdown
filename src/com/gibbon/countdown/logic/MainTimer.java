/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.logic;


import com.gibbon.countdown.framework.IReactable;
import java.util.Timer;
import java.util.TimerTask;



/*******************************************************************************
 * Intance třídy {@code SuperTimer} představují timer pro každý z časů.
 *
 * @author  André HELLER
 * @version 4.00 — 03/2014
 */
public class MainTimer extends Timer
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Časový dotaz schopný reagovat na timer */
    private MyTask task;

//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    /** Hodnota opakování */
    private int period;

    /** Nastavitelné zpoždění */
    private int delay;

//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Konstruktor bez parametru delay. Bez zpoždění.
     *
     * @param reacter objekt, který se ma upozotnit na odbytí nastaveného času
     *                (periody).
     * @param period časová perioda, kdy se upozorní objekt
     */
    public MainTimer(IReactable reacter, int period)
    {
        this(reacter, period, 0);
    }

    /***************************************************************************
     * Konstruktor s nastavitelným zpožděním --> delay. Vytvorí instanci dotazu,
     * které předá objekt pro zavolání metody
     *
     * @param reacter objekt, který se ma upozotnit na odbytí nastaveného času
     *                (periody).
     * @param period časová perioda, kdy se upozorní objekt
     * @param delay zpoždení, před prvním spuštěním timeru
     */
    public MainTimer(IReactable reacter, int period, int delay)
    {
        super();

        this.task = new MyTask(reacter);
        this.period = period;
        this.delay = delay;
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================


    /***************************************************************************
     * Inicializace. Spustí timer.
     */
    public void start() {
        this.schedule(task, delay, period);
    }

    /***************************************************************************
     * Pozastaví timer. Zruší přidělěný dotaz.
     */
    public void pause() {
        task.cancel();
        this.purge();
    }

    /***************************************************************************
     * Úplně zastaví timer.
     */
    public void cancelThis(){
        task.cancel();
        this.cancel();
    }

    /***************************************************************************
     * Znovuspuštění timeru. Vytvoří novou instanci dotazu a opět spustí timer.
     *
     * @param reacter objekt, který se ma upozotnit na odbytí nastaveného času
     *                (periody).
     */
    public void play(IReactable reacter){
        task = new MyTask(reacter);
        this.schedule(task, delay, period);
    }


//== EMBEDDED TYPES AND INNER CLASSES ==========================================

    /***************************************************************************
     * Instace trídy {@code MyTask} představují dotazy reagující na odbytí
     * periody timeru.
     */
    private class MyTask extends TimerTask {

        private IReactable reacter;

        private MyTask(IReactable reacter)
        {
            this.reacter = reacter;
        }

        /***********************************************************************
         * Zavolá reakcní metodu objektu.
         */
        @Override
        public void run() {
            reacter.react();
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
