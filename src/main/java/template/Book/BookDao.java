package template.Book;

import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(BookMapper.class)

public interface BookDao {

}