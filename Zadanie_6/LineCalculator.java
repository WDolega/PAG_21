/*
    authors: Wojciech Dołęga, Adam Ziętek
 */

package com.lineCalculator;

public class LineCalculator {
    private String catalogName;
    private String[] extentions;

    public LineCalculator(String[] arguments) {
        this.catalogName = arguments[0];
        String[] extentions = new String[arguments.length-1];
        for (int a = 1; a < arguments.length; ++a) {
            if (!arguments[a].equals(""))
                extentions[a-1] = arguments[a];
            else
                ;//System.out.println("Add extentions!");
        }
        this.extentions = extentions;
    }

    //getters
    public String getCatalogName() { return catalogName; }
    public String[] getExtentions() { return extentions; }

    //setters
    public void setCatalogName(String name) { catalogName = name; }
    public void setExtentions(String[] ext) { extentions = ext; }
    public void setExtentions(String ext) {
        String[] newExtentions = new String[extentions.length+1];
        for (int e = 0; e < extentions.length; ++e){
            newExtentions[e] = extentions[e];
        }
        newExtentions[extentions.length] = ext;
        extentions = newExtentions;
    }
}
