package com.yekrik.poc.sso.dao;

import com.yekrik.poc.sso.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Should load a freshly created User")
    public void test() {
        User user = User.build("test_user","test@test.fr");
        entityManager.persist(user);
        entityManager.flush();

        Optional<User> result = userRepository.findById(user.getId());

        assertThat(result).isNotEmpty();
        assertEquals(user, result.get());
    }

}