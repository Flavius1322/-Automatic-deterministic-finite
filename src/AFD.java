import java.util.*;
import java.io.*;
//babba
public class AFD
{
    String path;
    public int numberOfStates;
    public int initialState;//stare initiala
    public int numberOfFinalStates = 1;
    public int numberOfSymbols = 2;
    public int numberOfTransitions;
    public int states[];//multime stari
    public int finalStates[];//stari finale
    public ArrayList<Character> sigma = new ArrayList<Character>();//alfabet finit intrare
    public ArrayList<Tranzaction> tranzitii = new ArrayList<Tranzaction>();

    public AFD(String path)
    {
        this.path = path;
        citire();
        afisare();
    }

    public void citire()
    {


        try {
            try (BufferedReader br = new BufferedReader(new FileReader(this.path)))
            {
                String line ;
                String[] values;

                line = br.readLine();
                numberOfStates = Integer.parseInt(line);
                line = br.readLine();
                states = new int[numberOfStates];
                values = line.split(",");//separa valorile dupa virgula
                for(int i = 0; i < numberOfStates; i++) {
                    states[i] = Integer.parseInt(values[i]);
                }
                line = br.readLine();
                initialState = Integer.parseInt(line);
                line = br.readLine();
                numberOfFinalStates = Integer.parseInt(line);
                line = br.readLine();
                values = line.split(",");
                finalStates = new int[numberOfFinalStates];
                values = line.split(",");
                for(int i = 0; i < numberOfFinalStates; i++) {
                    finalStates[i] = Integer.parseInt(values[i]);
                }

                line = br.readLine();
                numberOfSymbols = Integer.parseInt(line);
                line = br.readLine();
                values = line.split(",");
                for(int i = 0; i < numberOfSymbols; i++) {
                    sigma.add(values[i].charAt(0));
                }
                line = br.readLine();
                numberOfTransitions = Integer.parseInt(line);


                while((line = br.readLine()) != null) {
                    values = line.split(",");
                    Tranzaction t = new Tranzaction(Integer.parseInt(values[0]), Integer.parseInt(values[2]), values[1].charAt(0));
                    tranzitii.add(t);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afisare()
    {
        System.out.println("Numarul de stari este: " + numberOfStates + ". Sunt: " + Arrays.toString(states));
        System.out.println("Starea initiala este: " + initialState);
        System.out.println("Numarul de stari finale este: " + numberOfFinalStates + ". Sunt: " + Arrays.toString(finalStates));
        System.out.println("Numarul de simboluri este: " + numberOfSymbols + ". Sunt: " + sigma.toString());
        System.out.println("Numarul de tranzitii este: " + numberOfTransitions + ". Sunt: ");
        for(Tranzaction t: tranzitii) {
            t.print();
        }
    }
}


