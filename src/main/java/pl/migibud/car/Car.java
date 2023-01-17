package pl.migibud.car;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.migibud.wheel.Wheel;

import java.util.Set;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelName;
    private String producer;
    private Double engineVolume;

    public Car(String modelName, String producer, Double engineVolume) {
        this.modelName = modelName;
        this.producer = producer;
        this.engineVolume = engineVolume;
    }

    public Car(String modelName, String producer, Double engineVolume, Set<Wheel> wheels) {
        this.modelName = modelName;
        this.producer = producer;
        this.engineVolume = engineVolume;
        this.wheels = wheels;
    }

//    @OneToMany(mappedBy = "car",cascade = {CascadeType.PERSIST,CascadeType.MERGE})

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    @ToString.Exclude
    private Set<Wheel> wheels;
}
