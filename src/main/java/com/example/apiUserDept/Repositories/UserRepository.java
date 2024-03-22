package com.example.apiUserDept.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiUserDept.entities.User.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
