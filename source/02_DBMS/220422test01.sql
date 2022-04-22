--[EMP] EMPNO(사번;NUMBER), ENAME(사원명;VARCHAR2), JOB(직책;VARCHAR2),
--MGR(상사의 사번;NUMBER), HIREDATE(입사일;DATE), SAL(급여;NUMBER)
--(상여;NUMBER), DEPTNO(부서번호;NUMBER-DEPT테이블의 DEPTNO참조)
--[DEPT] DEPTNO(부서번호;NUMBER), DNAME(부서명;VARCHAR2), LOC(근무지;VARCHAR2)
--[SALGRADE] GRADE(등급;NUMBER), LOSAL(등급 내 최저급여비교액;NUMBER),
--HISAL(등급 내 최고급여비교액;NUMBER)

-- 1. 생성된 테이블의 목록을 출력하는 SQL문을 작성하시오(5점).
SELECT * FROM TAB;
SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

-- 2. TO_DATE 단일행함수를 이용하여 EMP 테이블에서 HIREDATE가 1981년 2월 20일부터 1981년 5월 1일 사이에 입사한 사원의 사원명, 직책, 입사일을 최초입사일부터 최근입사일 순으로 정렬하여 출력하는 SQL문을 작성하시오(5점).
SELECT ENAME 사원명, JOB 직책, HIREDATE 입사일 FROM EMP 
    WHERE HIREDATE BETWEEN TO_DATE ('810220', 'RRMMDD')AND TO_DATE ('810501', 'RRMMDD')
    ORDER BY HIREDATE ;
-- 3. EMP테이블과 DEPT테이블의 self join과 outer join을 이용하여 사원명, 급여, 부서번호, 부서명, 근무지, 직속상사명을 상사가 없는 직원까지 전체 직원 다 출력하는 SQL문을 작성하시오. 단, 상사가 없는 경우 상사명 대신 ‘없음’을 출력한다(5점).
SELECT W.ENAME 사원명, W.JOB 직책, W.DEPTNO 부서번호, DNAME 부서명, LOC 근무지, NVL(M.ENAME,'없음') 직속상사명 
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO(+) AND W.DEPTNO = D.DEPTNO;


-- 4. SALGRADE 테이블의 LOSAL을 등급최저 급여, HISAL을 등급 최고 급여로 이용하여, EMP 테이블의 사원을 사번, 사원명, 직책, 급여, 급여등급을 급여 기준 내림차순으로 정렬하여 출력하는 SQL문을 작성하시오(5점).
SELECT EMPNO 사번, ENAME 사원명, JOB 직책, SAL 급여, GRADE 급여등급
    FROM EMP E, SALGRADE S
    WHERE E.SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;

--5. EMP 테이블에서 부서번호가 20번인 사원의 사번, 사원명, 급여를 출력하되 급여 앞에는 $를 붙이고, 숫자는 3자리마다 콤마( , )를 추가하여 출력하는 SQL문을 작성하시오. 단 급여(SAL)의 타입은 NUMBER(7,2)로 한다(5점).
SELECT EMPNO 사번, ENAME 사원명, TO_CHAR(SAL, '$9,999,999.99') 급여 FROM EMP E WHERE DEPTNO = 20;

-- 6. EMP 테이블에서 직책별 급여 평균이 3000이상인 직책에 대하여 직잭명, 평균급여, 금여의 합을 출력하는 SQL문을 작성하시오(5점).

SELECT JOB, ROUND(AVG(SAL)), SUM(SAL) FROM EMP 
        GROUP BY JOB 
        HAVING AVG(SAL)>=3000 ;

    
-- 7. EMP테이블에서 사원명이 ‘FORD’인 직원과 직책(JOB)과 급여(SAL)이 같은 사원의 모든 정보를 출력하는 SQL문을 작성하시오(5점).
SELECT * FROM EMP WHERE (JOB, SAL) =(SELECT JOB, SAL FROM EMP WHERE ENAME = 'FORD') AND ENAME!='FORD';

-- 8. EMP 테이블에서 사원명이 ‘FORD’인 사원을 삭제하는 SQL문을 작성하시오(5점).
DELETE FROM EMP WHERE ENAME = 'FORD';


-- 9. 데이터베이스에서 트랜잭션은 데이터 처리의 한 단위를 말한다. 데이터를 조작하기 위한 INSERT, UPDATE, DELETE 등의 명령들이 실행됨과 동시에 트랜잭션이 진행되는데, 이들 INSERT, UPDATE, DELETE작업이 성공적으로 데이터베이스에 반영·처리되도록 명령어를 작성하시오(5점).

CREATE TABLE DEPT02 AS SELECT * FROM DEPT; -- 새로운 테이블 생성
SELECT * FROM DEPT02; -- 목록 확인
INSERT INTO DEPT02 VALUES (99, 'GD', 'YG'); -- 테이블에 새로운 행 삽입
SELECT * FROM DEPT02; -- 목록 확인
COMMIT; --데이터베이스에 반영
DELETE FROM DEPT02 WHERE DEPTNO IN (99,77); -- 테이블에 해당하는 행 삭제
SELECT * FROM DEPT02; -- 목록 확인
COMMIT; --데이터베이스에 반영
UPDATE DEPT02 SET DNAME = 'DONMILLS' WHERE DEPTNO = 88; -- 88번 부서의 부서명 업데이트
SELECT * FROM DEPT02; -- 목록 확인
COMMIT; --데이터베이스에 반영

-- 10. EMP테이블에서 사원명으로 조회하는 시간을 단축하기 위해 사용되는 인덱스 생성 명령어를 작성하시오. 생성된 인덱스의 이름은 IDX_EMP_ENAME으로 한다(10점).
DROP TABLE EMP02;
CREATE TABLE EMP02 AS SELECT * FROM EMP; -- EMP와 똑같은 더미데이터 생성
SELECT * FROM EMP02; -- 더미데이터 조회
INSERT INTO EMP02 SELECT * FROM EMP02; -- 목록 수 증가시키기
INSERT INTO EMP02 (EMPNO, ENAME) VALUES (1111,'HONG'); --찾을 데이터 삽입
INSERT INTO EMP02 SELECT * FROM EMP02; -- 목록 수 증가시키기
SELECT * FROM EMP02 WHERE ENAME = 'HONG'; -- 인덱스 생성 전 검색 속도 0.002초
CREATE INDEX IDX_EMP_ENAME ON EMP02(ENAME); -- 인덱스 생성
SELECT * FROM EMP01 WHERE ENAME = 'HONG'; -- 인덱스 생성 이후 0.012초

-- 11. 현재 계정 소유한 테이블에 대한 정보를 저장한 데이터 딕셔너리뷰를 살펴보는 SQL문을 작성하시오(5점).

SELECT * FROM USER_INDEXES;
