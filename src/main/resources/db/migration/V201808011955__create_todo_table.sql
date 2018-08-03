CREATE TABLE todo(
  id INT PRIMARY KEY AUTO_INCREMENT,
  value TEXT,
  checked BOOL,
  timestamp DATETIME,
  user_id int,
  deleted BOOL default false,
  FOREIGN KEY (user_id) REFERENCES user(id)
);