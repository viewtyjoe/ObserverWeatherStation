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
public class Startup {
    public static void main(String[] args) {
        Team team = new Team();
        team.addColorListener(new Parent());
        team.setTeamColor("blue");
        team.addColorListener(new School());
        team.setTeamColor("green");
        
    }
}
