create table salgrade (
grade char(1),
min_sal number(6),
max_sal number(6)
);

insert into salgrade values('1', 20000, 100000);
insert into salgrade values('2', 10000, 19999);
insert into salgrade values('3', 6000, 9999);
insert into salgrade values('4', 3000, 5999);
insert into salgrade values('5', 1, 2999);


select * 
from salgrade;

select last_name, salary
from employees;

select e.last_name, e.salary, sg.grade
from employees e, salgrade sg
where e.salary between sg.min_sal and sg.max_sal;


-- 각 사원의 job_id 에 해당하는 최대 받을 수 있는 급여와 최소급여가 얼마인지 출력하시오
select
e.last_name 사원명,
e.salary 봉급,
e.job_id 직무명,
j.max_salary 최대급여,
j.min_salary 최소급여
from employees e,jobs j
where e.job_id = j.job_id;


-- 각 사원의 관리자 정보를 출력하시오 
-- selfjoin
-- 가상의 동일한 테이블 하나 더 생성해서 조건을 걸어줌
select e.last_name 사원, m.last_name 관리자
from employees e, employees m
where e.manager_id = m.employee_id;

-- outer join 널값 추가
select e.last_name 사원, 
case when m.last_name is null then nvl(m.last_name, '관리자없음') else m.last_name end  관리자
from employees e, employees m
where e.manager_id = m.employee_id(+);

-- set 연산자
-- 테스트 데이터 생성
create table tc_seta (
no number,
data varchar2(2)
);

create table tc_setb (
no number,
data varchar2(2)
);

insert into tc_seta values(1, 'a');
insert into tc_seta values(2, 'b');
insert into tc_seta values(3, 'c');
insert into tc_seta values(4, 'd');

insert into tc_setb values(3, 'c');
insert into tc_setb values(4, 'd');
insert into tc_setb values(5, 'e');
insert into tc_setb values(6, 'f');

-- union all 더하기
SELECT no, 
       data 
  FROM tc_seta 
UNION ALL 
SELECT no, 
       data 
  FROM tc_setb; 

-- minus 차집합
SELECT no, 
       data 
  FROM tc_seta 
MINUS
SELECT no, 
       data 
  FROM tc_setb; 
  
-- union 합집합, 정렬
SELECT no, 
       data 
  FROM tc_seta 
UNION 
SELECT no, 
       data 
  FROM tc_setb; 

-- intersect 교집합
SELECT no, 
       data 
  FROM tc_seta 
INTERSECT 
SELECT no, 
       data 
  FROM tc_setb; 

-- 조건1 결과 열의 수가 같아야 한다.
SELECT last_name, 
       salary, 
       department_id 
  FROM employees 
UNION ALL 
SELECT department_id, 
       department_name 
  FROM departments; 
  
-- 조건2 서로 대응하는 열의 데이터 타입이 같아야 한다. 
SELECT last_name, 
       salary 
  FROM employees 
UNION ALL 
SELECT department_id, 
       department_name 
  FROM departments; 

-- 조건3 order by절이 중간에 오면 안된다. 
SELECT last_name, 
       salary 
  FROM employees 
 ORDER BY last_name 
UNION ALL 
SELECT department_id, 
       department_name 
  FROM departments; 

-- 조건4 정렬은 첫번째 select 절의 컬럼을 기준으로 해야한다. 
SELECT department_id, 
       last_name 
  FROM employees 
UNION ALL 
SELECT department_id, 
       department_name 
  FROM departments 
 ORDER BY department_name; 
 

-- 서브쿼리 : 쿼리 안의 쿼리
-- Chen 사원이 속해있는 부서의 평균 급여를 구하시오

 -- 단일행 서브쿼리(Single Row SubQuery)
 SELECT Avg(salary) 
  FROM employees 
 WHERE department_id = (SELECT department_id 
                          FROM employees 
                         WHERE last_name = 'Chen');
                         
 
 -- 다중행 서브쿼리(Multi Row SubQuery)                      
SELECT department_id 부서, 
       round(Avg(salary)) 평균급여 
  FROM employees 
 WHERE department_id IN (SELECT department_id 
                           FROM employees 
                          WHERE last_name = 'King') 
 GROUP BY department_id; 

 
SELECT d.department_name 부서, 
       round(Avg(salary)) 평균급여 
  FROM employees e, departments d
 WHERE e.department_id = d.department_id IN (SELECT department_id 
                           FROM employees 
                          WHERE last_name = 'King')               
 GROUP BY department_id; 

-- 30번 부서의 평균급여보다 급여를 많이 받는 사원 정보 출력
select *
from employees
where salary > (select avg(salary) from employees where department_id=30);

-- 30번 부서의 사원들이 받는 급여보다 많은 급여를 받는 사원의 정보 출력
select *
from employees
where salary >ALL (select salary from employees where department_id=30);

-- 30번 부서의 사원들이 받는 제일작은 급여보다 많은 급여를 받는 사원의 정보 출력
select *
from employees
where salary >ANY (select salary from employees where department_id=30);

-- 30번 부서의 사원들이 받는 급여들이랑랑 같은 급여를  받는 사원들의 정보 출력
select *
from employees
where salary in (select salary from employees where department_id=30);

select *
from employees
where salary =ANY (select salary from employees where department_id=30);

-- 각 부서에서 가장 작은 급여를 받는 사원의 정보
-- 부서번호와 최소급여 두개를 동시에 비교해야함
-- multi column subquery
SELECT * 
  FROM employees 
 WHERE ( department_id, salary ) IN (SELECT department_id, 
                                            Min(salary) 
                                       FROM employees 
                                      GROUP BY department_id) 
-- 쿼리를 join 문으로 변경
SELECT * 
  FROM employees e, 
       (SELECT department_id, 
               Min(salary) min_sal 
          FROM employees 
         GROUP BY department_id) m 
 WHERE e.department_id = m.department_id 
       AND e.salary = min_sal; 


-- 사원명, 부서번호, 부서명
SELECT e.last_name, 
       e.department_id, 
       d.department_name 
  FROM employees e, 
       departments d 
 WHERE e.department_id = d.department_id; 

SELECT e.last_name, 
       e.department_id, 
       (SELECT department_name 
          FROM departments 
         WHERE department_id = e.department_id) 
  FROM employees e; 

-- From 절에서 사용하는 SubQuery : Inline View
-- Inline View에서는 Order by 사용 가능
SELECT department_id, 
       max_sal 
  FROM (SELECT department_id, 
               Max(salary) max_sal 
          FROM employees 
         GROUP BY department_id) 
 ORDER BY department_id; 
 
--Top-N 서브쿼리 
SELECT ROWNUM, 
       last_name, 
       salary 
  FROM employees 
 WHERE ROWNUM < 11; 

--rownum이 1번인 데이터 출력 
SELECT ROWNUM, 
       last_name, 
       salary 
  FROM employees 
 WHERE ROWNUM = 1; 

SELECT ROWNUM, 
       last_name, 
       salary 
  FROM employees 
 WHERE ROWNUM = 2; 

-- 사원 중에서 급여를 많이 받는 5명 출력 
SELECT ROWNUM, 
       last_name, 
       salary 
  FROM (SELECT * 
          FROM employees 
         ORDER BY salary DESC) 
 WHERE ROWNUM < 6; 

SELECT rnum, 
       last_name, 
       salary 
  FROM (SELECT ROWNUM rnum, 
               last_name, 
               salary 
          FROM (SELECT * 
                  FROM employees 
                 ORDER BY salary DESC)) 
 WHERE rnum BETWEEN 1 AND 10; 

SELECT rnum, 
       last_name, 
       salary 
  FROM (SELECT ROWNUM rnum, 
               last_name, 
               salary 
          FROM employees 
         ORDER BY salary DESC) 
 WHERE rnum BETWEEN 1 AND 10; 

-- 서브쿼리를 이용하는 테이블 생성 
CREATE TABLE employees_copy AS 
  SELECT * 
    FROM employees; 

SELECT * 
  FROM employees_copy; 

CREATE TABLE employees_copy2 AS 
  SELECT * 
    FROM employees 
   WHERE 1 != 1; 

SELECT * 
  FROM employees_copy2; 

INSERT INTO employees_copy2 
SELECT * 
  FROM employees; 

SELECT * 
  FROM employees_copy2; 