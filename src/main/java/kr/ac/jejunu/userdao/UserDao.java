package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(Integer id) throws  SQLException {
       StatementStrategy statementStrategy = connection -> {
           PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
           preparedStatement.setLong(1, id);
           return preparedStatement;
       };
       return jdbcContext.jdbcContextForGet(statementStrategy);
    }
    public void insert(User user) throws SQLException {
        StatementStrategy statementStrategy =connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("inset into userinfo (name, password) values (?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            return preparedStatement;
        };
        jdbcContext.jdbcContextForinsert(user, statementStrategy);
    }
    public void update(User user) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("Updtae userinfo set name =?,password=?,where id =? ");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getId());
            return preparedStatement;
        };
        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

    public void delete(Integer id) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("delete from userinfo where id=?");
            preparedStatement.setInt(1, id);
            return preparedStatement;
        };

        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }


}