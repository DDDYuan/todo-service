INSERT INTO todo (`value`, `checked`, `timestamp`) VALUES ("todo item 1 from script", false, CURRENT_TIMESTAMP );
INSERT INTO todo (`value`, `checked`, `timestamp`) VALUES ("todo item 2 from script", false, CURRENT_TIMESTAMP );
INSERT INTO todo (`value`, `checked`, `timestamp`) VALUES ("todo item 3 from script", false, CURRENT_TIMESTAMP );

INSERT INTO task (`content`, `todo_id`)  VALUES ("task1 for item 1", 1 );
INSERT INTO task (`content`, `todo_id`)  VALUES ("task2 for item 1", 1 );
INSERT INTO task (`content`, `todo_id`)  VALUES ("task3 for item 2", 2 );