package HW.Lesson7;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {
    public static final int GM_HVH = 0;
    public static final int GM_HVA = 1;

    GameMap() {
        setBackground(new Color(81, 179, 182));
    }
    void startGameWithParams(int mapSize_X, int mapSize_Y, int winLength, int modeGame) {
        System.out.println("mapSize_X= " + mapSize_X + "mapSize_X= " + mapSize_Y + "winLength= " + winLength + "modeGame= " + modeGame);
    }
}
