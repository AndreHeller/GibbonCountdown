/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown;

import com.gibbon.countdown.gui.MainFrame;
import com.gibbon.countdown.logic.KeyListener;
import com.gibbon.countdown.logic.Rider;
import com.gibbon.countdown.logic.RiderManager;
import com.gibbon.countdown.logic.TimeManager;
import java.awt.event.KeyEvent;
import java.util.Map;
import javax.swing.JOptionPane;

import javax.swing.SwingUtilities;





/*******************************************************************************
 * Třída {@code Countdown} představuje jedináčka jakožto prostředníka pro celou
 * aplikaci. Jednotlivé oddělěné části spolu komunikují právě díky této třídě.
 *
 * @author  André HELLER
 * @version 1.00 — 03/2014
 */
public final class Countdown
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Odkaz na jedináčka */
    private static final Countdown SINGLETON = new Countdown();

//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Odkaz na správce riderů */
    private final RiderManager RIDER_MANAGER = RiderManager.getInstance();

    /** Odkaz na správce časů */
    private final TimeManager TIME_MANAGER = TimeManager.getInstance();

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Tovární metoda vracející odkaz jedináčka aplikace.
     *
     * @return odkaz na jedináčka
     */
    public static Countdown getInstance()
    {
        return SINGLETON;
    }

    /***************************************************************************
     * Konstruktor
     */
    private Countdown(){
        SwingUtilities.invokeLater(new Runnable()
        {
            /*******************************************************************
             * Nechá EDT vytvořit grafické uživatelské rozhraní
             */
            @Override
            public void run()
            {
                MainFrame.getInstance();
            }
        });
    }

//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Nastaví typ monitoru Single nebo Multi
     *
     * @param type
     */
    public void setMonitorMode(String type)
    {
        TIME_MANAGER.setMonitorMode(type);
    }

    /***************************************************************************
     * Vytvoří časi pro ridery a zinicializuje timerové okno.
     *
     * @param minutes počet minut
     * @param seconds počet vteřin
     */
    public void createTimes(int minutes, int seconds)
    {
        TIME_MANAGER.createTimes(minutes, seconds);
    }


    /***************************************************************************
     * Zjistí, zda jsou v kolekci skutečně dva rideři, což je podmínka proto,
     * aby molh být spuštěn timer.
     *
     * @return false, když kolekce neobsahuje dva ridery.
     */
    public boolean isBattleFull()
    {
        return TIME_MANAGER.isBattleFull();
    }


    /***************************************************************************
     * Přidá ridera do kolekce timeru
     *
     * @param sign podpis ridera
     * @return false, pokud je rider již přidán
     */
    public boolean addRiderToBattle(String sign)
    {
        Rider rider = RIDER_MANAGER.getAllRiders().get(sign);

        return TIME_MANAGER.addRiderToBattle(rider);
    }


    /***************************************************************************
     * Odebere ridera z kolekce timeru
     *
     * @param sign podpis ridera
     */
    public void removeRiderFromBattle(String sign)
    {
        TIME_MANAGER.removeRiderFromBattle(sign);
    }


    /***************************************************************************
     * Zinicializujeokno timeru. Zviditelní a nastaví základní časy a jména.
     *
     * @param minutes minuty
     * @param seconds vteřiny
     * @return false, když je nějaký battle aktivní
     */
    public boolean startBattle(String minutes, String seconds)
    {
        int minutesInt = Integer.parseInt(minutes.trim());
        int secondsInt = Integer.parseInt(seconds.trim());

        return TIME_MANAGER.createTimes(minutesInt, secondsInt);
    }


    /***************************************************************************
     * Přetížený zápis metody. Jako podklad pro vytvoření ridera bere
     * jednotlívé hodnoty bez formátu.
     *
     * @param sign formátovaný zápis ridera ve tvaru "Jméno Příjmení (XX)"
     * XX značí oblast původu.
     * @return false, když rider už existuje.
     */
    public boolean createRider(String sign)
    {
        String[] values = sign.split(" ");
        return createRider(values[0], values[1], values[2].replace("(", "").replace(")", "").trim());
    }


    /***************************************************************************
     * Vytvoří nového ridera pokud ještě neexistuje.
     *
     * @param firstName křestní jméno
     * @param lastName příjmení
     * @param country oblast původu
     * @return false, pokud rider s tímto jménem už existuje
     */
    public boolean createRider(String firstName, String lastName, String country)
    {
        return RIDER_MANAGER.createRider(firstName, lastName, country);
    }

    /***************************************************************************
     * Přetížený zápis metody. Odstraní ridera z kolekce. Převeda paramety
     * na formátovaný tvar.
     *
     * @param firstName jméno
     * @param lastName příjmení
     * @param country země
     * @return false, když rider neexistuje
     */
    public boolean deleteRider(String firstName, String lastName, String country)
    {
        String sign = firstName + " " + lastName + " (" + country + ")";

        return deleteRider(sign);
    }

    /***************************************************************************
     * Odstraní ridera z kolekce.
     *
     * @param sign název ridera v naformátovaném stavu.
     * @return false, když rider neexistuje
     */
    public boolean deleteRider(String sign)
    {
        return RIDER_MANAGER.deleteRider(sign);
    }


    /***************************************************************************
     * Vrátí ridery jako pole. Respektive Stringové pole jejich
     * formátovéného podpisu.
     *
     * @param typeOfList typ seznamu, rider/timer
     * @return pole s podpisy riderů
     */
    public String[] ridersToArray(String typeOfList)
    {
        if(typeOfList.equals("timer")){
            return TIME_MANAGER.ridersToArray();
        }
        else {
            return RIDER_MANAGER.ridersToArray();
        }
    }


    /***************************************************************************
     * Vrátí kolekci riderů
     *
     * @return kolekce riderů
     */
    public Map<String, Rider> getAllRiders()
    {
        return RIDER_MANAGER.getAllRiders();
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
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
//        Countdown inst = new Countdown();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
