import java.io.*;
import java.text.NumberFormat;
import java.util.*;
import java.nio.file.Files;
/**
 * 
 * 
 * @author Khalil McCall
 * N01043972
 * 
 */
public class Project1 {

    /**
     * the states loaded from file 
     */
    private static State[] states;

   /**
    * instance of scanner to read the file name entered
    * 
    */
    private static Scanner scanned = new Scanner(System.in);
   
    
    
    
    /**
     * this method reads file
     * @throws IOException
     */
    private static void readFile() throws IOException {
        File ChosenFile;

        while (true) {
            System.out.print("Enter file name: ");
            
            /**
             * file assigned to file object 'ChosenFile'
             */
            ChosenFile = new File(scanned.nextLine());
            /**
             * if file exists, break out of loop
             */
            if (ChosenFile.exists()) 
            	break;
            
            else {
                System.out.println();
                System.out.println("That file doesn't exist!");
                System.out.println();
                continue;

            }
        }
        /**
         * All Lines Read
         */
        List<String> each = Files.readAllLines(ChosenFile.toPath());
        
        /**
         * states array created with number of lines
         */
        states = new State[each.size() - 1];

        /**
         * iterates though states array
         */
        for (int i = 1; i < each.size() ; i++) {
        	/**
        	 * each line is stored in a position
        	 */
            String eachLine = each.get(i);
            
            /**
             * Array of string data is split and created by each 
             * delimiter read
             */
            String[] data = eachLine.split(",");
            
            /**
             * each value stored in respective index
             */
            String name = data[0];
            String capital = data[1];
            String abbreviation = data[2];
            int population = Integer.valueOf(data[3]);
            String region = data[4];
            int houseSeats = Integer.valueOf(data[5]);
            
            /**
             * constructor called, initializes each varible in state.java
             */
            State state = new State(name, capital, abbreviation, region, population, houseSeats);
            states[i-1] = state;
        }

        System.out.println();
        System.out.println("There were " + states.length + " state records read.");
    }
    
    
    
    
    
   

    
    /**
     * prints greeting message
     */
    private static void greeting() {
    	
        System.out.println("COP3538 Project 1");
        System.out.println("Instructor: Xudong Liu"+ "\n");
        System.out.println("Array Searches and Sorts");
        
    }

  
    
    

    /**
     * MainMenu is prompted
     * @return
     */
  
    private static int mainMenu() {
        System.out.print("1. Print A State Report " + "\n"  + 
        		"2. Sort By State Name" + "\n" +
        		"3. Sort By Population"+ "\n" +
        		"4. Sort By Capital"+ "\n" +
        		"5. Find And Print A State, Given The Capital"+ "\n" +
        		"6. Quit"+ "\n" +"\n" +
        		"Enter Your Choice: " +"\r");
      

        return Integer.parseInt(scanned.nextLine());
    }

   
    
    /***
     * prints out states in certain string format
     */
    private static void printStates() {
        System.out.println();
        System.out.println(String.format("%-25s %-17s %-15s %-12s %-16s %-12s", "Name", "Capital", "Abbreviation", "Population", "Region", "US House Seats"));
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------");

        for (State eachState : states) {
            System.out.println(eachState);
        }
    }
    
    
    
    
    /**
     * Insertion Sort. Sorting by capital 
     */
    
    public static void sortByCapital() {
    	 
    	  int i;
    	  int j;

          for (i = 1; i < states.length; i++) {
              State temp = states[i];

              	j = i-1;

              while (j > 0 && states[j - 1].getCapital().compareTo(temp.getCapital()) > 0) {
                  states[j] = states[j - 1];

                  j--;
              }

              states[j] = temp;
          }

          System.out.println(" \n ");
          System.out.println("States are sorted by capital.");
    }
    
    
    
   /**
    * Bubble Sort. Sorting by the names of the States.
    */
    private static void sortByName() {
        for (int out = 0; out < states.length - 1; out++) {
        	
        		for (int in =  states.length -1; in > 0 + out; in--) {
        			
        			if (states[in].compareStates(states[in - 1]) < 0) {
                	
                    State temp = states[in];
                    states[in] = states[in - 1];
                    states[in -1] = temp;
                    
                }
            }
        }

        System.out.println(" \n ");
        System.out.println("States are sorted by name.");
    }
    
    
    

    /**
     * Selection Sort. Sorting by population size
     */
    private static void sortByPop() {
    	
    	State minVal;
    	int minIndex;
    	
        for (int i = 0; i < states.length - 1; i++) {
             minVal = states[i];
             minIndex = i;

            for (int j = i + 1; j < states.length; j++) {
                if (states[j].getPopulation() < minVal.getPopulation()) {
                    minVal = states[j];
                    minIndex = j;
                }
            }

            if(minVal != states[i]) {
            	
                State temp = states[i];
                states[i] = minVal;
                states[minIndex] = temp;
                
            }
        }

        System.out.println(" \n ");
        System.out.println("States are sorted by population.");
    }

   /**
    * Searches for a given state
    */
  
    private static void givenState() {
        System.out.println();
        System.out.print("Enter capital city: \r");

        String capitalCity = scanned.nextLine();

        State state = null;

        for (State n : states) {
            if (n.getCapital().toLowerCase().equals(capitalCity.toLowerCase())) {
                state = n;
                break;
            }
        }

        System.out.println();

        if (state==null) {
        	System.out.println( capitalCity + " is not a capital");
            return;
        }
        System.out.println(String.format("%-14s %-10s","Name:", state.getName()));
        System.out.println(String.format("%-14s %-10s","Capital:", state.getCapital()));
        System.out.println(String.format("%-14s %-10s","Abbreviation:", state.getAbbreviation()));
        System.out.println(String.format("%-14s %-10s", "Population:",NumberFormat.getNumberInstance().format(state.getPopulation())));
        System.out.println(String.format("%-14s %-10s", "Region:", state.getRegion()));
        System.out.println(String.format("%-14s %-10s","Seats:", state.getHouseSeats()));
        
       
        	return;
        
    }
   

    /**
     * Quits Application
     */
    private static void quit() {
    	
    	System.out.println();
    	System.out.println("Have a good day!");
    	System.out.println();
        System.exit(0);
        
    }
    
   
    /**
     * Main method
     * @param args
     * @throws IOException
     *greeting displayed
     *read file called, scanner class called
     *switch for which value is entered
     *if wrong value is entered... catched..continue
    */
    public static void main(String[] args) throws IOException {
        greeting();

        readFile();

        while (true) {
            System.out.println();

            try {
                switch (mainMenu()) {
                    case 1:
                        printStates();
                        break;
                        
                    case 2:
                    	sortByName();
                        break;
                        
                    case 3:
                    	sortByPop();
                        break;
                        
                    case 4:
                        sortByCapital();
                        break;
                        
                    case 5:
                    	givenState();
                        break;
                    case 6:
                        quit();
                        break;
                        
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
            		System.out.println();
                System.out.println("Please enter a number from 1 to 6!");
            }
        }
    }
    }
    
    
    
    
    
    

