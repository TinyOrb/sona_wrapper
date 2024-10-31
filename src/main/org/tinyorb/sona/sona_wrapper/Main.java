package org.tinyorb.sona.sona_wrapper;

import org.tinyorb.sona.sona_wrapper.job.type.TaskIntf;
import org.tinyorb.sona.sona_wrapper.reactor.JobQueuer;
import org.tinyorb.sona.sona_wrapper.job.category.CategoryName;
import org.tinyorb.sona.sona_wrapper.job.category.SimpleJob;
import java.util.List;

public class Main {

    public <Job> void dispatch(Job job, CategoryName categoryName) {
        
    }

    public <Job> Job jobBuilder(TaskIntf task) {
        return (Job) new SimpleJob();
    }

    public <Job> Job jobBuilder(List<TaskIntf> task) {
        return (Job) new SimpleJob();
    }

    public void poller() {

    }

}