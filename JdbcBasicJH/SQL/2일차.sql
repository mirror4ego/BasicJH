-- Group By	: 데이터의 소그룹화
-- 그룹 함수	: count(컬럼|표현식), max(컬럼|표현식), min(컬럼|표현식), sum(컬럼|표현식), avg(컬럼|표현식)
-- 그룹 함수의 특징 : 여러개의 데이터를 가지고 하나의 결과값만 나옴
-- 사원의 총 수를 출력하시오
SELECT employee_id
FROM   employees; 

SELECT Count(employee_id) 
FROM   employees; 

-- 사원중에 가장 많은 급여를 출력
SELECT max(salary) 
FROM   employees; 

SELECT min(salary), sum(salary), avg(salary) 
FROM   employees;

/*
 * 테이블			사원들
 * 조건			10번 부서의 사원
 * 화면에출력 누구 	최고급여
 */
-- 10번 부서의 사원들의 급여중에서 가장 많은 급여가 얼마인지 출력
SELECT Max(salary) 
FROM   employees 
WHERE  department_id = 10; 

-- 10번부서 20번부서 사원급여중
-- 부서별 가장 많은 급여 얼마인지 출력
SELECT Max(salary) 
FROM   employees 
WHERE  department_id in (10,20);
	
SELECT department_id 부서번호, Max(salary) 최고연봉
FROM   employees 
WHERE  department_id IN ( 10, 20 ) 
GROUP  BY department_id;

-- 그룹핑 원리 이해
CREATE TABLE t86_group 
  ( 
     id      VARCHAR2(32), 
     sal     NUMBER, 
     job_id  VARCHAR2(2), 
     dept_id NUMBER 
  ) 

INSERT INTO t86_group VALUES('a', 1000, 'SA', 10);
INSERT INTO t86_group VALUES('b', 2000, 'CM', 30);
INSERT INTO t86_group VALUES('c', 3000, 'CM', 20);
INSERT INTO t86_group VALUES('d', 4000, 'LA', 10);
INSERT INTO t86_group VALUES('e', 3000, 'SA', 30);
INSERT INTO t86_group VALUES('f', 2000, 'SA', 10);

SELECT * 
FROM   t86_group; 

SELECT Max(sal) 
FROM   t86_group 
GROUP  BY dept_id; 

SELECT Max(sal) 
FROM   t86_group 
GROUP  BY job_id; 

SELECT Max(sal)
FROM   t86_group 
GROUP  BY dept_id, job_id;

SELECT dept_id, job_id, Max(sal)
FROM   t86_group 
GROUP  BY dept_id, job_id;

--job_id가 여러개 나올수 있는데 max는 하나만 나와야 하기때문에 오류가 난다
SELECT dept_id, job_id, Max(sal)
FROM   t86_group 
GROUP  BY dept_id;

-- 각 부서별 최대 급여를 출력하라.
-- 출력시 최대급여, 부서번호, 사원의 이름을 출력
SELECT Max(salary), department_id, last_name
FROM   employees
GROUP  BY department_id;

-- 각 부서별 부서번호, 사원수를 출력하시오
SELECT department_id, count(*)
FROM   employees
GROUP  BY department_id
ORDER  BY department_id;

-- 각 부서별 최대급여를 출력합니다.
-- 단, 최대급여가 높은 부서부터 출력
SELECT department_id, max(salary) max_sal
FROM   employees
GROUP  BY department_id
ORDER  BY max_sal desc;

-- 부서별 평균 급여를 출력합니다.
-- 단, 100번보다 큰 부서는 제외하고 부서의 평균급여가 5000이상인 부서만 출력합니다.
-- 출력은 부서번호 순으로
SELECT   department_id, 
         Avg(salary)
FROM     employees 
WHERE    department_id <= 100 and Avg(salary) >= 5000 
GROUP BY department_id 
ORDER BY department_id;

-- 그룹함수에 대한 제약은 having절에서 처리한다.
SELECT   department_id, 
         Avg(salary)
FROM     employees 
WHERE    department_id <= 100 
GROUP BY department_id 
HAVING   Avg(salary) >= 5000
ORDER BY department_id;

-- 실행순서
-- FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY

-----------------------------------
-- 문자형 함수
-----------------------------------
SELECT last_name, Lower(last_name), Upper(last_name), Initcap(last_name) 
FROM   employees; 

SELECT last_name, concat(last_name, first_name), substr(last_name, 1, 2), substr(last_name, 3, 2)
FROM   employees;

SELECT last_name, concat(lower(last_name), upper(first_name)) 
FROM   employees; 

SELECT last_name,
       length(last_name),
       trim('A' from last_name),
       lpad(last_name, 10, '*'),
       rpad(last_name, 10, '*'),
       translate(last_name, 'Ba', '**'), --문자 하나 단위로 바뀜
       replace(last_name, 'Ba', '**') --단어 단위로 바뀜
FROM   employees; 

-----------------------------------
-- 숫자형 함수
-----------------------------------
SELECT Abs(-11), Mod(3,2), Sign(-11), Sign(0), Sign(11)
FROM   dual; 

SELECT Ceil(1.1), Floor(1.1)
FROM   dual; 

SELECT Round(75.152, -2), Trunc(25.152, -2)
FROM   dual; 

-----------------------------------
-- 날짜형 함수
-----------------------------------
SELECT sysdate, add_months(sysdate,1), 
       months_between(sysdate, add_months(sysdate,-2)), 
       last_day(sysdate)
FROM   dual; 

-- 각 사원의 장기 휴가는 입사일로부터 10년째 되는날에 발생한다
SELECT last_name as "사원이름", Add_months(hire_date, 120) AS "휴가일" 
FROM   employees; 

-- 각 사원의 근속개월수
SELECT last_name as "사원이름", trunc(months_between(sysdate, hire_date)) as "근속개월"
FROM   employees;

-- 날짜  + 숫자 -> 날짜
-- 날짜  - 날짜 -> 숫자
select sysdate, sysdate+7, sysdate-7, sysdate-sysdate, sysdate + 1/24
from dual;

-- 각 사원의 근속일수
SELECT last_name as "사원이름", round(sysdate - hire_date) as "근속일수"
FROM   employees;

-----------------------------------
-- 변환형 함수
-----------------------------------
-- 변환형 함수	::: format(날짜 -> 문자), parse(문자 -> 날짜)
-- to_char 	: 날짜 -> 문자, 숫자 -> 문자
-- to_date 	: 문자 -> 날짜
-- to_number: 문자 -> 숫자

SELECT to_date('20160721', 'yyyymmdd') 
FROM   dual;

SELECT to_char(SYSDATE,'yyyy-mm-dd hh24:mi:ss') 
FROM   dual;

SELECT to_char(sysdate, 'yyyy"년"mm"월"dd"일"') 
FROM   dual;

SELECT to_char(1000000000), to_char(1000000000, '9,999,999,999'), to_char(10000000000, '9,999,999,999')
FROM   dual;

SELECT to_number('900000'),
       to_number('900,000', '999,999')
FROM   dual;

-- 사원중에서 5월에 입사한 사원들의 정보만 출력하시오
SELECT * 
FROM   employees 
WHERE  To_char(hire_date, 'mm') = '05'; 

--현재월
SELECT * 
FROM   employees 
WHERE  To_char(hire_date, 'mm') = To_char(sysdate, 'mm');


-----------------------------------
-- 기타 함수
-----------------------------------
-- 기타함수 : decode(=비교밖에안됨), case, 일반적으로 통계 쿼리에 많이 사용됨...

SELECT Decode(job_id, 'AC_ACCOUNT', '회계사', 
                      'IT_PROG', '위대한 개발자', 
                      'SA_MAN', '말잘하는 영업맨', 
                      '평범한 직원') AS 직업 
FROM   employees; 

SELECT CASE job_id 
         WHEN 'AC_ACCOUNT' THEN '회계사' 
         WHEN 'IT_PROG' THEN '위대한 개발자' 
         ELSE '무직' 
       END AS 직업
FROM   employees; 

SELECT CASE 
         WHEN job_id = 'AC_ACCOUNT' THEN '회계사' 
         WHEN job_id = 'IT_PROG' THEN '위대한 개발자' 
         ELSE '무직' 
       END AS 직업
FROM   employees; 

SELECT job_id
FROM   employees; 

SELECT Decode(job_id, 'AC_ACCOUNT', '회계사', 
                      'IT_PROG', '위대한 개발자', 
                      'SA_MAN', '말잘하는 영업맨', 
                      '평범한 직원') AS 직업
  FROM employees; 

SELECT CASE job_id 
         WHEN 'AC_ACCOUNT' THEN '회계사' 
         WHEN 'IT_PROG' THEN '위대한 개발자' 
         ELSE '무직' 
       END AS 직업
  FROM employees; 

SELECT CASE 
         WHEN job_id = 'AC_ACCOUNT' THEN '회계사' 
         WHEN job_id = 'IT_PROG' THEN '위대한 개발자' 
         ELSE '무직'
       END AS 직업 
  FROM employees; 

SELECT job_id 
  FROM employees; 

-- 사원의 급여에따라서
-- 급여가 10000이상 "우후.."
-- 급여가 5000이상 "아이.."
-- 급여가 5000미만 "에이.."
SELECT salary, 
       CASE 
         WHEN salary >= 10000 THEN '우후..' 
         WHEN salary >= 5000 THEN '아이..' 
         ELSE '에이..' 
       END AS 연봉반응
FROM   employees 
ORDER  BY salary DESC;

-- 조인
-- 결과행의 수 : M X N, 카테시안 프로덕트(Cartesian Product)
-- 테이블간의 증거조건을 주지 않았을때 발생
SELECT employees.employee_id, 
       employees.department_id, 
       departments.department_name 
FROM   employees, 
       departments 

-- equi 조인
SELECT employees.last_name, 	
       employees.department_id, 
       departments.department_name 
FROM   employees, 
       departments 
WHERE  employees.department_id = departments.department_id; 

-- 칼럼 alias
SELECT e.last_name, 	
       e.department_id, 
       d.department_name 
FROM   employees e, 
       departments d 
WHERE  e.department_id = d.department_id;

-- 테이블명 생략
SELECT last_name, 	
       e.department_id, 
       department_name 
FROM   employees e, 
       departments d
WHERE  e.department_id = d.department_id;

-- 3개 테이블 조인
SELECT e.last_name, 
       e.department_id, 
       d.department_name, 
       d.location_id, 
       l.city 
FROM   employees e, 
       departments d, 
       locations l 
WHERE  e.department_id = d.department_id 
       AND d.location_id = l.location_id; 
       
-- Canada에 근무하는 사원의 지역명, 부서명, 사원명 출력하시오
       
SELECT l.city            지역명, 
       d.department_name 부서명, 
       e.last_name       사원명 
FROM   employees e, 
       departments d, 
       locations l, 
       countries c 
WHERE  e.department_id = d.department_id 
       AND d.location_id = l.location_id 
       AND l.country_id = c.country_id 
       AND c.country_name = 'Canada'; 
       
       
