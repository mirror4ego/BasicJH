CREATE TABLE t86_g4_member_info 
  ( 
     no                    NUMBER(10) PRIMARY KEY, 
     name                  VARCHAR2(30) NOT NULL, 
     id                    VARCHAR2(24) UNIQUE,
     pass                  VARCHAR2(16) NOT NULL, --최소값 2종류 10자, 3종류8자 
     birth                 DATE NOT NULL,
     gender                CHAR(1) NOT NULL,-- foreign key 
     home_zipcode          VARCHAR2(6) NOT NULL,-- foreign key 
     home_adress           VARCHAR2(100) NOT NULL,-- foreign key 
     home_adress_detail    VARCHAR2(100) NOT NULL, 
     home_telephone_number VARCHAR2(20) NOT NULL, 
     email                 VARCHAR2(100) UNIQUE,-- email_inc foreign key 
     cellphone_number      VARCHAR2(20), 
     company_number        VARCHAR2(20), 
     company_zipcode       VARCHAR2(6),-- foreign key 
     company_adress        VARCHAR2(100)-- foreign key 
  ); 