package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "workers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Workers {

    public Workers(int age, Availability availability, String fullName) {
        this.age = age;
        this.availability = availability;
        this.fullName = fullName;
    }

    public Workers(int age, Availability availability, String fullName, Department departmentId) {
        this.age = age;
        this.availability = availability;
        this.fullName = fullName;
        this.departmentId = departmentId;
    }

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "age")
    private int age;

    @Column(name = "availability")
    @Enumerated(EnumType.STRING)
    private Availability availability;

    @Column(name = "full_name")
    private String fullName;


    @ManyToOne(fetch = FetchType.LAZY)
    private Department departmentId;

    public enum Availability {
        FULL_TIME,
        PART_TIME
    }

    @Override
    public String toString() {
        return "Worker: " +
                "id= " + id +
                ", age= " + age +
                ", availability= " + availability +
                ", fullName= " + fullName + '\'' +
                ", departmentId= " + departmentId + " ";
    }
}