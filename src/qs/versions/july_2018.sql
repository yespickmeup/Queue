/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Jul 23, 2018
 */

drop table if exists settings;
create table settings(
id int auto_increment primary key
,business_name varchar(255)
,address varchar(255)
,contact_no varchar(255)
,pool_host varchar(255)
,print_queue_no int
,queue_server_ip varchar(255)
,queue_server_port varchar(255)
,location_screen_x varchar(255)
,location_screen_y varchar(255)
,font_size varchar(255)
,counter_no1_ip varchar(255)
,counter_no1_port varchar(255)
,counter_no2_ip varchar(255)
,counter_no2_port varchar(255)
,counter_no3_ip varchar(255)
,counter_no3_port varchar(255)
,counter_no4_ip varchar(255)
,counter_no4_port varchar(255)
,counter_no5_ip varchar(255)
,counter_no5_port varchar(255)
,counter_no6_ip varchar(255)
,counter_no6_port varchar(255)
,counter_no7_ip varchar(255)
,counter_no7_port varchar(255)
,counter_no8_ip varchar(255)
,counter_no8_port varchar(255)
,counter_no9_ip varchar(255)
,counter_no9_port varchar(255)
,counter_no10_ip varchar(255)
,counter_no10_port varchar(255)
,server_ip varchar(255)
,server_port varchar(255)
);

insert into settings(
business_name,address,contact_no,pool_host,print_queue_no,queue_server_ip,queue_server_port,location_screen_x,location_screen_y,
font_size,counter_no1_ip,counter_no1_port,counter_no2_ip,counter_no2_port,counter_no3_ip,counter_no3_port,counter_no4_ip,counter_no4_port,
counter_no5_ip,counter_no5_port,counter_no6_ip,counter_no6_port,counter_no7_ip,counter_no7_port,counter_no8_ip,counter_no8_port,
counter_no9_ip,counter_no9_port,counter_no10_ip,counter_no10_port,
server_ip,server_port
)
values(
"Bawayan Water District","Bayawan City","","localhost","0","localhost","2000","0","0",
"medium","","3000","","3000","","3000","","3000",
"","3000","","3000","","3000","","3000",
"","3000","","3000",
"localhost","3306"
);

