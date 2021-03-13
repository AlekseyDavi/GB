package HW.Lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private static final int WIN_WIDTH = 500;
    private static final int WIN_HEIGHT = 550;
    private static final int WIN_POS_X = 650;
    private static final int WIN_POS_Y = 200;

    private Settings settings;
    private GameMap gameMap;

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POS_X, WIN_POS_Y);
        setTitle("Game");
        setResizable(false);

        settings = new Settings(this);
        gameMap = new GameMap();

        JButton btnStartGame = new JButton("Start new game");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        JButton btnExitGame = new JButton("Exit game");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelForButton = new JPanel();
        panelForButton.setLayout(new GridLayout(1, 2));
        panelForButton.add(btnExitGame);
        panelForButton.add(btnStartGame);
        add(panelForButton, BorderLayout.SOUTH);
        add(gameMap);

        setVisible(true);

    }

    void getParamsSettingAndStartGameStartGameWithParams(int mapSize_X, int mapSize_Y, int winLength, int modeGame) {
        gameMap.startGameWithParams(mapSize_X, mapSize_Y, winLength, modeGame);
    }


}
