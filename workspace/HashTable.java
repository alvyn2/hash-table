import java.util.*;
import java.util.function.Consumer;
import java.io.*;

public class HashTable {

// Methods you have to supply:
//

   private String[][] arr=new String[150][3];
    int fill=0;
  public void put(String key) {
    
    int hashCode = key.hashCode();
    int arrayIndex = Math.abs(hashCode) % 150;
    if(arr[arrayIndex][0]==null){
        arr[arrayIndex][0]=key;
    }else{
        int bucketIndex=0;
        while(arr[arrayIndex][bucketIndex]==null&& bucketIndex<arr[arrayIndex].length){
            bucketIndex++;
        }
        arr[arrayIndex][bucketIndex]=key;
    }    
}

public void put(String key, String value) {
    
    int hashCode = key.hashCode();
    int index=value.hashCode();
    int arrayIndex = hashCode;

    if(arr[arrayIndex][0]==null){
        arr[arrayIndex][0]=key;
    }else{
        int bucketIndex=0;
        while(arr[arrayIndex][bucketIndex]==null&& bucketIndex<arr[arrayIndex].length){
            bucketIndex++;
        }
        arr[arrayIndex][bucketIndex]=key;
    }    
}
//
  public String get(String key) {
    int index=Math.abs(key.hashCode()) % 150;
    for(String s:arr[index]){
        if(s==key){
            return key;
        }
    }
    return "";
}
//
  public String remove(String key){
    int hashCode = key.hashCode();
    int arrayIndex = Math.abs(hashCode) % 150;
    if(arr[arrayIndex][0]==key){
        arr[arrayIndex][0]=null;
        return key;
    }else{
        int bucketIndex=0;
        while(arr[arrayIndex][bucketIndex]!=key && bucketIndex<arr[arrayIndex].length){
            bucketIndex++;
        }
        arr[arrayIndex][bucketIndex]=null;
        return key;
    }    

}

public Iterator keys() {
  Iterator r = new iterator<String>();
    return r;
}
    
private class iterator<E> implements Iterator<String>{
    int nextIndex=0;
    int bucketIndex=0;


     public boolean hasNext(){
         while(nextIndex<arr.length-1 && arr[nextIndex][bucketIndex]==null){
            while(bucketIndex<arr.length-1 && arr[nextIndex][bucketIndex]==null){
                bucketIndex++;
                }
                nextIndex++;
             }       
             if(arr[nextIndex][bucketIndex]!=null){
                return true;
             }else{
                return false;
             }

             
    }  

    public String next(){
            String element="";
            hasNext();
            element=arr[nextIndex][bucketIndex];
            return element;
        }

     public void remove(){
             arr[nextIndex]=null;
         }

    }
//end iterator


//prints the table to the console
  public void print(){
    Iterator it =new iterator<String>();
    String s="";
    while(it.hasNext()==false){
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
