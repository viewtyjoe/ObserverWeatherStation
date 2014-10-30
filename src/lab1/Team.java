/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.*;
/**
 *
 * @author viewt_000
 */
public class Team {
    private String teamColor;
    private List<ColorListener> listeners;
    
    public Team()
    {
        listeners = new ArrayList<>();
    }
    
    public void setTeamColor(String teamColor)
    {
        this.teamColor = teamColor;
        updateListeners();
    }
    
    public String getTeamColor()
    {
        return teamColor;
    }
    
    public void addColorListener(ColorListener listener)
    {
        listeners.add(listener);
    }
    
    private void updateListeners()
    {
        listeners.stream().forEach((l) ->
        {
            l.notifyColorChange(teamColor);
        });
    }
}
