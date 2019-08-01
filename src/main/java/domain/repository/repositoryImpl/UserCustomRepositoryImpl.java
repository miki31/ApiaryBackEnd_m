package domain.repository.repositoryImpl;

import domain.repository.UserCustomRepository;
import domain.repository.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    @PersistenceContext
    EntityManager entityManager;

}
