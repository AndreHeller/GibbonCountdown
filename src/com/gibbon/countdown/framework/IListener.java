/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.framework;



/*******************************************************************************
 * Instance rozhraní {@code Ilistener2} jsou schopné se přihlásit jako
 * posluchači ke třídám implementující rozhraní {@link IBroadcaster}
 *
 * @author  André HELLER
 * @version 1.00 — 07/2013
 */
public interface IListener
{
//== CONSTATS ==================================================================
//== DECLARED GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Informuje o udání očekávané akce
     * @param informant
     */
    public abstract void notice(IReactable informant);

//== INHERITED GETTERS AND SETTERS =============================================
//== REMAINING DECLARED METHODS ================================================
//== REMAINING INHERITED METHODS ===============================================
//== EMBEDDED DATA TYPES =======================================================

    /*******************************************************************************
    * Instances of enumerated type {@code Events} represents ...
    *
    * @author  André HELLER
    * @version 0.00 — mm/20yy
    */
   public enum Events
   {
   //== VALUES OF THE ENUMERATION TYPE ============================================

       /** Událost odesílá zprávu pro GUI*/
       GUI;

   //== CONSTANT CLASS ATTRIBUTES =================================================
   //== VARIABLE CLASS ATTRIBUTES =================================================
   //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
   //== CONSTANT INSTANCE ATTRIBUTES ==============================================
   //== VARIABLE INSTANCE ATTRIBUTES ==============================================
   //== CLASS GETTERS AND SETTERS =================================================
   //== OTHER NON-PRIVATE CLASS METHODS ===========================================

   //##############################################################################
   //== CONSTUCTORS AND FACTORY METHODS ===========================================

       /***************************************************************************
        *
        */
       private Events()
       {
       }



   //== ABSTRACT METHODS ==========================================================
   //== INSTANCE GETTERS AND SETTERS ==============================================
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
   //    }
   //    /** @param args Command line arguments - not used. */
   //    public static void main(String[] args)  {  test();  }
   }
}
