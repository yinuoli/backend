package api;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import template.Constant;
import template.User.User;
import template.User.UserDao;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/user")
public class UserApi {
    private UserDao dao;
    private static final Logger LOG = LoggerFactory.getLogger(UserApi.class);

    @Path("/register")
    @POST
    public String register(String request) {
        User user;
        Gson gson = new Gson();
        try {
            user = gson.fromJson(request, User.class);
            user.setId(Constant.generateUUID());
            if (!user.validate()) {
                return Constant.NOTVALID;
            }
            dao.insert(user);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return Constant.FAIL;
        }
        return Constant.SUCCESS;
    }

    @Path("/login")
    @POST
    public String login(String request) {
        User potential;
        Gson gson = new Gson();
        User user;
        try {
            potential = gson.fromJson(request, User.class);
            user = dao.getUserByEmail(potential.getEmail());
            if (!user.getPassword().equals(potential.getPassword())) {
                return Constant.FAIL;
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return Constant.FAIL;
        }
        return user.getId();
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }
}
