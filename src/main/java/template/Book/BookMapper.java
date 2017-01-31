package template.Book;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements ResultSetMapper<Book> {
    public Book map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return null;
    }
}
