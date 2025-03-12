package org.example.provahibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;
import org.example.provahibernate.entity.Dept;
import org.example.provahibernate.entity.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeptRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Dept> findAllDept() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Dept> query = criteriaBuilder.createQuery(Dept.class);
        Root<Dept> from = query.from(Dept.class);
        query.select(from);

        return entityManager.createQuery(query).getResultList();
    }

    public List<Dept> esercizio43() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Dept> query = criteriaBuilder.createQuery(Dept.class);
        Subquery<Long> subQuery = query.subquery(Long.class);
        Root<Dept> from = query.from(Dept.class);
        Root<Emp> sub = subQuery.from(Emp.class);
        subQuery.select(sub.get("dept").get("deptno")).groupBy(sub.get("dept").get("deptno")).having(criteriaBuilder.equal(criteriaBuilder.count(sub.get("dept").get("deptno")), 3));
        query.select(from).where(from.get("deptno").in(subQuery));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio51() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Subquery<Integer> subquery = query.subquery(Integer.class);
        Root<Dept> fromDept = query.from(Dept.class);
        Root<Emp> fromEmp = subquery.from(Emp.class);
        subquery.select(fromEmp.get("dept").get("deptno"));
        query.multiselect(fromDept.get("deptno")).where(criteriaBuilder.not(fromDept.get("deptno").in(subquery)));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Dept> esercizio52() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Dept> query = criteriaBuilder.createQuery(Dept.class);
        Subquery<Integer> sub = query.subquery(Integer.class);
        Root<Dept> fromDept = query.from(Dept.class);
        Root<Emp> fromEmp = sub.from(Emp.class);
        sub.select(fromEmp.get("dept").get("deptno")).where(criteriaBuilder.equal(fromDept.get("deptno"), fromEmp.get("dept").get("deptno")));
        query.select(fromDept).where(fromDept.get("deptno").in(sub));
        return entityManager.createQuery(query).getResultList();
    }

    public void esercizio88() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Dept> query = criteriaBuilder.createCriteriaDelete(Dept.class);
        Subquery<Integer> sub1 = query.subquery(Integer.class);
        Root<Dept> from = query.from(Dept.class);
        Root<Emp> fromSub1 = sub1.from(Emp.class);
        sub1.select(fromSub1.get("dept").get("deptno")).where(criteriaBuilder.isNull(fromSub1.get("dept").get("deptno")));
        query.where(criteriaBuilder.not(from.get("deptno").in(sub1)));
        entityManager.createQuery(query).executeUpdate();
    }

}
