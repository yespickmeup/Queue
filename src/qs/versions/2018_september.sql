/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Sep 4, 2018
 */



drop table if exists counter_departments;
create table counter_departments(
id int auto_increment primary key
,counter_id varchar(255)
,counter varchar(255)
,department_id varchar(255)
,department varchar(255)
,created_at datetime
,updated_at datetime
,status int
,priority int
);







