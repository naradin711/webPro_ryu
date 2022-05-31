-- table drop and create
DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER (
    ID      VARCHAR2(30) PRIMARY KEY,
    PW      VARCHAR2(30) NOT NULL,
    NAME    VARCHAR2(30) NOT NULL,
    PHONE1  VARCHAR2(30),
    PHONE2  VARCHAR2(30),
    PHONE3  VARCHAR2(30),
    GENDER  VARCHAR2(1),
    EMAIL   VARCHAR2(50),
    BIRTH   DATE,
    RDATE   DATE DEFAULT SYSDATE NOT NULL,
    ADDRESS VARCHAR2(200)
);

SELECT * FROM member;

-- 1. 회원가입시 ID 중복 체크를 위한 SQL : public int confirmId(String id)
SELECT * FROM MEMBER WHERE ID = 'aaa';

-- 2. 회원가입 : public int joinMember(MemberDto dto)
INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)
    VALUES ('aaa', '111', '홍길동', '02', '1111', '1111', 'm', 'hong@h.com', '1995-12-12', SYSDATE, '서울');

-- 3. 로그인 (id/pw) : public int loginCheck(String id, String pw)
SELECT ID, PW FROM MEMBER WHERE ID='aaa';

-- 4. ID로 dto 가져오기 : public MemberDto getMember(String id)
SELECT * FROM MEMBER WHERE ID='aaa';

-- 5. 회원정보 수정

UPDATE MEMBER SET PW='111',
                  NAME = '신길동',
                  phone1 = '010',
                  phone2 = '9999',
                  phone3 = '9999',
                  GENDER = 'm',
                  EMAIL  = 'a@A.COM',
                  BIRTH  = '1990-12-01',
                  address = '경기도 과천'
                  WHERE ID = 'aaa';
                  
COMMIT;











