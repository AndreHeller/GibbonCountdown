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
public interface IBroadcaster
{
//== CONSTATS ==================================================================
//== DECLARED GETTERS AND SETTERS ==============================================

    public void addListener(IListener informant);

    public void removeListener(IListener informant);

    public void removeAllListeners();

    public void noticeAll();

//== INHERITED GETTERS AND SETTERS =============================================
//== REMAINING DECLARED METHODS ================================================
//== REMAINING INHERITED METHODS ===============================================
//== EMBEDDED DATA TYPES =======================================================
}
