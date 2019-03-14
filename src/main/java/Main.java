import dao.DepartmentDAO;
import dao.WorkersDAO;
import entity.Department;
import entity.Workers;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {

        Session session = AppUtil.getSession();
        session.beginTransaction();

//        DepartmentDAO departmentDAO = new DepartmentDAO(session);
//        departmentDAO.createOrUpdate(new Department("Vasya", false));
//        WorkersDAO workersDAO = new WorkersDAO(session);
//        workersDAO.createOrUpdate(new Workers(33, Workers.Availability.FULL_TIME,"Hello",departmentDAO.findById(3)));
//        System.out.println(workersDAO.findAll());
//        System.out.println( workersDAO.findByDepartmentIdAndAvaliabilityJPACriteria(2, Workers.Availability.FULL_TIME));
//        System.out.println(departmentDAO.findAllActiveDepartmentsJPACriteria());
        session.getTransaction().commit();
        AppUtil.closeSessionFactoryAndSession();
    }
}
