package com.example.stratyp.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.stratyp.user.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can define custom query methods here if needed

    @Query
    Optional<User> findByUsername(String username);


    @Query("SELECT U FROM User U WHERE U.kvd_sg.id =:userKvdId")
    List<User> getAllAsgUsers(@Param("userKvdId") Long userKvdId);

 }