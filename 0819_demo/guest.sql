create table guestbook(
num int primary key auto_increment,
writer varchar(20) not null,
pwd varchar(20) not null,
wdate date not null,
content varchar(100) not null
);