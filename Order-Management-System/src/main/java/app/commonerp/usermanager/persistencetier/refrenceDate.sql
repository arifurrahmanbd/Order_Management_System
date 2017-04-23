drop table country;
drop table security_group;
drop table security_group_permission;
drop table security_permission;
drop table user_login;
drop table user_login_security_group;
drop table person;

insert into hometheatre_db.user(user_email, user_password) 
	values('admin@gmail.com', '123');
