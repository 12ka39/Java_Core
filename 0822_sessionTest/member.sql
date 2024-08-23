create table member(
id varchar(20) primary key,
pwd varchar(20) not null,
name varchar(20) not null,
email varchar(50) not null,
type varchar(20)
);



--on delete cascade, 부모 데이터 삭제시 자식 데이터도 삭제

create table board(
num int primary key auto_increment,
writer varchar(20) references member(id) on delete cascade,
wdate date,
title varchar(100),
content varchar(500)
);