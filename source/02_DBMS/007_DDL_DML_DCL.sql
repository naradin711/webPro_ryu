-- [VII] DDL, DML, DCL
-- SQL = DDL (테이블 생성, 테이블 삭제, 테이블구조변경, 테이블 모든 데이터 제거)
--       DML (검색 = SELECT, 추가 = INSERT, 수정 = UPDATE, 삭제 = DELETE)
--       DCL (사용자계정생성, 사용자권한부여, 권한박탈, 사용자계정삭제)

-- *** DDL ***
-- 1. 테이블 생성 (CREATE TABLE)
CREATE TABLE BOOK(
  BOOKID NUMBER(4),         -- 도서번호 BOOKID 필드 타입은 숫자 4자리
  BOOKNAME VARCHAR2(300),   -- 도서제목 BOOKNAME 필드는 문자 300 바이트
  PUBLISHER VARCHAR2(300),  -- 출판사 PUBLISHER 필드는 문자 300 바이트
  RDATE     DATE,           -- 출판일 RDATE 필드는 DATE형
  PRICE     NUMBER(8),      -- 가격 PRICE 필드는 숫자 8자리
  PRIMARY KEY(BOOKID));     -- BOOKID 는 주키/PRIMARY KEY 설정 - NOT NULL, 유일한 값 입력.
  
SELECT * FROM BOOK;

DROP TABLE BOOK;
CREATE TABLE BOOK(
  BOOKID    NUMBER(4)    PRIMARY KEY, -- 도서번호 BOOKID 필드 타입은 숫자 4자리
  BOOKNAME  VARCHAR2(20),             -- 도서제목 BOOKNAME 필드는 문자 300 바이트
  PUBLISHER VARCHAR2(20),             -- 출판사 PUBLISHER 필드는 문자 300 바이트
  RDATE     DATE,                     -- 출판일 RDATE 필드는 DATE형
  PRICE     NUMBER(8) );              -- 가격 PRICE 필드는 숫자 8자리
  
SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- ROWNUM : 테이블에서 읽어들인 논리적 순서.
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO = 20 ORDER BY ENAME;

-- EMP 테이블과 유사한 EMP01 : EMPNO NUMBER(4) ENAME VARCHAR2(20), SAL   NUMBER(7, 2))
CREATE TABLE EMP01( 
            EMPNO NUMBER(4), 
            ENAME VARCHAR2(20), 
            SAL   NUMBER(7, 2)); -- 7자리, 소수점 두자리
DESC EMP01;            
SELECT * FROM EMP01;

-- DEPT 테이블과 유사한 DEPT01 : DEPTNO NUMBER(2, PK) DNAME VARCHAR2(42), SAL   LOC VARCHAR2(39)
CREATE TABLE DEPT01 (
       DEPTNO NUMBER(2),
       DNAME  VARCHAR2(15),
       LOC    VARCHAR2(39),
       PRIMARY KEY(DEPTNO) );
DESC DEPT01;       
-- 서브쿼리를 이용한 테이블 생성
SELECT * FROM TAB ; -- SCOTT이 생성한 테이블 조회
CREATE TABLE EMP02 AS SELECT * FROM EMP; --서브쿼리 결과만 EMP02 테이블 생성후 들어감 (제약조건은 미포함.)

--EX. EMP03 : EMP 테이블에서 EMPNO, ENAME, DEPTNO만 추출한 데이터로 테이블 생성
CREATE TABLE EMP03 AS SELECT EMPNO, ENAME, DEPTNO FROM EMP;
SELECT * FROM EMP03;

--EX. EMP04 : EMP  테이블에서 10번 부서만 추출한 데이터로 테이블
CREATE TABLE EMP04 AS SELECT * FROM EMP WHERE DEPTNO=10;
SELECT * FROM EMP04;

--EX. EMP05 : EMP  테이블에서 테이블 구조만 추출
CREATE TABLE EMP05 AS SELECT * FROM EMP WHERE 1=0; 
-- 혹시라도 필드에 존재하지 않는 값을 넣으면 나중에 INSERT 할 수 있어서 아예 논리적으로 불가능한 수식을 넣어서 구조만 추출한다.
SELECT * FROM EMP05;

-- 2. 테이블 구조변경 (ALTER TABLE)
-- ALTER TABLE 테이블명 ADD || MODIFY || DROP -
-- 2. 1. 필드 추가 (ADD)
SELECT * FROM EMP03; -- EMPNO, ENAME, DEPTNO
ALTER TABLE EMP03 ADD (JOB VARCHAR2 (30), SAL NUMBER(7,2));
ALTER TABLE EMP03 ADD (COMM NUMBER(7, 2));
SELECT * FROM EMP03; -- 추가된 필드에는 NULL이 들어간다 추가된 필드는 EMP에서 값을 넣진 않았기 때문.

--2. 2. 필드 수정 (MODIFY)
SELECT * FROM EMP03; -- EMPNO, ENAME, DEPTNO, / JOB, SAL, COMM = NULL
DESC EMP03;
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2 (4)); -- 숫자데이터가 들어가 있는 상태에서 숫자로만 변경 가능
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER (3)); -- 에러, 기존 필드보다 자리수가 적음
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER (6)); -- 가능
SELECT MAX(LENGTH(ENAME)) FROM EMP;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2 (300));
DESC EMP03;

--2. 3. 필드 삭제 (DROP) : 필드 자체를 삭제.
ALTER TABLE EMP03 DROP COLUMN JOB;
SELECT * FROM EMP03;
-- 논리적으로 특정 필드를 접근 못하도록 (낮)
ALTER TABLE EMP03 SET UNUSED(DEPTNO);
SELECT * FROM EMP03;
-- 논리적으로 접근 못한 필드를 물리적으로 삭제 (새벽)
ALTER TABLE EMP03 DROP UNUSED COLUMNS;


--3. 테이블 삭제 (DROP TABLE)
DROP TABLE EMP01;
DROP TABLE DEPT; -- 다른 테이블엥서 참조하는 데이터가 있을 경우 DROP 안됨.

--4. 테이블의 모든 행을 제거 (TRUNCATE)
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03; -- EMP03안의 모든 데이터가 제거. (취소불가.)
SELECT * FROM EMP03;

--5. 테이블명 변경 (RENAME 전이름 TO 새이름)
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2;

--6. 데이터 딕셔너리 (오라클 시스템만 액세스 가능 ) VS 데이터 딕셔너리 뷰 (사용자 접근용)
-- 종류
-- USER_XXX : 현 계정이 소유하고 있는 객체 (TABLE INDEX CONSTRAINT VIEW) 
--       EX. USER_TABLES   USER_INDEXES  USER_CONSTRAINTS  USER_VIEWS
-- ALL_XXX : 현 계정이 접근 가능한 객체 TABLE INDEX CONSTRAINT VIEW)
--       EX. ALL_TABLES   ALL_INDEXES  ALL_CONSTRAINTS  ALL_VIEWS
-- DBA_XXX : DBA권한자만 접근 가능. DBMS의 모든 객체
--       EX. DBA_TABLES   DBA_INDEXES  DBA_CONSTRAINTS  DBA_VIEWS
SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;
SELECT * FROM USER_TABLES;       -- 내 계정이 소유한 테이블 객체 정보
SELECT * FROM USER_INDEXES;      -- 내 계정이 소유한 인덱스 정보
SELECT * FROM USER_CONSTRAINTS;  -- 내 계정이 소유한 제약 조건
SELECT * FROM USER_VIEWS;        -- 내 계정이 소유한 뷰 정보

--- *** DCL (사용자계정생성, 사용자권한부여, 권한박탈, 사용자 계정삭제) ***

CREATE USER scott2 IDENTIFIED BY 1234;
-- 권한부여 (세션권한, scott.EMP, scott.DEPT 테이블에 대한 모든 권한)

GRANT CREATE SESSION TO scott2; 
GRANT ALL ON EMP TO scott2; -- EMP 테이블에 대한 모든 권한 (검색, 추가, 수정, 삭제) 
GRANT ALL ON DEPT TO scott2; -- DEPT 테이블에 대한 모든 권한 (검색, 추가, 수정, 삭제)
SHOW USER;

-- 권한 박탈 (권한을 박탈할 계정이 접속해제가 된 상태에서 가능)
REVOKE ALL ON EMP FROM SCOTT2; -- SCOTT에 있던 EMP 모든 권한 박탈.
REVOKE ALL ON DEPT FROM SCOTT2; -- SCOTT에 있던 DEPT 모든 권한 박탈.
SHOW USER;

-- 사용자 계정 삭제 (접속중인 계정 삭제 불가)
DROP USER SCOTT2 CASCADE;


-- *** DML (SELECT, INSERT, UPDATE, DELETE)***

-- 1. INSERT INTO 테이블명 VALUES (값1, 값2, 값3, 값4, 값5 .....);
--    INSERT INTO 테이블명 (필드명1, 필드명2, ....) VALUES (값1, 값2, 값3, 값4, 값5 .....);
SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (60, 'IT', 'SEOUL');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (70, 'OPERATION');
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (80, 'HR', NULL); -- 명시적으로 NULL 추가
INSERT INTO DEPT01 VALUES (90, 'SALES', NULL); -- 명시적으로 NULL 추가

-- 서브쿼리를 이용한 INSERT
INSERT INTO DEPT01 SELECT * FROM DEPT;

SELECT * FROM DEPT01 ORDER BY DEPTNO;

-- 트랜잭션 명령어 (DML 명령어만)
COMMIT;

-- SAM01 테이블 작성 주키는 EMPNO

CREATE TABLE SAM01 (
       EMPNO NUMBER(4) CONSTRAINTS SAM_PK PRIMARY KEY,
       ENAME VARCHAR2(10),
       JOB   VARCHAR2(9),
       SAL   NUMBER(7,2));

INSERT INTO SAM01 VALUES (1000, 'APPLE', 'POLICE', 10000);
INSERT INTO SAM01 VALUES (1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 VALUES (1020, 'ORANGE', 'DOCTOR', 25000);
INSERT INTO SAM01 VALUES (1030, 'VERY', NULL , 25000);
INSERT INTO SAM01 VALUES (1040, 'CAT', NULL, 2000);
INSERT INTO SAM01 (SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO=10);

SELECT * FROM SAM01;
SELECT * FROM USER_CONSTRAINTS;
COMMIT;
DROP TABLE SAM01;

-- 2. UPDATE 테이블명 SET 필드명1 = 값1 필드명 2 값2 [WHERE 조건];
DROP TABLE EMP01;

CREATE TABLE EMP01 AS SELECT * FROM EMP;

-- EMP01 테이블의 모든 사원의 SAL을 10% 인상
UPDATE EMP01 SET SAL = 1.1*SAL WHERE SAL IS NOT NULL;

-- 10번 부서의 직원의 입사일을 오늘로, 부서번호는 30으로 수정
UPDATE EMP01 SET HIREDATE = SYSDATE, DEPTNO = 30
WHERE DEPTNO = 10;

-- EMP01 테이블의 급여가 3000이상인 사람만 SAL을 10% 인상
UPDATE EMP01 SET SAL = 1.1*SAL WHERE SAL >= 3000;



-- 'DALLAS'에 근무하는 직원의 급여를 1000씩 인상 (서브쿼리사용)

UPDATE EMP01 SET SAL = (SAL+1000) 
WHERE DEPTNO = (SELECT DEPTNO FROM  DEPT WHERE LOC = 'DALLAS');

--SCOTT의 부서번호를 20으로, JOB을 MANAGER로, SAL과 COMM을 500씩 인상, 직속 상사를 KING으로 수정

UPDATE EMP01 SET DEPTNO=20 ,
                 JOB = 'MANAGER',
                 SAL = SAL+500,
                COMM = NVL(COMM, 0)+500,
                 MGR =(SELECT EMPNO FROM EMP WHERE ENAME  = 'KING')
                 WHERE ENAME = 'SCOTT';
                 
SELECT * FROM EMP01;
-- DEPT01에서 20번 부서 지역명을 DEPT 테이블의 60번 부서 지역명으로 변경   
UPDATE DEPT01 SET LOC =(SELECT LOC FROM DEPT WHERE DEPTNO=60)
              WHERE DEPTNO>=20;
              
SELECT * FROM DEPT01;   -- DEPT 60번 부서가 없어서 NULL값으로 수정.

-- EMP01 테이블의 모든 사원의 급여와 입사일을 'KING'의 급여와 입사일로 수정;
SELECT * FROM EMP01;
UPDATE EMP01
SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME = 'KING');

-- DEPT01 테이블의 20번 부서의 지역명과 부서명을 40번 부서의 지역명과 부서명으로 변경
UPDATE DEPT01
SET (LOC, DNAME) = (SELECT LOC, DNAME FROM DEPT01 WHERE DEPTNO=40)
WHERE DEPTNO = 20;
COMMIT;
SELECT * FROM DEPT01 ORDER BY DEPTNO;

--3. DELETE FROM 테이블명 [WHERE 조건];

SELECT * FROM EMP01; 
DELETE FROM EMP01;
ROLLBACK;

  --EX. EMP01테이블에서 'FORD'인 사원을 삭제
DELETE FROM EMP 01 WHERE ENAME = 'FORD';  

  --EX. EMP01 테이블에서 30번 부서 직원을 삭제
DELETE FROM EMP01 WHERE DEPTNO=30;
ROLLBACK;

  --EX. EMP01 테이블에서 부서명이 RESEARCH 부서의 직원을 삭제
  DELETE FROM EMP01 
  WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME = 'RESEARCH');
  
  --EX. SAM01 테이블에서 JOB이 정해지지 않은 사원을 삭제
  DELETE FROM SAM01 WHERE JOB IS NULL;
  
  --EX. SAM01 테이블에서 이름이 ORANGE인 사원을 삭제 
  DELETE FROM SAM01 WHERE ENAME = 'ORANGE';



CREATE TABLE MY_DATA (
       ID NUMBER(4) PRIMARY KEY,
       NAME VARCHAR2(10),
       USERID   VARCHAR2(30),
       SALARY   NUMBER(10,2));
INSERT INTO MY_DATA VALUES ( 1, 'Scott', 'sscott', 10000);
INSERT INTO MY_DATA VALUES ( 2, 'Ford', 'fford', 13000);
INSERT INTO MY_DATA VALUES ( 3, 'Patel', 'ppatel', 33000);
INSERT INTO MY_DATA VALUES ( 4, 'Report', 'rreport', 23500);
INSERT INTO MY_DATA VALUES ( 5, 'Good', 'ggood', 44450);

SELECT ID, NAME, USERID, TO_CHAR(SALARY, '999,999.99') "SALARY" FROM MY_DATA ;
COMMIT;

UPDATE MY_DATA SET  SALARY = 65000  WHERE ID = 3;
COMMIT;

DELETE MY_DATA WHERE NAME = 'Ford';
COMMIT;

UPDATE MY_DATA SET SALARY = 15000 WHERE SALARY <15000;
COMMIT;

DROP TABLE MY_DATA;


SELECT * FROM MY_DATA;
















