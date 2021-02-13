import java.util.*;

// Given the profits and deadlines
// of n jobs
// Every job takes one unit of time
// Find the maximum profit if
// only one job can be done at a time
public class job_scheduling {

    // class representing each job
    public static class Job {
        Integer profit;
        Integer deadline;

        public Job(int p, int d) {
            profit = p;
            deadline = d;
        }

        @Override
        public String toString() {
            return "(" + profit  + " " + deadline + ")";
        }
    }

    public static int js(int[] profits, int[] deadlines) {
        
        // create a list of jobs
        LinkedList<Job> job_list = new LinkedList<>();
        for (int i=0; i<profits.length; i++) {
            job_list.add(new Job(profits[i], deadlines[i]));
        }
        // sort the list of jobs in decreasing order of profit
        Collections.sort(job_list, new Comparator<Job>(){
            @Override
            public int compare(job_scheduling.Job arg0, job_scheduling.Job arg1) {
                return arg1.profit.compareTo(arg0.profit);
            }
        });
        // initialize a boolean array for each time slot
        // initially each element will have false value
        boolean[] job_done = new boolean[job_list.size()];
        //
        int total_profit = 0;

        // at each step we pick the job with highest profit
        // and check if it can be done
        for (int i=0; i<job_list.size(); i++) {

            int curr_profit = job_list.get(i).profit;
            int curr_deadline = job_list.get(i).deadline;

            for (int j=curr_deadline-1; j>=0; j--) {
                // check if time slot j is empty
                // if it is empty we can do the job i
                if (!job_done[j]) {
                    job_done[j] = true;
                    total_profit = total_profit+curr_profit;
                    System.out.println(job_list.get(i));
                    break;
                }
            }
        }

        return total_profit;
    }

    public static void main(String[] args) {

        int[] PROFITS = {200,180,190,300,120,100};
        int[] DEADLINES = {5,3,3,2,4,2};

        int max_profit = js(PROFITS,DEADLINES);

        System.out.println("MAXIMUM PROFIT : " + max_profit);
        //js(PROFITS,DEADLINES);
    }
}