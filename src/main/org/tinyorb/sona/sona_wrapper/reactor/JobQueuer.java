package org.tinyorb.sona.sona_wrapper.reactor;

import org.tinyorb.sona.sona_wrapper.job.JobIntf;
import org.tinyorb.sona.sona_wrapper.job.type.Http;
import org.tinyorb.sona.sona_wrapper.job.type.Log;
import org.tinyorb.sona.sona_wrapper.job.category.SimpleJob;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class JobQueuer {
    // JobIntf<Http> simpleHttpJob = new SimpleJob<Http>();
    
    static Queue<SimpleJob> simpleJobQueue = new LinkedList<SimpleJob>();

    synchronized static void enqueSimpleHttpJob(SimpleJob<Http> job) {
        JobQueuer.simpleJobQueue.add(job);
    }

    synchronized static void enqueSimpleLogJob(SimpleJob<Log> job) {
        JobQueuer.simpleJobQueue.add(job);
    }

    synchronized public JobIntf peekJob() {
        return simpleJobQueue.peek();
    }

    public JobIntf retrieveJob() {
        return simpleJobQueue.poll();
    }
}