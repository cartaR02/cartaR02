import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartingEdition {
    public static int RandX;
    public static int RandY;
    public static boolean RandomPicking = false;
    public static int X = 0;
    public static int StartingNum = 2;
    public static int WinCon = 2048;
    public static int[][] TestingArr = {
            { X, X, X, X },
            { X, X, X, X },
            { X, X, X, X },
            { X, X, X, X },

    };// Testing Arr

    public static int Counter = 0;

    // Creats Frame
    public static JFrame frame;
    public static JPanel panel;
    public static JButton UpButton;
    public static JButton DownButton;
    public static JButton LeftButton;
    public static JButton RightButton;

    public static Font font1 = new Font("SansSerif", Font.BOLD, 100);

    // First Line
    public static JLabel ZeroZero = new JLabel();
    public static JLabel ZeroOne = new JLabel();
    public static JLabel ZeroTwo = new JLabel();
    public static JLabel ZeroThree = new JLabel();

    // Second Line
    public static JLabel OneZero = new JLabel();
    public static JLabel OneOne = new JLabel();
    public static JLabel OneTwo = new JLabel();
    public static JLabel OneThree = new JLabel();

    // Third Line
    public static JLabel TwoZero = new JLabel();
    public static JLabel TwoOne = new JLabel();
    public static JLabel TwoTwo = new JLabel();
    public static JLabel TwoThree = new JLabel();

    // Fourth Line
    public static JLabel ThreeZero = new JLabel();
    public static JLabel ThreeOne = new JLabel();
    public static JLabel ThreeTwo = new JLabel();
    public static JLabel ThreeThree = new JLabel();

    public StartingEdition() {
        panel = new JPanel();
        frame = new JFrame();

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        UpButton = new JButton("Up");
        DownButton = new JButton("Down");
        LeftButton = new JButton("Left");
        RightButton = new JButton("Right");
        frame.setLayout(new GridLayout(4, 4));

        // Makes the text center
        ZeroZero.setHorizontalAlignment(JLabel.CENTER);
        ZeroOne.setHorizontalAlignment(JLabel.CENTER);
        ZeroTwo.setHorizontalAlignment(JLabel.CENTER);
        ZeroThree.setHorizontalAlignment(JLabel.CENTER);
        OneZero.setHorizontalAlignment(JLabel.CENTER);
        OneOne.setHorizontalAlignment(JLabel.CENTER);
        OneTwo.setHorizontalAlignment(JLabel.CENTER);
        OneThree.setHorizontalAlignment(JLabel.CENTER);
        TwoZero.setHorizontalAlignment(JLabel.CENTER);
        TwoOne.setHorizontalAlignment(JLabel.CENTER);
        TwoTwo.setHorizontalAlignment(JLabel.CENTER);
        TwoThree.setHorizontalAlignment(JLabel.CENTER);
        ThreeZero.setHorizontalAlignment(JLabel.CENTER);
        ThreeOne.setHorizontalAlignment(JLabel.CENTER);
        ThreeTwo.setHorizontalAlignment(JLabel.CENTER);
        ThreeThree.setHorizontalAlignment(JLabel.CENTER);

        // Adds Labels to frame
        frame.add(ZeroZero);
        frame.add(ZeroOne);
        frame.add(ZeroTwo);
        frame.add(ZeroThree);
        frame.add(OneZero);
        frame.add(OneOne);
        frame.add(OneTwo);
        frame.add(OneThree);
        frame.add(TwoZero);
        frame.add(TwoOne);
        frame.add(TwoTwo);
        frame.add(TwoThree);
        frame.add(ThreeZero);
        frame.add(ThreeOne);
        frame.add(ThreeTwo);
        frame.add(ThreeThree);

        // Sets labels fonts
        ZeroZero.setFont(font1);
        ZeroOne.setFont(font1);
        ZeroTwo.setFont(font1);
        ZeroThree.setFont(font1);
        OneZero.setFont(font1);
        OneOne.setFont(font1);
        OneTwo.setFont(font1);
        OneThree.setFont(font1);
        TwoZero.setFont(font1);
        TwoOne.setFont(font1);
        TwoTwo.setFont(font1);
        TwoThree.setFont(font1);
        ThreeZero.setFont(font1);
        ThreeOne.setFont(font1);
        ThreeTwo.setFont(font1);
        ThreeThree.setFont(font1);

    }

    public static void PrintArray(int[][] Arr) throws InterruptedException {// Prints Out array
        // TextField.setText(String.valueOf(PrintingArray));
        for (int i = 0; i < TestingArr.length; i++) {

            for (int k = TestingArr[0].length - 1; k >= 0; k--) {

                if (TestingArr[i][k] == WinCon) {
                    System.out.println("YOU WOn");
                    System.exit(0);
                }
            }

        }

        ZeroZero.setText(String.valueOf(TestingArr[0][0]));
        ZeroOne.setText(String.valueOf(TestingArr[0][1]));
        ZeroTwo.setText(String.valueOf(TestingArr[0][2]));
        ZeroThree.setText(String.valueOf(TestingArr[0][3]));
        OneZero.setText(String.valueOf(TestingArr[1][0]));
        OneOne.setText(String.valueOf(TestingArr[1][1]));
        OneTwo.setText(String.valueOf(TestingArr[1][2]));
        OneThree.setText(String.valueOf(TestingArr[1][3]));
        TwoZero.setText(String.valueOf(TestingArr[2][0]));
        TwoOne.setText(String.valueOf(TestingArr[2][1]));
        TwoTwo.setText(String.valueOf(TestingArr[2][2]));
        TwoThree.setText(String.valueOf(TestingArr[2][3]));
        ThreeZero.setText(String.valueOf(TestingArr[3][0]));
        ThreeOne.setText(String.valueOf(TestingArr[3][1]));
        ThreeTwo.setText(String.valueOf(TestingArr[3][2]));
        ThreeThree.setText(String.valueOf(TestingArr[3][3]));

    }// Print Array

    public static void RandomPick(int x, int y) throws InterruptedException {

        if (Counter <= 16) {
            if (TestingArr[x][y] != X) {
                x = (int) (Math.random() * TestingArr.length) + 0;
                y = (int) (Math.random() * TestingArr[0].length) + 0;

                RandomPick(x, y);
                Thread.sleep(1);

            } else {
                TestingArr[x][y] = StartingNum;
                Counter = 0;
            }
        } else {
            System.out.println("You lost :(");
            System.exit(0);
        }

    }

    // Picks a jhit starting from the right and moving line by lines to get the ones
    // closest to the right side first
    public static void MovingToRightInitial() throws InterruptedException {

        for (int i = TestingArr.length - 1; i >= 0; i--) {
            for (int k = TestingArr[0].length - 1; k >= 0; k--) {
                if (TestingArr[i][k] != 0) {
                    MoveToRightSecondary(i, k);
                }
            }
        }

    }

    // Moves them to the right by checking the row for the next open position
    private static void MoveToRightSecondary(int tempx, int tempy) throws InterruptedException {
        int originialy = tempy;
        int OGValue = TestingArr[tempx][tempy];
        // System.out.println(tempx + " " + tempy);
        while (tempy + 1 != TestingArr.length && TestingArr[tempx][tempy + 1] == X) {
            tempy++;

        }
        TestingArr[tempx][originialy] = X;
        TestingArr[tempx][tempy] = OGValue;
        if (tempy + 1 != TestingArr.length && TestingArr[tempx][tempy] == TestingArr[tempx][tempy + 1]) {
            TestingArr[tempx][tempy] = X;
            TestingArr[tempx][tempy + 1] = TestingArr[tempx][tempy + 1] + TestingArr[tempx][tempy + 1];

        }

    }

    // gets each "o" starting from the left and going right
    public static void MovingToLeftInitial() throws InterruptedException {

        for (int i = 0; i < TestingArr.length; i++) {
            for (int k = 0; k < TestingArr.length; k++) {
                if (TestingArr[i][k] != 0) {
                    MoveToLeftSecondary(i, k);
                }
            }
        }

    }

    public static void MoveToLeftSecondary(int tempx, int tempy) {
        int OriginialY = tempy;
        int OGValue = TestingArr[tempx][tempy];
        while (tempy - 1 >= 0 && TestingArr[tempx][tempy - 1] == 0) {
            tempy--;

        }
        TestingArr[tempx][OriginialY] = X;
        TestingArr[tempx][tempy] = OGValue;

        if (tempy - 1 >= 0 && TestingArr[tempx][tempy] == TestingArr[tempx][tempy - 1]) {
            TestingArr[tempx][tempy] = X;
            TestingArr[tempx][tempy - 1] = TestingArr[tempx][tempy - 1] + TestingArr[tempx][tempy - 1];

        }

    }

    public static void MovingToDownInitial() throws InterruptedException {

        for (int i = TestingArr.length - 1; i >= 0; i--) {
            for (int k = 0; k < TestingArr.length; k++) {
                if (TestingArr[i][k] != 0) {
                    MoveToDownSecondary(i, k);
                }
            }
        }
    }

    public static void MoveToDownSecondary(int tempx, int tempy) {
        int ogX = tempx;
        int OGValue = TestingArr[tempx][tempy];
        while (tempx + 1 != TestingArr.length && TestingArr[tempx + 1][tempy] == 0) {
            tempx++;

        }
        TestingArr[ogX][tempy] = X;
        TestingArr[tempx][tempy] = OGValue;
        if (tempx + 1 != TestingArr.length && TestingArr[tempx][tempy] == TestingArr[tempx + 1][tempy]) {
            TestingArr[tempx][tempy] = X;
            TestingArr[tempx + 1][tempy] = TestingArr[tempx + 1][tempy] + TestingArr[tempx + 1][tempy];

        }

    }

    public static void MovingToUpInitial() throws InterruptedException {
        for (int i = 0; i < TestingArr.length; i++) {
            for (int k = 0; k < TestingArr.length; k++) {
                if (TestingArr[i][k] != 0) {
                    MoveToUpSecondary(i, k);
                }
            }
        }
    }

    public static void MoveToUpSecondary(int tempx, int tempy) {
        int ogX = tempx;
        int OGVAlue = TestingArr[tempx][tempy];
        while (tempx - 1 >= 0 && TestingArr[tempx - 1][tempy] == 0) {
            tempx--;

        }
        TestingArr[ogX][tempy] = X;
        TestingArr[tempx][tempy] = OGVAlue;
        if (tempx - 1 >= 0 && TestingArr[tempx][tempy] == TestingArr[tempx - 1][tempy]) {
            TestingArr[tempx][tempy] = X;
            TestingArr[tempx - 1][tempy] = TestingArr[tempx - 1][tempy] + TestingArr[tempx - 1][tempy];
        }

    }

    public static void pickingAnOpenSpot(int amount) throws InterruptedException {
        while (amount > 0) {
            RandX = (int) (Math.random() * TestingArr.length) + 0;
            RandY = (int) (Math.random() * TestingArr[0].length) + 0;
            amount--;
            RandomPick(RandX, RandY);

        }
        PrintArray(TestingArr);
    }

    private static void WhatDirection() throws InterruptedException {

        // Gets what key you are pressing
        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {

                    // Checks for Up press
                    case KeyEvent.VK_W:
                        try {
                            MovingToUpInitial();

                            pickingAnOpenSpot(2);

                        } catch (InterruptedException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        break;

                    // Checks for Down press
                    case KeyEvent.VK_S:
                        try {
                            MovingToDownInitial();

                            pickingAnOpenSpot(2);

                        } catch (InterruptedException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        break;

                    // Checks for left Press
                    case KeyEvent.VK_A:
                        try {
                            MovingToLeftInitial();

                            pickingAnOpenSpot(2);

                        } catch (InterruptedException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        break;

                    // Checks for right press
                    case KeyEvent.VK_D:
                        try {
                            MovingToRightInitial();

                            pickingAnOpenSpot(2);

                        } catch (InterruptedException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        break;

                }

            }

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }

        });
    }

    public static void main(String[] args) throws Exception {

        new StartingEdition();

        pickingAnOpenSpot(2);

        System.out.println();

        WhatDirection();

    }

}
