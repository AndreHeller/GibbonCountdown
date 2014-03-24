/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.logic;

import com.gibbon.countdown.Countdown;
import com.gibbon.countdown.framework.IListener;
import com.gibbon.countdown.framework.IReactable;
import com.gibbon.countdown.gui.TimerFrame;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.SwingUtilities;





/*******************************************************************************
 * Třída {@code TimeManager} je jedináček představující správce všech času.
 * Je zodpovědná, za správnou manipulaci s časem i za zobrazení grafického okna.
 *
 * @author  André HELLER
 * @version 1.00 — mm/2013
 */
public class TimeManager implements IListener
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Odkaz na jedináčka */
    private static final TimeManager SINGLETON = new TimeManager(Countdown.getInstance());

//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Odkaz na jedináčka */
    private final TimerFrame TIMER_FRAME = new TimerFrame();

    /** kolekce riderů pro timer */
    private final Map<String, Rider> TIMER_RIDERS = new HashMap();

//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    private Countdown COUNTDOWN;

    /** Čas prvního ridera */
    private Time riderTime1;

    /** Čas druhého ridera */
    private Time riderTime2;

//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Tovární metody vrací odkaz na jedináčka.
     *
     * @return odkaz na jedináčka
     */
    public static TimeManager getInstance()
    {
        return SINGLETON;
    }

    /***************************************************************************
     * Privátní konstruktor zabrˇnující vytvoření instance.
     */
    private TimeManager(Countdown cd)
    {
        this.COUNTDOWN = cd;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    public void setMonitorMode(String type)
    {
        TIMER_FRAME.setMonitorMode(type);
    }

    /***************************************************************************
     * Vytvoří časi pro ridery a zinicializuje timerové okno.
     *
     * @param minutes počet minut
     * @param seconds počet vteřin
     * @return false, pokud existuje nějaké běžící okno
     */
    public boolean createTimes(final int  minutes, final int seconds)
    {
        if(TIMER_FRAME.isVisible()){
            return false;
        }

        cancelTimes();

        riderTime1 = new Time(minutes, seconds);
        riderTime1.addListener(this);

        riderTime2 = new Time(minutes, seconds);
        riderTime2.addListener(this);

        final String time1 = riderTime1.getTime();
        final String time2 = riderTime2.getTime();

        final String[] signs = new String[TIMER_RIDERS.size()];
        int i = 0;
        for(String sign : TIMER_RIDERS.keySet()){
            signs[i] = sign;
            i++;
        }

        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                TIMER_FRAME.setTimerManager(TimeManager.this);
                TIMER_FRAME.initialize(signs[0], signs[1], time1, time2);
            }
        });

        return true;
    }


    /***************************************************************************
     * Zjistí, zda jsou v kolekci skutečně dva rideři, což je podmínka proto,
     * aby molh být spuštěn timer.
     *
     * @return false, když kolekce neobsahuje dva ridery.
     */
    public boolean isBattleFull()
    {
        if(TIMER_RIDERS.size() == 2){
            return true;
        }
        else {
            return false;
        }
    }


    /***************************************************************************
     * Přidá ridera do kolekce timeru
     *
     * @param rider
     * @return false, pokud je rider již přidán
     */
    public boolean addRiderToBattle(Rider rider)
    {
        for(String riderSign : TIMER_RIDERS.keySet()){
            if(riderSign.equals(rider.getSign())){
                return false;
            }
        }

        TIMER_RIDERS.put(rider.getSign(), rider);

        return true;
    }


    /***************************************************************************
     * Odebere ridera z kolekce timeru.
     *
     * @param sign podpis ridera
     */
    public void removeRiderFromBattle(String sign)
    {
        TIMER_RIDERS.remove(sign);
    }


    /***************************************************************************
     * Vrátí ridery jako pole. Respektive Stringové pole jejich
     * formátovéného podpisu.
     *
     * @return pole s podpisy riderů
     */
    public String[] ridersToArray()
    {
        Set<String> keys = TIMER_RIDERS.keySet();

        String[] ridersArray = new String[TIMER_RIDERS.size()];

        int i = 0;
        for(String key : keys){
            ridersArray[i] = TIMER_RIDERS.get(key).getSign();
            i++;
        }

        return ridersArray;
    }


    /***************************************************************************
     *
     * @param reacter
     */
    @Override
    public void notice(IReactable reacter)
    {
        timeChange((Time)reacter);
    }


    /***************************************************************************
     * Odstartuje odpočítávání. Metoda pro využití UI bez KeyListeneru.
     * @param type
     */
    public void startTime(String type)
    {
        switch (type) {
            case "first":
                if(riderTime1.hasBeenStarted()){
                    riderTime1.pausePlay();
                }
                else {
                    riderTime1.start();
                }
                break;
            case "second":
                if(riderTime2.hasBeenStarted()){
                    riderTime2.pausePlay();
                }
                else {
                    riderTime2.start();
                }
                break;
        }
    }


    /***************************************************************************
     * Ukončí všechny timery.
     */
    public void cancelTimes()
    {
        if(riderTime1 != null || riderTime2 != null){
            riderTime1.cancel();
            riderTime2.cancel();
        }
    }

//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    /***************************************************************************
     * Metoda přenastaví čas jednoho z časů.
     *
     * @param time čas, který se má přenastavit.
     */
    private void timeChange(Time time)
    {
        final String riderTime = time.getTime();
        final int riderId = time.getId();

        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                TIMER_FRAME.changeTime(riderId, riderTime);
            }
        });
    }

//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /*************************************************************************
//     * Testing method.
//     */
//    public static void test()
//    {
//        TimeManager inst = new TimeManager();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
