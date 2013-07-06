package com.gibbon.countdown.framework;

/**
 * Třídy implementující IRactable jsou schopné reagovat na události
 * definované v ReactEvent.
 *
 * @author Tetroids
 */
public interface IListener
{
    /***************************************************************************
     * Vyvolá reakci na různé typy ReactEventů u tříd implemetujících
     * toto rozhraní.
     *
     * @param reactevent daná událost, na kteoru je třeba reagovat
     *
     */
    public abstract void notice();
}
