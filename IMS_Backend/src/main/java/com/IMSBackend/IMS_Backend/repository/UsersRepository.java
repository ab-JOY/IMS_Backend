package com.IMSBackend.IMS_Backend.repository;

import com.IMSBackend.IMS_Backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
    @Query(value = "select * from users where username =?1", nativeQuery = true)
    Optional<Users> findByUserName(String Username);
}
