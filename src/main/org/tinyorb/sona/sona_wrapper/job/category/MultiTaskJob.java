package org.tinyorb.sona.sona_wrapper.job.category;

import org.tinyorb.sona.sona_wrapper.job.JobIntf;
import java.util.ArrayList;
import java.util.List;

public class MultiTaskJob <Task> implements JobIntf <Task> {
    List<Task> job_list = new ArrayList<Task>();
    
    @Override
    public void execute() {
        System.out.println("MultiTask Job");
    }

    @Override
    public void add(Task task) {
        job_list.add(task);
    }

    public void abort() {

    }
}