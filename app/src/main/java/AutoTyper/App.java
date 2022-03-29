package AutoTyper;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

public class App{




    public static void main(String[] args) {

        final GuiContainer gui = new GuiContainer();

        gui.test();


        //initialize global key listener
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("could not register global hook");
            System.err.println(ex.getMessage());

        }
        GlobalScreen.addNativeKeyListener(new GlobalKeyHandler());
    }

}