import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Sketch extends JPanel {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    public static final int CX = WIDTH / 2;
    public static final int CY = HEIGHT / 2;
    public static final int R1 = (int)(0.9 * CX);
    public static final int R2 = (int)(0.7 * CX);

    void drawClock(Graphics2D g) {
        Calendar cal = Calendar.getInstance();
        int s = cal.get(Calendar.SECOND);
        int m = cal.get(Calendar.MINUTE);
        int h = cal.get(Calendar.HOUR);
        double ss = 2 * Math.PI * s / 60.0;
        double mm = 2 * Math.PI * m / 60.0;
        double hh = 2 * Math.PI * h / 12.0;

        g.drawOval(5, 5, WIDTH - 10, HEIGHT - 10);
        g.setColor(Color.RED);
        g.drawLine(CX, CY,
                CX + (int)(R1 * Math.sin(ss)), CY - (int)(R1 * Math.cos(ss)));
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2));
        g.drawLine(CX, CY,
                CX + (int)(R1 * Math.sin(mm)), CY - (int)(R1 * Math.cos(mm)));
        g.setStroke(new BasicStroke(3));
        g.drawLine(CX, CY,
                CX + (int)(R2 * Math.sin(hh)), CY - (int)(R2 * Math.cos(hh)));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawClock((Graphics2D)g);
    }

    public static void start() {
        SwingUtilities.invokeLater(() -> {
            Date now = new Date();
            String date = new SimpleDateFormat("MM/dd/YYYY").format(now);
            JFrame app = new JFrame(date);
            app.setSize(WIDTH, HEIGHT + 35);
            app.add(new Sketch(), BorderLayout.CENTER);
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setLocationRelativeTo(null);
            app.setVisible(true);
            new Timer(500, event -> app.repaint()).start();
        });
    }
}
