/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Aug 17, 2018
 */

alter table departments add shortcut varchar(255);
alter table counters add shortcut varchar(255);

alter table settings add screen_size_x int default 1366;
alter table settings add screen_size_y int default 768;
alter table settings add play_video_sound int default 0;

alter table counters add login int default 0;
set global max_connections = 20000;