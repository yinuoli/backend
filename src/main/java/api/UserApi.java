package api;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import template.Book.Book;
import template.Book.BookDao;
import template.Constant;
import template.User.User;
import template.User.UserDao;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/user")
public class UserApi {
    private static final Logger LOG = LoggerFactory.getLogger(UserApi.class);
    private UserDao userDao;
    private BookDao bookDao;

    @Path("/all")
    @GET
    public String getAllUser() {
        String result;
        try {
            List<User> list = userDao.getAllUser();
            if (list.size() == 0) {
                return Constant.EMPTY;
            }
            Gson gson = new Gson();
            result = gson.toJson(list);
            if (result == null) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return Constant.FAIL;
        }
        return result;
    }

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
            userDao.insert(user);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return Constant.FAIL;
        }
        return Constant.SUCCESS;
    }

    @Path("/login")
    @POST
    public String login(String request) {
        Gson gson = new Gson();
        String result;
        try {
            User potential = gson.fromJson(request, User.class);
            User user = userDao.getUserByEmail(potential.getEmail());
            if (!user.getPassword().equals(potential.getPassword())) {
                return Constant.FAIL;
            }
            result = gson.toJson(user);
            if (result == null) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return Constant.FAIL;
        }
        return result;
    }

    @Path("/my_book/{user_id}")
    @GET
    public String getMyBooks(@PathParam("user_id") String userId) {
        String result;
        try {
            User user = userDao.getUserById(userId);
            if (!user.validate()) {
                throw new Exception();
            }
            List<Book> books = bookDao.getBooksByUser(userId);
            if (books.size() == 0) {
                return Constant.EMPTY;
            }
            Gson gson = new Gson();
            result = gson.toJson(books);
            if (result == null) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return Constant.FAIL;
        }
        return result;
    }

    public void setDao(UserDao userDao, BookDao bookDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
    }
}
