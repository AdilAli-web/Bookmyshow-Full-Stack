package com.cfs.SpringBootP05.repository;

import com.cfs.SpringBootP05.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRespository extends JpaRepository<Student,Long> {
}
