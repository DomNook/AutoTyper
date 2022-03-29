package AutoTyper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;


public class GuiContainer {
    
    static final JFrame frame = new JFrame("AutoTyper");

    //input fields
    JTextField textField = new JTextField();
    JSpinner amount = new JSpinner();
    JButton buttonSend = new JButton("Spam away");

    //evt handler to catch button press
    GuiEventHandler eventHandler = new GuiEventHandler();

    private final int keyAmt = 12;
    private String[] keySelection = new String[keyAmt];

    public GuiContainer() {
        for (int index = 0; index < keyAmt; index++) {
            keySelection[index] = "F" + (index+1);
        }
    }

    public void test() {

        //main stuff
        JPanel panel = new JPanel();

        Color panelColor = new Color(152,251,152);
        panel.setBackground(panelColor);


        //sizing
        Dimension largerfield = new Dimension(200, 25);
        Dimension smallerfield = new Dimension(50, 25);
        Dimension sendButton = new Dimension(280, 25);
        textField.setPreferredSize(largerfield);
        amount.setPreferredSize(smallerfield);
        buttonSend.setPreferredSize(sendButton);

        //button color
        Color buttonColor = new Color(0,139,139);
        buttonSend.setBackground(buttonColor);
        Color buttonTextColor = new Color(255,255,255);
        buttonSend.setForeground(buttonTextColor);

        //south panel
        JPanel southPanel = new JPanel();
        southPanel.add(buttonSend);
        southPanel.setBackground(panelColor);

        //checkbox for delays
        JCheckBox randomDelay = new JCheckBox("Delay");
        southPanel.add(randomDelay);
        randomDelay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Typer.toggleDelay();
                Typer.getDelayState();
            }
        });


        //exit program when window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //define window
        frame.setSize(380, 150);
        frame.setLayout(new BorderLayout());

        //menu bar
        JMenuBar menubar = new JMenuBar();
        JMenu debugging = new JMenu("DEBUGGING");
        menubar.add(debugging);
        JMenu settings = new JMenu("Settings");
        menubar.add(settings);

        //inside the menu bar item "Debugging"
        JMenuItem oldspam = new JMenuItem("Old test");
        debugging.add(oldspam);

        //button event listener
        oldspam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventHandler.oldSpamTest();
            }
        });

        JMenuItem fishingBot = new JMenuItem("Fishing machine");
        debugging.add(fishingBot);

        fishingBot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Typer.fishMachine();
            }
        });
        
        //inside the menu bar item "settings"
        JMenuItem chokeKey = new JMenuItem("Set choke key");
        settings.add(chokeKey);

        chokeKey.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int chosenKey = JOptionPane.showOptionDialog(frame, "Change choke key" , "Choose new key", JOptionPane.DEFAULT_OPTION  , JOptionPane.INFORMATION_MESSAGE, null, keySelection, keySelection[0]);
                GlobalKeyHandler.changeChokeKey(chosenKey);
            }
        });



        //label
        JLabel label = new JLabel();
        label.setText("What to spam:              Times to spam:");
        label.setSize(300, 50);



        //add stuff to panel
        panel.add(label);
        panel.add(textField);
        panel.add(amount);

        
        //placement
        frame.getContentPane().add(BorderLayout.NORTH, menubar);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, southPanel);
        frame.setVisible(true);



        //events
        //send command
        buttonSend.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                // make sure the spinner has up to date values
                try {
                    amount.commitEdit();
                } catch (java.text.ParseException w) {
                    //if value submitted is not of matching type
                    System.out.println("Please enter a number");
                }
                // parse getvalue to an integer
                int value = (Integer) amount.getValue();
                // send thingy
                eventHandler.startSpammer(textField.getText(), value);
            };  
        });


    }


}