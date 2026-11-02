package org.codeArmy.repository;

import org.codeArmy.entity.StudentEntity;
import org.codeArmy.mapper.StudentRowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;
//    private final StudentRowMapper rowMapper = new StudentRowMapper();

    private RowMapper<StudentEntity> rowMapper = new BeanPropertyRowMapper<>(StudentEntity.class);


    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CREATE
    public void createUser(StudentEntity student) {
        String sql = "INSERT INTO STUDENT_ENTITY(NAME, EMAIL, AGE) VALUES (?, ?, ?)";
        int rowAffected = jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getAge());
        if (rowAffected == 1) System.out.println("Create Operation successful..");
    }

    // UPDATE
    public void updateUser() {
        String sql = "UPDATE STUDENT_ENTITY SET NAME = ?, EMAIL = ?, AGE = ? WHERE ID = ?";
        int rowAffected = jdbcTemplate.update(sql, "Prasad", "prasad@gmail.com", 23, 1);
        if (rowAffected == 1) System.out.println("Update Operation successful..");
    }

    // DELETE
    public void deleteUser() {
        String sql = "DELETE FROM STUDENT_ENTITY WHERE ID = ?";
        int rowAffected = jdbcTemplate.update(sql, 1);
        if (rowAffected == 1) System.out.println("Delete Operation successful..");
    }

    // READ
    /*
    public void getUserById() {
        String sql = "SELECT id, name, email, age FROM STUDENT_ENTITY WHERE ID = ?";
        StudentEntity student = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> mapRow(rs), 1);
        System.out.println(student.getId() + " : " + student.getEmail() + " : " + student.getAge() + " : " + student.getName());
    }

    // COMPLETE CRUD (READ ALL)
    public void completeCURD() {
        String sql = "SELECT id, name, email, age FROM STUDENT_ENTITY WHERE ID = ?";
        List<StudentEntity> students = jdbcTemplate.query(sql, (rs, rowNum) -> mapRow(rs), 1);
        if (!students.isEmpty()) {
            System.out.println("Reading....");
            for (StudentEntity student : students) System.out.println(student.getName());
        }
    }
     */

    public List<StudentEntity> getStudent() {
        String sql = """
                SELECT ID, NAME, AGE FROM STUDENT_ENTITY;
                """;
        List<StudentEntity> studentEntities = jdbcTemplate.query(sql, new StudentRowMapper());
        System.out.println(studentEntities);
        return studentEntities;
    }

    // READ
    public void getUserById() {
        String sql = "SELECT id, name, email, age FROM STUDENT_ENTITY WHERE ID = ?";
        StudentEntity student = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(student.getName());
    }

    // READ ALL
    public void completeCURD() {
        String sql = "SELECT id, name, email, age FROM STUDENT_ENTITY";
        List<StudentEntity> students = jdbcTemplate.query(sql, rowMapper);

        for (StudentEntity student : students) {
            System.out.println(student.getName());
        }
    }

    // ROW MAPPER
    private StudentEntity mapRow(ResultSet rs) throws SQLException {
        StudentEntity student = new StudentEntity(0, null, null);
        student.setId(rs.getLong("id"));
        student.setName(rs.getString("name"));
        student.setAge(rs.getInt("age"));
        student.setEmail(rs.getString("email"));
        return student;
    }
}
