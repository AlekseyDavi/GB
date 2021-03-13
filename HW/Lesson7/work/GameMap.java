package lesson7.work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 06.03.2021
 */

public class GameMap extends JPanel {
    public static final int GM_HVH = 0;
    public static final int GM_HVA = 1;

    private static final int HUMAN_DOT = 1;
    private static final int AI_DOT = 2;
    private static final int EMPTY_DOT = 0;
    private static final int OVAL_PADDING = 5;

    private static final Random RANDOM = new Random();
    private static final int EVENT_DRAW = 0;
    private static final int EVENT_WIN_HUMAN = 1;
    private static final int EVENT_WIN_AI = 2;
    private static final String TEXT_EVENT_WIN_HUMAN = "Human win!";
    private static final String TEXT_EVENT_WIN_AI = "AI win!";
    private static final String TEXT_EVENT_WIN_DRAW = "DRAW!";
    private int[][] map;
    private int mapSizeX;
    private int mapSizeY;
    private int winLength;
    private int modeGame;
    private int cellWidth;
    private int cellHeight;
    private boolean initMap;
    private boolean isGameOver;
    private int currentWinEvent;


    GameMap() {
        setBackground(Color.BLACK);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
        initMap = false;
    }

    void startGameWithParams(int mapSizeX, int mapSizeY, int winLength, int modeGame) {
        this.mapSizeX = mapSizeX;
        this.mapSizeY = mapSizeY;
        this.winLength = winLength;
        this.modeGame = modeGame;
        this.map = new int[mapSizeY][mapSizeX];
        initMap = true;
        isGameOver = false;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void update(MouseEvent e) {
        if (!initMap) return;
        if (isGameOver) return;

        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        System.out.println("x=" + cellX + "y=" + cellY);
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) {
            System.out.println("3x=" + cellX + "3y=" + cellY);
            return;
        }
        System.out.println("human=1;empty=0 " + map[cellY][cellX]);
        map[cellY][cellX] = HUMAN_DOT;
        System.out.println("human=1;empty=0 " + map[cellY][cellX]);
        System.out.println("2x=" + cellX + "2y=" + cellY);
        if (checkWin(HUMAN_DOT)) {
            setGameOverEvent(EVENT_WIN_HUMAN);
            return;
        }

        if (isFullMap()) {
            setGameOverEvent(EVENT_DRAW);
            return;
        }
        repaint();
        aiTurn();
        repaint();

        if (checkWin(AI_DOT)) {
            setGameOverEvent(EVENT_WIN_AI);
            return;
        }

        if (isFullMap()) {
            setGameOverEvent(EVENT_DRAW);
            return;
        }

    }

    private void setGameOverEvent(int valueEvent) {
        isGameOver = true;
        currentWinEvent = valueEvent;
        repaint();
    }

    private void render(Graphics g) {
        if (!initMap) return;

        int width = getWidth();
        int height = getHeight();

        cellWidth = width / mapSizeX;
        cellHeight = height / mapSizeY;

        g.setColor(Color.WHITE);

        for (int i = 0; i < mapSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int i = 0; i < mapSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }


        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {

                if (isEmptyCell(x, y)) {
                    continue;
                }
                if (map[y][x] == HUMAN_DOT) {
                    g.setColor(new Color(0, 255, 0));
                    g.fillOval(x * cellWidth + OVAL_PADDING, y * cellHeight + OVAL_PADDING, cellWidth - OVAL_PADDING * 2, cellHeight - OVAL_PADDING * 2);
                } else if (map[y][x] == AI_DOT) {
                    g.setColor(new Color(255, 0, 0));
                    g.fillOval(x * cellWidth + OVAL_PADDING, y * cellHeight + OVAL_PADDING, cellWidth - OVAL_PADDING * 2, cellHeight - OVAL_PADDING * 2);
                } else {
                    throw new RuntimeException("Invalid render player in y = " + y + " x = " + x);
                }
            }
        }
        if (isGameOver) {
            showMessageGameOverEvent(g);
        }

    }

    private void showMessageGameOverEvent(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Times New Roman", Font.BOLD, 40));
        switch (currentWinEvent) {
            case EVENT_DRAW:
                g.drawString(TEXT_EVENT_WIN_DRAW, 180, getHeight() / 2);
                break;
            case EVENT_WIN_HUMAN:
                g.drawString(TEXT_EVENT_WIN_HUMAN, 150, getHeight() / 2);
                break;
            case EVENT_WIN_AI:
                g.drawString(TEXT_EVENT_WIN_AI, 180, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Invalid winEvent " + currentWinEvent);
        }
    }

    public void aiTurn() {

        if (turnAIWinCell()) {
            return;
        }
        if (turnHumanWinCell()) {
            return;
        }


        if (isEmptyCell(1, 1)) {
            map[1][1] = AI_DOT;
            return;
        }
        if (isEmptyCell(0, 0)) {
            map[0][0] = AI_DOT;
            return;
        }
        if (map[0][0] == HUMAN_DOT && map[1][1] == AI_DOT && map[2][2] == HUMAN_DOT && map[1][0] == EMPTY_DOT) {

            map[1][0] = AI_DOT;
            return;

        }
        if (map[2][0] == HUMAN_DOT && map[1][1] == AI_DOT && map[0][2] == HUMAN_DOT && map[1][0] == EMPTY_DOT) {
            if (isEmptyCell(0, 1)) {
                map[1][0] = AI_DOT;
                return;
            }
        }
        if (map[0][0] == AI_DOT && map[1][1] == HUMAN_DOT && map[2][2] == HUMAN_DOT && map[0][2] == EMPTY_DOT) {
            map[0][2] = AI_DOT;
            return;
        }
        int x;
        int y;
        do {
            x = RANDOM.nextInt(mapSizeX);
            y = RANDOM.nextInt(mapSizeY);
        } while (!isEmptyCell(x, y));
        map[y][x] = AI_DOT;
    }

    private boolean turnAIWinCell() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    map[i][j] = AI_DOT;
                    if (checkWin(AI_DOT)) {
                        return true;
                    }
                    map[i][j] = EMPTY_DOT;
                }
            }
        }
        return false;
    }

    // Проверка, выиграет-ли игрок своим следующим ходом
    private boolean turnHumanWinCell() {
        System.out.println();
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    map[i][j] = HUMAN_DOT;     // поставим крестик в каждую клетку по очереди
                    if (checkWin(HUMAN_DOT)) {    // если игрок победит
                        map[i][j] = AI_DOT;    // поставить на то место нолик
                        return true;
                    }
                    map[i][j] = EMPTY_DOT;    // в противном случае вернуть на место пустоту
                }
            }
        }
        return false;
    }

    // проверка на победу
    private boolean checkWin(int player) {
        for (int i = 0; i < mapSizeX; i++) {     // ползём по всему полю
            for (int j = 0; j < mapSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLength, player)) {
                    return true;    // проверим линию по х
                }
                if (checkLine(i, j, 1, 1, winLength, player)) {
                    return true;    // проверим по диагонали х у
                }
                if (checkLine(i, j, 0, 1, winLength, player)) {
                    return true;    // проверим линию по у
                }
                if (checkLine(i, j, 1, -1, winLength, player)) {
                    return true;    // проверим по диагонали х -у
                }
            }
        }
        return false;
    }

    // проверка линии
    private boolean checkLine(int x, int y, int vx, int vy, int len, int player) {
        final int farX = x + (len - 1) * vx;    // посчитаем конец проверяемой линии
        final int farY = y + (len - 1) * vy;
        if (!isValidCell(farX, farY)) {
            return false;    // проверим не выйдет-ли проверяемая линия за пределы поля
        }
        for (int i = 0; i < len; i++) {    // ползём по проверяемой линии
            if (map[y + i * vy][x + i * vx] != player) {
                return false;    // проверим одинаковые-ли символы в ячейках
            }
        }
        return true;
    }

    public boolean isFullMap() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (map[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidCell(int x, int y) {
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }

    public boolean isEmptyCell(int x, int y) {
        return map[y][x] == EMPTY_DOT;
    }

}

