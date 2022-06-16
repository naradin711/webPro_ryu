--ch_19 mvc에 쓰일 sql
DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER (
        ID VARCHAR2(30) PRIMARY KEY,
        PW VARCHAR2(30) NOT NULL,
        NAME  VARCHAR2(30) NOT NULL,
        BIRTH DATE,
        RDATE DATE DEFAULT SYSDATE NOT NULL
        );
        
-- 회원 가입

    INSERT INTO MEMBER (ID, PW, NAME, BIRTH)    
        VALUES ('aaa', '111', '장길동', '1999-09-09');
    
-- 회원 리스트

SELECT * FROM MEMBER;

commit;


    
    
    
    
    