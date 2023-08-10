package com.system.bugle;

import com.system.bugle.entity.user_management.Blog;
import com.system.bugle.repo.user_management.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BlogRepoTests {

    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @Rollback(value = false)
    public void saveBlogTest() {
        Blog blog = new Blog();
        blog.setTitle("Sample Blog");
        blog.setAuthor("John Doe");
        blog.setContent("This is a sample blog content");

        Blog savedBlog = blogRepo.save(blog);
        assertThat(savedBlog.getId()).isNotNull();
    }

    @Test
    public void findByUemailTest() {
        Blog blog1 = new Blog();
        blog1.setTitle("Blog 1");
        blog1.setAuthor("Author 1");
        blog1.setContent("Content 1");
        blog1.setUemail("user1@example.com");

        Blog blog2 = new Blog();
        blog2.setTitle("Blog 2");
        blog2.setAuthor("Author 2");
        blog2.setContent("Content 2");
        blog2.setUemail("user2@example.com");

        entityManager.persist(blog1);
        entityManager.persist(blog2);

        List<Blog> blogsForUser1 = blogRepo.findByUemail("user1@example.com");
        assertThat(blogsForUser1.size()).isEqualTo(1);
        assertThat(blogsForUser1.get(0).getTitle()).isEqualTo("Blog 1");
    }
}
