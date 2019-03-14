package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    public Department(int id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Department(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    @Id
    @PrimaryKeyJoinColumn
    private int id;

    @Column(name = "department_name")
    private String name;

    @Column(name = "status")
    private boolean status;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, mappedBy = "departmentId")
    List<Workers> workersList;

    @Override
    public String toString() {
        return "Department: " +
                "id= " + id +
                ", name= " + name + '\'' +
                ", status= " + status + " ";
    }
}
