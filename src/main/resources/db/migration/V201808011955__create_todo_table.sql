CREATE TABLE todo(
  id INT PRIMARY KEY AUTO_INCREMENT,
  value TEXT,
  checked BOOL,
  timestamp DATETIME,
  deleted BOOL default false
);