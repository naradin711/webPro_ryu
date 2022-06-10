-- TABLE & SEQUENCE DROP & CREATE
DROP TABLE CUSTOMER;
CREATE TABLE CUSTOMER(
        CID VARCHAR2(50) PRIMARY KEY,
        CPW VARCHAR2(50) NOT NULL,
        CNAME VARCHAR2(50) NOT NULL,
        CTEL VARCHAR2(50) NOT NULL,
        CEMAIL VARCHAR2(50),
        CADDRESS VARCHAR2(250),
        CGENDER VARCHAR2(10) NOT NULL,
        CBIRTH DATE NOT NULL,
        CRDATE DATE DEFAULT SYSDATE
    );
select * from customer;
commit;

-- BOOK

DROP SEQUENCE BOOK_SEQ;
DROP TABLE BOOK;
CREATE SEQUENCE BOOK_SEQ MAXVALUE 99999 NOCACHE NOCYCLE;
CREATE TABLE BOOK (
        BID     NUMBER(5) PRIMARY KEY,      --  책번호
        BTITLE  VARCHAR2(50) NOT NULL,      --  책제목
        BPRICE  NUMBER(7) NOT NULL,         --  책가격
        BIMAGE1 VARCHAR2(50) NOT NULL,      --  책 대표 이미지 (첨부 하지 않을 경우 : noImg.png)
        BIMAGE2 VARCHAR2(50) NOT NULL,      --  책 부가 이미지 (첨부 하지 않을 경우 : NOTHING.jpg)
        BCONTENT VARCHAR2(4000),            --  책 설명 (한글 1,333 글자 이내)
        BDISCOUNT NUMBER(3) NOT NULL,       --  책 할인율
        BRDATE  DATE DEFAULT SYSDATE        --  책 등록일
        
        );
SELECT * FROM BOOK;

-- FILEBOARD
DROP SEQUENCE FILEBOARD_SEQ;
DROP TABLE FILEBOARD;
CREATE SEQUENCE FILEBOARD_SEQ MAXVALUE 99999999 NOCACHE NOCYCLE;
CREATE TABLE FILEBOARD(
        FNUM        NUMBER(7)       PRIMARY KEY, -- 글번호
        CID         VARCHAR2(50)    REFERENCES CUSTOMER(CID), -- 작성자 아이디
        FSUBJECT    VARCHAR2(250)   NOT NULL, -- 글제목
        FCONTENT    VARCHAR2(4000)  , -- 글내용
        FFILENAME   VARCHAR2(250)   , -- 첨부파일명
        FPW         VARCHAR2(50)    NOT NULL, -- 삭제용 비밀번호
        FHIT        NUMBER(7)       DEFAULT 0 NOT NULL , -- 조회수
        FREF        NUMBER(7)       NOT NULL, -- 글순서
        FRESTEP     NUMBER(7)       NOT NULL, -- 그룹내 출력 순서
        FRELEVEL    NUMBER(7)       NOT NULL, -- 들여쓰기 정도
        FIP         VARCHAR2(50)    NOT NULL, -- 글 쓴 컴퓨터의 IP
        FRDATE      DATE    DEFAULT SYSDATE NOT NULL 
        );
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    