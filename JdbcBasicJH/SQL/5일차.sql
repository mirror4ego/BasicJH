-- 트랜잭션 처리하기
create table t86_tran (
	no number,
	data varchar2(100)
);
select case when concatlogin='adminadmin'  then 'LogIn' else 'notLogIn' end as member_login
						from (select concat(member_id,member_password) concatlogin 
						from T86_4_member);
select * from t86_tran;

-- commit(데이터베이스에 완전하게 적용)
-- rollback(이전 커밋위치까지 되돌리기)
-- 데이터에 대한 DML 작업 후 commit 하기 전에는 작업을 진행한 유저만 해당 데이터를 볼 수 있다. 
-- DDL 문장들은 자동 커밋이 발생한다.
-- 데이터를 수정하고 커밋하기 전에 다른 사용자가 동일한 데이터에 대해서 수정하면 데이터락이 발생해서 커밋하기전까지 무한 대기상태로 빠진다.

-- 롤백시 특정한 지점(savepoint)까지 되돌릴 수 있다.
-- savepoint 이름;
-- rollback to 이름;

-- jdbc 트랜잭션 처리 연습 테이블
create table t86_account (
	id varchar2(10),
	money number(9)
);

insert into t86_account values ('hong', 100000);
insert into t86_account values ('kim', 50000);

select * from t86_account;

					
					
					