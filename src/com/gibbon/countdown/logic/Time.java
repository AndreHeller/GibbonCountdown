/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.logic;

import com.gibbon.countdown.Countdown;
import com.gibbon.countdown.framework.IBroadcaster;
import com.gibbon.countdown.framework.IListener;
import com.gibbon.countdown.framework.IReactable;
import java.util.Collection;
import java.util.HashSet;
import javax.swing.JOptionPane;





/*******************************************************************************
 * Instance třídy {@code Time} představují jednotlivé odpočítávané časy.
 * Každá intance je schopna reagovat na inicializaci, pozastavení a zrušení.
 * Rovněž umí vrátit svoje aktuální hodnoty, ošetřené pro jednociferná čísla.
 *
 * @author  André HELLER
 * @version 1.00 — 03/2014
 */
public class Time implements IReactable
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Identifikátory jednotlivých časů */
    private static final Collection<Integer> IDS = new HashSet<Integer>();

//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Odkaz na timer, který zajištuje časové úpravy */
    private final MainTimer TIMER;

    /** Odkaz na Countdown */
    private final Broadcaster BROADCASTER = new Broadcaster();

//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    /** Stav času - Běžící nebo pozastavený */
    private boolean alive = false;

    /** Stav času - Běžící nebo pozastavený */
    private boolean started = false;

    /** Hodnota minut */
    private int minute;

    /** Hodnota vteřin */
    private int second;

    /** Hodnota setin */
    private int hundreth;

    /** ID času */
    private int id;

//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Konstruktor vytvoří základní čas dle nastavených parametrů.
     * Společně s tím připraví Timer s nastavenou periodou na setinu vteřiny
     *
     * @param minutes Počáteční počet minut
     * @param seconds počáteční počet sekund
     */
    public Time(int minutes, int seconds)
    {
        this.minute = minutes;
        this.second = seconds;
        // Setiny jsou vždy na nule, aby se na začátku ukazoval pěkně uhlazený
        // čas. O doplnění druhé nuly se stará metota {@link getTime()}
        this.hundreth = 0;

        this.id = IDS.size();
        IDS.add(id);

        // Deklaruje timer se setinovou periodou.
        TIMER = new MainTimer(this, 10);
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí aktuální čas ve formátu 00:00:00.
     *
     * @return aktuální hodnota času
     */
    public String getTime(){
        StringBuilder sb = new StringBuilder();

        if(minute <= 9){
            sb.append(0);
        }

        sb.append(minute).append(":");

        if(second <= 9){
            sb.append(0);
        }

        sb.append(second).append(":");

        if(hundreth <= 9){
            sb.append(0);
        }

        sb.append(hundreth);

        return sb.toString();
    }


    /***************************************************************************
     * Vrátí ID.
     *
     * @return ID
     */
    public int getId(){
        return id;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Inicializuje timer a nastaví čas jako běžící.
     */
    public void start(){
        System.out.println("Timer " + getId() + ": Started");
        TIMER.start();
        alive = true;
        started = true;
    }


    /***************************************************************************
     * Pozastaví nebo rozběhne timer podle jeho aktuálního stavu. Rovněž upravý
     * i živost času.
     */
    public void pausePlay(){
        if(alive){
            System.out.println("Timer " + getId() + ": Paused");
            TIMER.pause();
        }
        else{
            System.out.println("Timer " + getId() + ": Played");
            TIMER.play(this);
        }
        alive = !alive;
    }


    /***************************************************************************
     * Zruší a vypne timer. Tím skončí i vlákno. Tuto metodu je nutné volat vždy
     * na konci práce s tímto časem. Jinak může dojít k deadlocku.
     * Nastavý čas jako neběžící. Po této metodě už byste se neměli snažit
     * timer rozeběhnout.
     */
    public void cancel(){
        System.out.println("Timer " + getId() + ": Canceled");
        TIMER.cancelThis();
        IDS.remove(id);
        alive = false;
    }


    /***************************************************************************
     *
     * @return
     */
    public boolean hasBeenStarted()
    {
        return started;
    }

    /***************************************************************************
     * Předá zprávu všem posluchačům.
     * Odečte setinu z času a upraví všechny hodnoty. Pokud je timer již doběhl,
     * tak ho zastaví a zruší.
     */
    @Override
    public void react()
    {
        noticeAll(this);

        if(hundreth != 0){
            hundreth--;
            return;
        }
        if(second != 0){
            second--;
            hundreth = 99;
            return;
        }
        if(minute != 0){
            minute--;
            second = 59;
            hundreth = 99;
            return;
        }

        cancel();
    }


    /***************************************************************************
     * Přidá posluchače do kolekce posluchačů
     *
     * @param listener posluchač, který se zajímá o časové události.
     */
    public void addListener(IListener listener)
    {
        BROADCASTER.addListener(listener);
    }


    /***************************************************************************
     * Upozorní všechny posluchače na změnu.
     *
     * @param time čas, který provedl změnu.
     */
    public void noticeAll(Time time)
    {
        BROADCASTER.noticeAll(time);
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
