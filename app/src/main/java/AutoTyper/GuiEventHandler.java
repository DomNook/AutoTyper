package AutoTyper;

public class GuiEventHandler {

    Typer typer = new Typer();

    public void startSpammer(String toType, int repeatNum) {
        typer.typeString(toType, repeatNum);
    }

    public void oldSpamTest() {
        typer.delayTime(5000);
        typer.sendHEHEHEHA();
        typer.sendGRRRRR();
    }

}