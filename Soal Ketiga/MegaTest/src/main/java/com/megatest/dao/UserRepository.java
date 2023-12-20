package com.megatest.dao;

import com.megatest.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("""
            SELECT new com.megatest.model.Users(
                us.id,
                us.username,
                us.password
            )
            FROM Users AS us
            WHERE us.username = :username
            """)
    public Users getUser(@Param("username") String username);
}
