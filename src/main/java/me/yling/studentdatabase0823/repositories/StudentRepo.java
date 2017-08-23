package me.yling.studentdatabase0823.repositories;

import me.yling.studentdatabase0823.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository <Student, Long> {
}
