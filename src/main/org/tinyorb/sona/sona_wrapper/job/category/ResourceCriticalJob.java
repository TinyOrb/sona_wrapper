package org.tinyorb.sona.sona_wrapper.job.category;

import org.tinyorb.sona.sona_wrapper.job.JobIntf;

public class ResourceCriticalJob<Task> implements JobIntf<Task> {
    private Task task;

    @Override
    public void execute() {
        System.out.println("Resource Critical Job");
    }

    @Override
    public void add(Task task) {
        this.task = task;
    }

    public void abort() {
        this.rollback();
    }

    private void rollback() {

    }
}