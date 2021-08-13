package com.yekrik.poc.sso.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="users")
public class User {

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;
        @Column(name = "uuid")
        private UUID uuid;
        @Column(name = "login")
        private String login;
        @Column(name = "email")
        private String email;

        public User(UUID uuid, String login, String email) {
                this.uuid = Objects.requireNonNull(uuid);
                this.login = Objects.requireNonNull(login);
                this.email = Objects.requireNonNull(email);
        }

        public User(String login, String email) {
                this(UUID.randomUUID(), login, email);
        }

        public static User build(String login, String email) {
                return new User(login, email);
        }

        public Long getId() {
                return id;
        }

        public UUID getUuid() {
                return uuid;
        }

        public String getLogin() {
                return login;
        }

        public String getEmail() {
                return email;
        }
}
