package com.petro.apiary.domain.repository;

import com.petro.apiary.domain.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByLoginAndPassAndRemoveDateIsNull(String login, String pass);

    User findByIdAndRemoveDateIsNull(Long Id);


}
