package org.tinyorb.sona.sona_wrapper.job.category;

import org.tinyorb.sona.sona_wrapper.job.JobIntf;

public class SimpleJob<Job> implements JobIntf<Job> {
    private Job job;

    @Override
    public void execute() {
        System.out.println("Simple Job");
    }

    public void abort() {

    }

    @Override
    public void add(Job job) {
        this.job = job;
    }
}