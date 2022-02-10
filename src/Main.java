import java.util.*;
import java.io.*;

public class Main {

    static int currentState;
    public static void main(String[] args) {

        String path = "C:\\Users\\anate\\AppData\\Local\\AFD\\AFD.txt";
        AFD afd = new AFD(path);

        Scanner sc = new Scanner(System.in);
        boolean continua = true;
        currentState = afd.initialState;

        while(continua) {

            System.out.println();
            System.out.println("Introduceti un cuvant: ");

            String cuvant = sc.nextLine();

            char[] simboluriCuvant = cuvant.toCharArray();
            char c;
            boolean blocaj = true;

            for(int i = 0; i < simboluriCuvant.length; i++) {
                c = simboluriCuvant[i];
                System.out.println("caracterul " + c);
                if(!afd.sigma.contains(c)) {
                    System.out.println("Caracterul " + c + " nu este permis.Introdu "
                            + "un cuvant format din caracterele cuprinse in alfabet.");
                    blocaj = true;
                }
                else {
                    blocaj = true;
                    for(Tranzaction t: afd.tranzitii) {
                        if(t.getFromState() == currentState && t.getValueOfState() == c) {
                            currentState = t.getToState();
                            System.out.println("Stare: " + t.getToState());
                            blocaj = false;
                            break;
                        }
                    }
                    if(blocaj) {
                        System.out.println("Blocaj!");
                        break;
                    }
                }
            }

            if(!blocaj) {
                boolean acceptat = false;
                for(int i : afd.finalStates) {
                    if(currentState == i) {
                        acceptat = true;
                    }
                }

                if(acceptat) {
                    System.out.println("Acceptat!");
                }
                else {
                    System.out.println("Neacceptat!");
                }

            }

            System.out.println("Continuati programuul? Introdu \"nu\" ca sa opresti programul sau orice alt text pentru a continua.");
            String inputContinua = sc.next();

            if(inputContinua.equals("nu")) {
                continua = false;
            }
        }
        sc.close();
    }

}
