import User.TestApi;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class BackendService extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new BackendService().run(args);
    }

    public void run(Configuration configuration, Environment environment) throws Exception {
        final TestApi testApi = new TestApi();

        environment.jersey().register(testApi);

        FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORSFilter", CrossOriginFilter.class);

        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
    }
}
