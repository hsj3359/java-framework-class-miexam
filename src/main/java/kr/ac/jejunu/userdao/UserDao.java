package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(Integer id) throws  SQLException {
       StatementStrategy statementStrategy = new GetStatememntStategy(id);
       return jdbcContext.jdbcContextForGet(statementStrategy);
    }
    public void insert(User user) throws SQLException {
        StatementStrategy statementStrategy = new InsertStatementStarategy(user);
        jdbcContext.jdbcContextForinsert(user, statementStrategy);
    }
    public void update(User user) throws SQLException {
        StatementStrategy statementStrategy = new UpdateStatementStrategy(user);
        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

    public void delete(Integer id) throws SQLException {
        StatementStrategy statementStrategy = new DeleteStatementStrategy(id);
        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }


}