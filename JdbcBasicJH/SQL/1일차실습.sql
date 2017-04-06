QUERY ��ɾ� �ǽ� 
 
�׽�Ʈ�� �ʿ��� ���̺�� �����ʹ� ������ SQL Script ���ϵ��� �����Ͽ� �����Ѵ�.  
- Scott �������� �α��� �� �׽�Ʈ �Ѵ�.
 
## ��Ű�� ���� ���̺� / Object ��ü Ȯ���ϱ� 
SELECT * FROM tab; 
 
## �� ���̺��� ���� Ȯ�� 
## DESC ���̺��̸� 
desc emp; 
desc dept; 
desc bonus; 
desc salgrade; 
 
## ���̺� ���� Ȯ���ϱ� 
## SELECT * FROM ���̺��̸�; 
SELECT * FROM emp; 
SELECT * FROM dept; 
SELECT * FROM salgrade; 
 
 
## SCOTT ��Ű���� �� ���̺�� ���̺��� �÷����� ������ �������� �̾߱��غ���. 
 
�⺻ SELECT 
- SQL ������ �� �ٷ� �Է��ϰų� ���� �ٷ� ���� ���� ������ �Է��Ѵ�. 
- SQL ������ ��ҹ��ڸ� ������ �ʴ´�. (Case insensitive) 
- data ���� ��ҹ��ڸ� ������. (Case sensitive) 
 
# SELECT ������ Table���� data�� �˻��ϱ� ���� �������� ���� ���α׷� �ۼ� �� ���� ���� ����ϴ� �����̴�. 
 
# �ּ��� SELECT���� FROM���� �־�� SELECT ������ �����ϴ�. 
 
# Default Column Heading : column ���� �빮�ڷ� display�ȴ�. 
# Default Data ���� : Number ���� ������ ����, Character�� Date ���� ���� ���� �ȴ�.  
 
SELECT �⺻ 
 
SELECT ename FROM emp; 
SELECT ename from emp; 
SELECT Ename From Emp; 
SELECT ename Fdesc employees;ROM emp; 
SELECT empno, ename FROM emp; 
SELECT ename, empno FROM emp; 
SELECT ename, ename FROM emp; 
SELECT * FROM emp; 
 

## ���������  
+, -, *, / : ��Ģ���� 
��Ģ������ ����: * / + -,  
��ȣ ��밡�� 
 
SELECT sal, -sal FROM emp; 
SELECT sal, sal*1.1 FROM emp; 
SELECT sal, comm, sal + comm FROM emp; 
SELECT sal, -sal + 100 * -2 FROM emp; 
SELECT sal, (-sal + 100) * -2 FROM emp; 
 
## ��� ����� ������ ����ϱ� ���� ������̴�. ������ �ǽ��� ���ÿ�. 
SELECT empno, ename, sal, sal*12 FROM emp; 
SELECT empno, ename, sal, sal*12 + comm FROM emp; 
SELECT empno, ename, sal, sal + comm * 12 FROM emp; 
SELECT empno, ename, sal, (sal + comm) * 12 FROM emp; 
 

NULL: �ƹ��� ���� �ԷµǾ� ���� ������ ǥ�� 
�˻��� �Ҷ��� IS NULL �̿� 
NULL�� ������ ��� ����� ����� NULL 
 
## ���� ������ ������ ���ÿ�.  Column�� Null�� ��� ��� ǥ���Ǵ°�?   
Comm ���� �ִ� ����� � ������ΰ�?    
��� 7844�� ����� Ŀ�̼��� ���ΰ�? 
 
SELECT empno, job, comm FROM emp; 
 
(* Null�� ���� ����ִ� ������ ǥ���ȴ�.  JOB�� SALESMAN�� ����鿡�Ը� Ŀ�̼���  
����Ǹ�, ��� 7844�� ����� Ŀ�̼��� 0�̴�.) 
 
## ������ ������� ������ ����ϴ� �����̴�.   
Comm ���� Null�� ��� ������ ���ΰ�?   
���� ����� ������ column heading�� ��� ��Ÿ���°�?  
 
SELECT sal, comm, (sal+comm)*12  FROM emp; 
(* comm ���� Null�� row�� ��� (sal+comm)*12�� �� ����� ��� Null�� �ȴ�.   
����,  expression ��ü�� column heading���� ��Ÿ����.) 
 
## ������ ����� Ŀ�̼��� ����ϸ鼭 Ŀ�̼��� ���� ����� ��� Null�� �ƴ϶� 0����  
����ϵ��� �ϴ� �����̴�.  ������ ���ÿ�. 
 
SELECT empno, ename, NVL(comm, 0) comm FROM emp; 
 
## ������ �Ŵ����� ����, �� �ְ� ������ ����� ��� ��No Manager����� ��µǵ��� �ϴ�  
�����̴�.  �����Ͽ� Error �޽����� ����� Error�� ���� ������ �����Ͻÿ�. 
 
SELECT NVL(mgr, 'No Manager') FROM emp;    
 
* Error �߻�.  ������ :                                        
 
 
## column alias�� ����� ������̴�.  column heading�� ��� ��Ÿ�������� ����ϰ�,   
Error�� ���� ���忡 ���ؼ��� ������ �����Ͻÿ�. 
 
SELECT sal*12 Annual Salary FROM emp;   
 
* Error �߻�.  ����? 
 
SELECT sal*12 "Annual Salary" FROM emp; 
SELECT sal*12 AS "Annual Salary" FROM emp; 
 
 
## ���Ῥ����:  ���ڿ��� ����(Concatunation) 
 
SELECT empno||ename FROM emp; 
SELECT empno||ename||hiredate FROM emp; 
(* number�� date ���� default ������ character ������ �ڵ� ��ȯ�� �� ����ȴ�.) 
 
## Literal: ������ �ǽ��� ���ÿ�. 
�� �� ? Literal , SQL���� ���Ǵ� ������ � ��� 
�� �� ? SQL�� Alias �̸�, ���̺��� �̸� �� SQL �ļ����� �ν��� ���ڿ��� ��� 
 
SELECT ename|| '  ' || sal FROM emp; 
SELECT ename || ' is working as a ' || job FROM emp; 
   
DUAL Table: ȭ�鿡 Ư�� ���� ��� ���� ����� �� ���. �� ���� Row�� ���� ������ ���̺� 
- SELECT�� ����� �׻� ���̺��� row����ŭ �����Ƿ� ������ table�� �ʿ���� ���ǿ��� ��� 
 
## ��� row�� ������ table�� row ���� ����.  
 
SELECT 'Korea Fighting' FROM emp;   
(* Korea Fighting �̶�� literal�� 14 �� ��µȴ�. ������ : emp���̺��� ������ ������ 14��    ) 
 
 
SELECT 'Korea Fighting' FROM dept;   
(* Korea Fighting �̶�� literal�� 4 �� ��µȴ�. ���� : dept���̺��� ������ ������ 4��      ) 
 
## literal�̳� literal���� �������� ����� �� ���� sys����� ������ dual�̶�� dummy 
table�� Ȱ���Ѵ�. 
 
SELECT 'Korea Fighting' FROM dual;   
SELECT 10 + 20 FROM dual;   
SELECT 'Red' || '  ' || 'Devil'  FROM dual;   
 
##  dual table�� �̿��Ͽ� server�� ���� �ð��� ��ȸ�� �� �� �ִ�.  
 
SELECT sysdate FROM dual; 
 
DISTINCT : �ߺ����� 
==================================================== 
## DISTINCT: ���� ������� �����ϰ� ����� ���Ͻÿ�. 
## �� ���� Ʃ���� ��µǴ°�?? 
 
SELECT job FROM emp;    
(? 14  rows selected) 
SELECT DISTINCT job FROM emp; 
(? 5  rows selected) 
SELECT deptno FROM emp; 
(? 14  rows selected) 
SELECT DISTINCT deptno FROM emp; 
(? 3  rows selected) 
 
 
## ������ ���� column�� ���� �ߺ� ���� �����ϴ� �����̴�. ����� ���Ͻÿ�. 
 
SELECT deptno, job FROM emp; 
(? 14  rows selected) 
SELECT DISTINCT deptno, job FROM emp; 
(? 9 rows selected)   
 

D## BOSTON�̳� DALLAS �� ��ġ�� �μ��� ����Ͻÿ�. 
SELECT dname, loc FROM dept WHERE loc IN ('BOSTON', 'DALLAS'); 
 
## 30, 40�� �μ��� ������ �ʴ� ������� ����Ͻÿ�. 
SELECT ename,deptno FROM emp WHERE deptno NOT IN (30,40); 
 
## DALLAS�� 20�� �μ�, �Ǵ� CHICAGO�� 30�� �μ��� ����Ͻÿ�. 
SELECT * FROM dept WHERE (deptno,loc) IN ((20,'DALLAS'),(30,'CHICAGO')); 
#==================================================== 
 
 
��Ÿ ������:  
BETWEEN: ���̿� 
LIKE: ���ڿ� �κ� ��Ī 
 
# �޿��� 2000���� 3000 ������ ����� ����Ͻÿ�. 
SELECT ename, job, sal FROM emp WHERE sal BETWEEN 2000 AND 3000; 
 
## �̸��� A �� ���۵Ǵ� ����� ����Ͻÿ�. 
SELECT ename FROM emp WHERE ename LIKE 'A%'; 
 
## ����� 8������ ������ ����� ����Ͻÿ�. 
SELECT empno, ename FROM emp WHERE empno LIKE '%8'; 


IS NULL, IS NOT NULL : Null�ΰ�? �ƴѰ�? (= �� ����ϸ� ����� �ȳ���) 
 
## Ŀ�̼� ���� ����� ����� ����Ͻÿ�. 
SELECT ename, comm FROM emp WHERE comm IS NOT NULL; 
 
==================================================== 
## �Ʒ� �� ������ ����� ���� ���� �������� �����Ͻÿ�. 
SELECT ename, comm FROM emp WHERE comm IS NULL; 
SELECT ename, comm FROM emp WHERE comm = NULL; 

�ΰ��� �񱳿����� ���� �ʱ� ������ �Ʒ� �������� ��µ��� �ʴ´�.
 
���� ���� �ǽ� 
## ����� 7788�� ����� �̸��� �޿��� ����Ͻÿ�. 
SELECT ename, sal FROM emp WHERE empno = 7788;  
 
## �޿��� 3000 �� �Ѵ� ������ ����Ͻÿ�. 
SELECT job FROM emp WHERE sal > 3000; 
 
## PRESIDENT �� ������ ������� �̸��� ������ ����Ͻÿ�. 
SELECT ename, job FROM emp WHERE job <> 'PRESIDENT'; 
 
## BOSTON ������ �ִ� �μ��� ��ȣ�� �̸��� ����Ͻÿ�.  
SELECT deptno, dname FROM dept WHERE loc = 'BOSTON'; 
 
## ������ CLERK �� ��� �߿��� �޿��� 1000 �̻��� ����� ����Ͻÿ�. 
SELECT ename, job, sal FROM emp WHERE job = 'CLERK' AND sal >= 1000; 
 
## commission�� �޴� ����� ����Ͻÿ�. 
SELECT ename FROM emp WHERE comm IS NOT NULL; 
SELECT ename FROM emp WHERE NOT comm IS NULL; 
 
## 10�� �μ��� 20�� �μ��� ���� ����� ����Ͻÿ�. 
SELECT ename, deptno FROM emp WHERE (deptno = 10 OR deptno = 20); 
SELECT ename, deptno FROM emp WHERE deptno IN (10, 20);  
 
## 10���� 20�� �μ��� ������ �ʴ� ����� �̸��� �μ���ȣ�� ����Ͻÿ�. 
SELECT ename, deptno FROM emp WHERE deptno <> 10 AND deptno <> 20; 
SELECT ename, deptno FROM emp WHERE deptno NOT IN (10,20); 
 
## �޿��� 2000���� 3000 ������ ����� ����Ͻÿ�. 
SELECT ename, job, sal FROM emp WHERE sal >= 2000 AND sal <= 3000; 
SELECT ename, job, sal FROM emp WHERE sal BETWEEN 2000 AND 3000; 
 

����: ORDER BY 
==================================================== 
## ORDER BY 
## Null ���� ���������� ��� �� ��������, �����ڼ��� ��� �� ó���� display�ȴ�. 
 
SELECT ename, comm FROM emp ORDER BY comm; 
SELECT ename, comm FROM emp ORDER BY comm DESC; 
 
## �޿��� ���� ������� ����Ͻÿ�. 
SELECT ename, sal FROM emp ORDER BY sal; 
 
## �޿��� ���� ������� ����Ͻÿ�. 
SELECT ename, sal FROM emp ORDER BY sal DESC; 
 
## �޿��� ���� ������� ����ϵ� �޿��� ���� ��� �̸� ������� ����Ͻÿ�. 
SELECT ename, sal FROM emp ORDER BY sal DESC, ename; 
 
## �޿��� ���� ������� ����ϵ� �޿��� ���� ��� �̸� ������� ����Ͻÿ�.  
(ORDER BY ���� ���� ���: ���° �÷�?) 
SELECT ename, sal FROM emp ORDER BY 2 DESC, 1; 
 
## SELECT ���� ��Ÿ���� ���� column�� ���ؼ��� ������ �����ϴ�. 
SELECT ename FROM emp ORDER BY sal DESC; 
SELECT sal, ename FROM emp ORDER BY sal DESC; 