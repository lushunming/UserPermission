
/*

插入用户表

*/

INSERT INTO "t_user" (loginname,password,status)VALUES('admin',111111,1);


/*
插入任务表
*/



INSERT INTO "t_task"  ( name, url, description) VALUES ('任务管理', '/task/list.html', '任务管理');
INSERT INTO "t_task"  ( name, url, description) VALUES ('角色管理', '/role/list.html', '角色管理');
INSERT INTO "t_task"  ( name, url, description) VALUES ('用户管理', '/user/list.html', '用户管理（超级管理员使用）');
INSERT INTO "t_task"  ( name, url, description) VALUES ('用户管理', '/user/manage.html', '用户管理（给不是超级管理的使用）');


/*
插入角色表
*/

INSERT INTO "t_role" ( name, level, description) VALUES ('系统管理员', '100', '系统管理员是超级管理员');
INSERT INTO "t_role" ( name, level, description) VALUES ('教务管理员', '90', '教务管理员是学校一级');
INSERT INTO "t_role" ( name, level, description) VALUES ('课程管理员', '80', '课程管理员是学院一级');
INSERT INTO "t_role" ( name, level, description) VALUES ('课程组长', '70', '课程组长');
INSERT INTO "t_role" ( name, level, description) VALUES ('教师', '60', '教师');
INSERT INTO "t_role" ( name, level, description) VALUES ('学生', '50', '学生');




/*
插入用户角色关系表
*/

INSERT INTO "t_user_role_rel" (user_id,role_id) VALUES (1,1);

/*
插入角色任务关系表
*/

INSERT INTO "t_role_task_rel" (role_id,task_id) VALUES (1,1);
INSERT INTO "t_role_task_rel" (role_id,task_id) VALUES (1,2);
INSERT INTO "t_role_task_rel" (role_id,task_id) VALUES (1,3);
INSERT INTO "t_role_task_rel" (role_id,task_id) VALUES (1,4);
