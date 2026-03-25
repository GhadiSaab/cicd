package fr.polytech;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
    @SequenceGenerator(name = "city_seq", sequenceName = "city_id_seq", allocationSize = 1)
    @Column(nullable = false)
    public Integer id;

    @Column(name = "department_code", nullable = false, length = 50)
    public String departmentCode;

    @Column(name = "insee_code", length = 50)
    public String inseeCode;

    @Column(name = "zip_code", length = 50)
    public String zipCode;

    @Column(nullable = false, length = 255)
    public String name;

    @Column(nullable = false)
    public double lat;

    @Column(nullable = false)
    public double lon;
}
