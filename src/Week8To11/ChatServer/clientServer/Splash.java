package Week8To11.ChatServer.clientServer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Splash extends JFrame {

    private JPanel contentPane;
    private static JLabel lblNewLabel;
    private static JProgressBar progressBar;


    public static void main(String[] args) {
        int x;
        Splash frame = new Splash();
        frame.setVisible(true);
        try {
            for(x = 0; x<=100;x++) {
                Splash.progressBar.setValue(x);
                Thread.sleep(60);
                Splash.lblNewLabel.setText(Integer.toString(x)+" %");
                if(x==100) {
                    frame.dispose();
                }

            }

        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    public Splash() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("");
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/loading.gif"));
        label.setIcon(icon);
        label.setBounds(74,12,500,398);
        contentPane.add(label);

        progressBar = new JProgressBar();
        progressBar.setForeground(new Color(0,128,128));
        progressBar.setBounds(80, 449, 494, 32);
        contentPane.add(progressBar);

        lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(304, 422, 70, 15);
        contentPane.add(lblNewLabel);
    }
}