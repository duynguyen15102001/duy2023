use springbootweb;

insert into role(code,name) values('ADMIN','Quản trị hệ thống');
insert into role(code,name) values('USER','người dùng');

insert into users(id,username,password,fullname,status)
values(1,'admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','admin',1);
// default là 123456 nhé.
insert into users(id,username,password,fullname,status)
values(2,'nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van a',1);

INSERT INTO user_role(user_id,role_id) VALUES (1,1);
INSERT INTO user_role(user_id,role_id) VALUES (2,2);






