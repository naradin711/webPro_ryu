-- [VII] DDL, DML, DCL
-- SQL = DDL (���̺� ����, ���̺� ����, ���̺�������, ���̺� ��� ������ ����)
--       DML (�˻� = SELECT, �߰� = INSERT, ���� = UPDATE, ���� = DELETE)
--       DCL (����ڰ�������, ����ڱ��Ѻο�, ���ѹ�Ż, ����ڰ�������)

-- *** DDL ***
-- 1. ���̺� ���� (CREATE TABLE)
CREATE TABLE BOOK(
  BOOKID NUMBER(4),         -- ������ȣ BOOKID �ʵ� Ÿ���� ���� 4�ڸ�
  BOOKNAME VARCHAR2(300),   -- �������� BOOKNAME �ʵ�� ���� 300 ����Ʈ
  PUBLISHER VARCHAR2(300),  -- ���ǻ� PUBLISHER �ʵ�� ���� 300 ����Ʈ
  RDATE     DATE,           -- ������ RDATE �ʵ�� DATE��
  PRICE     NUMBER(8),      -- ���� PRICE �ʵ�� ���� 8�ڸ�
  PRIMARY KEY(BOOKID));     -- BOOKID �� ��Ű/PRIMARY KEY ���� - NOT NULL, ������ �� �Է�.
  
SELECT * FROM BOOK;