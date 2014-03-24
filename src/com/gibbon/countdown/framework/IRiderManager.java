/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.framework;



/*******************************************************************************
 * Instances of interface {@code IRiderManager} represent ...
 *
 * @author  André HELLER
 * @version 1.00 — mm/2013
 */
public interface IRiderManager
{
//== CONSTATS ==================================================================
//== DECLARED GETTERS AND SETTERS ==============================================
//== INHERITED GETTERS AND SETTERS =============================================
//== REMAINING DECLARED METHODS ================================================

    /***************************************************************************
     * Vytvoří nového ridera pokud ještě neexistuje.
     *
     * @param firstName křestní jméno
     * @param lastName příjmení
     * @param country oblast původu
     * @return false, pokud rider s tímto jménem už existuje
     */
    public boolean createRider(String firstName, String lastName, String country);


    /***************************************************************************
     * Odstraní ridera z kolekce.
     *
     * @param sign název ridera v naformátovaném stavu.
     * @return false, když rider neexistuje
     */
    public boolean deleteRider(String sign);


    /***************************************************************************
     * Vrátí ridery jako pole. Respektive Stringové pole jejich
     * formátovéného podpisu.
     *
     * @return pole s podpisy riderů
     */
    public String[] ridersToArray();

//== REMAINING INHERITED METHODS ===============================================
//== EMBEDDED DATA TYPES =======================================================
}
