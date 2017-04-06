--문제1번
--테이블 생성

CREATE TABLE t86_text 
  ( 
     text_no     NUMBER(5) NOT NULL, 
     title       VARCHAR2(500) NOT NULL, 
     content     VARCHAR2(4000) NOT NULL, 
     user_id     VARCHAR2(16), 
     reg_time    DATE NOT NULL, 
     read_count  NUMBER(5) NOT NULL, 
     recom_count NUMBER(5) NOT NULL 
  ); 

CREATE TABLE t86_user 
  ( 
     user_id  VARCHAR2(16) NOT NULL, 
     password VARCHAR2(16) NOT NULL, 
     email    VARCHAR2(60) 
  ); 

CREATE TABLE t86_recom 
  ( 
     text_no  NUMBER(5) NOT NULL, 
     user_id  VARCHAR2(16) NOT NULL, 
     the_time DATE NOT NULL 
  ); 
  
--문제 2번
--t86_user 에 데이터를 입력하세요

INSERT INTO t86_user (user_id, password, email)
VALUES     ('root', 
            'abcd1234', 
            'root@noname.com'); 

INSERT INTO t86_user (user_id, password, email)
VALUES     ('user1', 
            'abcd1234', 
            'user1@noname.com'); 

INSERT INTO t86_user (user_id, password)
VALUES     ('user2', 
            'abcd1234'); 

INSERT INTO t86_user (user_id, password) 
VALUES     ('user3', 
            'abcd1234'); 
            
--문제 3번
UPDATE t86_user 
SET    password = '12341234' 
WHERE  user_id = 'user1';

--문제 4번
--이메일을 입력하지 않은 사람들의 ID 를 출력하세요
SELECT user_id AS ID 
FROM   t86_user 
WHERE  email IS NULL; 

--문제5번
--user3 의 이메일을 user3@noname.com 변경하세요
UPDATE t86_user 
SET    email = 'user3@noname.com' 
WHERE  user_id = 'user3';

--문제6번
--user1 이 글을 입력합니다.( 이 글을 1 번 글이라 칭합니다. )
--제목 : 오늘하루 , 내용 : 할 일 없었다
INSERT INTO t86_text 
            (text_no, 
             title, 
             content, 
             user_id, 
             reg_time, 
             read_count, 
             recom_count) 
VALUES      (1, 
             '오늘하루', 
             '할 일 없었다', 
             'user1', 
             sysdate, 
             0, 
             0 ) 

--문제7번
--user2 이 글을 입력합니다. ( 이 글을 2 번 글이라 칭합니다. )
--제목 : 오늘하루 , 내용 : 할 일 많았다
INSERT INTO t86_text 
            (text_no, 
             title, 
             content, 
             user_id, 
             reg_time, 
             read_count, 
             recom_count) 
VALUES      (2, 
             '오늘하루', 
             '할 일 많았다', 
             'user2', 
             sysdate, 
             0, 
             0 ) 

--문제8번
--user3 이 글을 입력합니다. ( 이 글을 3 번 글이라 칭합니다. )
--제목 : 오늘하루 , 내용 : 할 일이란 과연 무엇일까?
INSERT INTO t86_text 
            (text_no, 
             title, 
             content, 
             user_id, 
             reg_time, 
             read_count, 
             recom_count) 
VALUES      (3, 
             '오늘하루', 
             '할 일이란 과연 무엇일까?', 
             'user3', 
             sysdate, 
             0, 
             0 ) 
             
--문제9번
--user3 이 1 번 글을 조회합니다.( 한문장 또는 2 문장으로 작성합니다)
--자신이 쓴 글인지 아닌지를 조사합니다. 자신이 쓴 글이 아닌 경우에만 조회수를 1 증가시킵니다
SELECT content 
FROM   t86_text 
WHERE  text_no = 1; 

UPDATE t86_text 
SET    read_count = read_count + 1 
WHERE  user_id != 'user3' and text_no = 1; 
            
--문제10번
--user1 이 1 번 글을 조회합니다.( 한문장 또는 2 문장으로 작성합니다)
--자신이 쓴 글인지 아닌지를 조사합니다. 자신이 쓴 글이 아닌 경우에만 조회수를 1 증가시킵니다.
SELECT content 
FROM   t86_text 
WHERE  text_no = 1; 

UPDATE t86_text 
SET    read_count = read_count + 1 
WHERE  user_id != 'user1' and text_no = 1; 
             
--문제11번
--user2 사용자가 1 번 글을 추천합니다
--자신이 쓴 글인지 아닌지를 조사합니다. 자신이 쓴 글은 추천할 수 없습니다.
--기존에 추천한 기록이 있는지 조사합니다.
--없을 경우 추천 횟수를 증가시키고 추천 기록을 테이블에 입력합니다.
UPDATE t86_text 
SET    recom_count = recom_count + 1 
WHERE  user_id != 'user2' and text_no = 1; 
             
--문제12번
--user3 사용자가 1 번글을 추천합니다.
--자신이 쓴 글인지 아닌지를 조사합니다. 자신이 쓴 글은 추천할 수 없습니다.
--기존에 추천한 기록이 있는지 조사합니다.
--없을 경우 추천 횟수를 증가시키고 추천 기록을 테이블에 입력합니다.
UPDATE t86_text 
SET    recom_count = recom_count + 1 
WHERE  user_id != 'user3' and text_no = 1; 
             
--문제13번
--오늘 작성된 글의 목록만 보여주는 쿼리문을 작성하세요
SELECT *
FROM   t86_text 
WHERE  reg_time in sysdate;
             
--문제14번
--이번달에 작성된 글의 목록만 보여주는 쿼리문을 작성하세요
SELECT *
FROM   t86_text 
WHERE  to_char(reg_time,'MM') = to_char(sysdate,'MM');
             
--문제15
--제목에 '오늘' 이라는 단어가 들어있는 글의 목록을 보여주는 쿼리문을 작성하세요
SELECT *
FROM   t86_text 
WHERE  title like '%오늘%';
             
--문제16
--user1 이 작성한 글의 목록을 보여주는 쿼리문을 작성하세요
SELECT *
FROM   t86_text 
WHERE  user_id = 'user1';
             
--문제17일
--내용에 '할일'이라는 단어가 들어있는 글의 목록을 보여주는 쿼리문을 작성하세요
SELECT *
FROM   t86_text 
WHERE  content like '%할일%';