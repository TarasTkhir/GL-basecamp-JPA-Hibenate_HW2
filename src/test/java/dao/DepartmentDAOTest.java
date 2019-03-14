package dao;

import generatedTestObjects.GenerateOrDeleteDepartments;
import generatedTestObjects.GenerateOrDeleteWorkers;
import org.apache.logging.log4j.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentDAOTest {

    private static SessionFactory sessionFactory;
    private static Session session;

    @Inject
    private static Logger logger;

    @BeforeAll
    public static void createFactory() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @AfterAll
    public static void closeSessionFactory() {
        sessionFactory.close();
    }

    @BeforeEach
    public void startSession() {
        session = sessionFactory.openSession();
    }

    @AfterEach
    public void closeSession() {

        GenerateOrDeleteWorkers.deleteWorkers(session);
        GenerateOrDeleteDepartments.deleteDepartments(session);

        session.close();
    }


    @Test
    void findAllActiveDepartmentsHQLPositive() {

        GenerateOrDeleteDepartments.generateDepartments(session);
        GenerateOrDeleteWorkers.generateWorkers(session);

        DepartmentDAO departmentDAO = new DepartmentDAO(session);

        assertEquals(3, departmentDAO.findAllActiveDepartmentsHQL().size());

    }

    @Test
    void findAllActiveDepartmentsHQLNegative() {

        GenerateOrDeleteDepartments.generateDepartments(session);
        GenerateOrDeleteWorkers.generateWorkers(session);

        DepartmentDAO departmentDAO = new DepartmentDAO(session);

        assertNotEquals(true,
                ((departmentDAO.findAllActiveDepartmentsHQL().size() > 3)
                        || (departmentDAO.findAllActiveDepartmentsHQL().size() < 3)));
    }

    @Test
    void findAllActiveDepartmentsJPACriteriaPositive() {

        GenerateOrDeleteDepartments.generateDepartments(session);
        GenerateOrDeleteWorkers.generateWorkers(session);

        DepartmentDAO departmentDAO = new DepartmentDAO(session);

        assertEquals(3, departmentDAO.findAllActiveDepartmentsJPACriteria().size());
    }

    @Test
    void findAllActiveDepartmentsJPACriteriaNegative() {

        GenerateOrDeleteDepartments.generateDepartments(session);
        GenerateOrDeleteWorkers.generateWorkers(session);

        DepartmentDAO departmentDAO = new DepartmentDAO(session);

        assertNotEquals(true,
                ((departmentDAO.findAllActiveDepartmentsHQL().size() > 3)
                        || (departmentDAO.findAllActiveDepartmentsJPACriteria().size() < 3)));
    }
}