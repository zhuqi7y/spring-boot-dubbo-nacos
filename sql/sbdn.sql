create database sbdn;
create user 'sbdn'@'localhost' IDENTIFIED BY '123456';
grant all on sbdn.* to 'sbdn'@'localhost';
