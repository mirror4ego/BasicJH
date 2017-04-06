# 오라클 제공 단일행 함수
 
# NUMBER 함수 
 
#ROUND, TRUNC 는 첫 번째 argument를 소수점 아래 두 번째 argument자리까지 표현한다. 
SELECT sal, ROUND(sal, -3), TRUNC(sal, -3) FROM emp; 
  
#ROUND, TRUNC 함수의 두 번째 argument를 생략하면 default로 0 이다. 
SELECT ROUND(45.925), ROUND(45.925, 0), TRUNC(45.925), TRUNC(45.925, 0) 
  FROM dual; 
  
#FLOOR, CEIL 함수는 argument가 1개이며, TRUNC나 ROUND(반올림의 경우)로 바꾸어 표현이 가능하다. 
#FLOOR나 CEIL은 정수부분만 표시한다.  
#TRUNC나 ROUND는 자리수 표현, 자리수 지정 없으면 정수부분 
SELECT FLOOR(45.925), CEIL(45.925) FROM dual; 
SELECT TRUNC(45.925), ROUND(45.925) FROM dual;
  
  
# 문자열 함수 
  
SELECT CONCAT('Oracle','DBMS'), INITCAP('Oracle DBMS'),  
            LOWER('Oracle DBMS'), UPPER('Oracle DBMS') 
           FROM dual; 
SELECT LPAD('Oracle DBMS', 13, 'x'), RPAD('Oracle DBMS', 13, 'x') FROM dual; 
SELECT LPAD(ename, 15)||'   '||RPAD(job,20) FROM emp; 
  
# TRIM: 주어진 문자가 아닌 문자가 나올때까지 지운다.  
SELECT ename , LTRIM(ename, 'AB'), RTRIM(ename, 'SR') FROM emp; 
 
# 문자열 치환 
SELECT REPLACE('Oracle DB System','DB','Database') FROM dual; 
 
# 문자열 일부 추출 
SELECT SUBSTR('Oracle DB System',2,4) FROM dual; 
 
# 각 글자 단위로 변환 A->1, B->2, ... 
SELECT TRANSLATE('Oracle DBMS','ABCD','1234') FROM dual; 
 
# 길이 
SELECT LENGTH('Oracle DBMS') FROM dual; 

# Number data의 경우 character string으로 자동 변환된 후에 처리된다. 
SELECT CONCAT(ename, sal) FROM emp; 
SELECT LPAD(sal, 10, '\') FROM emp; 
SELECT LENGTH(sal) FROM emp; 
 
# DATE 함수  
 
#날짜 더하기 
SELECT ADD_MONTHS(sysdate, 5), ADD_MONTHS(sysdate, -5) FROM dual; 
 
# 마지막 날? 
SELECT LAST_DAY(sysdate) FROM dual; 
 
# 오늘 현재 날짜 5일 뒤의 날짜와 5일 전의 날짜를 출력하시오. 
SELECT sysdate + 5, sysdate - 5 FROM dual; 
  
#이름이 KING 인 사원의 근무 일수를 출력하시오. 
SELECT sysdate - hiredate FROM emp WHERE ename = 'KING'; 
 
# 근무한 지 200000 시간이 넘은 사원을 출력하시오. 
SELECT ename, (sysdate - hiredate) * 24 FROM emp  
          WHERE (sysdate - hiredate) * 24 > 200000; 
  
# 모든 사원에 대해 근무한 지 몇 주가 지났는지를 출력하시오. 
SELECT (sysdate - hiredate)/7 weeks FROM emp; 
  
  
# 변환 함수 
# 다음과 같이 여러 가지 형식을 사용하여 TO_CHAR 함수를 실습해 보시오. 
SELECT sal, TO_CHAR(sal,'99,999') FROM emp; 
  
# 화폐단위 
SELECT TO_CHAR(sal, '$99,999') FROM emp; 
  
# TO_NUMBER 함수는 character string이 number와 +,-로만 구성된 경우 
# format을 주지 않고도 변환이 가능하다.  
SELECT TO_NUMBER('1234') FROM dual; 
SELECT TO_NUMBER('-1234') FROM dual;  
SELECT TO_NUMBER('+1234') FROM dual; 
SELECT TO_NUMBER('$123,456','$999,999') FROM dual; 
  
# DATE 변환 
# 현재의 시각을 출력하시오. 
SELECT TO_CHAR(sysdate, 'HH24"시" MI"분" SS"초"') FROM dual;  
  
# 오늘이 올해의 몇 번째 날인지를 출력하시오. 
SELECT TO_CHAR(sysdate, 'DDD"일"') FROM dual; 
  
# TO_DATE 함수를 사용하여 character string을 date 값으로 변환하시오. 
SELECT TO_DATE('1966, 2, 8', 'YYYY, MM, DD') FROM dual; 
  
# 다음을 실습해 보시오. 
SELECT TO_CHAR(sysdate, '"오늘의 날짜" yyyy month dd') FROM dual; 
(* Format에 임의의 character string을 추가할 때는 이중 인용 부호(“)로 묶어준다.) 
 
   
CASE 
==================================================== 
## CASE는 IF-THEN-ELSE와 비슷한 logic을 제공한다. 
 
## 각 부서별로 실적에 따라 급여를 다르게 인상하고자 한다.   
## 10번과 20번 부서는 각각 10%, 20% 인상을 하고  
## 나머지 부서는 동결할 경우의 급여를 CASE를 써서 출력하시오. 
SELECT ename, CASE deptno WHEN 10 THEN sal * 1.1 
  WHEN 20 THEN sal * 1.2 
  ELSE sal END  new_sal 
 FROM emp; 
   
# CLERK은 sal 10%인상, Manager는 15%인상, president는 20%인상 
#CASE 
SELECT ename, job, sal, CASE job WHEN 'CLERK'  THEN  1.10*sal 
   WHEN 'MANAGER' THEN  1.15*sal 
   WHEN 'PRESIDENT'   THEN  1.20*sal 
   ELSE sal END    REVISED_SALARY 
FROM   emp; 
 
  
# 사용자의 이름 
SELECT user FROM dual; 
  
# NVL: NULL이면 2의 값 리턴 
SELECT NVL(TO_CHAR(MGR), 'No Manager') FROM emp;    
  
# COALESCE: 처음 NULL이 아닌값 리턴 
SELECT ename, comm, mgr, COALESCE(COMM, mgr,-1000) FROM emp; 
 
  
#사원의 이름과 매니저 사번을 출력하시오.  단, 매니저가 없는 사원의 경우 'TOP'이’라고  
출력하시오. 
SELECT empno, NVL(mgr, 'TOP')  manager FROM emp; 
SELECT empno, NVL(TO_CHAR(mgr), 'TOP')  manager FROM emp; 
(무엇이 잘못되었나?)  


======================================== 
# Aggregation 
======================================== 
 
# 아래의 문장들을 실행하면서 결과를 확인하시오. 
# 결과가 차이가 나는 이유는 무엇인가? 
  
# COUNT 
SQL> SELECT count(*)  FROM emp;   
SQL> SELECT count(comm)  FROM emp;   
SQL> SELECT count(job)  FROM emp;   
  
# SUM 
SQL> SELECT sum(sal)  FROM emp;    
  
# AVG 
SQL> SELECT avg(comm)  FROM emp;    
SQL> SELECT sum(comm)/count(*)  FROM emp;    
SQL> SELECT sum(comm)/count(comm)  FROM emp; 
    
# 합, 평균, 최소, 최대, 표준편차, 분산 
SQL> SELECT sum(sal), avg(sal), min(sal), max(sal)
       FROM emp; 
  
======================================== 
# Grouping 
======================================== 
 
# 다음을 실습해 보시오. 
 
SQL> SELECT  job, avg(sal), max(sal), min(sal) 
           FROM  emp  GROUP BY  job; 
   
SQL> SELECT  deptno, count(*) 
           FROM  emp  GROUP BY  deptno; 
  
# Stock Clerk 직종의 사원들의 부서별 인원수를 출력하시오. 
SQL> SELECT deptno, COUNT(*) "Number"   FROM emp 
           WHERE job = 'CLERK'  GROUP BY deptno; 
  
# 직종별 최고 급여를 급여가 많은 직종부터 출력하시오. 
SQL> SELECT job, max(sal)  FROM emp 
           GROUP BY job  ORDER BY max(sal) DESC; 
  
# 직종별 최고 급여를 급여가 많은 직종부터 출력하시오. (단, 직원이 2명 이상인 경우만) 

# HAVING 사용법 
SQL> SELECT job, max(sal)  
       FROM emp 
      GROUP BY job   
     HAVING count(sal) >= 2 
      ORDER BY max(sal) DESC;
