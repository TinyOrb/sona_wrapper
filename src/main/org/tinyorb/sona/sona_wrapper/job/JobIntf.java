package org.tinyorb.sona.sona_wrapper.job;


public interface JobIntf<Job> {
    public void add(Job job);
    public void execute();
}