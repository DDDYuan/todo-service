CREATE TABLE task(
  id INT PRIMARY KEY AUTO_INCREMENT,
  content TEXT,
  todo_id INT,
  deleted BOOL default false,
  FOREIGN KEY (todo_id) REFERENCES todo(id)
);