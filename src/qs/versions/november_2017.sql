/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Nov 7, 2017
 */


drop table if exists queues;
create table queues(
id int auto_increment primary key
,queue_no varchar(255)
,department varchar(255)
,department_id varchar(255)
,customer varchar(255)
,customer_id varchar(255)
,counter_no varchar(255)
,teller varchar(255)
,teller_id varchar(255)
,remarks varchar(255)
,status int
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
);

drop table if exists customers;
create table customers(
id int auto_increment primary key
,customer_no varchar(255)
,fname varchar(255)
,mi varchar(255)
,lname varchar(255)
,sname varchar(255)
,bday date
,gender int
,occupation varchar(255)
,address varchar(255)
,barangay varchar(255)
,city varchar(255)
,province varchar(255)
,contact_no varchar(255)
,email_address varchar(255)
,status int
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
);
