import javax.swing.*;
import java.awt.*;

public class CloudPanell extends JPanel {
    public CloudPanell() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(new Color(230, 190, 255)); // Pastel purple background
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw clouds
        drawCloud(g2d, 100, 100, 150, 80);
        drawCloud(g2d, 300, 150, 200, 100);
        drawCloud(g2d, 450, 50, 180, 90);
    }

    private void drawCloud(Graphics2D g2d, int x, int y, int width, int height) {
        g2d.setColor(Color.WHITE);
        int ovalWidth = width / 3;
        int ovalHeight = height / 2;

        g2d.fillOval(x, y, ovalWidth, ovalHeight);
        g2d.fillOval(x + ovalWidth / 2, y - ovalHeight / 2, ovalWidth, ovalHeight);
        g2d.fillOval(x + ovalWidth, y, ovalWidth, ovalHeight);
        g2d.fillOval(x + 3 * ovalWidth / 4, y + ovalHeight / 2, ovalWidth, ovalHeight);
    }
}
