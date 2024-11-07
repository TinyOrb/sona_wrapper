package wrapper;

import io.cucumber.java8.En;
import static org.junit.Assert.assertEquals;
import org.tinyorb.sona.sona_wrapper.Main;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class StepPoll implements En {

    @Before
    public void setUp() {
        System.out.println("Setting up...");
        Main poller = Main.get_instance();
        poller.poller();
    }

    @After
    public void tearDown() {
        System.out.println("Tearing down system");
        Main poller = Main.get_instance();
        poller.closeGracefully();
    }
    
    public StepPoll() {

        Then("It should be alive", ()-> {
            Main poller = Main.get_instance();
            // assertEquals(expected, actual);
            assertEquals(true, poller.isAlive());
        });

        Then("It should running", ()-> {
            Main poller = Main.get_instance();
            assertEquals("Poll is running", poller.status());
        });
    }
}