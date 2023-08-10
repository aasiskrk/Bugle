package com.system.bugle.repo.user_management;

import com.system.bugle.entity.user_management.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepo extends JpaRepository<Tags, Long> {
}
