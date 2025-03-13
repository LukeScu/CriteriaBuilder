# Esercizi su CriteriaBuilder

Questo file è un riferimento utile per esercitarsi con CriteriaBuilder
Possibili soluzioni si trovano sulla branch "Soluzioni"
Di seguito le tabelle da creare e le query sql da tradurre usando i CriteriaBuilder

Fonte delle tabelle e query : https://myorastuff.blogspot.com/2009/09/oracle-sql-questions.html

========================================================================================================================
<details>
<summary>## Creazione Tabelle</summary>
  
CREATE TABLE DEPT (
DEPTNO NUMBER(2),
DNAME VARCHAR2(14),
LOC VARCHAR2(13));

INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT VALUES (20, 'RESEARCH', 'DALLAS');
INSERT INTO DEPT VALUES (30, 'SALES', 'CHICAGO');
INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'BOSTON');

ALTER TABLE DEPT ADD PRIMARY KEY(DEPTNO);

CREATE TABLE EMP (EMPNO NUMBER(4) NOT NULL,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR NUMBER(4),
HIREDATE DATE,
SAL NUMBER(7,2),
COMM NUMBER(7,2),
DEPTNO NUMBER(2));

ALTER TABLE EMP ADD CONSTRAINT FK_EMP_01
FOREIGN KEY(DEPTNO) REFERENCES DEPT;

INSERT INTO EMP VALUES (7369, 'SMITH', 'CLERK', 7902, TO_DATE('17-DEC-1980', 'DD-MON-YYYY'), 800, NULL, 20);
INSERT INTO EMP VALUES (7499, 'ALLEN', 'SALESMAN', 7698, TO_DATE('20-FEB-1981', 'DD-MON-YYYY'), 1600, 300, 30);
INSERT INTO EMP VALUES (7521, 'WARD', 'SALESMAN', 7698, TO_DATE('22-FEB-1981', 'DD-MON-YYYY'), 1250, 500, 30);
INSERT INTO EMP VALUES (7566, 'JONES', 'MANAGER', 7839, TO_DATE('2-APR-1981', 'DD-MON-YYYY'), 2975, NULL, 20);
INSERT INTO EMP VALUES (7654, 'MARTIN', 'SALESMAN', 7698,TO_DATE('28-SEP-1981', 'DD-MON-YYYY'), 1250, 1400, 30);
INSERT INTO EMP VALUES (7698, 'BLAKE', 'MANAGER', 7839,TO_DATE('1-MAY-1981', 'DD-MON-YYYY'), 2850, NULL, 30);
INSERT INTO EMP VALUES (7782, 'CLARK', 'MANAGER', 7839,TO_DATE('9-JUN-1981', 'DD-MON-YYYY'), 2450, NULL, 10);
INSERT INTO EMP VALUES (7788, 'SCOTT', 'ANALYST', 7566,TO_DATE('09-DEC-1982', 'DD-MON-YYYY'), 3000, NULL, 20);
INSERT INTO EMP VALUES (7839, 'KING', 'PRESIDENT', NULL,TO_DATE('17-NOV-1981', 'DD-MON-YYYY'), 5000, NULL, 10);
INSERT INTO EMP VALUES (7844, 'TURNER', 'SALESMAN', 7698,TO_DATE('8-SEP-1981', 'DD-MON-YYYY'), 1500, 0, 30);
INSERT INTO EMP VALUES (7876, 'ADAMS', 'CLERK', 7788,TO_DATE('12-JAN-1983', 'DD-MON-YYYY'), 1100, NULL, 20);
INSERT INTO EMP VALUES (7900, 'JAMES', 'CLERK', 7698,TO_DATE('3-DEC-1981', 'DD-MON-YYYY'), 950, NULL, 30);
INSERT INTO EMP VALUES (7902, 'FORD', 'ANALYST', 7566,TO_DATE('3-DEC-1981', 'DD-MON-YYYY'), 3000, NULL, 20);
INSERT INTO EMP VALUES (7934, 'MILLER', 'CLERK', 7782,TO_DATE('23-JAN-1982', 'DD-MON-YYYY'), 1300, NULL, 10);

CREATE TABLE SALGRADE(
GRADE NUMBER(2),
LOSAL NUMBER,
HISAL NUMBER);

INSERT INTO SALGRADE VALUES(1, 700,1200);
INSERT INTO SALGRADE VALUES(2, 1201,1400);
INSERT INTO SALGRADE VALUES(3, 1401,2000);
INSERT INTO SALGRADE VALUES(4, 2001,3000);
INSERT INTO SALGRADE VALUES(5, 3001,9999);
</details>
========================================================================================================================
<details>
<summary>## Lista delle Query</summary>

1) Display all the records in emp table?
select * from emp;
2) Display all the records in emp table where employee belongs to deptno 10?
select * from emp where deptno = 10
3) Display all the records in emp table where employee does not belong to deptno 30?
select * from emp where deptno != 30;
4) Display total number of records in Emp table?
select count(*) from emp;
5) Display emp table with salary descending order?
select * from emp order by sal desc
6) Display first five records in employee table?
select * from emp where rownum <= 5
7) Display all the records in emp table order by ascending deptno, descending salary?
select * from emp order by deptno asc, sal desc
8) Display all employees those who were joined in year 1981?
select * from emp where to_char(hiredate,'YYYY') = 1981;
9) Display COMM in emp table. Display zero in place of null.
select nvl(comm,0) from emp
10) Display the records in emp table where MGR in 7698,7566 and sal should be greater then 1500
select * from emp where mgr in(7698,7566) and sal > 1500
11) Display all employees where employees hired before 01-JAN-1981
select * from emp where hiredate < '01-JAN-1981'
12) Display all employees with how many years they have been servicing in the company?
select hiredate,round((sysdate-hiredate)/360) as years from emp
13) Display all employees those were not joined in 1981?
select * from emp where to_char(hiredate,'YYYY') != 1981;
14) Display all employees where their hiredate belongs to third quarter?
select * from emp where to_char(hiredate,'Q') = 3;
15) Display all employees where their salary is less then the Ford’s salary?
select * from emp where sal <(select sal from emp where ename='FORD');
16) Display all the records in EMP table along with the rowid?
select ename,rowid from emp;
17) Display all records in EMP table those were joined before SCOTT joined?
select * from emp where hiredate <(select hiredate from emp where ename='SCOTT')
18) Display all employees those who were joined in third quarter of 1981?
select * from emp where to_char(hiredate,'Q') = 3 and to_char(hiredate,'YYYY') = 1981
19) Add 3 months with hiredate in EMP table and display the result?
select hiredate, add_months(hiredate,3) from emp
20) Display the date for next TUESDAY in hiredate column?
select next_day(hiredate,'TUESDAY') from emp;
21) Find the date, 15 days after today’s date.
select sysdate+15 from dual
22) Write a query to display current date?
select sysdate from dual;
select current_date from dual;
23) Display distinct job from emp table?
select distinct job from emp
24) Display all the records in emp table where employee hired after 28-SEP-81 and before 03-DEC-81?
select * from emp where hiredate between '28-SEP-81' and '03-DEC-81'
25) Write a query that displays the employee’s names with the first letter capitalized and all other letters lowercase for all employees whose name starts with J, A, or M
select initcap(ename) from emp where ename like 'J%' or ename like 'A%' or ename like 'M%'
26) Display all jobs that are in department 10. Include the location of department in the output.
select job, loc from emp,dept where emp.deptno = dept.deptno and emp.deptno =10
27) Write a query to display the employee name, department name of all employees who earn a commission
select ename,dname from emp,dept where emp.deptno = dept.deptno and comm is not null;
28) Display the empno, ename, sal, and salary increased by 15%.
select empno, ename, sal actual_sal, (sal * 15/100) as Increased_sal from emp
29) Display ename, sal, grade. Use emp, salgrade table
select ename,sal,grade from emp,salgrade where sal between losal and hisal;
30) Display all employees and corresponding managers
select w.ename,w.sal,m.ename,m.sal from emp w, emp m where w.mgr = m.empno;
31) Display all the departments where employee salary greater then average salary of that department.
select ename,deptno, sal from emp a where sal > (select avg(sal) from emp where emp.deptno = a.deptno) order by deptno;
32) Display all employees whose salary greater then the manager salary?
select w.ename,w.sal,m.ename,m.sal from emp w, emp m where w.mgr = m.empno and w.sal > m.sal
33) Display employees where length of ename is 5
select * from emp where length(ename) =5
34) Display all employees where ename start with J and ends with S
select * from emp where ename like 'J%S'
35) Display all employees where employee does not belong to 10,20,40
select * from emp where deptno not in(10,20,40)
36) Display all employees where jobs does not belong to PRESIDENT and MANAGER?
select * from emp where job not in('PRESIDENT','MANAGER');
37) Display the maximum salary in the emp table
select max(sal) from emp
38) Display average salary for job SALESMAN
select avg(sal) from emp where job = 'SALESMAN'
39) Display all three figures salary in emp table
select * from emp where sal < = 999;
select * from emp where length(sal) = 3;
40) Display all records in emp table for employee who does not receive any commission
select * from emp where comm is not null
41) Display all ename where first character could be anything, but second character should be L?
select * from emp where ename like '_L%'
42) Display nth highest and nth lowest salary in emp table?
SELECT DISTINCT (a.sal) FROM EMP A WHERE &N = (SELECT COUNT (DISTINCT (b.sal)) FROM EMP B WHERE a.sal<=b.sal);
select distinct sal from (select ename,sal,dense_rank() over(order by sal desc) dr from emp) where dr = &x ;
43) Display all the departments where department has 3 employees?
select deptno from dept a where deptno in(select deptno from emp group by deptno having count(*)=3)
44) Display emp name and corresponding subordinates. Use CONNECT BY clause.
select lpad(' ',level+12)+ename from emp connect by prior empno = mgr start with mgr is null
Note: Please replace pipe symbol in the place of + sign for question 44. Pipe symbol is not displaying the blog. This is the reason, i used Plus sign here.
45) Display sum of salary for each department. The output should be in one record
select sum(decode(deptno,10,sal)) dept10, sum(decode(deptno,20,sal)) dept20, sum(decode(deptno,30,sal)) dept30, sum(sal) total_sal from emp
46) Display all department with Minimum salary and maximum salary?
select min(sal),max(sal) from emp;
47) Display all ename, sal, deptno,dname from emp, dept table where all department which has employees as well as department does not have any employees. This query should include non matching rows.
select dname,b.deptno, ename,sal from emp a, dept b where a.deptno(+) = b.deptno;
select dname,b.deptno, ename,sal from emp a right outer join dept b on a.deptno = b.deptno;
48) Display all ename, sal, deptno from emp, dept table where all employees which has matching department as well as employee does not have any departments. This query should include non matching rows.
Note: In the below query, employee will always have matching record in dept table. Emp, dept table may not be good example to answer this question.
select dname,b.deptno, ename,sal from emp a, dept b where a.deptno = b.deptno(+);
select dname,b.deptno, ename,sal from emp a left outer join dept b on a.deptno = b.deptno;
49) Display all ename, sal, deptno from emp, dept table where all employees which has matching and non matching department as well as all departments in dept table which has matching and non matching employees. This query should include non matching rows on both the tables.
Note: In the below query, employee will always have matching record in dept table. Emp, dept table may not be good example to answer this question.
select dname,b.deptno, ename,sal from emp a full outer join dept b on a.deptno = b.deptno
50) Display all ename, empno, dname, loc from emp, dept table without joining two tables
select * from emp,dept;
51) Display all the departments where department does not have any employees
select deptno from dept where not exists(select 1 from emp where emp.deptno = dept.deptno);
select deptno from dept where deptno not in(select deptno from emp);
52) Display all the departments where department does have atleast one employee
select * from dept a where exists(select 1 from emp b where b.deptno = a.deptno)
select * from dept a where deptno in(select deptno from emp b where a.deptno = b.deptno)
53) Display all employees those who are not managers?
select ename from emp a where not exists (select 1 from emp b where b.mgr = a.empno);
select ename from emp a where empno not in (select mgr from emp b where b.mgr = a.empno and mgr is not null);
54) Display ename, deptno from emp table with format of {ename} belongs to {deptno}
select ename+' belongs to '+deptno from emp
Note: Please replace pipe symbol in the place of + sign for question 44. Pipe symbol is not displaying the blog. This is the reason, i used Plus sign here.
55) Display total number of employees hired for 1980,1981,1982. The output should be in one record.
select
count(decode(to_char(hiredate,'YYYY'), 1980,hiredate)) total_hire_1980,
count(decode(to_char(hiredate,'YYYY'), 1981,hiredate)) total_hire_1981,
count(decode(to_char(hiredate,'YYYY'), 1982,hiredate)) total_hire_1982
from emp
56) Display ename, deptno from employee table. Also add another column in the same query and it should display ten for dept 10, twenty for dept 20, thirty for dept 30, fourty for dept 40
select ename,deptno, (case deptno
when 10 then 'Ten'
when 20 then 'Twenty'
when 30 then 'Thirty'
when 40 then 'fourty'
else 'others' end) as dept
from emp
57) Display all the records in emp table. The ename should be lower case. The job first character should be upper case and rest of the character in job field should be lower case.
select lower(ename) as ename, initcap(job) as job from emp
58) Display all employees those who have joined in first week of the month ?
select * from emp where to_char(hiredate,'W') = 1;
59) Display all empoyees those who have joined in the 49th week of the year?
select * from emp where to_char(hiredate,'WW') = 49;
60) Display empno, deptno, salary, salary difference between current record and previous record in emp table. Deptno should be in descending order.
SELECT empno,
ename,
job,
sal,
LAG(sal, 1, 0) OVER (ORDER BY sal) AS sal_prev,
sal - LAG(sal, 1, 0) OVER (ORDER BY sal) AS sal_diff
FROM emp;
61) Create table emp1 and copy the emp table for deptno 10 while creating the table
Create table emp1 as select * from emp where deptno=10
62) Create table emp2 with same structure of emp table. Do not copy the data
create table emp2 as select * from emp where 1=2
63) Insert new record in emp1 table, Merge the emp1 table on emp table.
insert into emp1 values(9999,'PAUL','MANAGER',7839,SYSDATE,8900,NULL,10);

MERGE
INTO emp tgt
USING emp1 src
ON ( src.empno = tgt.empno )
WHEN MATCHED
THEN
UPDATE
SET tgt.ename = src.ename,
tgt.job = src.job,
tgt.mgr = src.mgr,
tgt.hiredate = src.hiredate,
tgt.sal = src.sal,
tgt.deptno = src.deptno
WHEN NOT MATCHED
THEN
Insert(
Tgt.empno,
Tgt.Ename,
Tgt.Job,
Tgt.Mgr,
Tgt.Hiredate,
Tgt.Sal,
Tgt.Comm,
Tgt.Deptno)
values (src.empno,
src.ename,
src.job,
src.mgr,
src.hiredate,
src.sal,
src.comm,
src.deptno);
64) Display all the records for deptno which belongs to employee name JAMES?
select * from emp where deptno in(select deptno from emp where ename = 'JAMES')
65) Display all the records in emp table where salary should be less then or equal to ADAMS salary?
select * from emp where sal <= (select sal from emp where ename='ADAMS')
66) Display all employees those were joined before employee WARD joined?
select * from emp where hiredate < (select hiredate from emp where ename='WARD')
67) Display all subordinate those who are working under BLAKE?
Select ename from emp where mgr = (select empno from emp where ename='BLAKE')
68) Display all subordinate(all levels) for employee BLAKE?
select ename from emp start with empno = (select empno from emp where ename='BLAKE')
connect by prior empno = mgr
69) Display all record in emp table for deptno which belongs to KING's Job?
select * from emp where deptno in(select deptno from emp where job= (select job from emp where ename = 'KING'))
70) Display the employees for empno which belongs to job PRESIDENT?
select * from emp where empno in(select empno from emp where ename in(select ename from emp where JOB = 'PRESIDENT'));
71) Display list of ename those who have joined in Year 81 as MANAGER?
select * from emp where to_char(hiredate,'YYYY') = 1981 and job = 'MANAGER';
72) Display who is making highest commission?
select * from emp where comm = (select max(comm) from emp);
73) Display who is senior most employee? How many years has been working?
select * from emp where trunc(sysdate-hiredate)/365 = (select max(trunc(sysdate-hiredate)/365) from emp);
select * from emp where hiredate =(select min(hiredate) from emp)
74) Display who is most experienced and least experienced employee?
select * from emp where trunc(sysdate-hiredate)/365 = (select min(trunc(sysdate-hiredate)/365) from emp);
select * from emp where hiredate =(select max(hiredate) from emp)
75) Display ename, sal, grade, dname, loc for each employee.
select empno,ename,b.deptno,dname,grade from
emp a,dept b, salgrade c
where a.deptno = b.deptno
and sal between losal and hisal;
76) Display all employee whose location is DALLAS?
SELECT emp.ename, emp.JOB, emp.deptno
FROM emp
WHERE EXISTS
(SELECT 'x'
FROM dept d
WHERE d.DEPTNO = emp.DEPTNO
AND d.LOC = 'DALLAS') ;

select emp.ename, emp.job, emp.deptno
from emp
where deptno in(select deptno from dept where loc='DALLAS');
77) Display ename, job, dname, deptno for each employee by using INLINE view?
SELECT emp.ename,
emp.JOB,
emp.deptno,
dnames.dname
FROM emp
JOIN (select dname, deptno
from dept ) dnames ON emp.deptno = dnames.deptno
78) List ename, job, sal and department of all employees whose salary is not within the salary grade?
select ename, job, sal, dname
from emp, dept
where emp.deptno = dept.deptno
and not exists
(select ‘x’ from salgrade
where emp.sal between losal and hisal);
79) Use EMP and EMP1 table. Query should have only three columns. Display empno,ename,sal from both tables inluding duplicates.
select empno, ename, sal from emp
union all
select empno, ename, sal from emp1
80) Delete emp table for detpno 10 and 20.
delete emp where deptno in(10,20);
81) Delete all employees those are not getting any commission?
delete emp where comm is null;
82) Delete all employees those who employeed more then 28 years
delete emp where trunc(sysdate - hiredate)/365 > 28;
83) Add duplicate records in emp1 table. Delete the duplicate records in emp1 table.
insert into emp1 select * from emp1 where rownum <=1; commit; delete emp1 a where a.rowid <>(select min(b.rowid) from emp1 b where a.empno = b.empno);
84) Delete the employees where employee salary greater then average salary of department salary?
delete emp a where sal > (select avg(sal) from emp where emp.deptno = a.deptno);
85) Delete all employees those who are reporting to BLAKE?
Delete emp where ename in(Select ename from emp where mgr = (select empno from emp where ename='BLAKE'))
86) Delete all levels of employees those who are under BLAKE?
Delete emp where ename in(select ename from emp start with empno = (select empno from emp where ename='BLAKE')
connect by prior empno = mgr)
87) Delete all employees those who are only managers?
delete emp where ename in(select ename from emp a where empno in (select mgr from emp b where b.mgr = a.empno and mgr is not null))
88) Remove the department in dept table where dept does not have any employees?
delete dept where deptno not in(select deptno from emp where deptno is not null)
89) Remove all grade 2 employees in emp table?
delete emp where empno in(select empno from emp,salgrade where sal between losal and hisal and grade = 2)
90) Remove all the employees in SMITH's department
delete emp where deptno = (select deptno from emp where ename = 'SMITH')
91) Remove least paid employee who are reporting to BLAKE ?
delete emp where sal = (select min(sal) from emp where mgr =
(select empno from emp where ename = 'BLAKE')) and
ename in(select ename from emp where mgr =
(select empno from emp where ename = 'BLAKE'))
92) Remove all employees who were joined before SMITH joined?
delete emp where hiredate < (select hiredate from emp where ename='SMITH');
93) Rename the employee name JONES to ANDY
update emp set ename = 'ANDY' where ename = 'JONES'
94) Change the WARD's hiredate to one day ahead
update emp set hiredate = hiredate + 1 where ename = 'WARD'
95) Update MARTIN salary same as SMITH's salary
update emp set sal = (select sal from emp where ename = 'SMITH') where ename='MARTIN'
96) Increase the salary 5% for employee those who are earning commission less then 1000
update emp set sal = sal + (sal * (5/100)) where comm between 0 and 1000
97) Increase 250$ commission for BLAKE's team
update emp set comm = nvl(comm,0)+250 where mgr = (select empno from emp where ename='BLAKE');
98) Increase 100$ for employee who is making more then averge salary of his department?
update emp a set sal = sal + 150 where sal > (select avg(sal) from emp b where b.deptno = a.deptno)
99) Increase 1% salary for employee who is making lowest salary in dept 10
update emp set sal = sal + (sal* 1/100)
where
sal = (select min(sal) from emp where deptno = 10)
and deptno = 10
100) Reduce the commission amount from employee salary for each employee who were joined after ALLEN joined.
update emp set sal = sal - NVL(comm,0)
where empno in(select empno from emp where hiredate > (select hiredate from emp where
ename = 'ALLEN'))
101) Increase commission 10$ for employees those who are located in NEW YORK.
update emp a set comm = NVL(COMM,0) + 10
where deptno = (select deptno from dept where loc='NEW YORK');
</details>
