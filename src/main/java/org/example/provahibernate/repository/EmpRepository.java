package org.example.provahibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;
import org.example.provahibernate.entity.Dept;
import org.example.provahibernate.entity.Emp;
import org.example.provahibernate.entity.Emp1;
import org.example.provahibernate.entity.Salgrade;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

@Repository
public class EmpRepository {

    private static final BufferedReader oInput = new BufferedReader(new InputStreamReader(System.in));
    Logger logger = Logger.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Emp> esercizio1() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from);

        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio2() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.equal(from.get("dept").get("deptno"), 10));

        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio3() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.notEqual(from.get("dept").get("deptno"), 30));

        return entityManager.createQuery(query).getResultList();
    }

    public Long esercizio4() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(criteriaBuilder.count(from));

        return entityManager.createQuery(query).getSingleResult();
    }

    public List<Emp> esercizio5() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).orderBy(criteriaBuilder.desc(from.get("sal")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio6() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from);
        return entityManager.createQuery(query).setMaxResults(5).getResultList();
    }

    public List<Emp> esercizio7() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).orderBy(criteriaBuilder.asc(from.get("dept").get("deptno")), criteriaBuilder.desc(from.get("sal")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio8() {
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("yyyy");
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.equal(criteriaBuilder.function("to_char", Integer.class,  from.get("hiredate"), criteriaBuilder.literal("YYYY")), "1981"));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio9() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createTupleQuery();
        Root<Emp> from = query.from(Emp.class);
        query.select(criteriaBuilder.tuple(criteriaBuilder.function("nvl", Integer.class, from.get("comm"), criteriaBuilder.literal("0"))));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio10() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.between(from.get("mgr"), 7566,7698), criteriaBuilder.greaterThan(from.get("sal"), 1500));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio11() {
        Date date = new Date("01/01/1981");
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.lessThan(from.get("hiredate"), date));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio12() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createTupleQuery();
        Root<Emp> from = query.from(Emp.class);
        //Trovare una soluzione migliore a questa function
        Expression<Integer> subDates = criteriaBuilder.function("to_number", Integer.class, criteriaBuilder.function( "SYSDATE -", String.class, from.get("hiredate")));
        query.select(criteriaBuilder.tuple(from.get("hiredate"), criteriaBuilder.function("round", Integer.class, criteriaBuilder.quot(subDates, 360))));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio13() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.notEqual(criteriaBuilder.function("to_char", Integer.class, from.get("hiredate"), criteriaBuilder.literal("YYYY")), 1981));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio14() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.equal(criteriaBuilder.function("to_char", Integer.class, from.get("hiredate"), criteriaBuilder.literal("Q")),3));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio15() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Subquery<Long> sub = query.subquery(Long.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> subRoot = sub.from(Emp.class);
        sub.select(subRoot.get("sal")).where(criteriaBuilder.equal(subRoot.get("ename"), "FORD"));
        query.select(from).where(criteriaBuilder.lessThan(from.get("sal"), sub));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio16() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(criteriaBuilder.tuple(from.get("ename"), from.get("rowid")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio17() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Subquery<Date> subQuery = query.subquery(Date.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> subRoot = subQuery.from(Emp.class);
        subQuery.select(subRoot.get("hiredate")).where(criteriaBuilder.equal(subRoot.get("ename"), "SCOTT"));
        query.select(from).where(criteriaBuilder.lessThan(from.get("hiredate"), subQuery));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio18() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.equal(criteriaBuilder.function("to_char", Integer.class, from.get("hiredate"), criteriaBuilder.literal("Q")), 3)
                , criteriaBuilder.equal(criteriaBuilder.function("to_char", Integer.class, from.get("hiredate"), criteriaBuilder.literal("YYYY")), 1981));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio19() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(criteriaBuilder.tuple(from.get("hiredate"), criteriaBuilder.function("add_months", Date.class, from.get("hiredate"), criteriaBuilder.literal(3))));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio20() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(criteriaBuilder.tuple(criteriaBuilder.function("next_day", Date.class, from.get("hiredate"), criteriaBuilder.literal("MARTEDÌ"))));
        return entityManager.createQuery(query).getResultList();
    }

    public List esercizio21() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = criteriaBuilder.createQuery();
        query.select(criteriaBuilder.function("sysdate + ", Date.class, criteriaBuilder.literal("15")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio22() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        query.select(criteriaBuilder.tuple(criteriaBuilder.function("sysdate", Date.class), criteriaBuilder.function("current_date", Date.class)));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio23() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from.get("job")).distinct(true);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio24() {
        Date date1 = new Date("28-SEP-81");
        Date date2 = new Date("03-DEC-81");
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.between(from.get("hiredate"), date1, date2));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio25() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Predicate primaCondizione = criteriaBuilder.like(from.get("ename"), "J%");
        Predicate secondaCondizione = criteriaBuilder.like(from.get("ename"), "A%");
        Predicate terzaCondizione = criteriaBuilder.like(from.get("ename"), "M%");
        Predicate or = criteriaBuilder.or(primaCondizione, secondaCondizione, terzaCondizione);
        query.select(criteriaBuilder.tuple(criteriaBuilder.function("initcap", String.class, from.get("ename")))).where(or);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio26() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Dept> fromDept = query.from(Dept.class);
        Predicate condition1 = criteriaBuilder.equal(from.get("dept").get("deptno"), fromDept.get("deptno"));
        Predicate condition2 = criteriaBuilder.equal(from.get("dept").get("deptno"), 10);
        query.select(criteriaBuilder.tuple(from.get("job"), fromDept.get("loc"))).where(condition1, condition2);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio27() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Dept> fromDept = query.from(Dept.class);
        query.multiselect(from.get("ename"), fromDept.get("deptName")).where(criteriaBuilder.equal(from.get("dept").get("deptno"), fromDept.get("deptno")), criteriaBuilder.isNotNull(from.get("comm")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio28() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        query.multiselect(from.get("empId"), from.get("ename"), from.get("sal"), criteriaBuilder.quot(criteriaBuilder.prod(from.get("sal"), 15), 100));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio29() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Salgrade> fromSal = query.from(Salgrade.class);
        query.multiselect(from.get("ename"), from.get("sal"), fromSal.get("empId")).where(criteriaBuilder.between(from.get("sal"), fromSal.get("losal"), fromSal.get("hisal")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio30() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> from2 = query.from(Emp.class);
        query.multiselect(from.get("ename"), from.get("sal"), from2.get("ename"), from2.get("sal")).where(criteriaBuilder.equal(from.get("mgr"), from2.get("empId")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio31() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Subquery<Double> sub = query.subquery(Double.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> from2 = sub.from(Emp.class);
        sub.select(criteriaBuilder.avg(from2.get("sal"))).where(criteriaBuilder.equal(from2.get("dept").get("deptno"), from.get("dept").get("deptno")));
        query.multiselect(from.get("ename"), from.get("dept").get("deptno"), from.get("sal"))
                .where(criteriaBuilder.greaterThan(from.get("sal"), sub)).orderBy(criteriaBuilder.asc(from.get("dept").get("deptno")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio32() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> from2 = query.from(Emp.class);
        query.multiselect(from.get("ename"), from.get("sal"), from2.get("ename"), from2.get("sal"))
                .where(criteriaBuilder.equal(from.get("mgr"), from2.get("empId")), criteriaBuilder.greaterThan(from.get("sal"), from2.get("sal")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio33() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.equal(criteriaBuilder.length(from.get("ename")), 5));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio34() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.like(from.get("ename"), "J%S"));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio35() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        List<Integer> notIn = Arrays.asList(10, 20, 40);
        query.select(from).where(criteriaBuilder.not(from.get("dept").get("deptno").in(notIn)));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio36() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        List<String> notIn = Arrays.asList("PRESIDENT", "MANAGER");
        query.select(from).where(criteriaBuilder.not(from.get("job").in(notIn)));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio37() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        query.multiselect(criteriaBuilder.function("max", Integer.class, from.get("sal")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio38() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        query.multiselect(criteriaBuilder.function("avg", Integer.class, from.get("sal"))).where(criteriaBuilder.equal(from.get("job"), "SALESMAN"));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio39() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.lessThanOrEqualTo(from.get("sal"), 999));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio40() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.isNotNull(from.get("comm")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio41() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.like(from.get("ename"), "_L%"));
        return entityManager.createQuery(query).getResultList();
    }
    //Salario + alto
    public List<Tuple> esercizio42A() throws IOException {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Subquery<Long> sub = query.subquery(Long.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> from2 = sub.from(Emp.class);
        logger.info("Inserisci n-esimo salario + alto che vuoi trovare: ");
        int valore = Integer.parseInt(oInput.readLine());
        sub.select(criteriaBuilder.countDistinct(from2.get("sal"))).where(criteriaBuilder.lessThanOrEqualTo(from.get("sal"), from2.get("sal")));
        query.select(from.get("sal")).where(criteriaBuilder.equal(criteriaBuilder.literal(valore), sub));
        return entityManager.createQuery(query).getResultList();
    }
    //Salario + basso
    public List<Tuple> esercizio42B() throws IOException {
        int valore;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Subquery<Long> sub = query.subquery(Long.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> from2 = sub.from(Emp.class);
        logger.info("Inserisci n-esimo salario + basso che vuoi trovare: ");
        valore = Integer.parseInt(oInput.readLine());
        sub.select(criteriaBuilder.countDistinct(from2.get("sal"))).where(criteriaBuilder.greaterThanOrEqualTo(from.get("sal"), from2.get("sal")));
        query.select(from.get("sal")).where(criteriaBuilder.equal(criteriaBuilder.literal(valore), sub));
        return entityManager.createQuery(query).getResultList();
    }
    //Modificare temporaneamente FetchType.EAGER per subordinati in Emp oppure spring.jpa.show-sql=false in properties per formattazione corretta
    public List<Emp> esercizio44() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.isNull(from.get("mgr")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio45() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Expression<Integer> expr1 = criteriaBuilder.selectCase()
                .when(criteriaBuilder.equal(from.get("dept").get("deptno"), 10), from.get("sal"))
                .otherwise(criteriaBuilder.literal(0))
                .as(Integer.class);
        Expression<Integer> expr2 = criteriaBuilder.selectCase()
                .when(criteriaBuilder.equal(from.get("dept").get("deptno"), 20), from.get("sal"))
                .otherwise(criteriaBuilder.literal(0))
                .as(Integer.class);
        Expression<Integer> expr3 = criteriaBuilder.selectCase()
                .when(criteriaBuilder.equal(from.get("dept").get("deptno"), 30), from.get("sal"))
                .otherwise(criteriaBuilder.literal(0))
                .as(Integer.class);
        //Altra soluzione con function:
        //Expression<Integer> expr1 = criteriaBuilder.function("decode", Integer.class, from.get("dept").get("deptno"), criteriaBuilder.literal(10), from.get("sal"));
        //Expression<Integer> expr2 = criteriaBuilder.function("decode", Integer.class, from.get("dept").get("deptno"), criteriaBuilder.literal(20), from.get("sal"));
        //Expression<Integer> expr3 = criteriaBuilder.function("decode", Integer.class, from.get("dept").get("deptno"), criteriaBuilder.literal(30), from.get("sal"));
        query.multiselect(criteriaBuilder.sum(expr1), criteriaBuilder.sum(expr2), criteriaBuilder.sum(expr3), criteriaBuilder.sum(from.get("sal")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio46() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        query.multiselect(criteriaBuilder.min(from.get("sal")), criteriaBuilder.max(from.get("sal")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio47() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Join<Emp, Dept> deptJoin = from.join("dept", JoinType.RIGHT);
        query.multiselect(deptJoin.get("deptName"), deptJoin.get("deptno"), from.get("ename"), from.get("sal"));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio48() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Join<Emp, Dept> deptJoin = from.join("dept", JoinType.LEFT);
        query.multiselect(deptJoin.get("deptName"), deptJoin.get("deptno"), from.get("ename"), from.get("sal"));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio49() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Join<Emp, Dept> leftDeptJoin = from.join("dept", JoinType.LEFT);
        query.multiselect(leftDeptJoin.get("deptName"), leftDeptJoin.get("deptno"), from.get("ename"), from.get("sal"));
        List<Tuple> leftResults = entityManager.createQuery(query).getResultList();

        Join<Emp, Dept> rightDeptJoin = from.join("dept", JoinType.RIGHT);
        query.multiselect(rightDeptJoin.get("deptName"), rightDeptJoin.get("deptno"), from.get("ename"), from.get("sal"));
        List<Tuple> rightResults = entityManager.createQuery(query).getResultList();

        Set<String> risultatiUnici = new LinkedHashSet<>();
        List<Tuple> risultatoFinale = new ArrayList<>();

        for (Tuple risultato : leftResults) {
            String key = risultato.get(0) + "-" + risultato.get(1) + "-" + risultato.get(2) + "-" + risultato.get(3);
            if (risultatiUnici.add(key)) {
                risultatoFinale.add(risultato);
            }
        }

        for (Tuple risultato : rightResults) {
            String key = risultato.get(0) + "-" + risultato.get(1) + "-" + risultato.get(2) + "-" + risultato.get(3);
            if (risultatiUnici.add(key)) {
                risultatoFinale.add(risultato);
            }
        }
        return risultatoFinale;
    }

    public List<Tuple> esercizio50() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> fromEmp = query.from(Emp.class);
        Root<Dept> fromDept = query.from(Dept.class);
        query.multiselect(fromEmp, fromDept);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio53() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Subquery<Integer> sub = query.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromEmp = sub.from(Emp.class);
        sub.select(fromEmp.get("mgr")).where(criteriaBuilder.equal(fromEmp.get("mgr"), from.get("empId")));
        query.multiselect(from.get("ename")).where(criteriaBuilder.not(from.get("empId").in(sub)));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio54() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Expression<String> concat = criteriaBuilder.concat(from.get("ename"), " belongs to ");
        query.multiselect(criteriaBuilder.concat(concat, from.get("dept").get("deptno")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio55() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Expression toChar = criteriaBuilder.function("to_char", String.class, from.get("hiredate"), criteriaBuilder.literal("YYYY"));
        Expression<Date> expr1 = criteriaBuilder.selectCase()
                .when(criteriaBuilder.equal(toChar, 1980), from.get("hiredate"))
                .as(Date.class);
        Expression<Date> expr2 = criteriaBuilder.selectCase()
                .when(criteriaBuilder.equal(toChar, 1981), from.get("hiredate"))
                .as(Date.class);
        Expression<Date> expr3 = criteriaBuilder.selectCase()
                .when(criteriaBuilder.equal(toChar, 1982), from.get("hiredate"))
                .as(Date.class);
        query.multiselect(criteriaBuilder.count(expr1), criteriaBuilder.count(expr2), criteriaBuilder.count(expr3));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio56() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Expression<String> expr = criteriaBuilder.selectCase()
                        .when(criteriaBuilder.equal(from.get("dept").get("deptno"), 10), "Ten")
                        .when(criteriaBuilder.equal(from.get("dept").get("deptno"), 20), "Twenty")
                        .when(criteriaBuilder.equal(from.get("dept").get("deptno"), 30), "Thirty")
                        .when(criteriaBuilder.equal(from.get("dept").get("deptno"), 40), "Fourty")
                        .otherwise("Others")
                        .as(String.class);
        query.multiselect(from.get("ename"), from.get("dept").get("deptno"), expr);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio57() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        query.multiselect(criteriaBuilder.lower(from.get("ename")), criteriaBuilder.function("initcap", String.class, from.get("job")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio58() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        Expression<String> expr = criteriaBuilder.function("to_char", String.class, from.get("hiredate"), criteriaBuilder.literal("W"));
        query.select(from).where(criteriaBuilder.equal(expr, 1));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio59() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        Expression<String>  expr = criteriaBuilder.function("to_char", String.class, from.get("hiredate"), criteriaBuilder.literal("WW"));
        query.select(from).where(criteriaBuilder.equal(expr, 49));
        return entityManager.createQuery(query).getResultList();
    }

    //Non ho trovato un modo per usare la funzione finestra lag con OVER usando solo criteriaBuilder, quindi gestisco i calcoli con java nel Service
    public List<Emp> esercizio60() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).orderBy(criteriaBuilder.asc(from.get("sal")));
        return entityManager.createQuery(query).getResultList();
    }

    //spring.jpa.hibernate.ddl-auto=update nelle properties per far creare la tabella Emp1 a Hibernate
    public void esercizio61() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.select(from).where(criteriaBuilder.equal(from.get("dept").get("deptno"), 10));
        List<Emp> lista = entityManager.createQuery(query).getResultList();
        try {
            for (Emp emp : lista) {
                Emp1 newEmp = new Emp1();
                newEmp.setEmpId(emp.getEmpId());
                newEmp.setEname(emp.getEname());
                newEmp.setJob(emp.getJob());
                newEmp.setSal(emp.getSal());
                newEmp.setDept(emp.getDept());
                entityManager.persist(newEmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void esercizio63() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        Emp1 newEmp1 = new Emp1();
        Date date = new Date();
        Dept dept = new Dept(); dept.setDeptno(10);
        newEmp1.setEmpId(9999); newEmp1.setEname("PAUL"); newEmp1.setJob("MANAGER"); newEmp1.setMgr(7839); newEmp1.setHiredate(date); newEmp1.setSal(8900D); newEmp1.setComm(null); newEmp1.setDept(dept);
        Emp newEmp = new Emp();
        newEmp.setEmpId(newEmp1.getEmpId());
        newEmp.setEname(newEmp1.getEname());
        newEmp.setJob(newEmp1.getJob());
        newEmp.setMgr(newEmp1.getMgr());
        newEmp.setHiredate(newEmp1.getHiredate());
        newEmp.setSal(newEmp1.getSal());
        newEmp.setComm(newEmp1.getComm());
        newEmp.setDept(newEmp1.getDept());
        entityManager.merge(newEmp1);
        entityManager.merge(newEmp);
    }

    public List<Emp> esercizio64() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Subquery<Integer> sub = query.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = sub.from(Emp.class);
        sub.select(fromSub.get("dept").get("deptno")).where(criteriaBuilder.equal(fromSub.get("ename"), "JAMES"));
        query.select(from).where(from.get("dept").get("deptno").in(sub));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio65() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Subquery<Integer> sub = query.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = sub.from(Emp.class);
        sub.select(fromSub.get("sal")).where(criteriaBuilder.equal(fromSub.get("ename"), "ADAMS"));
        query.select(from).where(criteriaBuilder.lessThanOrEqualTo(from.get("sal"), sub));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio66() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Subquery<Date> sub = query.subquery(Date.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = sub.from(Emp.class);
        sub.select(fromSub.get("hiredate")).where(criteriaBuilder.equal(fromSub.get("ename"), "WARD"));
        query.select(from).where(criteriaBuilder.lessThan(from.get("hiredate"), sub));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio67() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Subquery<Integer> sub = query.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = sub.from(Emp.class);
        sub.select(fromSub.get("mgr")).where(criteriaBuilder.equal(fromSub.get("ename"), "BLAKE"));
        query.select(from).where(criteriaBuilder.equal(from.get("mgr"), sub));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio68() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Subquery<Integer> sub = query.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = sub.from(Emp.class);
        sub.select(fromSub.get("empId")).where(criteriaBuilder.equal(fromSub.get("ename"), "BLAKE"));
        query.select(from).where(criteriaBuilder.equal(from.get("empId"), sub));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio69() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Subquery<Integer> sub1 = query.subquery(Integer.class);
        Subquery<String> sub2 = query.subquery(String.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub1 = sub1.from(Emp.class);
        Root<Emp> fromSub2 = sub2.from(Emp.class);
        sub2.select(fromSub2.get("job")).where(criteriaBuilder.equal(fromSub2.get("ename"), "KING"));
        sub1.select(fromSub1.get("dept").get("deptno")).where(criteriaBuilder.equal(fromSub1.get("job"), sub2));
        query.select(from).where(from.get("dept").get("deptno").in(sub1));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio70() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Subquery<Integer> sub1 = query.subquery(Integer.class);
        Subquery<String> sub2 = query.subquery(String.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub1 = sub1.from(Emp.class);
        Root<Emp> fromSub2 = sub2.from(Emp.class);
        sub2.select(fromSub2.get("ename")).where(criteriaBuilder.equal(fromSub2.get("job"), "PRESIDENT"));
        sub1.select(fromSub1.get("empId")).where(fromSub1.get("ename").in(sub2));
        query.select(from).where(from.get("empId").in(sub1));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio71() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        Expression<String> expr = criteriaBuilder.function("to_char", String.class, from.get("hiredate"), criteriaBuilder.literal("YYYY"));
        query.select(from).where(criteriaBuilder.equal(expr, 1981), criteriaBuilder.equal(from.get("job"), "MANAGER"));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio72() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Subquery<Integer> sub = query.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = sub.from(Emp.class);
        sub.select(criteriaBuilder.max(fromSub.get("comm")));
        query.select(from).where(criteriaBuilder.equal(from.get("comm"), sub));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio73() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Subquery<Date> sub = query.subquery(Date.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = sub.from(Emp.class);
        Expression<Date> expr = fromSub.get("hiredate");
        sub.select(criteriaBuilder.least(expr));
        query.select(from).where(criteriaBuilder.equal(from.get("hiredate"), sub));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Emp> esercizio74() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> query = criteriaBuilder.createQuery(Emp.class);
        Subquery<Date> sub = query.subquery(Date.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = sub.from(Emp.class);
        Expression<Date> expr = fromSub.get("hiredate");
        sub.select(criteriaBuilder.greatest(expr));
        query.select(from).where(criteriaBuilder.equal(from.get("hiredate"), sub));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio75() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Dept> fromDept = query.from(Dept.class);
        Root<Salgrade> fromSalgrade = query.from(Salgrade.class);
        query.multiselect(from.get("empId"), from.get("ename"), fromDept.get("deptno"), fromDept.get("deptName"), fromSalgrade.get("empId"))
                .where(criteriaBuilder.equal(from.get("dept").get("deptno"), fromDept.get("deptno")), criteriaBuilder.between(from.get("sal"), fromSalgrade.get("losal"), fromSalgrade.get("hisal")));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio76() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Subquery<Integer> sub = query.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Dept> fromSub = sub.from(Dept.class);
        sub.select(fromSub.get("deptno")).where(criteriaBuilder.equal(fromSub.get("loc"), "DALLAS"));
        query.multiselect(from.get("ename"), from.get("job"), from.get("dept").get("deptno")).where(from.get("dept").get("deptno").in(sub));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio77() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Join<Emp, Dept> deptJoin = from.join("dept");
        query.multiselect(from.get("ename"), from.get("job"), from.get("dept").get("deptno"), deptJoin.get("deptName"));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio78() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        Subquery<Integer> sub = query.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Dept> fromDept = query.from(Dept.class);
        Root<Salgrade> fromSal = sub.from(Salgrade.class);
        Predicate predicate = criteriaBuilder.equal(from.get("dept").get("deptno"), fromDept.get("deptno"));
        sub.select(criteriaBuilder.literal(1)).where(criteriaBuilder.between(from.get("sal"), fromSal.get("losal"), fromSal.get("hisal")));
        query.multiselect(from.get("ename"), from.get("job"), from.get("sal"), fromDept.get("deptName"))
                .where(predicate, criteriaBuilder.not(criteriaBuilder.exists(sub)));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Tuple> esercizio79() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
        CriteriaQuery<Tuple> query1 = criteriaBuilder.createQuery(Tuple.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp1> from1 = query1.from(Emp1.class);
        query.multiselect(from.get("empId"), from.get("ename"), from.get("sal"));
        List<Tuple> list1 = entityManager.createQuery(query).getResultList();
        query1.multiselect(from1.get("empId"), from1.get("ename"), from1.get("sal"));
        List<Tuple> list2 = entityManager.createQuery(query1).getResultList();
        list1.addAll(list2);
        return list1;
    }

    public void esercizio80() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Emp> query = criteriaBuilder.createCriteriaDelete(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        List<Integer> list = List.of(50, 60); //Modificare la lista di deptno a piacimento
        query.where(from.get("dept").get("deptno").in(list.toArray()));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio81() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Emp> query = criteriaBuilder.createCriteriaDelete(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.where(criteriaBuilder.isNull(from.get("comm")));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio82() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Emp> query = criteriaBuilder.createCriteriaDelete(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        //Trovare una soluzione migliore a questa function
        Expression<Integer> subDates = criteriaBuilder.function("to_number", Integer.class, criteriaBuilder.function( "SYSDATE -", String.class, from.get("hiredate")));
        Expression<Long> daysDiff = criteriaBuilder.function("TRUNC", Long.class, subDates);
        Expression<Long> yearsDiff = criteriaBuilder.toLong(criteriaBuilder.quot(daysDiff, 365));
        query.where(criteriaBuilder.greaterThan(yearsDiff, 28L));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio84() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Emp> query = criteriaBuilder.createCriteriaDelete(Emp.class);
        CriteriaQuery<Emp> querySub = criteriaBuilder.createQuery(Emp.class);
        Subquery<Double> sub = querySub.subquery(Double.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = sub.from(Emp.class);
        sub.select(criteriaBuilder.avg(fromSub.get("sal"))).where(criteriaBuilder.equal(from.get("dept").get("deptno"), fromSub.get("dept").get("deptno")));
        query.where(criteriaBuilder.greaterThan(from.get("sal"), sub));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio85() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Emp> query = criteriaBuilder.createCriteriaDelete(Emp.class);
        CriteriaQuery<Emp> querySub = criteriaBuilder.createQuery(Emp.class);
        Subquery<String> sub1 = querySub.subquery(String.class);
        Subquery<Integer> sub2 = querySub.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub1 = sub1.from(Emp.class);
        Root<Emp> fromSub2 = sub2.from(Emp.class);
        sub2.select(fromSub2.get("empId")).where(criteriaBuilder.equal(fromSub2.get("ename"), "BLAKE"));
        sub1.select(fromSub1.get("ename")).where(criteriaBuilder.equal(fromSub1.get("mgr"), sub2));
        query.where(from.get("ename").in(sub1));
        entityManager.createQuery(query).executeUpdate();
    }

    /*
    public void esercizio86() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Emp> query = criteriaBuilder.createCriteriaDelete(Emp.class);
        Subquery<String> sub1 = query.subquery(String.class);
        Subquery<Integer> sub2 = query.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub1 = sub1.from(Emp.class);
        Root<Emp> fromSub2 = sub2.from(Emp.class);
        sub2.select(fromSub2.get("empId")).where(criteriaBuilder.equal(fromSub2.get("ename"), "BLAKE"));
        sub1.select(fromSub1.get("ename")).where(criteriaBuilder.equal(fromSub1.get("mgr"), sub2));
        query.where(from.get("ename").in(sub1));
        entityManager.createQuery(query).executeUpdate();
    } */

    public void esercizio87() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Emp> query = criteriaBuilder.createCriteriaDelete(Emp.class);
        CriteriaQuery<Emp> querySub = criteriaBuilder.createQuery(Emp.class);
        Subquery<String> sub1 = querySub.subquery(String.class);
        Subquery<Integer> sub2 = querySub.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub1 = sub1.from(Emp.class);
        Root<Emp> fromSub2 = sub2.from(Emp.class);
        sub2.select(fromSub2.get("mgr")).where(criteriaBuilder.equal(fromSub2.get("mgr"), fromSub1.get("empId")), criteriaBuilder.isNotNull(fromSub2.get("mgr")));
        sub1.select(fromSub1.get("ename")).where(fromSub1.get("empId").in(sub2));
        query.where(from.get("ename").in(sub1));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio89() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Emp> query = criteriaBuilder.createCriteriaDelete(Emp.class);
        CriteriaQuery<Emp> querySub = criteriaBuilder.createQuery(Emp.class);
        Subquery<Integer> sub1 = querySub.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSubEmp = sub1.from(Emp.class);
        Root<Salgrade> fromSubSal = sub1.from(Salgrade.class);
        sub1.select(fromSubEmp.get("empId")).where(criteriaBuilder.between(fromSubEmp.get("sal"), fromSubSal.get("losal"), fromSubSal.get("hisal")), criteriaBuilder.equal(fromSubSal.get("empId"), 2));
        query.where(from.get("empId").in(sub1));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio90() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Emp> query = criteriaBuilder.createCriteriaDelete(Emp.class);
        CriteriaQuery<Emp> querySub = criteriaBuilder.createQuery(Emp.class);
        Subquery<Integer> sub1 = querySub.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = sub1.from(Emp.class);
        sub1.select(fromSub.get("dept").get("deptno")).where(criteriaBuilder.equal(fromSub.get("ename"), "SMITH"));
        query.where(criteriaBuilder.equal(from.get("dept").get("deptno"), sub1));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio91() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Emp> query = criteriaBuilder.createCriteriaDelete(Emp.class);
        CriteriaQuery<Emp> querySub = criteriaBuilder.createQuery(Emp.class);
        Subquery<Integer> sub1 = querySub.subquery(Integer.class);
        Subquery<String> sub2 = querySub.subquery(String.class);
        Subquery<Integer> subComune = querySub.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub1 = sub1.from(Emp.class);
        Root<Emp> fromSub2 = sub2.from(Emp.class);
        Root<Emp> fromSubComune = subComune.from(Emp.class);
        subComune.select(fromSubComune.get("empId")).where(criteriaBuilder.equal(fromSubComune.get("ename"), "BLAKE"));
        sub1.select(criteriaBuilder.min(fromSub1.get("sal"))).where(criteriaBuilder.equal(fromSub1.get("mgr"), subComune));
        sub2.select(fromSub2.get("ename")).where(criteriaBuilder.equal(fromSub2.get("mgr"), subComune));
        query.where(criteriaBuilder.equal(from.get("sal"), sub1), from.get("ename").in(sub2));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio92() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Emp> query = criteriaBuilder.createCriteriaDelete(Emp.class);
        CriteriaQuery<Emp> querySub = criteriaBuilder.createQuery(Emp.class);
        Subquery<Date> sub = querySub.subquery(Date.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = sub.from(Emp.class);
        sub.select(fromSub.get("hiredate")).where(criteriaBuilder.equal(fromSub.get("ename"), "SMITH"));
        query.where(criteriaBuilder.lessThan(from.get("hiredate"), sub));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio93() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Emp> query = criteriaBuilder.createCriteriaUpdate(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.set("ename", "ANDY").where(criteriaBuilder.equal(from.get("ename"), "JONES")); //CHECK
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio94() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Emp> query = criteriaBuilder.createCriteriaUpdate(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        Expression<Date> newHireDate = criteriaBuilder.function("1 +", Date.class, from.get("hiredate"));
        query.set("hiredate", newHireDate)
                .where(criteriaBuilder.equal(from.get("ename"), "WARD"));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio95() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Emp> query = criteriaBuilder.createCriteriaUpdate(Emp.class);
        Subquery<Integer> querySub = query.subquery(Integer.class);
        Root<Emp> fromSub = querySub.from(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        querySub.select(fromSub.get("sal")).where(criteriaBuilder.equal(fromSub.get("ename"), "SMITH"));
        query.set("sal", querySub).where(criteriaBuilder.equal(from.get("ename"), "MARTIN"));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio96() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Emp> query = criteriaBuilder.createCriteriaUpdate(Emp.class);
        Root<Emp> from = query.from(Emp.class);
        query.set("sal", criteriaBuilder.sum(from.get("sal"), (criteriaBuilder.prod(from.get("sal"), 0.05))))
                .where(criteriaBuilder.between(from.get("comm"), 0, 1000));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio97() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Emp> query = criteriaBuilder.createCriteriaUpdate(Emp.class);
        Subquery<Integer> querySub = query.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = querySub.from(Emp.class);
        querySub.select(fromSub.get("empId")).where(criteriaBuilder.equal(fromSub.get("ename"), "BLAKE"));
        query.set("comm", criteriaBuilder.sum(criteriaBuilder.function("nvl", Integer.class, from.get("comm"), criteriaBuilder.literal(0)), 250))
                .where(criteriaBuilder.equal(from.get("mgr"), querySub));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio98() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Emp> query = criteriaBuilder.createCriteriaUpdate(Emp.class);
        Subquery<Double> querySub = query.subquery(Double.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = querySub.from(Emp.class);
        querySub.select(criteriaBuilder.avg(fromSub.get("sal"))).where(criteriaBuilder.equal(fromSub.get("dept").get("deptno"), from.get("dept").get("deptno")));
        query.set("sal", criteriaBuilder.sum(from.get("sal"), 150))
                .where(criteriaBuilder.greaterThan(from.get("sal"), querySub));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio99() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Emp> query = criteriaBuilder.createCriteriaUpdate(Emp.class);
        Subquery<Double> querySub = query.subquery(Double.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = querySub.from(Emp.class);
        querySub.select(criteriaBuilder.min(fromSub.get("sal"))).where(criteriaBuilder.equal(fromSub.get("dept").get("deptno"), 10));
        query.set("sal", criteriaBuilder.sum(from.get("sal"), criteriaBuilder.prod(from.get("sal"), 0.01D)))
                .where(criteriaBuilder.equal(from.get("sal"), querySub), criteriaBuilder.equal(from.get("dept").get("deptno"), 10));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio100() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Emp> query = criteriaBuilder.createCriteriaUpdate(Emp.class);
        Subquery<Integer> querySub = query.subquery(Integer.class);
        Subquery<Date> querySub2 = query.subquery(Date.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Emp> fromSub = querySub.from(Emp.class);
        Root<Emp> fromSub2 = querySub2.from(Emp.class);
        querySub2.select(fromSub2.get("hiredate")).where(criteriaBuilder.equal(fromSub2.get("ename"), "ALLEN"));
        querySub.select(fromSub.get("empId")).where(criteriaBuilder.greaterThan(fromSub.get("hiredate"), querySub2));
        query.set("sal", criteriaBuilder.diff(from.get("sal"), criteriaBuilder.function("nvl", Integer.class, from.get("comm"), criteriaBuilder.literal(0))))
                .where(from.get("empId").in(querySub));
        entityManager.createQuery(query).executeUpdate();
    }

    public void esercizio101() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Emp> query = criteriaBuilder.createCriteriaUpdate(Emp.class);
        CriteriaQuery<Dept> queryDept = criteriaBuilder.createQuery(Dept.class);
        Subquery<Integer> querySub = queryDept.subquery(Integer.class);
        Root<Emp> from = query.from(Emp.class);
        Root<Dept> fromSub = querySub.from(Dept.class);
        Expression<Integer> expr = criteriaBuilder.sum(criteriaBuilder.function("nvl", Integer.class, from.get("comm"), criteriaBuilder.literal(0)), 10);
        querySub.select(fromSub.get("deptno")).where(criteriaBuilder.equal(fromSub.get("loc"), "NEW YORK"));
        query.set("comm", expr)
                .where(criteriaBuilder.equal(from.get("dept").get("deptno"), querySub));
        entityManager.createQuery(query).executeUpdate();
    }
}



