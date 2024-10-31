package org.tinyorb.sona.sona_wrapper.job;


public interface JobIntf<Task> {
    public void add(Task task);
    public void execute();
}