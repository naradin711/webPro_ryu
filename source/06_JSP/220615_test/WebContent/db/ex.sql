-- 220615 과정평가용 sql
-- 1. CUSTOMER1 TABLE 만들기

CREATE TABLE CUSTOMER1 (
        CID         VARCHAR2(50)  PRIMARY KEY, 
        CPW         VARCHAR2(50)  NOT NULL,
        CNAME       VARCHAR2(50)  NOT NULL,
        CEMAIL      VARCHAR2(50)  NOT NULL,
        CPHOTO      VARCHAR2(250),
        CBIRTH      DATE          NOT NULL,
        CADDRESS    VARCHAR2(250) NOT NULL,
        CRDATE      DATE  DEFAULT SYSDATE NOT NULL
        );
        
-- 1-1 회원가입 public int insertCustomer(CustomerDto dto)

INSERT INTO CUSTOMER1 (CID,  CPW, CNAME, CEMAIL, CPHOTO, CBIRTH, CADDRESS, CRDATE)
         VALUES('aaa', '111', '서지수', 'lovelyz3@lovelyz.com', null, '1994-02-11', '인천광역시 연수구 연수동',  SYSDATE );
     
-- 1-2 회원정보수정

 UPDATE CUSTOMER1 SET 
                    CPW = '111',  
                    CEMAIL = 'hong@hong.com',
                    CPHOTO = null,
                    CADDRESS = '부산',
                    CBIRTH = '1998-08-17'
                    WHERE CID='aaa';
-- 1-3 로그인

SELECT * FROM CUSTOMER1 WHERE CID='aaa' and CPW = '111';

-- 1-4 로그아웃

SELECT * FROM CUSTOMER1 WHERE CID='aaa' and CPW = '111';
--로그아웃은 로그인 로직과 동일하며 로그아웃은 java나 sql문이 아닌 jsp에서 session.invalidate를 통해 이루어진다.


-- 2. ADMIN1 TABLE 만들기

CREATE TABLE ADMIN1 (
        AID     VARCHAR2(50)  PRIMARY KEY, 
        APW     VARCHAR2(50)  NOT NULL,
        ANAME     VARCHAR2(50)  NOT NULL
        );
        
-- 2-1 관리자 등록
INSERT INTO ADMIN1 (AID, APW, ANAME) VALUES('aaa', '111', '홍길동');
     
-- 2-2 관리자 로그인
SELECT * FROM ADMIN1 WHERE AID='aaa' AND APW = '111';

     
            
-- 3. FILBOARD1 TABLE 및 시퀀스 만들기

CREATE SEQUENCE FILEBOARD1_SEQ MAXVALUE 99999999 NOCACHE NOCYCLE;
CREATE TABLE FILEBOARD1(
        FNUM        NUMBER(10)       PRIMARY KEY,
        CID         VARCHAR2(50)     REFERENCES CUSTOMER1(CID), 
        AID         VARCHAR2(50)     REFERENCES ADMIN1(AID), 
        FSUBJECT    VARCHAR2(250)    NOT NULL,  
        FCONTENT    VARCHAR2(3500),  
        FFILENAME   VARCHAR2(250),   
        FHIT        NUMBER(7)        DEFAULT 0 NOT NULL , 
        FIP         VARCHAR2(50)     NOT NULL,  
        FRDATE      DATE             DEFAULT SYSDATE NOT NULL,
        FREF        NUMBER(10)       NOT NULL,  
        FRESTEP     NUMBER(10)       NOT NULL,  
        FRELEVEL    NUMBER(10)       NOT NULL  
        );
        
-- 3-1 원글쓰기

INSERT INTO FILEBOARD1 (FNUM, CID, AID, FSUBJECT, FCONTENT, FFILENAME,  FRDATE, FIP, FREF, FRESTEP, FRELEVEL)
           VALUES (FILEBOARD1_SEQ.NEXTVAL, 'ccc', null, '상하이상하이', '트위스트 추면서', NULL, SYSDATE, '192.168.20.44', FILEBOARD_SEQ.CURRVAL, 0, 0);

-- 3-1-1 관리자의 답글쓰기

UPDATE FILEBOARD1 SET FRESTEP = FRESTEP+1 WHERE FREF=5 AND FRESTEP>0;
    
INSERT INTO FILEBOARD1 (FNUM, CID, AID, FSUBJECT, FCONTENT, FFILENAME,  FRDATE, FIP, FREF, FRESTEP, FRELEVEL)
           VALUES (FILEBOARD1_SEQ.NEXTVAL,  null, 'ccc', '답) 상하이상하이', '난생처음 그녀를 알았고', NULL, SYSDATE, '192.168.20.44', 5, 1, 1);
   
   
-- 3-2 글 목록

SELECT F.*, CNAME, CEMAIL FROM FILEBOARD1 F, CUSTOMER1 C 
                          WHERE F.CID = C.CID 
                          ORDER BY FREF DESC, FRESTEP;
                          
-- 3-2-1 글 상세보기 (FID로 DTO가져오기)

SELECT F.*, CNAME, CEMAIL FROM FILEBOARD1 F, CUSTOMER1 C 
                          WHERE F.CID=C.CID AND FNUM = 4;

-- 3-3 글 수정

UPDATE FILEBOARD1 SET FSUBJECT = '수정된 제목',
                      FCONTENT = '수정된 본문',
                      FFILENAME = NULL, 
                      FIP = '155.155.15.7'
                      WHERE FNUM =3;
                      
-- 3-4 글 삭제

DELETE FROM FILEBOARD1 WHERE FNUM = 1;