package connectivity;

import shopLogic.User;

import java.math.BigDecimal;
import java.sql.*;

public class ConnectionClass {
    private String url = "jdbc:mysql://localhost/shop?serverTimezone=Europe/Moscow&useSSL=false";
    private String user = "root";
    private String password = "";
    private Connection connection;
    private User currentUser;


    public ConnectionClass() throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public ResultSet execQuery(String sql) throws SQLException {
        Statement statement = this.connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        return res;
    }

    public void  execUpdate(String sql) throws SQLException{
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

    public ResultSet addToGoods(String GNAME, String GPRICE, String GVENDOR_CODE,
                            String GPLACE, int GQUAINTITY, int GTYPE) throws SQLException {
        String sql = "{CALL ADDTOGOODS(?, ?, ?, ?, ?, ?)}";
        CallableStatement callableStatement = connection.prepareCall(sql);
        callableStatement.setString(1, GNAME);
        callableStatement.setString(2, GPRICE);
        callableStatement.setString(3, GVENDOR_CODE);
        callableStatement.setString(4, GPLACE);
        callableStatement.setInt(5, GQUAINTITY);
        callableStatement.setInt(6, GTYPE);
        ResultSet res = callableStatement.executeQuery();
        return res;
    }
    // function returns the access level in case of lucky log in, -1 otherwise
    public int login(String login, String password) throws SQLException {
        String sql = "{CALL loginToDb(?, ?)}";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet res = statement.executeQuery();
        if(res.next()){   
            return res.getInt(3);
        }else {
            return -1;
        }
    }
    public ResultSet getReceiptView(String code) throws SQLException {
        String sql = "SELECT * FROM receipt_view where GVENDOR_CODE ="+ code +  ";";
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        return res;
    }

     public void closeConnection() throws SQLException {
        connection.close();
    }



}
