-- 모든 테이블 조회
select * from tab;

-- 테이블 생성 	: CREATE
-- 네이밍 룰	: t_이름, 단어가 여러개 이어질 경우 "_"로 구분한다.
--			: tb_이름, tc_이름, th_이름...
--			: t기수번호_테이블명
-- CLOB : Character Large OBject, 4gb
-- BLOB : Large OBject, 4gb
create table t86_board (
	no number(6),			--자리수
	title varchar2(300),	--글자수(바이트단위), UTF-8은 한글3바이트
	writer varchar2(30),		--
	content varchar2(4000),	--vachar2가 받을수 있는 최대크기
	reg_date date			--날짜타입
);


--테이블 구조 확인하기
desc t86_board;

--테이블 삭제
drop table t86_board;

--데이터 입력
insert into t86_board values(1,'title', 'w1', '내용1', sysdate);

--데이터 자르기
truncate table t86_board;

--데이터 삭제
delete table t86_board;

--데이터 삭제 : delete, truncate, drop
/*
 * drop		: 데이터 + 구조
 * truncate	: 데이터, 복구불가(완전삭제)
 * delete	: 데이터, 복구가능(복원가능삭제)
 */

--모든 데이터 조회
select * from t86_board;

--테이블 리네임
rename t86_board to t86_board_back;
rename t86_board_back to t86_board;

--테이블 제약조건 설정
/*
 *  1. primary key	: 중복불가 + null불가 (unique + not null)
 *  2. unique		: 중복불가
 *  3. not null		: null불가
 *  4. check		: 값에 대한 제약 조건
 *  5. foreign key	: 값이 다른 테이블의 값을 참조
 */

-- 제약조건 설정 전 테이블 삭제
drop table t86_board;

CREATE TABLE t86_board 
  ( 
     no       NUMBER(6) PRIMARY KEY, 
     title    VARCHAR2(300) NOT NULL, 
     writer   VARCHAR2(30) NOT NULL, 
     content  VARCHAR2(4000) NOT NULL, 
     reg_date DATE DEFAULT sysdate NOT NULL 
  ); 

-- 데이터 입력
insert into t86_board (no,title,writer,content,reg_date)
values(1, 'title', 'writer', 'content', sysdate);

-- 입력시 오류 발생함 : no는 pk 컬럼이기 때문에 동일값 입력이 불가능
insert into t86_board (no,title,writer,content,reg_date)
values(1, 'title2', 'writer2', 'content2', sysdate);

-- default 확인
insert into t86_board (no,title,writer,content)
values(41, 'title23', 'writer23', 'content23');

-- not null 제약 확인 : 오류발생
-- ORA-01400: NULL을 ("HR"."T86_BOARD"."CONTENT") 안에 삽입할 수 없습니다
insert into t86_board (no,title,writer)
values(41, 'title23', 'writer23');

-- 권장하지 않는다  ::: 전체 데이터 입력시...
insert into t86_board
values(1, 'title', 'writer', 'content');


-- 데이터 수정 : update
update t86_board
   set title = '변경1',
	   content = '내용 수정함1'

-- 특정 데이터 수정 : where
update t86_board
   set title = '변경1',
	   content = '내용 수정함1'
 where no = 41;

-- 글번호가 3번보다 작은 게시글의 내용을 조회
select *
  from t86_board
 where no < 3;

-- 글번호가 3번보다 작은 게시글의 no와 writer칼럼 조회
select no, writer
  from t86_board
 where no < 3;

-- delete : 데이터 삭제
delete from t86_board

-- 특정 데이터 삭제 41번 게시글
delete from t86_board
 where no = 41;


 
 
--
desc employees;
select * from employees;
desc departments;
select * from departments;

-- 사원의 사번과 이름, 입사일 출력
select employee_id , last_name, hire_date
  from employees;

-- alias(별칭) 사용하기
SELECT employee_id AS eid, 
       last_name   NAME, 
       hire_date   hdate 
FROM   employees; 

-- 오류남 alias가 띄어쓰기 되어있음
-- ORA-00923: FROM 키워드가 필요한 위치에 없습니다.
select last_name 사원의 이름
from employees;

-- 오류가 안나게 하려면 ""처리 해줘야 한다
-- 공백 또는 대소문자 구분, 특수문자 이용시에는 ""로 묶는다.
select last_name "사원의 이름"
from employees;

-- select 산술연산자 사용
-- 연봉 : 급여 * 15
select salary 급여, salary*15 연봉
  from employees;

-- 합성연산자 : ||
-- 사원명 : 홍길동
select '사원명 : ' || last_name as 정보
  from employees;  

-- Q> 사원의 정보를 아래의 형식에 맞게 출력하시오
-- 100번 사원의 이름은 king 이고, 급여는 24000000입니다.

select employee_id || '번 사원의 이름은 ' || last_name || ' 이고, 급여는 ' || salary*1000 || '입니다.' as "사원의 정보"
  from employees
  
-- 비교연산자
-- 사원의 급여가 10000이상인 사원의 정보를 출력하시오
select *
  from employees
 where salary >= 10000;

-- 사원의 정보를 출력합니다. 단, 100번 부서가 아닌 사원들만
select *
  from employees
 where department_id != 100;
 
-- 논리 연산자
-- 사원의 부서가 90번 이거나 100번인 사원
 select *
   from employees
  where department_id = 100 
     or department_id = 90;
     
-- 사원의 부서가 90번 이면서 급여가 10000 이하인 사원의 정보를 출력
 select *
   from employees
  where salary <= 10000
    and department_id = 90;
    
-- 사원의 부서 번호가 90번 또는 100번인 사원중에서
-- 급여가 10000 이하인 사원의 정보
-- 연산자 우선순위 and > or
select *
  from employees
 where salary <= 10000
   and (department_id = 100 or department_id = 90);
   
-- SQL 연산자

-- BETWEEN 연산자
-- 앞에 값이 뒤에값보다 작은값이 와야함
-- 사원의 급여가 10000보다 크고 15000보다 작은 사원의 정보를 출력
select *
  from employees
 where salary between 10000 
                  and 15000;
-- IN 연산자
-- 사원의 부서가 50번, 70번, 90번, 100번 중에  포함된 사원의 정보
select *
  from employees
 where department_id in(50,70,90,100);

-- LIKE 연산자  : %(0개 이상 문자), _(한개 문자)
-- 사원의 이름이 L로 시작하는 사원의 정보
select *
  from employees
 where LAST_NAME
  like 'L%';

-- 사원이 이름이 4자인 사원의 정보
select *
  from employees
 where LAST_NAME
  like '____';

-- 이메일이 D로 시작하고 T로 끝나는 사원의 정보
select *
  from employees
 where email
  like 'D%T';

-- 이름에 D 가 포함되는 사원의 정보를 출력
select *
  from employees
 where LAST_NAME
  like '%D%';
  
-- 이름이 'King' 인 사원의 정보를 출력
select *
  from employees
 where LAST_NAME = 'King';
 
-- null 에 대한 개념
-- null 은 미정의 값이다.(무한대...)
-- null 과의 산술연산은 null을 반환한다.
-- null + 100 = null
-- null > 100 = false

-- 커미션을 받지 않는 사원
SELECT * 
FROM   employees 
WHERE  commission_pct IS NULL;

-- 커미션을 받는 사원
SELECT * 
FROM   employees 
WHERE  commission_pct IS NOT NULL;

-- 사원의 연봉을 화면에 출력합니다.
-- 단, 연봉은 salary*15 + salary*commision_pct
-- nvl(null값올수있는것, 바꿔줄 값)
SELECT salary, commission_pct, salary * 15 + salary * nvl(commission_pct, 0)
FROM   employees;

-- 사원의 정보 중에서 이름과 커미션을 출력한다.
-- 단, 커미션이 널인경우 0
SELECT last_name, nvl(commission_pct, 0) as COMMISION_PCT
FROM   employees;

-- 사원의 정보 중에서 이름과 커미션을 출력한다.
-- 단, 커미션이 널인경우 '커미션 없음'
SELECT last_name, nvl(commission_pct || '', '커미션없음') as COMMISION_PCT
FROM   employees;

-- 사원의 급여순으로
SELECT last_name, 
       salary 
FROM   employees 
ORDER  BY salary ASC; 

SELECT last_name AS "이름", 
       salary    AS "연봉" 
FROM   employees 
ORDER  BY salary DESC; 

-- 권장하지 않음
SELECT last_name AS "이름", 
       salary    AS "연봉" 
FROM   employees 
ORDER  BY 2 DESC; 

-- 컬럼의 Alias 사용 가능함
-- 연봉순으로 정렬
SELECT last_name as "이름",
	   salary * 15 + salary * nvl(commission_pct, 0) as "연봉"
FROM   employees 
ORDER  BY "연봉" DESC; 

-- 사원의 정보중 부서번호, 사원명을 출력하시오 부서번호 순으로
SELECT DEPARTMENT_ID as "부서번호",
	   last_name as "이름"
FROM   employees 
ORDER  BY "부서번호";

-- 사원의 정보중 부서번호, 사원명을 출력하시오 부서번호 순으로 부서번호가 같을때는 사원명으로 정렬
SELECT DEPARTMENT_ID as "부서번호",
	   last_name as "이름"
FROM   employees 
ORDER  BY "부서번호", "이름";

-- 사원이 소속된 부서의 번호
select department_id
from employees;

-- 사원이 소속된 부서의 번호
-- 중복된 정보 제거
select distinct department_id
from employees;

-- 사원이 소속된 부서의 번호
-- 중복된 정보 제거
-- 정렬
select distinct nvl(department_id, '부서없음') as "부서"
from employees
order by department_id;