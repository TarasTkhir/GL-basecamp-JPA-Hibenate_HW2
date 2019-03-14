package dao;

import entity.Department;
import entity.Workers;
import org.hibernate.Session;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.*;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements DAO<Department, Integer> {

    private Session session;

    @Inject
    private static Logger log;

    public DepartmentDAO(Session session) {
        this.session = session;
    }

    @Override
    public Department createOrUpdate(Department entity) {

        session.saveOrUpdate(entity);
        return entity;
    }

    @Override
    public Department findById(Integer integer) {

        return session.load(Department.class, integer);
    }

    @Override
    public void delete(Integer integer) {

        session.delete(findById(integer));
    }

    @Override
    public List<Department> findAll() {

        return (ArrayList<Department>) (session.createQuery("from Department").list());
    }

//    TASK 2

    public List<Department> findAllActiveDepartmentsHQL() {

        return (List<Department>) session.
                createQuery("from Department where status = true").list();

    }

    public List<Department> findAllActiveDepartmentsJPACriteria() {

        CriteriaBuilder criteriaBilder = session.getCriteriaBuilder();

        CriteriaQuery<Department> criteriaQuery = criteriaBilder.createQuery(Department.class);
        Root<Department> element = criteriaQuery.from(Department.class);
        criteriaQuery.select(element);
        criteriaQuery.where(criteriaBilder.
                equal(element.get("status"), true));

        return session.createQuery(criteriaQuery).getResultList();
    }
}
