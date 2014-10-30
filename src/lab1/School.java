/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import javax.swing.JOptionPane;

/**
 *
 * @author viewt_000
 */
public class School implements ColorListener {

    @Override
    public void notifyColorChange(String newColor) {
        JOptionPane.showMessageDialog(null, "Go " + newColor + " team!");
    }
    
}
