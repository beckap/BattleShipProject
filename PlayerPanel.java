package BattleShip;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class PlayerPanel extends JPanel {
    GridPanel grid;
    PlayerPanel() throws IOException {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ImageIcon bannerIcon = new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("Images/" + "true" + ".png"))));
        JLabel bannerLabel = new JLabel(bannerIcon);
        grid = new GridPanel(true);

        this.add(bannerLabel);
        this.add(grid);
        bannerLabel.setAlignmentX(LEFT_ALIGNMENT);
        grid.setAlignmentX(LEFT_ALIGNMENT);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setBorder(new EmptyBorder(15,45,15,45));
    }

    public GridPanel getGridPanel(){ return this.grid; }
}
