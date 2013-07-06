/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.logic;



/*******************************************************************************
 * Instances of class {@code Rider} represent ...
 *
 * @author  André HELLER
 * @version 0.00 — mm/20yy
 */
public class Rider
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    /** Jméno ridera */
    private String firstName;

    /** Příjmení ridera */
    private String lasName;

    /** Země ridera */
    private String country;


//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public Rider(String firstName, String lastName, String country)
    {
        this.firstName = firstName;
        this.lasName = lastName;
        this.country = country;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí podpis ridera ve formátu: Jméno Příjmení (Země)
     *
     * @return podpis ridera
     */
    public String getSign(){
        return firstName + " " + lasName + " (" + country + ")";
    }


    /***************************************************************************
     * Nastaví jmené ridera
     *
     * @param firstName jméno ridera
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }


    /***************************************************************************
     * Nastaví přijímení ridera
     *
     * @param lastName píjmení ridera
     */
    public void setLastName(String lastName){
        this.lasName = lastName;
    }


    /***************************************************************************
     * Nastaví zemi ridera
     *
     * @param country země ridera
     */
    public void setCountry(String country){
        this.country = country;
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
//        Rider inst = new Rider();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
