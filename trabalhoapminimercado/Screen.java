package com.mycompany.trabalhoapminimercado;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Screen {
    

    public static void clear() {

        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
        
        }
    }
}