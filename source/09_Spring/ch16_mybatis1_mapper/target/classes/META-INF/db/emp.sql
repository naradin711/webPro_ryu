-- Dept.xml id=depList;
SELECT * FROM DEPT;

-- Emp.xml의 ID=emplist
SELECT * FROM EMP
        WHERE 1=1
        AND ENAME LIKE '%'||'A'||'%'
        AND JOB LIKE '%'||'E'||'%' 
        AND DEPTNO = 20 ;
