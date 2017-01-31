package template.Seller;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerMapper implements ResultSetMapper<Seller> {
    public Seller map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Seller(resultSet.getString("id"),
                resultSet.getString("sellerId"),
                resultSet.getString("bookId"));
    }
}
