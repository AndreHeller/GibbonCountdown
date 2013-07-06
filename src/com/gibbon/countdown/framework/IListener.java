/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.framework;

import java.util.ArrayList;
import java.util.Collection;





/*******************************************************************************
 * Instances of interface {@code IListener} represent ...
 *
 * @author  André HELLER
 * @version 0.00 — mm/20yy
 */
public interface IListener
{
//== CONSTATS ==================================================================

    public final Collection<IReactable> LISTENERES = new ArrayList<>();

//== DECLARED GETTERS AND SETTERS ==============================================

    public void addListener(IReactable reactant);

    public void removeListener (IReactable reactant);

    public void noticeAll();

//== INHERITED GETTERS AND SETTERS =============================================
//== REMAINING DECLARED METHODS ================================================
//== REMAINING INHERITED METHODS ===============================================
//== EMBEDDED DATA TYPES =======================================================
}
