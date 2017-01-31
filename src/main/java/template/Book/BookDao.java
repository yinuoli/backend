package template.Book;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import java.util.List;

@RegisterMapper(BookMapper.class)

public interface BookDao {
    @SqlUpdate("insert into book values (:id, :title, :title, :author, :code, :price, :description, :seller)")
    void insert(@BindBean @Valid Book book);

    @SqlQuery("select * from book")
    List<Book> getAllBook();

    @SqlUpdate("delete from book where id = :id")
    void deleteBookById(@Bind("id") String id);
}