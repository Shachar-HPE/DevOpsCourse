/**
 * Created by sameto on 12/04/2016.
 */
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import rest.DevopsServerResource;
import tasks.TaskStorage;

public class DevopsServerApplication extends Application<DevopsServerConfiguration> {
    public static void main(String[] args) throws Exception {
        new DevopsServerApplication().run(args);
    }

    private TaskStorage taskStorage;

    public DevopsServerApplication(){
        taskStorage = new TaskStorage();
    }

    @Override
    public String getName() {
        return "devops-server-course";
    }

    @Override
    public void initialize(Bootstrap<DevopsServerConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(DevopsServerConfiguration configuration,
                    Environment environment) {
        final DevopsServerResource resource = new DevopsServerResource(taskStorage);
        environment.jersey().register(resource);
    }

}