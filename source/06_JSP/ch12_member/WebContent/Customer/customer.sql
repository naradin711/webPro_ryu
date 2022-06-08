--CUSTOMER.SQL
DROP TABLE CUSTOMER;
SELECT * FROM CUSTOMER;
CREATE TABLE CUSTOMER (
    CID     VARCHAR2(50) NOT NULL,
    CPW     VARCHAR2(50) NOT NULL,
    CNAME   VARCHAR2(50) NOT NULL,
    CTEL    VARCHAR2(50) NOT NULL,
    CEMAIL  VARCHAR2(50) NOT NULL,
    CADDRESS VARCHAR2(250) NOT NULL,
    CGENDER VARCHAR2(50) NOT NULL,
    CBIRTH  DATE         NOT NULL,
    CRDATE  DATE DEFAULT SYSDATE NOT NULL
    );
    
COMMIT;  

-- 1. 회원가입 id 중복체크 : public int confirmId(String id)
SELECT * FROM CUSTOMER WHERE CID = 'AAA';

-- 2. 회원가입 : public int joinCustomer(CustomerDto dto)
INSERT INTO CUSTOMER ( CID,  CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH, CRDATE)
    VALUES('AAA', '111', '서지수', '010-2222-2222', 'lovelyz3@lovelyz.com', '인천광역시 연수구 연수동', 'f', '1994-02-11', SYSDATE );

-- 3. 로그인 (ID/PW) : public int loginCheck(String cid, String cpw)
SELECT cid, cpw FROM CUSTOMER WHERE CID = 'AAA';

-- 4. cid로 dto가져오기 : public customerDto getCustomer(String cid)
SELECT * FROM CUSTOMER WHERE CID = 'AAA';

-- 5. 회원정보 수정 : public void cUpdate();

UPDATE CUSTOMER SET CPW     ='111',
                    CNAME   = '서지수',
                    CTEL    = '010-3333-3333',
                    CEMAIL  =  'lovelyz3@lovelyz.com', 
                    CADDRESS = '서울시 용산구 한남동',
                    CGENDER = 'f',
                    CBIRTH  = '1994-02-11'
                    where cid = 'AAA';
                    
COMMIT;









