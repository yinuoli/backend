package template.Seller;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import java.util.List;

@RegisterMapper(SellerMapper.class)

public interface SellerDao {
    @SqlUpdate("insert into seller values (:id, :sellerId, :bookId)")
    void insert(@BindBean @Valid Seller seller);

    @SqlQuery("select * from seller where sellerId = :sellerId")
    List<Seller> getAllBook(@Bind("sellerId") String sellerId);

    @SqlUpdate("delete from seller where bookId = :bookId")
    void deleteSellerByBookId(@Bind("bookId") String bookId);
}