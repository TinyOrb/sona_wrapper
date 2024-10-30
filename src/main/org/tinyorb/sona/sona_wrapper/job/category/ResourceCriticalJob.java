package org.tinyorb.sona.sona_wrapper.job.category;

import org.tinyorb.sona.sona_wrapper.job.JobIntf;

public class ResourceCriticalJob<Job> implements JobIntf<Job> {
    private Job job;

    @Override
    public void execute() {
        System.out.println("Resource Critical Job");
    }

    @Override
    public void add(Job job) {
        this.job = job;
    }

    public void abort() {
        this.rollback();
    }

    private void rollback() {

    }
}