package org.tinyorb.sona.sona_wrapper;

import org.tinyorb.sona.sona_wrapper.job.type.TaskIntf;
import org.tinyorb.sona.sona_wrapper.reactor.JobQueuer;
import org.tinyorb.sona.sona_wrapper.job.category.CategoryName;
import org.tinyorb.sona.sona_wrapper.job.category.SimpleJob;
import java.util.List;
import java.lang.Thread;

public class Main extends Thread implements Runnable {
    private static Main main_instance = new Main();
    private static boolean close = false;
    
    public static synchronized Main get_instance() {
        return main_instance;
    }

    private Main() {

    }

    public <Job> void dispatch(Job job, CategoryName categoryName) {
        
    }

    public <Job> Job jobBuilder(TaskIntf task) {
        return (Job) new SimpleJob();
    }

    public <Job> Job jobBuilder(List<TaskIntf> task) {
        return (Job) new SimpleJob();
    }

    public void poller() {
        start();
    }

    public static void closeGracefully() {
        close = true;
    }

    public String status() {
        if (isAlive()) {
            return "Poll is running";
        } else {
            return "Poll is not running";
        }
    }

    @Override
    public void run() {
        System.out.println("Poller started...");
        while(!close) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Do nothing
            }
        }
    }

}