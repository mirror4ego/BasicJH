SELECT *  FROM tabs; 
desc 
SELECT * FROM employees; 

--1
SELECT Rpad(department_name, 10, Substr('1234567890', Length(department_name) + 1)) 
  FROM departments 
 WHERE Length(department_name) < 10;
 
--2
SELECT id, 
       Min(type1) type1, 
       Max(type2) type2, 
       Min(type3) type3 
  FROM testdb 
 GROUP BY id; 


--3
SELECT Ceil(ROWNUM / 3), 
       employee_id, 
       last_name 
  FROM employees; 

--4
SELECT ROWNUM         순번, 
       ea.employee_id 사원번호, 
       ea.last_name   사원명, 
       eb.employee_id 사원번호, 
       eb.last_name   사원명 
  FROM employees ea, 
       employees eb 
 WHERE ea.employee_id = eb.employee_id - 1 
       AND MOD(ea.employee_id, 2) = 0 
       AND MOD(eb.employee_id, 2) = 1; 