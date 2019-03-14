package generatedTestObjects;

import dao.DepartmentDAO;
import entity.Department;
import entity.Workers;
import org.hibernate.Session;

import java.util.List;

public class GenerateOrDeleteWorkers {

    public static void generateWorkers(Session session) {

        session.beginTransaction();

        session.saveOrUpdate(new Workers
                (1, 25, Workers.Availability.FULL_TIME, "J_A",
                        session.load(Department.class, 1)));
        session.saveOrUpdate(new Workers
                (2, 26, Workers.Availability.FULL_TIME, "J_B",
                        session.load(Department.class, 2)));
        session.saveOrUpdate(new Workers
                (3, 27, Workers.Availability.FULL_TIME, "J_C",
                        session.load(Department.class, 3)));
        session.saveOrUpdate(new Workers
                (4, 28, Workers.Availability.FULL_TIME, "J_D",
                        session.load(Department.class, 4)));
        session.saveOrUpdate(new Workers
                (5, 29, Workers.Availability.FULL_TIME, "J_E",
                        session.load(Department.class, 1)));
        session.saveOrUpdate(new Workers
                (6, 30, Workers.Availability.PART_TIME, "J_F",
                        session.load(Department.class, 2)));
        session.saveOrUpdate(new Workers
                (7, 31, Workers.Availability.PART_TIME, "J_J",
                        session.load(Department.class, 3)));
        session.saveOrUpdate(new Workers
                (8, 32, Workers.Availability.PART_TIME, "J_H",
                        session.load(Department.class, 3)));
        session.saveOrUpdate(new Workers
                (9, 33, Workers.Availability.PART_TIME, "J_I",
                        session.load(Department.class, 4)));
        session.getTransaction().commit();
    }

    public static void deleteWorkers(Session session) {

        session.beginTransaction();

        List<Workers> from_workers = session.createQuery("from Workers").list();

        for (Workers worker : from_workers) {
            session.delete(session.load(Workers.class, worker.getId()));
        }
        session.getTransaction().commit();
    }
}
