create database zero_waste;

use zero_waste;

create table users
(
user_id int IDENTITY(1,1) ,
username varchar(20),
name varchar(30),
email varchar(50),
password varchar(50),
question varchar(100),
answer varchar(255),
phone varchar(20),
user_type varchar(20),
primary key(user_id,username)
)


select *from users;

drop table users;

create table event(
event_id int IDENTITY(1,1) PRIMARY KEY,
event_name varchar(50),
event_for varchar(60),
food_type varchar(50),
date_time varchar(30),
location varchar(30),
quantity varchar(20))

drop table event;

create table donation_form(
donation_id int IDENTITY(1,1) PRIMARY KEY,
user_id int ,
username varchar(20),
phone varchar(30),
location varchar(50),
ngo varchar(50),
food_type varchar(60),
date_of_cooking varchar(30),
quantity varchar(20),
FOREIGN KEY(user_id,username) REFERENCES users(user_id,username)
)

drop table remained_food_info;

select *from donation_form;

create table remained_food_info(
user_event_id int  ,
remained_food varchar(50),
wasted_food varchar(50))

create table ngo_list(
ngo_id int IDENTITY(1,1) PRIMARY KEY,
ngo_name varchar(30))

create table event_donation_form(
username varchar(50),
email varchar(50),
phone varchar(50),
location varchar(50),
ngo varchar(40),
type_of_food varchar(100),
date_of_cooking varchar(30),
quatity varchar(20))

drop table event_donation_form;
create table event_donation_form(
donation_id int IDENTITY(1,1) PRIMARY KEY,
username varchar(20),
email varchar(50),
phone varchar(50),
location varchar(50),
ngo varchar(40),
food_type varchar(100),
date_of_cooking varchar(30),
quantity varchar(20))

create table offer_help(
username varchar(30),
email varchar(20),
phone varchar(20),
event_ID varchar(100),
event_name varchar(50),
event_time varchar(30),
event_location varchar(30),
event_for varchar(30));

insert into ngo_list values('basmah'),('Food Bank Network'),('One taka meal'),('Apon Foundation'),('Bidyanondo')

select *from users;

select*from offer_help;

select *from event;

select *from ngo_list;

select *from donation_form;

select *from event_donation_form;

select *from remained_food_info;
