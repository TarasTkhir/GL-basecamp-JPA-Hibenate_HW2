package dao;

import entity.Workers;
import generatedTestObjects.GenerateOrDeleteDepartments;
import generatedTestObjects.GenerateOrDeleteWorkers;
import org.apache.logging.log4j.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

class WorkersDAOTest {
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
    void findWorkersByDepartmentIdAndAvaliabilityHQLPositive() {

        GenerateOrDeleteDepartments.generateDepartments(session);
        GenerateOrDeleteWorkers.generateWorkers(session);

        WorkersDAO workersDAO = new WorkersDAO(session);

        assertEquals(2, workersDAO.
                findByDepartmentIdAndAvaliabilityHQL(1, Workers.Availability.FULL_TIME).size());
    }

    @Test
    void findWorkersByDepartmentIdAndAvaliabilityHQLNegative() {

        GenerateOrDeleteDepartments.generateDepartments(session);
        GenerateOrDeleteWorkers.generateWorkers(session);

        WorkersDAO workersDAO = new WorkersDAO(session);

        assertNotEquals(true,
                (workersDAO.findByDepartmentIdAndAvaliabilityHQL(2, Workers.Availability.PART_TIME).size() != 1));
    }

    @Test
    void findWorkersByDepartmentIdAndAvaliabilityJPACriteriaPositive() {

        GenerateOrDeleteDepartments.generateDepartments(session);
        GenerateOrDeleteWorkers.generateWorkers(session);

        WorkersDAO workersDAO = new WorkersDAO(session);

        assertEquals(1, workersDAO.
                findByDepartmentIdAndAvaliabilityJPACriteria(2, Workers.Availability.PART_TIME).size());
    }

    @Test
    void findWorkersByDepartmentIdAndAvaliabilityJPACriteriaNegative() {

        GenerateOrDeleteDepartments.generateDepartments(session);
        GenerateOrDeleteWorkers.generateWorkers(session);

        WorkersDAO workersDAO = new WorkersDAO(session);

        assertNotEquals(true,
                (workersDAO.findByDepartmentIdAndAvaliabilityJPACriteria(3, Workers.Availability.PART_TIME)
                        .size() != 2));
    }
}