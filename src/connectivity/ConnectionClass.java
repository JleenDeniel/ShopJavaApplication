package connectivity;

import shopLogic.User;

import java.math.BigDecimal;
import java.sql.*;

public class ConnectionClass {
    private String url = "jdbc:mysql://localhost/shop?serverTimezone=Europe/Moscow&useSSL=false";
    private String user = "root";
    private String password = "1T0bms93g5gK";
    private Connection connection;
    private User currentUser;


    public ConnectionClass() throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public void execQuery(String sql) throws SQLException {
        Statement statement = this.connection.createStatement();
        statement.executeUpdate(sql);
    }

    public void addToStaff(String SNAME, String SURNAME, String EMAIL, String SPOSITION, int SACCESS_LVL,
                           int SALARY, String DATE, String PASSWORD) throws SQLException {
        String sql = "{CALL ADDTOSTAFF(?,?,?,?,?,?,?,?)}";
        CallableStatement callableStatement = connection.prepareCall(sql);
        callableStatement.setString(1, SNAME);
        callableStatement.setString(2, SURNAME);
        callableStatement.setString(3, EMAIL);
        callableStatement.setString(4, SPOSITION);
        callableStatement.setInt(5, SACCESS_LVL);
        callableStatement.setBigDecimal(6, BigDecimal.valueOf(SALARY));
        callableStatement.setDate(7, Date.valueOf(DATE));
        callableStatement.setString(8, PASSWORD);
        callableStatement.executeQuery();
    }

    public void addToGoods(String GNAME, String GPRICE, String GVENDOR_CODE,
                           String GEXPIRE_DATE, String GPLACE, int GQUAINTITY, int GTYPE) throws SQLException {
        String sql = "{CALL ADDTOGOODS(?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement callableStatement = connection.prepareCall(sql);
        callableStatement.setString(1, GNAME);
        callableStatement.setString(2, GPRICE);
        callableStatement.setString(3, GVENDOR_CODE);
        callableStatement.setDate(4, Date.valueOf(GEXPIRE_DATE));
        callableStatement.setString(5, GPLACE);
        callableStatement.setInt(6, GQUAINTITY);
        callableStatement.setInt(7, GTYPE);
        callableStatement.executeQuery();
    }
    public boolean login(String login, String password) throws SQLException {
        String sql = "{CALL loginToDb(?, ?)}";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet res = statement.executeQuery();
        if(res.next()){
           //todo currentUser.setEmail();
            return true;
        }else {
            return false;
        }
    }



}
