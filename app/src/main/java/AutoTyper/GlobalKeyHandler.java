package AutoTyper;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyHandler implements NativeKeyListener {

    public static int chokeKey = 65; // 65 = F7

    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode() == chokeKey) {
            Typer.toChoke = true;
            System.out.println("Choke engaged");
        }
    }

    public static void changeChokeKey(int newKey) {
        newKey += 59;
        chokeKey = newKey;
    }

}