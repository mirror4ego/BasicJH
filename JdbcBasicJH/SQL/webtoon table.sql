create table t86_4_webtoons(
 title_id varchar2(100) primary key,
 genre varchar2(20) not null,
 closing_date date,
 day varchar2(10) not null,
 writer_id varchar2(100) not null,
 progression varchar2(10) not null,
 total_recommend number(10) ,
 writer_words varchar2(500),
 age_limit number(3) not null
);

create table t86_4_writers(
 writer_id varchar2(100) primary key,
 writer varchar2(100) not null,
 sex varchar2(10) not null,
 age number(3) not null,
 email varchar2(100) not null
);

create table t86_4_titles(
 title_id varchar2(100) primary key,
 title varchar2(100) not null,
 turn number(10) not null,
 strapline varchar2(100) not null,
 recommend number(10) default 0,
 content varchar2(100) not null,
 regist_date date,
 hits number(10) default 0
 
);

--별개 테이블
create table t86_4_member(
guest_id varchar2(100) primary key,
password varchar2(100) not null,
birth_day date,
guest_name varchar2(100) not null,
rank varchar2(50) not null
);
 