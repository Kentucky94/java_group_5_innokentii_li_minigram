package com.example.minigram.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoty extends JpaRepository<User, Integer> {
}
