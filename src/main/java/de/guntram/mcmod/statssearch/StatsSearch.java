/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.guntram.mcmod.statssearch;

import net.minecraft.stat.StatHandler;

/**
 *
 * @author gbl
 */
public class StatsSearch {
    
    private static String searchString = "";
    public static StatHandler statHandler;

    public static void setSearchString(String s) { searchString = s.toLowerCase(); }
    public static String getSearchString() { return searchString; }
}
