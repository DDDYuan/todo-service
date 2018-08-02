CREATE TABLE todo(
  id INT PRIMARY KEY AUTO_INCREMENT,
  value TEXT,
  checked BOOL,
  timestamp DATETIME,
  user_id int,
  deleted BOOL default false
);