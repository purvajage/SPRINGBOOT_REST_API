package spring.project.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import spring.project.entity.ToDo;


@Repository
public interface ToDoRepository extends PagingAndSortingRepository<ToDo, Long> {
}
