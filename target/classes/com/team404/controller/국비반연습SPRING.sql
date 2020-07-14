create table score (
    num number(10,0),
    name varchar2(50),
    kor varchar2(50),
    eng varchar2(50),
    math varchar2(50) 
);

alter table score add constraint score_pk primary key (num);
create sequence score_seq increment by 1 start with 1 nocache;
commit;
select * from score;

create table board (
    num number(10,0),
    name varchar2(50),
    title varchar2(50),
    content varchar2(50)
);

alter table board add constraint board_pk primary key (num);
create sequence board_seq increment by 1 start with 1 nocache;
select * from board;

select sysdate from dual;

create table user (
    num number(10,0),
    id varchar2(50),
    pw varchar2(50),
    name varchar2(50),
    phone1 varchar2(50),
    phone2 varchar2(50),
    email1 varchar2(50),
    email2 varchar2(50),
    addr1 varchar2(50),
    arrd2 varchar2(50)
);
alter table user add constraint user_pk primary key (num);
create sequence user_seq increment by 1 start with 1 nocache;

create table freeboard(
    bno number(10,0),--pk
    title varchar2(300) not null,
    writer varchar2(300) not null,
    content varchar2(2000) not null,
    regdate date default sysdate,--현재시간
    updatedate date default sysdate
    
);

alter table freeboard add CONSTRAINT freeboard_pk PRIMARY KEY (bno);
create SEQUENCE freeboard_seq INCREMENT by 1 start with 1 nocache;
commit;
select * from freeboard;