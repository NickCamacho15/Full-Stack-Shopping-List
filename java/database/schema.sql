BEGIN TRANSACTION;

DROP TABLE IF EXISTS group_member,groups,users;

DROP SEQUENCE IF EXISTS seq_group_id, seq_user_id;

CREATE SEQUENCE seq_user_id
INCREMENT BY 1
START WITH 1001
NO MAXVALUE;

CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE seq_group_id
INCREMENT BY 1
START WITH 2001
NO MAXVALUE;

CREATE TABLE groups (
	group_id int NOT NULL DEFAULT nextval ('seq_group_id'),
	group_name varchar(50) NOT NULL,
	admin_id int,
	
	CONSTRAINT pk_group PRIMARY KEY (group_id),
	CONSTRAINT fk_admin_id FOREIGN KEY (admin_id) REFERENCES users(user_id) 
);

CREATE TABLE group_member(
	user_id INT NOT NULL,
	group_id INT NOT NULL,
	
	
CONSTRAINT pk_group_member PRIMARY KEY (user_id, group_id)
	,CONSTRAINT fk_member_id FOREIGN KEY (user_id) REFERENCES users(user_id)
	,CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES groups(group_id)
);

COMMIT TRANSACTION;
