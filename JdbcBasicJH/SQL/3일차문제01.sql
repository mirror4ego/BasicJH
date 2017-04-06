--1
select job_id, max(salary), min(salary)
from EMPLOYEES
where job_id like 'SA%'
group by job_id;

--2
select job_id, max(salary) max_sal
from employees
group by job_id
order by max(salary) desc;

--3
select employee_id, first_name, salary
from employees
where salary between (select min_salary from jobs where job_title = 'Programmer') 
and (select max_salary from jobs where job_title = 'Programmer');

--4
select first_name 이름, last_name 성, salary 연봉
from employees e, jobs j
where (salary between 9000 and 10000) 
and e.job_id = j.job_id
and j.job_title = 'Sales Representative'
order by first_name;

--5
select e.employee_id 사원, e.first_name 이름, j.job_title 업무명, d.department_name 부서명
from employees e, jobs j, departments d, locations l
where e.department_id = d.department_id
and d.location_id = l.location_id
and e.job_id = j.job_id
and l.city = 'Seattle'; 

--6
SELECT j.job_title 업무명, 
       SUM(e.salary) 연봉 
  FROM employees e, 
       jobs j 
 WHERE j.job_id = e.job_id 
 GROUP BY j.job_title 
HAVING SUM(e.salary) > 30000
order by sum(e.salary) desc;

--7 
select e1.last_name 이름, e1.salary 연봉
from employees e1, employees e2
where e1.manager_id = e2.employee_id and e1.salary > e2.salary;

--8
select e1.employee_id 사번, e1.first_name 이름, d.department_name 부서명, e2.first_name 매니저이름
from employees e1, employees e2, departments d
where e1.manager_id = e2.employee_id and d.department_id = e1.department_id;

--9
select e1.employee_id 사번, e1.first_name 이름, 
case when e2.first_name is null then '관리자 없음' else e2.first_name end as "관리자 이름"
from employees e1, employees e2
where e1.manager_id = e2.employee_id(+) and e1.first_name like '%v%';

--10
select e1.employee_id 사번, e1.last_name 이름, e1.hire_date 사원입사일, e2.hire_date 매니저입사일
from employees e1, employees e2
where e1.manager_id = e2.employee_id and e1.hire_date < e2.hire_date
order by e1.hire_date;

--11
select e.employee_id 사번, e.last_name 이름, c.cmi 직속부하직원수 
from (select manager_id, count(manager_id) cmi from employees group by manager_id) c,
      employees e
where e.employee_id = c.manager_id and c.cmi > 7
order by c.cmi desc;

--12
select e.employee_id 사번, e.last_name 이름, e.salary 급여, e.department_id 부서번호, k.avg_sal 부서평균급여
from employees e, (select department_id, avg(salary) avg_sal from employees group by department_id) k
where e.department_id = k.department_id and e.salary > k.avg_sal;

--13
select e.first_name 이름, e.salary 급여, d.department_name 부서명
from employees e, departments d
where e.department_id = d.department_id  and e.salary < (select avg(salary) avg_sal from employees where department_id=100) and d.department_name = 'Sales';

--14
select 
from employees e, departments d, locations l
where e.department_id = d.department_id and d.location_id = l.location_id;

--14
select l.city 도시, avg(e.salary) 급여, count(l.city) 근무인원수
from employees e, departments d, locations l
where e.department_id = d.department_id 
and d.location_id = l.location_id 
group by l.city
having count(l.city) > 10;

--15
select employee_id, last_name, salary
from employees
where (department_id, salary) in (select department_id, max(salary) from employees group by department_id)
order by salary desc;

--16
select job_title, sum(salary)
from employees e, jobs j
where e.job_id = j.job_id
group by j.job_title
order by sum(e.salary) desc;

--17
select job_title, department_name
from (select job_id, max(department_id) d_id from employees group by job_id) e, jobs j, departments d
where e.job_id = j.job_id
and e.d_id = d.department_id
order by j.job_title;

--18
select to_char(hire_date, 'yyyy') "입사 년도", count(to_char(hire_date, 'yyyy')) "입사자 인원"
from employees
group by to_char(hire_date, 'yyyy')
order by to_char(hire_date, 'yyyy');

--19
select to_char(hire_date, 'mm') "입사 월", count(to_char(hire_date, 'mm')) "입사자 인원"
from employees
group by to_char(hire_date, 'mm')
order by to_char(hire_date, 'mm');

--20
select department_name 부서명, e.asal 평균연봉
from (select department_id, avg(salary) asal from employees group by department_id) e, departments d
where e.asal <= (select avg(salary) from employees where department_id = 30)
and e.department_id = d.department_id;

--21
select employee_id, first_name, last_name, nvl(department_name, 'NOT ASSIGNED') department_name
from employees e, departments d
where e.department_id = d.department_id(+)
and to_char(hire_date, 'yyyy') = 1999;

--22
select country_name, count(country_name) CNT
from (select e2.employee_id, max(e2.department_id) did
from employees e1, employees e2
where e1.manager_id = e2.employee_id group by e2.employee_id) a, departments d, locations l, countries c
where a.did = d.department_id and d.location_id = l.location_id and l.country_id = c.country_id
group by country_name
order by count(country_name);

--23
select employee_id, first_name, salary
from employees e, departments d, locations l
where e.department_id = d.department_id 
and d.location_id = l.location_id
and city = 'Southlake'
and salary = (select max(salary) from employees e, departments d, locations l
where e.department_id = d.department_id 
and d.location_id = l.location_id
and city = 'Southlake')

select *
from employee
