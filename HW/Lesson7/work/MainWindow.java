package lesson7.work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 06.03.2021
 */

public class MainWindow extends JFrame {

    private static final int WIN_WIDTH = 507;
    private static final int WIN_HEIGHT = 550;
    private static final int WIN_POS_X = 650;
    private static final int WIN_POS_Y = 250;

    private Settings settings;
    private GameMap gameMap;

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POS_X, WIN_POS_Y);
        setTitle("Game X-O");
        setResizable(false);

        settings = new Settings(this);
        gameMap = new GameMap();

        JButton btnStartGame = new JButton("Start New Game");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        JButton btnExitGame = new JButton("Exit Game");
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

    void getParamsFromSettingAndStartGame(int mapSizeX, int mapSizeY, int winLength, int modeGame) {
        gameMap.startGameWithParams(mapSizeX, mapSizeY, winLength, modeGame);
    }

}
