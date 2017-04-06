QUERY 명령어 실습 
 
테스트에 필요한 테이블과 데이터는 제공된 SQL Script 파일들을 실행하여 생성한다.  
- Scott 계정으로 로그인 후 테스트 한다.
 
## 스키마 속의 테이블 / Object 전체 확인하기 
SELECT * FROM tab; 
 
## 각 테이블의 구조 확인 
## DESC 테이블이름 
desc emp; 
desc dept; 
desc bonus; 
desc salgrade; 
 
## 테이블 내용 확인하기 
## SELECT * FROM 테이블이름; 
SELECT * FROM emp; 
SELECT * FROM dept; 
SELECT * FROM salgrade; 
 
 
## SCOTT 스키마의 각 테이블과 테이블의 컬럼들의 역할이 무엇인지 이야기해보자. 
 
기본 SELECT 
- SQL 문장은 한 줄로 입력하거나 여러 줄로 보기 좋게 나누어 입력한다. 
- SQL 문장은 대소문자를 가리지 않는다. (Case insensitive) 
- data 값은 대소문자를 가린다. (Case sensitive) 
 
# SELECT 문장은 Table에서 data를 검색하기 위한 문장으로 응용 프로그램 작성 시 가장 많이 사용하는 문장이다. 
 
# 최소한 SELECT절과 FROM절이 있어야 SELECT 문장이 가능하다. 
 
# Default Column Heading : column 명이 대문자로 display된다. 
# Default Data 정렬 : Number 값은 오른쪽 정렬, Character와 Date 값은 왼쪽 정렬 된다.  
 
SELECT 기본 
 
SELECT ename FROM emp; 
SELECT ename from emp; 
SELECT Ename From Emp; 
SELECT ename Fdesc employees;ROM emp; 
SELECT empno, ename FROM emp; 
SELECT ename, empno FROM emp; 
SELECT ename, ename FROM emp; 
SELECT * FROM emp; 
 

## 산술연산자  
+, -, *, / : 사칙연산 
사칙연산의 순서: * / + -,  
괄호 사용가능 
 
SELECT sal, -sal FROM emp; 
SELECT sal, sal*1.1 FROM emp; 
SELECT sal, comm, sal + comm FROM emp; 
SELECT sal, -sal + 100 * -2 FROM emp; 
SELECT sal, (-sal + 100) * -2 FROM emp; 
 
## 모든 사원의 연봉을 출력하기 위한 문장들이다. 다음을 실습해 보시오. 
SELECT empno, ename, sal, sal*12 FROM emp; 
SELECT empno, ename, sal, sal*12 + comm FROM emp; 
SELECT empno, ename, sal, sal + comm * 12 FROM emp; 
SELECT empno, ename, sal, (sal + comm) * 12 FROM emp; 
 

NULL: 아무런 값이 입력되어 있지 않음을 표시 
검색을 할때는 IS NULL 이용 
NULL을 포함한 모든 계산의 결과는 NULL 
 
## 다음 문장을 실행해 보시오.  Column이 Null인 경우 어떻게 표현되는가?   
Comm 값이 있는 사원은 어떤 사원들인가?    
사번 7844인 사원의 커미션은 얼마인가? 
 
SELECT empno, job, comm FROM emp; 
 
(* Null인 값은 비어있는 것으로 표현된다.  JOB이 SALESMAN인 사원들에게만 커미션이  
적용되며, 사번 7844인 사원의 커미션은 0이다.) 
 
## 다음은 사원들의 연봉을 계산하는 문장이다.   
Comm 값이 Null인 경우 연봉은 얼마인가?   
연봉 계산한 수식의 column heading은 어떻게 나타나는가?  
 
SELECT sal, comm, (sal+comm)*12  FROM emp; 
(* comm 값이 Null인 row의 경우 (sal+comm)*12를 한 결과도 모두 Null이 된다.   
또한,  expression 전체가 column heading으로 나타난다.) 
 
## 다음은 사번과 커미션을 출력하면서 커미션이 없는 사원의 경우 Null이 아니라 0으로  
출력하도록 하는 문장이다.  실행해 보시오. 
 
SELECT empno, ename, NVL(comm, 0) comm FROM emp; 
 
## 다음은 매니저가 없는, 즉 최고 직급의 사원인 경우 ‘No Manager’라고 출력되도록 하는  
문장이다.  실행하여 Error 메시지를 적어보고 Error가 나는 이유를 설명하시오. 
 
SELECT NVL(mgr, 'No Manager') FROM emp;    
 
* Error 발생.  이유는 :                                        
 
 
## column alias를 사용한 문장들이다.  column heading이 어떻게 나타나는지를 기록하고,   
Error가 나는 문장에 대해서는 이유를 설명하시오. 
 
SELECT sal*12 Annual Salary FROM emp;   
 
* Error 발생.  이유? 
 
SELECT sal*12 "Annual Salary" FROM emp; 
SELECT sal*12 AS "Annual Salary" FROM emp; 
 
 
## 연결연산자:  문자열을 연결(Concatunation) 
 
SELECT empno||ename FROM emp; 
SELECT empno||ename||hiredate FROM emp; 
(* number나 date 값은 default 형태의 character 값으로 자동 변환된 후 연결된다.) 
 
## Literal: 다음을 실습해 보시오. 
‘ ‘ ? Literal , SQL문에 사용되는 데이터 등에 사용 
“ “ ? SQL의 Alias 이름, 테이블의 이름 등 SQL 파서에서 인식할 문자열에 사용 
 
SELECT ename|| '  ' || sal FROM emp; 
SELECT ename || ' is working as a ' || job FROM emp; 
   
DUAL Table: 화면에 특정 연산 결과 등을 출력할 때 사용. 한 개의 Row를 갖는 가상의 테이블 
- SELECT의 결과는 항상 테이블의 row수만큼 나오므로 별도의 table이 필요없는 질의에서 사용 
 
## 결과 row의 개수는 table의 row 수와 같다.  
 
SELECT 'Korea Fighting' FROM emp;   
(* Korea Fighting 이라는 literal이 14 번 출력된다. 이유는 : emp테이블의 데이터 개수가 14개    ) 
 
 
SELECT 'Korea Fighting' FROM dept;   
(* Korea Fighting 이라는 literal이 4 번 출력된다. 이유 : dept테이블의 데이터 개수가 4개      ) 
 
## literal이나 literal들의 연산결과를 출력해 볼 때는 sys사용자 소유의 dual이라는 dummy 
table을 활용한다. 
 
SELECT 'Korea Fighting' FROM dual;   
SELECT 10 + 20 FROM dual;   
SELECT 'Red' || '  ' || 'Devil'  FROM dual;   
 
##  dual table을 이용하여 server의 현재 시각을 조회해 볼 수 있다.  
 
SELECT sysdate FROM dual; 
 
DISTINCT : 중복제거 
==================================================== 
## DISTINCT: 다음 문장들을 실행하고 결과를 비교하시오. 
## 몇 개의 튜플이 출력되는가?? 
 
SELECT job FROM emp;    
(? 14  rows selected) 
SELECT DISTINCT job FROM emp; 
(? 5  rows selected) 
SELECT deptno FROM emp; 
(? 14  rows selected) 
SELECT DISTINCT deptno FROM emp; 
(? 3  rows selected) 
 
 
## 다음은 여러 column에 대한 중복 값을 제거하는 문장이다. 결과를 비교하시오. 
 
SELECT deptno, job FROM emp; 
(? 14  rows selected) 
SELECT DISTINCT deptno, job FROM emp; 
(? 9 rows selected)   
 

D## BOSTON이나 DALLAS 에 위치한 부서를 출력하시오. 
SELECT dname, loc FROM dept WHERE loc IN ('BOSTON', 'DALLAS'); 
 
## 30, 40번 부서에 속하지 않는 사원들을 출력하시오. 
SELECT ename,deptno FROM emp WHERE deptno NOT IN (30,40); 
 
## DALLAS의 20번 부서, 또는 CHICAGO의 30번 부서를 출력하시오. 
SELECT * FROM dept WHERE (deptno,loc) IN ((20,'DALLAS'),(30,'CHICAGO')); 
#==================================================== 
 
 
기타 연산자:  
BETWEEN: 사이에 
LIKE: 문자열 부분 매칭 
 
# 급여가 2000에서 3000 사이인 사원을 출력하시오. 
SELECT ename, job, sal FROM emp WHERE sal BETWEEN 2000 AND 3000; 
 
## 이름이 A 로 시작되는 사원을 출력하시오. 
SELECT ename FROM emp WHERE ename LIKE 'A%'; 
 
## 사번이 8번으로 끝나는 사원을 출력하시오. 
SELECT empno, ename FROM emp WHERE empno LIKE '%8'; 


IS NULL, IS NOT NULL : Null인가? 아닌가? (= 을 사용하면 결과가 안나옴) 
 
## 커미션 지급 대상인 사원을 출력하시오. 
SELECT ename, comm FROM emp WHERE comm IS NOT NULL; 
 
==================================================== 
## 아래 두 문장의 결과를 비교해 보고 차이점을 설명하시오. 
SELECT ename, comm FROM emp WHERE comm IS NULL; 
SELECT ename, comm FROM emp WHERE comm = NULL; 

널값은 비교연산이 되지 않기 때문에 아래 쿼리문은 출력되지 않는다.
 
각종 질의 실습 
## 사번이 7788인 사원의 이름과 급여를 출력하시오. 
SELECT ename, sal FROM emp WHERE empno = 7788;  
 
## 급여가 3000 이 넘는 직종을 출력하시오. 
SELECT job FROM emp WHERE sal > 3000; 
 
## PRESIDENT 를 제외한 사원들의 이름과 직종을 출력하시오. 
SELECT ename, job FROM emp WHERE job <> 'PRESIDENT'; 
 
## BOSTON 지역에 있는 부서의 번호와 이름을 출력하시오.  
SELECT deptno, dname FROM dept WHERE loc = 'BOSTON'; 
 
## 직종이 CLERK 인 사원 중에서 급여가 1000 이상인 사원을 출력하시오. 
SELECT ename, job, sal FROM emp WHERE job = 'CLERK' AND sal >= 1000; 
 
## commission을 받는 사원을 출력하시오. 
SELECT ename FROM emp WHERE comm IS NOT NULL; 
SELECT ename FROM emp WHERE NOT comm IS NULL; 
 
## 10번 부서와 20번 부서에 속한 사원을 출력하시오. 
SELECT ename, deptno FROM emp WHERE (deptno = 10 OR deptno = 20); 
SELECT ename, deptno FROM emp WHERE deptno IN (10, 20);  
 
## 10번과 20번 부서에 속하지 않는 사원의 이름과 부서번호를 출력하시오. 
SELECT ename, deptno FROM emp WHERE deptno <> 10 AND deptno <> 20; 
SELECT ename, deptno FROM emp WHERE deptno NOT IN (10,20); 
 
## 급여가 2000에서 3000 사이인 사원을 출력하시오. 
SELECT ename, job, sal FROM emp WHERE sal >= 2000 AND sal <= 3000; 
SELECT ename, job, sal FROM emp WHERE sal BETWEEN 2000 AND 3000; 
 

정렬: ORDER BY 
==================================================== 
## ORDER BY 
## Null 값은 오름차순의 경우 맨 마지막에, 내림자순의 경우 맨 처음에 display된다. 
 
SELECT ename, comm FROM emp ORDER BY comm; 
SELECT ename, comm FROM emp ORDER BY comm DESC; 
 
## 급여가 적은 사원부터 출력하시오. 
SELECT ename, sal FROM emp ORDER BY sal; 
 
## 급여가 많은 사원부터 출력하시오. 
SELECT ename, sal FROM emp ORDER BY sal DESC; 
 
## 급여가 많은 사원부터 출력하되 급여가 같은 경우 이름 순서대로 출력하시오. 
SELECT ename, sal FROM emp ORDER BY sal DESC, ename; 
 
## 급여가 많은 사원부터 출력하되 급여가 같은 경우 이름 순서대로 출력하시오.  
(ORDER BY 절에 숫자 사용: 몇번째 컬럼?) 
SELECT ename, sal FROM emp ORDER BY 2 DESC, 1; 
 
## SELECT 절에 나타나지 않은 column에 대해서도 정렬이 가능하다. 
SELECT ename FROM emp ORDER BY sal DESC; 
SELECT sal, ename FROM emp ORDER BY sal DESC; 