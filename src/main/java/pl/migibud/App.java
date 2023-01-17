package pl.migibud;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import pl.migibud.car.Car;
import pl.migibud.car.CarDao;
import pl.migibud.car.CarDaoImpl;
import pl.migibud.wheel.Wheel;

import java.util.List;
import java.util.Set;

class App {
    public static void main(String[] args) {


        SessionFactory sessionFactory = DbConnection.getSessionFactory();

        CarDaoImpl carDao = new CarDaoImpl(sessionFactory);
//        Wheel wheel1 = new Wheel(
//                30,
//                "Wheel 1",
//                30L
//        );
//        Wheel wheel2 = new Wheel(
//                32,
//                "Wheel 2",
//                32L
//        );
//        Wheel wheel3 = new Wheel(
//                38,
//                "Wheel 3",
//                38L
//        );
//
//        Car car1 = new Car(
//                "LEON",
//                "SEAT",
//                152d,
//                Set.of(wheel1,wheel2,wheel3)
//        );
//
//        Car car2 = new Car(
//            "GOLF",
//            "VW",
//            133d,
//            Set.of(wheel2,wheel3)
//        );
//
//        Car car3 = new Car(
//                "CEED",
//                "KIA",
//                163d,
//                Set.of(wheel1,wheel2)
//        );
//
//        carDao.save(car1);
//        wheel2.setId(null);
//        wheel3.setId(null);
//        carDao.save(car2);
//        wheel1.setId(null);
//        wheel2.setId(null);
//        carDao.save(car3);

        List<Car> allCarsByWheelProducer = carDao.findAllCarsByWheelProducer("Wheel 1");
        System.out.println(allCarsByWheelProducer.size());
        allCarsByWheelProducer.forEach(System.out::println);

        DbConnection.close();
    }
}
