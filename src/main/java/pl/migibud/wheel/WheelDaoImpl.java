package pl.migibud.wheel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class WheelDaoImpl implements WheelDao {

    private final SessionFactory sessionFactory;

    @Override
    public <S extends Wheel> S save(S entity) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction=entityManager.getTransaction();
            if (!transaction.isActive()){
                transaction.begin();
            }
            entityManager.persist(entity);
            transaction.commit();
            return entity;
        }catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
            return null;
        }finally {
            if (entityManager!=null){
                entityManager.close();
            }
        }
    }

    @Override
    public Optional<Wheel> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Wheel> findAll() {
        return null;
    }

    @Override
    public void delete(Wheel entity) {

    }
}
