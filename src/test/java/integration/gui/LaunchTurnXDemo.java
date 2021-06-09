package integration.gui;



import javax.swing.SwingUtilities;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

public class LaunchTurnXDemo extends JFrame {

    private final static LaunchTurnXDemo launchTurnXDemo = new LaunchTurnXDemo();
    public LaunchTurnXDemo() {
        this.initComponent();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            System.setProperty("awt.useSystemAAFontSettings", "lcd"); // use font antialiasing
            System.setProperty("swing.aatext", "true");
            launchTurnXDemo.setVisible(true);
        });
    }

    private void initComponent() {
        this.setTitle("LaunchTurnXDemo");
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.WHITE);
        pack();
    }
}
