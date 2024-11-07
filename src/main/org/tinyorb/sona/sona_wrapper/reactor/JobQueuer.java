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
    
    static Queue<JobIntf> JobQueue = new LinkedList<>();

    synchronized static void enqueSimpleHttpJob(SimpleJob<Http> job) {
        JobIntf<Http> ajob = job;
        JobQueue.add(ajob);
    }

    synchronized static void enqueSimpleLogJob(SimpleJob<Log> job) {
        JobIntf<Log> ajob = job;
        JobQueue.add(job);
    }

    synchronized public JobIntf peekJob() {
        return JobQueue.peek();
    }

    public JobIntf retrieveJob() {
        return JobQueue.poll();
    }
}