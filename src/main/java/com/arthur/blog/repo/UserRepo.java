package com.arthur.blog.repo;

import com.arthur.blog.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    User getById(Long id);

    User getByEmail(String email);

    List<User> getAllByIdNotNull();

   // List<User> getAllByUser(int userID);

    // Iterable<User> findAllById(Iterable<Long> id);

}
