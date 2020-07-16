package com.arthur.blog.repo;

import com.arthur.blog.domain.BlogPost;
import com.arthur.blog.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepo extends CrudRepository<BlogPost, Long> {
    BlogPost getById(Long id);
    BlogPost getByTitle(String title);

    List<BlogPost> getAllByCreatedByAndOrderOrderByCreatedDate(User user);
}
