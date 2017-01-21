package Performance;

import java.util.*;

/**
 *
 * @author Kyle Hewitt
 * Makes an ArrayList and a Linked List and fills them with random Integer objects.
 * It then tests the time and determines which computes faster using different methods;
 * .get() and .remove() on ArrayList and .next() on the Linked List.
 */

public class LinkList{
    private LinkedList myList;// My LinkedList to fill and test.
    private long first, last, timeDif1, timeDif2, timeDif3;// Holds the values 
                                        //for the nanotime and their differences
    private Random ran = new Random();//To fill lists with random int
    public String better;//assigns for display purposes

    
    //Creates a LinkedList and fills it with random Integer objects
    public LinkList(){
        msg("LinkedList (NanoSeconds):");
        
        myList = new LinkedList();
        first = System.nanoTime();
        for(int i =0;i<100000;i++){
            myList.add(new Integer(ran.nextInt()));
        }
        last = System.nanoTime();
        timeDif1 = last - first;
        msg("\tBuild: \t\t"+timeDif1);
        getList();
        iteratedList();
        
    }//constructor
    
    //Uses a for loop to run the .get() method for the entire LinkedList
    public void getList(){
        first = System.nanoTime();
        for(int i =0; i<myList.size(); i++){
           myList.get(i);
        }
        last = System.nanoTime();
        timeDif2 = last - first;
        msg("\n\t.get(): \t"+timeDif2);
    }//getList
    
    //Uses an iterator to run the .next() iterator method for the entire LinkedList
    public void iteratedList(){
        first = System.nanoTime();
        for (Iterator i = myList.listIterator(0); i.hasNext(); ){
            i.next();
        }
        last = System.nanoTime();
        timeDif3 = last - first;
        msg("\tIterated: \t"+timeDif3);
    }//iteratedList
    
    
    //Calculates the better time between .get() and .next() and returns the 
    //difference in time
    public long diff(){
        if(timeDif2>timeDif3){
            better = "Itorator";
            return timeDif2-timeDif3;
        }
        else{
            better = ".get()";
            return timeDif3- timeDif2;
        }
    }//diff
    

    //Used to display strings
    public void msg(String s){
        System.out.println(s);
    }//msg
    
}