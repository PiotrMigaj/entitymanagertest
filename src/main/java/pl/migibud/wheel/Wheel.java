package pl.migibud.wheel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.migibud.car.Car;

@Entity
@Table(name = "wheels")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Wheel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer diameter;
    private String producer;
    private Long ageInDays;

//    @JoinColumn(name = "car_id")
//    @ManyToOne
//    private Car car;

    public Wheel(Integer diameter, String producer, Long ageInDays) {
        this.diameter = diameter;
        this.producer = producer;
        this.ageInDays = ageInDays;
    }
}
