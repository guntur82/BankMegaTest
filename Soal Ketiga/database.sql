CREATE DATABASE SpringMega
GO

use SpringMega

CREATE TABLE users (
	id BigInt PRIMARY KEY IDENTITY(1,1),
	username varchar(255) NOT NULL,
	password text NOT NULL,
	created_by BigInt NOT NULL,
	created_at DateTime DEFAULT GETDATE(),
	update_by BigInt,
	update_at DateTime,
	deleted_by BigInt,
	deleted_at DateTime,
)
GO

CREATE TABLE user_detail(
	id BigInt PRIMARY KEY IDENTITY(1,1),
	user_id BigInt NOT NULL,
	first_name varchar(255) NOT NULL,
	last_name varchar(255) NOT NULL,
	created_by BigInt NOT NULL,
	created_at DateTime DEFAULT GETDATE(),
	update_by BigInt,
	update_at DateTime,
	deleted_by BigInt,
	deleted_at DateTime,
	CONSTRAINT [FK_User_UserDetail] FOREIGN KEY (user_id) REFERENCES users(id)
)
GO

CREATE TABLE jobs(
	id BigInt PRIMARY KEY IDENTITY(1,1),
	user_id BigInt NOT NULL,
	nama varchar(255) NOT NULL,
	start_at DateTime NOT NULL,
	end_at DateTime NULL,
	created_by BigInt NOT NULL,
	created_at DateTime DEFAULT GETDATE(),
	update_by BigInt,
	update_at DateTime,
	deleted_by BigInt,
	deleted_at DateTime,
	CONSTRAINT [FK_User_Jobs] FOREIGN KEY (user_id) REFERENCES users(id)
)
GO
