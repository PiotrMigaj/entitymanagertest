package pl.migibud.car;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class CarDaoImpl implements CarDao {

    private final SessionFactory sessionFactory;

    @Override
    public <S extends Car> S save(S entity) {

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
                e.printStackTrace();
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
    public Optional<Car> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Car> findAll() {
        return null;
    }

    public List<Car> findAllCarsByWheelProducer(String producer) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction=entityManager.getTransaction();
            if (!transaction.isActive()){
                transaction.begin();
            }
            System.out.println("producer: "+producer);
            List<Car> resultList = entityManager
                    .createQuery("SELECT c FROM Car c JOIN c.wheels w WHERE w.producer=:producer", Car.class)
                    .setParameter("producer",producer)
                    .getResultList();
            System.out.println(resultList);
            transaction.commit();
            return Collections.unmodifiableList(resultList);
        }catch (Exception e){
            if (transaction!=null){
                e.printStackTrace();
                transaction.rollback();
            }
            return Collections.emptyList();
        }finally {
            if (entityManager!=null){
                entityManager.close();
            }
        }
    }

    @Override
    public void delete(Car entity) {

    }
}
