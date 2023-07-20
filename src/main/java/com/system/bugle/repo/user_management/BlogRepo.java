package com.system.bugle.repo.user_management;

import com.system.bugle.entity.user_management.Blog;
import com.system.bugle.entity.user_management.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long> {
    // Additional custom query methods can be defined here if needed
    @Query(value = "select * from blog where uemail=?1", nativeQuery = true)
    List<Blog> findByUemail(String email);
}
