public class Main {

public static void main(String[] args){
    HashTable h =new HashTable();
    h.put("hello");
    h.put("word");
    h.put("mine");
    h.put("helloagain");
    h.put("wordle");
    h.put("fun"); 
    h.put("program");
    h.put("wordnocollision");
    h.put("minecraft");

    System.out.println("print1");
    h.print();

    h.remove("hello");
    h.remove("word");
    h.remove("helloagain");
    h.print();
    System.out.println("print2");

    System.out.println("end");


}
}