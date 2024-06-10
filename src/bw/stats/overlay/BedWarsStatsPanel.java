package bw.stats.overlay;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BedWarsStatsPanel extends JFrame {
    private JPanel contentPane;
    public BedWarsStatsPanel(){
        setTitle("Bed Wars Stats");
        setBounds(100, 100, 570, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(46, 46, 46));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);




         JLabel lblName = new JLabel("Name");
        lblName.setForeground(new Color(168, 167, 167));
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblName.setBounds(10, 10, 50, 14);
        contentPane.add(lblName);

        JLabel lblStars = new JLabel("Stars");
        lblStars.setForeground(new Color(168, 167, 167));
        lblStars.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblStars.setBounds(70, 10, 50, 14);
        contentPane.add(lblStars);

        JLabel lblFinalKD = new JLabel("Final K/D");
        lblFinalKD.setForeground(new Color(168, 167, 167));
        lblFinalKD.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFinalKD.setBounds(130, 10, 50, 14);
        contentPane.add(lblFinalKD);

        JLabel lblbedKD = new JLabel("Bed Ratio");
        lblbedKD.setForeground(new Color(168, 167, 167));
        lblbedKD.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblbedKD.setBounds(190, 10, 50, 14);
        contentPane.add(lblbedKD);

        JLabel lblWinLoseRatio = new JLabel("Win/Lose Ratio");
        lblWinLoseRatio.setForeground(new Color(168, 167, 167));
        lblWinLoseRatio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblWinLoseRatio.setBounds(250, 10, 70, 14);
        contentPane.add(lblWinLoseRatio);

        JLabel lblWinstreak = new JLabel("Winstreak");
        lblWinstreak.setForeground(new Color(168, 167, 167));
        lblWinstreak.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblWinstreak.setBounds(320, 10, 70, 14);
        contentPane.add(lblWinstreak);
    }
    

}
