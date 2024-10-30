package org.tinyorb.sona.sona_wrapper.job.category;

import org.tinyorb.sona.sona_wrapper.job.JobIntf;
import java.util.ArrayList;
import java.util.List;

public class MultiTaskJob <Job> implements JobIntf <Job> {
    List<Job> job_list = new ArrayList<Job>();
    
    @Override
    public void execute() {
        System.out.println("MultiTask Job");
    }

    @Override
    public void add(Job job) {
        job_list.add(job);
    }

    public void abort() {

    }
}