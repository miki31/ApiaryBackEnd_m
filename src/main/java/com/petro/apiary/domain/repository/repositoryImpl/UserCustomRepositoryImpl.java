package com.petro.apiary.domain.repository.repositoryImpl;

import com.petro.apiary.domain.repository.UserCustomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    @PersistenceContext
    EntityManager entityManager;

}
