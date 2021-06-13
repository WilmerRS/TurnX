package integration.gui;

import org.turnx.cmpts.ButtonX;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.*;

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
        this.setLayout(new FlowLayout());
        for( int i=0; i<9;i++) {
            ButtonX btn = new ButtonX();
            btn.setPreferredSize(new Dimension(160, 160));
            btn.setBorderColor(new Color(50, 50, 50));
            btn.setBorderX(40);
            btn.setBackgroundX(new Color(255, 99, 110));
            btn.setBorderRadiusX(50, 75, 50, 120);
            //btn.setBorderRadiusX(80);
            System.out.println(btn.getBackgroundX());
            this.add(btn);
        }
        pack();
    }

}
