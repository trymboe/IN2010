import java.util.Comparator;

public class TaskComparator implements Comparator<Task>{
    
    public int compare(Task t1, Task t2){
        if (t1.time > t2.time){
            return 1;
        }
        else if (t1.time < t2.time){
            return -1;
        }
        return 0;
    }
}