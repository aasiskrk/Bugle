package com.system.bugle;

import com.system.bugle.entity.user_management.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTests {

    @Test
    public void testUserEntity() {
        User user = User.builder()
                .fullName("John Doe")
                .email("john.doe@example.com")
                .password("password")
                .image("profile.jpg")
                .build();

        assertThat(user.getId()).isNull(); // ID should be null before saving
        assertThat(user.getFullName()).isEqualTo("John Doe");
        assertThat(user.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(user.getPassword()).isEqualTo("password");
        assertThat(user.getImage()).isEqualTo("profile.jpg");
        assertThat(user.getImageBase64()).isNull(); // Transient field, should be null
        assertThat(user.getAuthorities()).isNull(); // Should return null
        assertThat(user.getUsername()).isEqualTo("john.doe@example.com");
        assertThat(user.isAccountNonExpired()).isTrue();
        assertThat(user.isAccountNonLocked()).isTrue();
        assertThat(user.isCredentialsNonExpired()).isTrue();
        assertThat(user.isEnabled()).isTrue();
    }
}
