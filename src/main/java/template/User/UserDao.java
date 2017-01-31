package template.User;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import javax.validation.Valid;
import java.util.List;

@RegisterMapper(UserMapper.class)

public interface UserDao {
    @SqlUpdate("insert into user values (:id, :email, :password, :name)")
    void insert(@BindBean User user);

    @SqlQuery("select * from user where email = :email")
    User getUserByEmail(@Bind("email") String email);
}