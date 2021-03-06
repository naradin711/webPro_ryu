-- 테이블 생성 (같은 이름의 테이블이 생성되었을 경우 DROP)
-- 더미데이터
SELECT * FROM PERSON;
SELECT * FROM JOB;
DROP TABLE JOB;
CREATE TABLE JOB (
    JNO NUMBER (10) PRIMARY KEY ,
    JNAME VARCHAR2(50) NOT NULL
    );
INSERT INTO JOB VALUES (10, '배우');
INSERT INTO JOB VALUES (20, '가수');
INSERT INTO JOB VALUES (30, '엠씨');

DROP TABLE PERSON;
CREATE TABLE PERSON(
    pNO NUMBER(10) PRIMARY KEY,
    pNAME VARCHAR2(50),
    JNO NUMBER (10) REFERENCES JOB(JNO),
    KOR NUMBER(10) NOT NULL,
    ENG NUMBER(10) NOT NULL,
    MAT NUMBER(10) NOT NULL
    );

DROP SEQUENCE PERSON_SEQ;
CREATE SEQUENCE PERSON_SEQ
    MAXVALUE 9999     -- 최대값
    MINVALUE 1        -- 최소값
    NOCACHE           -- 새로운 시퀀스를 시작할때 캐시 메모리를 초기화 하는 행.
    NOCYCLE   ; 
INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL, '정우성', 10, 90, 80, 81);
INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL, '박세영', 10, 80, 90, 80);
INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL, '배수지', 20, 50, 90, 90);
INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL, '설현', 20, 95, 95, 95);
INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL, '송혜교', 10, 100, 80, 95);

SELECT * FROM PERSON;
SELECT * FROM JOB;

-- 1번 : PNAME, JNAME, KOR, ENG, MAT 입력받아 INSERT
SELECT PNO "번호", PNAME "이름", JNAME "직업명" , KOR "국어점수", ENG "영어점수", MAT "수학점수"
    FROM PERSON P, JOB J WHERE P.JNO = J.JNO;
INSERT INTO PERSON VALUES
   (PERSON_SEQ.NEXTVAL, '정우성', (SELECT JNAME FROM JOB WHERE JNO = 10) , 90, 80, 81);
SELECT JNAME FROM JOB WHERE JNO = 10;
-- 2번 : 직업명을 입력받아 해당 직업의 등수, 이름, 직업명, 국어, 영어, 수학, 총점을 출력하고
--       총점기준으로 내림차순 정렬
SELECT  ROWNUM ||'등' "등수", PNAME||'('||PNO||'번)' "이름(번호)", JNAME "직업명" , 
        KOR "국어점수", ENG "영어점수", MAT "수학점수", KOR+ENG+MAT "총점"
    FROM 
    (SELECT * FROM PERSON P, JOB J WHERE P.JNO = J.JNO AND JNAME = '배우' 
     ORDER BY KOR+ENG+MAT DESC);

-- 3번 : 데이터베이스에 입력된 모든 사람의 등수, 이름, 직업명, 국어, 영어, 수학, 총점을 출력하고
--       총점기준으로 내림차순 정렬
SELECT  ROWNUM ||'등' "등수", PNAME||'('||PNO||'번)' "이름(번호)", JNAME "직업명" , 
        KOR "국어점수", ENG "영어점수", MAT "수학점수", KOR+ENG+MAT "총점"
    FROM 
    (SELECT * FROM PERSON P, JOB J WHERE P.JNO = J.JNO 
     ORDER BY KOR+ENG+MAT DESC);
  
     
DROP TABLE JOB;
CREATE TABLE JOB (
    JNO NUMBER (10) PRIMARY KEY ,
    JNAME VARCHAR2(50) NOT NULL
    );
INSERT INTO JOB VALUES (10, '배우');
INSERT INTO JOB VALUES (20, '가수');
INSERT INTO JOB VALUES (30, '엠씨');

DROP TABLE PERSON;
CREATE TABLE PERSON(
    pNO NUMBER(10) PRIMARY KEY,
    pNAME VARCHAR2(50),
    JNO NUMBER (10) REFERENCES JOB(JNO),
    KOR NUMBER(10) NOT NULL,
    ENG NUMBER(10) NOT NULL,
    MAT NUMBER(10) NOT NULL
    );
 DROP SEQUENCE PERSON_SEQ;
CREATE SEQUENCE PERSON_SEQ
    MAXVALUE 9999     -- 최대값
    MINVALUE 1        -- 최소값
    NOCACHE           -- 새로운 시퀀스를 시작할때 캐시 메모리를 초기화 하는 행.
    NOCYCLE   ;  
    
COMMIT; 

SELECT * FROM PERSON;
SELECT * FROM JOB;