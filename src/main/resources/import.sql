
/* Creamos algunos usuarios con sus roles */
INSERT INTO `users` (username, password, enabled,name,last_name) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1,'Administrador','General');
INSERT INTO `users` (username, password, enabled,name,last_name) VALUES ('ppovis','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1,'Paulina','Povis');
INSERT INTO `users` (username, password, enabled,name,last_name) VALUES ('natalia','$2a$10$gG33u1gd.oid0LuBeasXzO45Sx3kB3sdc911K5y1Bfa4oQ11cYyiC',1,'Natalia','');
INSERT INTO `users` (username, password, enabled,name,last_name) VALUES ('elvira','$2a$10$MCBz7O362g9eAYeJslrBCeRqb4pzwoVFoITwljwWFu5JIBgfpJDIy',1,'Elvira','');
INSERT INTO `users` (username, password, enabled,name,last_name) VALUES ('carles','$2a$10$kd3X4mcmczzg31VxGzD7Qe7xzpuYtdfZ3ovfqwF/3.vLl6JpxPh5O',1,'Carles','');
INSERT INTO `users` (username, password, enabled,name,last_name) VALUES ('gerard','$2a$10$NIhnPiTktR0c4lc7J6X4LeBTkbRRuAFbBG0S1PSp7d4YSrg7mINKW',1,'Gerard','');


INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (3,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (4,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (5,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (6,'ROLE_USER');
