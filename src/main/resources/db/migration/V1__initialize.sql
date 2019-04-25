DROP TABLE IF EXISTS students;

CREATE TABLE students (
	id int(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB CHARSET=latin1;

INSERT INTO students (id, name)
VALUES
(1, "Bob"),
(2, "John"),
(3, "Michael");