import java.util.*;
import java.io.*;

public class HashTable {

// Methods you have to supply:
//
array[][] arr=new array[150][1];
  public void put(String key) {
    
    int hashCode = key.hashCode();
    int arrayIndex = Math.abs(hashCode) % tableSize;
    if(arr[i]=null){
        arr[i].add(key);
    }    
}
//
  public String get(String key) {
    int index=Math.abs(key.hashCode()) % tableSize;
    for(int i:arr[index]){
        if(arr[index][i]==key){
            return key;
        }
    }
}
//
  public String remove(String key){


}

//public Iterator keys() {
//  }
    
private interface Iterator {

     default void forEachRemaining(Consumer< E> action){
        System.out.println("foreachremaining called");
        throw Error;
    }

    default boolean hasNext(){
        boolean b=false;

        return b;
    }  

    default E next(){
        E element;
    
        return element;
    }

    default void remove(){

    }

    }
//end iterator


//prints the table ig
  public void print(){
    Iterator it =HashTable.iterator;
    String s="";
    while(it.hasNext()){
        s+=it.next();
    }
    System.out.println(s);

}


//all starter code beyond this point
	/**
	 * Loads this HashTable from a file named "Lookup.dat".
	 */
    public void load() {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        
        // Open the file for reading
        try {
            File f = new File(System.getProperty("user.home"), "Lookup.dat");
            fileReader = new FileReader(f);
            bufferedReader = new BufferedReader(fileReader);
        }
        catch (FileNotFoundException e) {
            System.err.println("Cannot find input file \"Lookup.dat\"");
        }
        
        // Read the file contents and save in the HashTable
        try {
            while (true) {
                String key = bufferedReader.readLine();
                if (key == null) return;
                String value = bufferedReader.readLine();
                if (value == null) {
                    System.out.println("Error in input file");
                    System.exit(1);
                }
                String blankLine = bufferedReader.readLine();
                if (!"".equals(blankLine)) {
                    System.out.println("Error in input file");
                    System.exit(1);
                }
                put(key, value);
            }
        }
        catch (IOException e) {
            e.printStackTrace(System.out);
        }
        
        // Close the file when we're done
        try {
            bufferedReader.close( );
        }
        catch(IOException e) {
            e.printStackTrace(System.out);
        }
    }

	/**
	 * Saves this HashTable onto a file named "Lookup.dat".
	 */
	public void save() {
        FileOutputStream stream;
        PrintWriter printWriter = null;
        Iterator iterator;
        
        // Open the file for writing
        try {
            File f = new File(System.getProperty("user.home"), "Lookup.dat");
            stream = new FileOutputStream(f);
            printWriter = new PrintWriter(stream);
        }
        catch (Exception e) {
            System.err.println("Cannot use output file \"Lookup.dat\"");
        }
       
        // Write the contents of this HashTable to the file
        iterator = keys();
        while (iterator.hasNext()) {
            String key = (String)iterator.next();
            printWriter.println(key);
            String value = (String)get(key);
            value = removeNewlines(value);
            printWriter.println(value);
            printWriter.println();
        }
       
        // Close the file when we're done
        printWriter.close( );
    }
    
    /**
     * Replaces all line separator characters (which vary from one platform
     * to the next) with spaces.
     * 
     * @param value The input string, possibly containing line separators.
     * @return The input string with line separators replaced by spaces.
     */
    private String removeNewlines(String value) {
        return value.replaceAll("\r|\n", " ");
    }
}
