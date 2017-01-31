import api.BookApi;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import template.Book.BookDao;
import template.Constant;

public class BackendService extends Application<Configuration> {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Constant.dbi = new DBI("jdbc:mysql://localhost/blog?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "root", "delivery");
        new BackendService().run(args);
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/", "/", "index.html", "intro"));
        bootstrap.addBundle(new AssetsBundle("/assets/pages/", "/explore", "main.html", "explore"));
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        final BookApi bookApi = new BookApi();

        bookApi.setDbi(Constant.dbi.onDemand(BookDao.class));

        environment.jersey().register(bookApi);
    }
}