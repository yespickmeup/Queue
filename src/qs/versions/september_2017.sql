/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Sep 26, 2017
 */

drop schema if exists db_queue;
create schema db_queue;
use db_queue;

drop table if exists counters;
create table counters(
id int auto_increment primary key
,counter varchar(255)
,department varchar(255)
,department_id varchar(255)
,ip_address varchar(255)
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
,status int
);

drop table if exists departments;
create table departments(
id int auto_increment primary key
,department varchar(255)
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
,status int
);

