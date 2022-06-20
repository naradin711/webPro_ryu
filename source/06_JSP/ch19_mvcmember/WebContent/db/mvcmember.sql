-- mvcmember.sql 을 저장
DROP TABLE MVCMEMBER;
CREATE TABLE MVCMEMBER(
        MID      VARCHAR2(30) PRIMARY KEY,
        MPW      VARCHAR2(30) NOT NULL,
        MNAME    VARCHAR2(30) NOT NULL,
        MEMAIL   VARCHAR2(30) ,
        MPHOTO   VARCHAR2(30),
        MBIRTH   DATE NOT NULL,
        MADDRESS VARCHAR2(300) NOT NULL,
        MRDATE   DATE DEFAULT SYSDATE
        );
        
-- DUMMY DATA 넣기

INSERT INTO mvcmember (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
       VALUES ('aaa', '111', '홍길동', 'hong@hong.com', null, '1972/09/01', '서울시 은평구', SYSDATE);
INSERT INTO mvcmember (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
       VALUES ('bbb', '111', '신길동', 'hong1@hong.com', null, '1972/09/02', '서울시 은평구', SYSDATE);
INSERT INTO mvcmember (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
       VALUES ('ccc', '111', '고길동', 'hong2@hong.com', null, '1972/09/03', '서울시 은평구', SYSDATE);
INSERT INTO MVCMEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시' , SYSDATE);
INSERT INTO MVCMEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시', SYSDATE);
INSERT INTO MVCMEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시', SYSDATE);
INSERT INTO MVCMEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('ham','1','함소원','ham@naver.com','ham.jpg','1976/06/16','서울시', SYSDATE);
INSERT INTO MVCMEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시', SYSDATE);
INSERT INTO MVCMEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('jang','1','장동건',null,'jang.jpg','1981/03/01', '서울시 노원구', SYSDATE);
INSERT INTO MVCMEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('jo','1','조현우',null,'jo.jpg','1988/03/01', '서울시 은평구', SYSDATE);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('kang','1','강동원',null,'kang.jpg','1988/03/09', '서울시 은평구', SYSDATE);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('kim','1','김태희',null,'kim.jpg','1988/03/08', '서울시 은평구', SYSDATE);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('lee','1','이선빈',null,'lee.jpg','1988/03/07', '서울시 은평구', SYSDATE);
INSERT INTO MVCMEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('lim','1','임요한',null,'lim.jpg','1988/03/06', '서울시 은평구', SYSDATE);
INSERT INTO MVCMEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('park','1','박보검',null,'park.jpg','1988/03/05', '대전시 유성구', SYSDATE);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('rain','1','비',null,'rain.jpg','1988/03/14', '서울시 마포구', SYSDATE);
INSERT INTO MVCMEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('s','1','송가연',null,'s.jpg','1988/03/03', '서울시 은평구', SYSDATE);
INSERT INTO MVCMEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('son','1','손흥민',null,'son.jpg','1988/03/02', '서울시 은평구', SYSDATE);
INSERT INTO MVCMEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('song','1','송중기',null,'song.jpg','1953/07/07', '서울시 종로구', SYSDATE);
INSERT INTO MVCMEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('song2','1','송혜교',null,'song2.jpg','1982/03/02', '서울시 강남구', SYSDATE);    
       
-- dao에 들어갈 query

-- 로그인

SELECT * FROM mvcmember WHERE MID='aaa' AND MPW='111';

-- 회원가입
INSERT INTO mvcmember (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
       VALUES ('fff', '111', '금길동', 'hong5@hong.com', null, '1945/12/05', '서울시 은평구', SYSDATE);

-- 회원가입 아이디 중복체크
SELECT * FROM mvcmember WHERE MID='aaa'; 

-- 회원 수 세보기

SELECT COUNT(*) CNT FROM mvcmember;

-- 회원목록 전체보기 (페이징 3 블록사이즈 5)
SELECT * FROM 
        (SELECT ROWNUM RN, A.* FROM 
        (SELECT * FROM mvcmember ORDER BY MRDATE DESC)A )
         WHERE RN BETWEEN 1 AND 17;


-- 회원정보 상세보기 (MID로 DTO 불러오기)
SELECT * FROM mvcmember WHERE MID='aaa'; 

-- 회원정보 수정하기
UPDATE mvcmember SET MNAME  = '신길동',
                     MPW    = '111',
                     MEMAIL = 'hong111@hong.com',
                     MPHOTO = NULL,
                     MBIRTH = '1990-07-08',
                     MADDRESS = '서울시 중랑구'
                     WHERE MID = 'aaa';
SELECT * FROM mvcmember order by mrdate desc;
commit;