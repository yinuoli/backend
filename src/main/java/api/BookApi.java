package api;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import template.Book.Book;
import template.Book.BookDao;
import template.Constant;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/book")
public class BookApi {
    private BookDao dao;
    private static final Logger LOG = LoggerFactory.getLogger(BookApi.class);

    @Path("/all")
    @GET
    public String getAllBooks() {
        String result;
        try {
            List<Book> list = dao.getAllBook();
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

    @Path("/post")
    @POST
    public String postBook(String request) {
        Book book;
        Gson gson = new Gson();
        try {
            book = gson.fromJson(request, Book.class);
            if (book == null) {
                throw new NullPointerException();
            }
            if (!book.validate()) {
                throw new Exception();
            }
            dao.insert(book);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return Constant.FAIL;
        }
        return Constant.SUCCESS;
    }

    public void setDao(BookDao dao) {
        this.dao = dao;
    }
}
