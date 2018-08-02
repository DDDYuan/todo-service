INSERT INTO todo (`value`, `checked`, `timestamp`, `user_id`) VALUES ("todo item 1 from script", false, CURRENT_TIMESTAMP, 1);
INSERT INTO todo (`value`, `checked`, `timestamp`, `user_id`) VALUES ("todo item 2 from script", false, CURRENT_TIMESTAMP, 1);
INSERT INTO todo (`value`, `checked`, `timestamp`, `user_id`) VALUES ("todo item 3 from script", false, CURRENT_TIMESTAMP, 2);

INSERT INTO task (`content`, `todo_id`)  VALUES ("task1 for item 1", 1 );
INSERT INTO task (`content`, `todo_id`)  VALUES ("task2 for item 1", 1 );
INSERT INTO task (`content`, `todo_id`)  VALUES ("task3 for item 2", 2 );