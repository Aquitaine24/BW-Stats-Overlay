/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bw.stats.overlay;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author azmaa
 */
public class BWStatsOverlay {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        List<String> players = GetPlayers.GetPlayers();

        if(players !=null){
            for (String name : players) {
                GetPlayerData.GetPlayerData(name);
            }
        }




        //System.out.println(players.get(2));
        //GetPlayerData.GetPlayerData(players.get(2));
        //GetPlayerData.GetPlayerData("WildPlaysGame");
    }
    
}
