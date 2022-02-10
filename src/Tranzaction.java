import java.util.*;
import java.io.*;

public class Tranzaction
{
    int fromState;
    int toState;
    char valueOfState;

    public Tranzaction(int fromState, int toState, char valueOfState) {
        this.fromState = fromState;
        this.toState = toState;
        this.valueOfState = valueOfState;
    }

    public int getFromState() {
        return fromState;
    }

    public int getToState() {
        return toState;
    }

    public char getValueOfState() {
        return valueOfState;
    }

    public void print() {
        System.out.println("q" + fromState + " + " + valueOfState + " -> " + "q" + toState);
    }
}
