--1
SELECT name, 
       title, 
       salary, 
       dept_id 
FROM   s_emp 
WHERE  dept_id IN ( 112, 118 )
	   AND (title like '%과장' or title like '%사원')
       AND salary >= 1500 
       AND salary <= 4000; 
       
--2
SELECT name, 
       title, 
       salary
FROM   s_emp 
WHERE  manager_id is null; 

--3
SELECT name, 
       title, 
       salary
FROM   s_emp 
WHERE  title like '%부장' and salary >=3000;

--4
SELECT name, 
       title, 
       salary 
FROM   s_emp 
WHERE  dept_id IN ( 112, 113,117,118)
	   AND (title = '과장' or title = '%부장')
       AND salary >= 2300 
       AND salary <= 3000; 
       
--5
SELECT name, 
       title, 
       salary,
       start_date
FROM   s_emp
WHERE  (title like '%과장' or title like '%부장')
       AND to_char(start_date, 'mm') = '3'; 

--6
SELECT salary*16+1000 연봉
FROM   s_emp;

--7
SELECT name||' '||title||'의 급여 '||salary 직원급여
FROM   s_emp;

--8
SELECT name 
FROM   s_emp 
WHERE  ( commission_pct IS NOT NULL 
          OR manager_id IS NOT NULL ) 
       AND salary >= 2500; 
    
--9 
SELECT dept_id, 
       Min(salary) 
  FROM s_emp 
 GROUP BY dept_id; 

--10 
SELECT title, 
       Min(salary) 
  FROM s_emp 
 WHERE NOT title LIKE '%부장' 
 GROUP BY title; 

--11 
SELECT title, 
       Avg(salary) 
  FROM s_emp 
 GROUP BY title; 

--12 
SELECT title, 
       Count(title) 
  FROM s_emp 
 GROUP BY title; 

--13 
SELECT title, 
       Max(salary) 
  FROM s_emp 
HAVING Max(salary) >= 2000 
 GROUP BY title; 

--14 
SELECT title, 
       Min(salary) 
  FROM s_emp 
HAVING NOT title LIKE '%부장' 
 GROUP BY title 
 ORDER BY Min(salary) DESC; 

--15 
SELECT title, 
       Avg(salary) 
  FROM s_emp 
HAVING NOT title LIKE '사원' 
 GROUP BY title 
 ORDER BY Avg(salary); 

--16  
SELECT title, 
       SUM(salary) 
  FROM s_emp 
HAVING NOT title LIKE '사원' 
       AND SUM(salary) >= 2000 
 GROUP BY title 
 ORDER BY SUM(salary) DESC; 

--17 
SELECT Upper(Substr(mailid, 1, 1)) 
       || Lower(Substr(mailid, 2)) AS "메일 아이디" 
  FROM s_emp; 

--18 
SELECT name 
  FROM s_emp 
 WHERE Length(name) > 2; 

--19 
SELECT name, 
       Round(( salary * 16 ) * ( Months_between(SYSDATE, start_date) / 12 )) AS 
       총급여 
  FROM s_emp; 

--20 
SELECT name, 
       Nvl(To_char(commission_pct), '커미션없음') 
  FROM s_emp; 

--21 
SELECT name, 
       CASE 
         WHEN title LIKE '%사원' THEN Round(salary * 16 / 12 * 1.1) 
         WHEN title LIKE '%과장' THEN Round(salary * 16 / 12 * 1.2) 
         ELSE Round(salary * 16 / 12 * 1.1) 
       END 
  FROM s_emp; 

--22 
SELECT name, 
       Rpad(To_char(Round(salary * 16 / 12)), salary * 16 / 12 / 100, '*') 
       월급 
  FROM s_emp; 

--23 
SELECT dept_id               부서번호, 
       SUM(Decode(title, '사원', salary, 
                         0)) 사원, 
       SUM(Decode(title, '과장', salary, 
                         0)) 과장, 
       SUM(CASE 
             WHEN title NOT LIKE '사원' 
                   OR title NOT LIKE '과장' THEN salary 
             ELSE 0 
           END)              기타, 
       SUM(salary)           합계 
  FROM s_emp 
 GROUP BY dept_id 
 ORDER BY dept_id; 