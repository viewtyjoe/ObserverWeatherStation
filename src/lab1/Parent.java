/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author viewt_000
 */
public class Parent implements ColorListener {
    
    
    @Override
    public void notifyColorChange(String newColor)
    {
        System.out.println("Time to get some new " + newColor + " soutfits, then.");
    }
}
