package org.tinyorb.sona.sona_wrapper.job.category;

import org.tinyorb.sona.sona_wrapper.job.JobIntf;

public class SimpleJob<Task> implements JobIntf<Task> {
    private Task task;

    @Override
    public void execute() {
        System.out.println("Simple Job");
    }

    public void abort() {

    }

    @Override
    public void add(Task task) {
        this.task = task;
    }
}