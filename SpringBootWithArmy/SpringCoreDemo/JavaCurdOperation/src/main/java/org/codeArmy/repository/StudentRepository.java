package org.codeArmy.repository;

import org.codeArmy.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    public StudentEntity save(StudentEntity studentEntity);

    public Optional<StudentEntity> findById(Long id);

    public List<StudentEntity> findAll();
}
