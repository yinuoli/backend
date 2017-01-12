package User;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/user")
public class TestApi {
    private List<User> userList;
    static final Logger LOG = LoggerFactory.getLogger(TestApi.class);

    public TestApi() {
        userList = new ArrayList<User>();
        userList.add(new User("test@test.com", "12345678"));
        userList.add(new User("anonymous@test.com", "00001111"));
    }

    @GET
    @Path("/all_user_list")
    public String getUserList() {
        Gson gson = new Gson();
        String result;
        try {
            result = gson.toJson(userList);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return "FAIL";
        }
        if (result == null) {
            return "FAIL";
        }
        return result;
    }
}
