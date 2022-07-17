import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();

        ArrayList<Integer> arrayList = new ArrayList<>();

        long startTime, endTime, elapsedTime;

        for(int i=0; i<1000000; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        //--------------------Linked List-------------------------

        startTime = System.nanoTime();

        //linkedList.get(0);                //23947 ns
        //linkedList.get(500000);           //7435915 ns
        //linkedList.get(999999);           //23946 ns <- due to "Doubly Linked" - you can start searching from each end
        //linkedList.remove(0);             //31216 ns
        //linkedList.remove(500000);        //7330721 ns <- had to navigate to the middle to remove this element
        linkedList.remove(999999);    //27368 ns

        endTime = System.nanoTime();

        elapsedTime = endTime - startTime;

        System.out.println("LinkedList:\t" + elapsedTime + " ns");

        //--------------------Array List-------------------------

        startTime = System.nanoTime();

        //arrayList.get(0);              //10263 ns
        //arrayList.get(50000            //10691 ns
        //arrayList.get(999999);         //16250 ns
        //arrayList.remove(0);           //1140040 ns <- due to shifting of 999999 elements in array
        //arrayList.remove(500000);      //474660 ns <- due to shifting of 499999 elements in array
        arrayList.remove(999999);  //10263 ns <- no shifting necessary

        endTime = System.nanoTime();

        elapsedTime = endTime - startTime;

        System.out.println("ArrayList:\t" + elapsedTime + " ns");
    }
}
