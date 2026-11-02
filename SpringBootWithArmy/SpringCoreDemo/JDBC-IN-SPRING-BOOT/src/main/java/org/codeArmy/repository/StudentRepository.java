package org.codeArmy.repository;

import org.codeArmy.entity.StudentEntity;

import java.sql.*;

public class StudentRepository {
    String url = "jdbc:h2:mem:testdb";
    String username = "sa";
    String password = "";

    public void createUser(StudentEntity student) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();
//            String sql = "INSERT INTO STUDENT_ENTITY(NAME, EMAIL, AGE) VALUES " + "('HARISH', 'HARISHSEMWAL.COM', 21)";

            String sql = "INSERT INTO STUDENT_ENTITY(NAME, EMAIL, AGE) VALUES " + "(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());

//            int result = statement.executeUpdate(sql);
            int rowAffected = preparedStatement.executeUpdate();
//            if (result == 1) {
            if (rowAffected == 1) {
                System.out.println("Create Operation successful..");
            } else {
                System.out.println("Connection failed..");
            }

            System.out.println("Database connected Successfully.");
            connection.close();
        } catch (SQLException sqlException) {
            System.out.println("Database Connection failed..");
            sqlException.printStackTrace();
        }
    }

    public void updateUser() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "INSERT INTO STUDENT_ENTITY(NAME, EMAIL, AGE) VALUES " + "('Prasad', 'prasad@gmail.com', 23)";

            int result = statement.executeUpdate(sql);

            if (result == 1) {
                System.out.println("Update Operation successful..");
            } else {
                System.out.println("Update Connection failed..");
            }
            System.out.println("Database connected Successfully.");
            connection.close();
        } catch (SQLException sqlException) {
            System.out.println("Database Connection failed..");
            sqlException.printStackTrace();
        }
    }

    public void deleteUser() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "DELETE FROM STUDENT_ENTITY WHERE ID = 1";

            int result = statement.executeUpdate(sql);

            if (result == 1) {
                System.out.println("Delete Operation successful..");
            } else {
                System.out.println("Delete Connection failed..");
            }
            System.out.println("Database connected Successfully.");
            connection.close();
        } catch (SQLException sqlException) {
            System.out.println("Database Connection failed..");
            sqlException.printStackTrace();
        }
    }

    public void getUserById() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "SELECT id, name, email, age FROM STUDENT_ENTITY WHERE ID = 1";

            ResultSet result = statement.executeQuery(sql);
            result.next();

            StudentEntity studentEntity = mapRow(result);
            System.out.println(studentEntity.getId() + " : " + studentEntity.getEmail() + " : " + studentEntity.getAge() + " : " + studentEntity.getName());
            System.out.println("Database connected Successfully.");
            connection.close();
        } catch (SQLException sqlException) {
            System.out.println("Database Connection failed..");
            sqlException.printStackTrace();
        }
    }

    public void completeCURD() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT id, name, email, age FROM STUDENT_ENTITY WHERE ID = 1";
            boolean result = statement.execute(sql);
            if (result) {
                ResultSet resultSet = statement.getResultSet();
                System.out.println("Reading....");
            } else {
                int affectedRow = statement.getUpdateCount();
                System.out.println("Creating, Updating, Deleting... with count" + affectedRow);
            }

            connection.close();
        } catch (SQLException sqlException) {
            System.out.println("Database Connection failed..");
            sqlException.printStackTrace();
        }
    }

    private StudentEntity mapRow(ResultSet resultSet) throws SQLException {
        StudentEntity studentEntity = new StudentEntity(0, null, null);

        studentEntity.setId(resultSet.getLong("id"));
        studentEntity.setName(resultSet.getString("name"));
        studentEntity.setAge((int) resultSet.getLong("age"));
        studentEntity.setEmail(resultSet.getString("email"));

        return studentEntity;
    }
}
