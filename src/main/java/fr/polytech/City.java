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
    public Long id;

    @Column(name = "department_code", nullable = false)
    public String departmentCode;

    @Column(name = "insee_code")
    public String inseeCode;

    @Column(name = "zip_code")
    public String zipCode;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public float lat;

    @Column(nullable = false)
    public float lon;
}
