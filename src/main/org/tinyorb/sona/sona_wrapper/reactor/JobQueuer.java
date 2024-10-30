package org.tinyorb.sona.sona_wrapper;

import org.tinyorb.sona.sona_wrapper.job.JobIntf;
import org.tinyorb.sona.sona_wrapper.job.type.HttpJob;
import org.tinyorb.sona.sona_wrapper.job.type.LogJob;
import org.tinyorb.sona.sona_wrapper.job.category.SimpleJob;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class JobQueuer {
    // JobIntf<HttpJob> simpleHttpJob = new SimpleJob<HttpJob>();
    
    static Queue<SimpleJob> simpleJobQueue = new LinkedList<SimpleJob>();

    synchronized static void enqueSimpleHttpJob(SimpleJob<HttpJob> job) {
        JobQueuer.simpleJobQueue.add(job);
    }

    synchronized static void enqueSimpleLogJob(SimpleJob<LogJob> job) {
        JobQueuer.simpleJobQueue.add(job);
    }

    synchronized public JobIntf peekJob() {
        return simpleJobQueue.peek();
    }

    public JobIntf retrieveJob() {
        return simpleJobQueue.poll();
    }
}