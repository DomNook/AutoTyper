package AutoTyper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Typer {

    public static boolean toChoke = false;
    public static boolean toDelay = false;
    
    private static Robot robot;

    public Typer() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        
    }

    public void sendHEHEHEHA() {
        robot.keyPress(KeyEvent.VK_SHIFT);

        // HEHEHE
        robot.keyPress(KeyEvent.VK_H);
        robot.keyRelease(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_H);
        robot.keyRelease(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_H);
        robot.keyRelease(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);

        //space
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyPress(KeyEvent.VK_SPACE);

        //HA
        robot.keyPress(KeyEvent.VK_H);
        robot.keyRelease(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);

        robot.keyRelease(KeyEvent.VK_SHIFT);

        //send
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void sendGRRRRR() {
        robot.keyPress(KeyEvent.VK_SHIFT);

        //GRRRRR
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_G);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);

        robot.keyRelease(KeyEvent.VK_SHIFT);

        //send
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    /**
     * delay input by number of miliseconds
     * @param delay
     */
    public void delayTime(int delay) {
        robot.delay(delay);
    }


    public void typeString(String toType, int repeatNum) {
        //unchokes program
        toChoke = false;
        // limiting length to 50
        if (toType.length() < 50) {
            //delay by 5 seconds
            robot.delay(5000);
            //create new array of char
            char[] characters = new char[toType.length()];
            //transfer contents of input string to array of char
            toType.getChars(0, toType.length(), characters, 0);
            
            //type and send inputted string, stop if choke is engaged
            for (int index = 0; index < repeatNum && toChoke == false; index++) {

                //type the inputted string
                for (int typed = 0; typed < toType.length(); typed++) {
                    //initialize character to type
                    char toProcess = characters[typed];
                    //type key
                    if (toDelay == true) {robot.delay(DelayGenerator.getRandomVeryShort());}
                    robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(toProcess));
                    if (toDelay == true) {robot.delay(DelayGenerator.getRandomShort());}
                    robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(toProcess));
                }
                //send 
                if (toDelay == true) {robot.delay(DelayGenerator.getRandomVeryShort()); System.out.println("i am delayed");}
                robot.keyPress(KeyEvent.VK_ENTER);
                if (toDelay == true) {robot.delay(DelayGenerator.getRandomShort());}
                robot.keyRelease(KeyEvent.VK_ENTER);

                //delay by 1 sec
                robot.delay(1000);
            }
        } else {
            System.out.println("Error: the inputted string is too long,\n please keep the string shorter than \n" + 50 + " characters long");
        }
    }

    public static void fishMachine() {
        toChoke = false;
        robot.delay(3000);

        Random random = new Random();

        while (!toChoke) {
            robot.delay((random.nextInt(150) + 50));
            robot.keyPress(KeyEvent.VK_E);
            robot.delay((random.nextInt(30) + 40));
            robot.keyRelease(KeyEvent.VK_E);
            robot.delay((random.nextInt(50) + 25));
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(random.nextInt(15));
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }

    public static void toggleDelay() {
        toDelay = !toDelay;
    }

    public static void getDelayState() {
        System.out.println("delay = " + toDelay);
    }

}
