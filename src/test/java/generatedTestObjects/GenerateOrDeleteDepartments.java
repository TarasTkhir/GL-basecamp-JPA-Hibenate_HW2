package generatedTestObjects;

import entity.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GenerateOrDeleteDepartments {

    public static void generateDepartments(Session session) {

        session.beginTransaction();

        session.saveOrUpdate(new Department(1, "department_1", true));
        session.saveOrUpdate(new Department(2, "department_2", false));
        session.saveOrUpdate(new Department(3, "department_3", true));
        session.saveOrUpdate(new Department(4, "department_4", false));
        session.saveOrUpdate(new Department(5, "department_5", true));

        session.getTransaction().commit();
    }

    public static void deleteDepartments(Session session) {

        session.beginTransaction();

        List<Department> from_department = session.createQuery("from Department").list();

        for (Department department : from_department) {
            session.delete(session.load(Department.class, department.getId()));
        }
        session.getTransaction().commit();
    }
}
