package rambookapp.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import rambookapp.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
}