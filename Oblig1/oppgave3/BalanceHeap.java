import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BalanceHeap {
    public int[] list;
    public PriorityQueue<Integer> koe = new PriorityQueue<>();

    public BalanceHeap(int[] l){
        /*Constructor for the object BalanceHeap

        Args: 
            l (int[]): The sorted list of numbers we want to work with.

        Variables: 
            list: The list given in the Args.
        */

        list = l;
        for (Integer v : list){
            koe.offer(v);
        }
    }

    public void print(PriorityQueue<Integer> k){
        /*Print method that prints the elements out in a order that makes a balanced binary tree

        Args: 
            None

        Variables: 
            hoyere, venstre (PrioriteryQueue): container to keep the elements
        Return: 
            None, just prints to the terminal
        */
        
        PriorityQueue<Integer> hoyre = new PriorityQueue<>();
        PriorityQueue<Integer> venstre = new PriorityQueue<>();

        if (k.size()>2){
            int mid = (int) Math.floor((k.size()-1)/2); //Makes a varible for the mid index of the queue
            for (int i=0; i<mid; i++){ //Interates up to the mid variable and removes the Integers in the args queue and moves over to the left queue
                venstre.offer(k.poll());
            }

            System.out.println(k.poll()); //Prints out the middle integer in the argument queue, after removing all the Integers in front of it
            hoyre = k; //Takes the remainder of the argument queue and makes it the right queue

            print(venstre); print(hoyre); //Recursive call for the left and right queue
            
        } //If the queue only has 2 elements left we just print them out, starting with the smallest one, aka the first int the queue
        else if (k.size()==2) {
            while (!k.isEmpty()){ 
                System.out.println(k.poll());
            }

        } //If the queue only has 1 element we just print this element out and it is then empty and we do not need a recursive call
        else if (k.size()==1){
            System.out.println(k.poll());
        }
        //By doing it this way we never do a recursive call with an empty queue so we do not need a implemetation of this 
    }

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] list = in.lines().mapToInt(i -> Integer.parseInt(i)).toArray();

        BalanceHeap heap = new BalanceHeap(list);

        heap.print(heap.koe);
    }
}