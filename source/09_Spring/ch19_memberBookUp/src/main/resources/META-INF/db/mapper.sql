-- Member.xml(회원가입, 아이디로 DTO 불러오기, 로그인, 정보수정, 회원탈퇴)
select * from member;
-- idConfirm
SELECT * FROM member WHERE MID='bbb';
-- joinMember
INSERT INTO MEMBER VALUES ('aaa','1','홍길동','yisy0703@naver.com','12345','서울');
INSERT INTO MEMBER VALUES ('bbb','111','백길동','naradin@daum.net','12345','서울');
INSERT INTO MEMBER VALUES ('ccc','111','청길동','naradin711@gmail.com','12345','서울');
INSERT INTO MEMBER VALUES ('ddd','111','남길동','yisy0703@naver.com','12345','서울');
-- loginMember
SELECT * FROM member WHERE MID='bbb' AND MPW='111';
-- logoutMember(이건 외부용)
-- getDetailMember
SELECT * FROM member WHERE MID='bbb';
-- modifyMember
UPDATE member SET MNAME  = '신길동',
                     MPW    = '111',
                     MMAIL = 'hong111@hong.com',
                     mPost = '158-10',
                     MADDR = '서울시 중랑구'
                     WHERE MID = 'aaa';
              
--Book.xml(페이징없는 신규 순서대로 booklist, 페이징이 포함된 booklist(책이름순), 책 갯수, 책번호로 책DTO 가져오기, 도서등록, 도서수정  )
-- mainList(신규)
select * from book order by brdate desc;
-- bookList(알파벳)(페이징)
select * from book order by btitle;
SELECT * FROM
    (SELECT ROWNUM RN, A.* FROM
    (select * from book order by btitle)A )
     WHERE RN BETWEEN 1 AND 50;

-- totCntBook
select count(*) cnt from book;
-- getDetailBook
select * from book where bnum = 1;
-- registerBook
INSERT INTO BOOK VALUES
(BOOK_SQ.NEXTVAL, 'ASAP','블아필',sysdate,'noImg.png','noImg.png','ASAP 내 반쪽 아니 완전 Copy');
commit;
-- modifyBook
update book set btitle = 'DM',
                bwriter = '프나',
                bimg1 = 'noImg.png',
                bimg2 = 'noImg.png' ,
                binfo = '더즌메러'
                where bnum = 7;
                
                commit;
                
                