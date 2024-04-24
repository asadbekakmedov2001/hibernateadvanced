CREATE DATABASE  IF NOT EXISTS `instructor_tracker`;
USE `instructor_tracker`;

INSERT INTO `user` values(1, 'admin', '{noop}1', 'Y', 'Admin', null, null);
INSERT INTO `user` values(2, 'wayne', '{noop}1', 'Y', 'Wayne', 'Bruce', 'wayne@email');
INSERT INTO `user` values(3, 'martin', '{noop}1', 'Y', 'Martin', null, 'martin@email');
INSERT INTO `user` values(4, 'melmen', '{noop}1', 'Y', 'Melmen', null, 'melmen@email');
INSERT INTO `user` values(5, 'alex', '{noop}1', 'Y', 'Alex', null, 'alex@email');

INSERT INTO role values('wayne', 'ROLE_STUDENT');
INSERT INTO role values('martin', 'ROLE_STUDENT');
INSERT INTO role values('martin', 'ROLE_INSTRUCTOR');
INSERT INTO role values('melmen', 'ROLE_STUDENT');
INSERT INTO role values('melmen', 'ROLE_INSTRUCTOR');
INSERT INTO role values('melmen', 'ROLE_MANAGER');
INSERT INTO role values('alex', 'ROLE_STUDENT');
INSERT INTO role values('alex', 'ROLE_INSTRUCTOR');
INSERT INTO role values('alex', 'ROLE_MANAGER');
INSERT INTO role values('alex', 'ROLE_ADMIN');
INSERT INTO role values('admin', 'ROLE_STUDENT');
INSERT INTO role values('admin', 'ROLE_INSTRUCTOR');
INSERT INTO role values('admin', 'ROLE_MANAGER');
INSERT INTO role values('admin', 'ROLE_ADMIN');
