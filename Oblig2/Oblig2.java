import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Queue;

class Oblig2 {

    static void printSchedule(PriorityQueue<Task> runningTasks, Task[] list){
        int time = 0;
        int currentStaff = 0;
        System.out.println("Time: " + time);
        for (Task t : runningTasks){
            currentStaff += t.staff;
            System.out.println("Starts " + t.name + " ID: " + t.id + "\n" + "Current staff: " + currentStaff + "\n");
            t.setEarliestStart(time);
        }
        int j = 1;
        while (!runningTasks.isEmpty()){
            Task t = runningTasks.poll();
            t.visited = true;
            time += t.time;
            currentStaff -= t.staff;
            System.out.println("Time: " + time);
            System.out.println("Finishes " + t.name + " ID: " + t.id);
            for (Task running : runningTasks){
                running.doWork(t.time);
            }
            for (Task nabo : t.outEdges){
                nabo.cntPredecessors --;
                if(nabo.cntPredecessors == 0){
                    currentStaff += nabo.staff;
                    System.out.println("Starts " + nabo.name + " ID: " + nabo.id);
                    t.setEarliestStart(time);
                    runningTasks.add(nabo);
                }
            }
            System.out.println("Current staff: " + currentStaff + "\n");
            j += 1;
        }
        if (j-1 < list.length){
            System.out.println("Project has a cycle.");
            for(int k = 0; k < list.length; k++){
                if(!list[k].visited){
                     if(finnSykel(list[k], list[k], "")){
                         break;
                     }
                }
            }
        }
    }

    static Boolean finnSykel(Task current, Task slutt, String string){
        current.visited = true;
        string += current.name + " --> ";
        for(Task nabo : current.outEdges){
            if(nabo == slutt){
                System.out.println("This is one cycle: " + string);
                return true;
            }
            if(!nabo.visited){
                finnSykel(nabo, slutt, string);
            }
        }
        return false;
    }

    /*static void finnLengste(PriorityQueue<Task> starts, Taks[] tasks){

        for(Task start : starts){
            for(int i = 0; i < tasks.length; i++){

            }
        }
    }*/

    static PriorityQueue<Task> findStart (Task[] list){
        PriorityQueue<Task> output = new PriorityQueue(new TaskComparator());
        for (int i = 0; i < list.length; i++){
            if (list[i].cntPredecessors == 0){
                output.add(list[i]);
            }
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        String filename = args[0];
        Scanner in = new Scanner(new File(filename));

        int n = in.nextInt();
        Task[] tasks = new Task[n];


        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(i + 1);
        }

        for (int i = 0; i < n; i++) {
            int id = in.nextInt();
            Task task = tasks[id - 1];
            task.name = in.next();
            task.time = in.nextInt();
            task.staff = in.nextInt();

            while (true) {
                int dep = in.nextInt();
                if (dep == 0) {
                    break;
                }
                tasks[dep - 1].addEdge(task);
                tasks[id - 1].cntPredecessors++;
            }
        }
        //findCycle(tasks);
        PriorityQueue<Task> sort = findStart(tasks);
        printSchedule(sort, tasks);


    }
}
