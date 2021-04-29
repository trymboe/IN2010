import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Task {
    int id, time, staff, distance;
    String name;
    Boolean critical = false;
    int earliestStart, latestStart;
    List <Task> outEdges = new ArrayList<Task>();
    int cntPredecessors;
    boolean visited = false;

    Task(int id){
        this.id = id;
        distance = 0;
    }

    public void addEdge(Task nabo){
        outEdges.add(nabo);
    }

    public PriorityQueue<Task> checkReadyTasks(){
        PriorityQueue<Task> output = new PriorityQueue(new TaskComparator());
        for (Task t : outEdges){
            t.cntPredecessors --;
            if (t.cntPredecessors == 0){
                output.add(t);
            }
        }
        return output;
    }

    public void doWork(int t){
        time -= t;
    }

    public void setEarliestStart(int time){
        earliestStart = time;
    }

    public void setLatestStart(int time){
        latestStart = time;
    }

}
