/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Jan 24, 2018
 */


drop table if exists user_settings;
create table user_settings(
id int auto_increment primary key
,user_id varchar(255)
,user_name varchar(255)
,counter_id varchar(255)
,counter_no varchar(255)
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
);