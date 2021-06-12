package dao;

import entity.SoftdrinkUserBar;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class SoftdrinkUserBarDAO {

    private static final String USER_FILDS= "UserBarSoftdrinkId";
    private static final String QUERY_FIND_ALL="SELECT * FROM softdrink_user_bar";
    private static final String QUERY_FIND_BY_ID="SELECT * FROM softdrink_user_bar where id = ?";
    private static final String INSERT_SQL = "INSERT INTO softdrink_user_bar(" + USER_FILDS + ") VALUES(?)";
    private static final String DELETE = "DELETE FROM softdrink_user_bar WHERE id = ?";

    public  void deleteSoftdrinkUserBar(int id) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Integer createSoftdrinkUserBar(SoftdrinkUserBar softdrinkUserBar) throws SQLException {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setInt(1, softdrinkUserBar.getUserBarSoftdrinkId());


            return preparedStatement.executeUpdate();
        }
    }

    public  SoftdrinkUserBar findById(int id) throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_BY_ID);
        ) {
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
                SoftdrinkUserBar softdrinkUserBar = new SoftdrinkUserBar();
                softdrinkUserBar.setUserBarSoftdrinkId(resultSet.getInt("UserBarSoftdrinkId"));

                return softdrinkUserBar;
            }
            return null;

        }}

    public  List<SoftdrinkUserBar> findAll() throws SQLException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <SoftdrinkUserBar> softdrinkUserBars = new ArrayList<>();

            while (resultSet.next()) {
                SoftdrinkUserBar softdrinkUserBar = new SoftdrinkUserBar();
                int UserBarSoftdrinkId = resultSet.getInt("UserBarSoftdrinkId");
                softdrinkUserBar.setUserBarSoftdrinkId(UserBarSoftdrinkId);
                softdrinkUserBars.add(softdrinkUserBar);
            }
            return softdrinkUserBars;
        }

    }
}

