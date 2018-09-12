package com.lizhi.repository;

import com.lizhi.bean.Usersss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usersss,String> {
    Usersss findByUsername(String username);
}
