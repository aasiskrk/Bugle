package com.system.bugle.repo.user_management;

import com.system.bugle.entity.user_management.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long> {
    // Additional custom query methods can be defined here if needed
}
