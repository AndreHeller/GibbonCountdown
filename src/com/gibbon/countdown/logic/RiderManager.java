/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.logic;

import com.gibbon.countdown.framework.IRiderManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;





/*******************************************************************************
 * Třída {@code RiderManager} představuje jedináčka jakožto správce všech riderů.
 *
 * @author  André HELLER
 * @version 1.00 — 03/2014
 */
public class RiderManager implements IRiderManager
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Odkaz na jedináčka */
    private static final RiderManager SINGLETON = new RiderManager();

//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    private final Map<String, Rider> RIDERS = new HashMap();

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Tovární metoda vracející odkaz na jedináčka
     *
     * @return odkaz na jedináčka
     */
    public static RiderManager getInstance()
    {
        return  SINGLETON;
    }

    /***************************************************************************
     * Privátní kontruktor zabraňujívcí vytvoření instance
     */
    private RiderManager()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public Map<String, Rider> getAllRiders(){
        return RIDERS;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Vytvoří nového ridera pokud ještě neexistuje.
     *
     * @param firstName křestní jméno
     * @param lastName příjmení
     * @param country oblast původu
     * @return false, pokud rider s tímto jménem už existuje
     */
    @Override
    public boolean createRider(String firstName, String lastName, String country)
    {
        String sign = firstName + " " + lastName + " (" + country + ")";

        if(RIDERS.containsKey(sign)){
            return false;
        }

        Rider rider = new Rider(firstName, lastName, country);
        RIDERS.put(sign, rider);

        return true;
    }


    /***************************************************************************
     * Odstraní ridera z kolekce.
     *
     * @param sign název ridera v naformátovaném stavu.
     * @return false, když rider neexistuje,
     */
    @Override
    public boolean deleteRider(String sign){
        Rider rider = RIDERS.get(sign);

        if(rider == null){
            return false;
        }
        RIDERS.remove(rider.getSign());
        return true;
    }


    /***************************************************************************
     * Vrátí ridery jako pole. Respektive Stringové pole jejich
     * formátovéného podpisu.
     *
     * @return pole s podpisy riderů
     */
    @Override
    public String[] ridersToArray()
    {
        Set<String> keys = RIDERS.keySet();

        String[] ridersArray = new String[RIDERS.size()];

        int i = 0;
        for(String key : keys){
            ridersArray[i] = RIDERS.get(key).getSign();
            i++;
        }

        return ridersArray;
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
//        RiderManager inst = new RiderManager();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
