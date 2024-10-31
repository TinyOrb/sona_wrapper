package org.tinyorb.sona.sona_wrapper.job.type;

import org.tinyorb.sona.sona_wrapper.job.JobIntf;
import org.tinyorb.sona.sona_wrapper.job.type.TaskIntf;

public class Http implements TaskIntf {

    public void execute(){
        System.out.println("Http Job");
    }
}