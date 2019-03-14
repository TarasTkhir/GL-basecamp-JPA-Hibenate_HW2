package dao;

import entity.Workers;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.*;

import java.util.ArrayList;
import java.util.List;

public class WorkersDAO implements DAO<Workers, Integer> {

    private Session session;

    @Inject
    private static Logger log;

    public WorkersDAO(Session session) {
        this.session = session;
    }

    @Override
    public Workers createOrUpdate(Workers entity) {

        session.saveOrUpdate(entity);
        return entity;
    }

    @Override
    public Workers findById(Integer integer) {

        return session.load(Workers.class, integer);
    }

    @Override
    public void delete(Integer integer) {

        session.delete(findById(integer));
    }

    @Override
    public List<Workers> findAll() {

        return (ArrayList<Workers>) (session.createQuery("from Workers").list());

    }

    //    TASK 2
    public List<Workers> findByDepartmentIdAndAvaliabilityHQL(Integer id, Workers.Availability availability) {

        Query query = session.
                createQuery("from Workers where departmentId.id =: departmentId and availability =: avai");

        query.setParameter("departmentId", id);
        query.setParameter("avai", availability);

        return (List<Workers>) query.list();
    }

    public List<Workers> findByDepartmentIdAndAvaliabilityJPACriteria(Integer id, Workers.Availability availability) {

        CriteriaBuilder criteriaBilder = session.getCriteriaBuilder();

        CriteriaQuery<Workers> criteriaQuery = criteriaBilder.createQuery(Workers.class);
        Root<Workers> element = criteriaQuery.from(Workers.class);
        criteriaQuery.select(element);
        criteriaQuery.where(criteriaBilder.
                        equal(element.get("departmentId"), id),
                criteriaBilder.equal(element.get("availability"), availability));

        return session.createQuery(criteriaQuery).getResultList();
    }


}
