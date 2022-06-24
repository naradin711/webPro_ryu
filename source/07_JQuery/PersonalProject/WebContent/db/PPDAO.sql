--for the Personal Project
--------------------------------------------------------------------
                        -- CUSTOMER TABLE
--------------------------------------------------------------------
DROP TABLE CUSTOMER_SHOP;
CREATE TABLE CUSTOMER_SHOP (
            cid VARCHAR2(30) PRIMARY KEY,
            cpw VARCHAR2(30) NOT NULL,
            cname VARCHAR2(30) NOT NULL,
            cemail VARCHAR2(30) NOT NULL UNIQUE,
            ctel VARCHAR2(30) NOT NULL UNIQUE,
            caddress VARCHAR2(30) NOT NULL,
            cbirth DATE,
            crdate DATE DEFAULT SYSDATE
        );
select * from customer_shop;

--1. ID중복체크


--2. 회원가입        
INSERT INTO customer_shop (CID, CPW, CNAME, CEMAIL, CTEL, CADDRESS, CBIRTH)
        VALUES ('aaa', '111', '홍길동', 'honghong11@hong.com', '010-9999-9999', 
                '서울시 종로구 무악동', '1992-02-19');
                
                
--------------------------------------------------------------------
                        -- ADMIN TABLE
--------------------------------------------------------------------    
DROP TABLE ADMIN CASCADE CONSTRAINTS;
CREATE TABLE ADMIN(
    aid VARCHAR2(30)    PRIMARY KEY,
    apw VARCHAR2(30)    NOT NULL,
    aname VARCHAR2(30)  NOT NULL);
    
select * from admin; 
-- (1) admin loginCheck
SELECT * FROM ADMIN WHERE AID='admin' AND APW='111';
-- (2) 로그인 후 세션에 넣을 용도 : admin aid로 dto 가져오기
SELECT * FROM ADMIN WHERE AID='admin';


--------------------------------------------------------------------
                        -- PRODUCT TABLE
--------------------------------------------------------------------  

DROP TABLE PRODUCT CASCADE CONSTRAINTS;
DROP SEQUENCE PRODUCT_SEQ;
CREATE  SEQUENCE PRODUCT_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;

CREATE TABLE PRODUCT (
        pid NUMBER(10) PRIMARY KEY,
        pname VARCHAR2(30) NOT NULL UNIQUE,
        ptype VARCHAR2(30) NOT NULL,
        pcontent VARCHAR2(3000) NOT NULL,
        pphoto VARCHAR2(300) NOT NULL,
        pprice NUMBER(10) NOT NULL,
        phit NUMBER(10) DEFAULT 0 ,
        prdate DATE DEFAULT SYSDATE
        );
        
SELECT * FROM product;
COMMIT;
        
-- 1. 상품등록        
INSERT INTO PRODUCT (PID, PNAME, PTYPE, pcontent, pphoto, pprice )
        VALUES (PRODUCT_SEQ.nextval , 'WHITE DRESS' , 'DRESS' , 
                '이것은 하얀색 원피스' , 'NOIMG.JPG' , 50000 );
        INSERT INTO PRODUCT (PID, PNAME, PTYPE, pcontent, pphoto, pprice )
        VALUES (PRODUCT_SEQ.nextval , 'WHITE TOP' , 'TOP' , 
                '이것은 하얀색 상의' , 'NOIMG.JPG' , 45000 );
        INSERT INTO PRODUCT (PID, PNAME, PTYPE, pcontent, pphoto, pprice )
        VALUES (PRODUCT_SEQ.nextval , 'RED DRESS' , 'DRESS' , 
                '이것은 빨간색 원피스' , 'NOIMG.JPG' , 35000 );
        INSERT INTO PRODUCT (PID, PNAME, PTYPE, pcontent, pphoto, pprice )
        VALUES (PRODUCT_SEQ.nextval , 'RED DRESS 01' , 'DRESS' , 
                '이것은 빨간색 원피스' , 'NOIMG.JPG' , 35000 );        
                
-- 2. 상품 상세 조회 (PID로 DTO 출력)

SELECT * FROM PRODUCT WHERE PID = 2;

-- 2-1. 상품 조회수 올리기
UPDATE PRODUCT SET PHIT = PHIT + 1 WHERE PID = 2;

-- 3-1 . 상품 목록 출력 이름 검색
Select * from PRODUCT where PNAME like '%' || upper( 'WH' ) || '%';

-- 3-2 . 상품 목록 출력 가격 높은순

SELECT * FROM PRODUCT ORDER BY PPRICE DESC;

-- 3-3 . 상품 목록 출력 가격 낮은순
SELECT * FROM PRODUCT ORDER BY PPRICE ;

-- 3-4 . 상품 목록 최신순
SELECT * FROM PRODUCT ORDER BY PRDATE DESC;

-- 3-5 . 상품 목록 인기순
SELECT * FROM PRODUCT ORDER BY PHIT DESC;

-- 3-6 . 상품 목록 종류별 (인기순)
SELECT * FROM PRODUCT WHERE PTYPE='DRESS' ORDER BY PHIT DESC;

-- 4. 상품 정보 수정
UPDATE PRODUCT SET  PNAME = 'BLUE TOP',
                    PTYPE = 'TOP',
                    PCONTENT = '이것은 파란색 상의입니다.',
                    PPHOTO = 'NOIMG.JPG',
                    PPRICE = 43000
                    WHERE PID = 2;
-- 5. 상품 삭제

DELETE PRODUCT WHERE PID = 4;

COMMIT;
--------------------------------------------------------------------
                        -- FREEBOARD TABLE
--------------------------------------------------------------------
DROP TABLE FREEBOARD_SHOP;
DROP SEQUENCE FBSHOP_SEQ;
CREATE SEQUENCE FBSHOP_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
CREATE TABLE FREEBOARD_SHOP (
                fbid    NUMBER(10)       PRIMARY KEY,
                CID     VARCHAR2(30)     REFERENCES CUSTOMER_SHOP(CID),
                aname   VARCHAR2(30)     REFERENCES ADMIN(aname),
                fbtitle VARCHAR2(30)     NOT NULL,
                fbcontent VARCHAR2(3000) NOT NULL,
                fbphoto VARCHAR2(300),
                fbrdate DATE DEFAULT SYSDATE,
                fbip    VARCHAR2(30) NOT NULL, 
                fbgroup NUMBER(10)   NOT NULL,
                fbstep  NUMBER(10)   NOT NULL,
                fbindent NUMBER(10)  NOT NULL,
                fbpw    VARCHAR2(3000) NOT NULL
            );

--------------------------------------------------------------------
                        -- REVIEW TABLE
--------------------------------------------------------------------
DROP TABLE FREEBOARD_SHOP;
DROP SEQUENCE FBSHOP_SEQ;
CREATE SEQUENCE FBSHOP_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
CREATE TABLE FREEBOARD_SHOP (
                rbid    NUMBER(10)       PRIMARY KEY,
                CID     VARCHAR2(30)     REFERENCES CUSTOMER_SHOP(CID),
                rbtitle VARCHAR2(30)     NOT NULL,
                rbcontent VARCHAR2(3000) NOT NULL,
                rbphoto VARCHAR2(300),
                rbrdate DATE DEFAULT SYSDATE,
                rbip    VARCHAR2(30) NOT NULL,
                rbpw    VARCHAR2(3000) NOT NULL
            );

--------------------------------------------------------------------
                        -- CART TABLE
--------------------------------------------------------------------

--------------------------------------------------------------------
                        -- ORDER TABLE
--------------------------------------------------------------------




