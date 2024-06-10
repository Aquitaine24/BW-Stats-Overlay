/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bw.stats.overlay;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatDarkLaf;

/**
 *
 * @author azmaa
 */
public class BWStatsOverlay{

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(() -> {
            try {
                BedWarsStatsPanel frame = new BedWarsStatsPanel();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        // List<String> players = GetPlayers.GetPlayers();

        // if(players !=null){
        //     for (String name : players) {
        //         GetPlayerData.GetPlayerData(name);
        //     }
        // }




        // System.out.println(players);
        // //GetPlayerData.GetPlayerData(players.get(2));
        // //GetPlayerData.GetPlayerData("WildPlaysGame");
    }

    
}
