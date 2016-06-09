CREATE DATABASE spending WITH ENCODING='UTF8' OWNER=s_admin CONNECTION LIMIT=-1;
create sequence U_ID;
create table USERS (id int not null default nextval('U_ID'), email varchar(127) not null, pass VARCHAR(30), primary key (ID));