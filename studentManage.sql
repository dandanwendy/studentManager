CREATE TABLE teacher(
id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
teacher_name VARCHAR(20),
course VARCHAR(20)
)

CREATE TABLE mark(
id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
student_id INT,
course VARCHAR(20),
teacher_id INT,
score INT
)

SELECT NAME,score FROM student AS s,mark AS m WHERE s.id = student_id AND m.course='语文';

SELECT NAME,score FROM student AS s INNER JOIN mark AS m ON s.id=m.`student_id` WHERE 13 = student_id AND m.course='语文';

`student`


SELECT NAME,score FROM student AS s INNER JOIN mark AS m ON s.id=m.`student_id` WHERE 13 = student_id AND m.course='语文'
AND
SELECT NAME,score FROM student AS s INNER JOIN mark AS m ON s.id=m.`student_id` WHERE 13 = student_id AND m.course='数学'
AND
SELECT NAME,score FROM student AS s INNER JOIN mark AS m ON s.id=m.`student_id` WHERE 13 = student_id AND m.course='英语';

DELETE FROM student WHERE id > 15;

/*下面这三行代码可以在删除数据之后，让主键重新从1开始自增*/

SET @i=0;

UPDATE `student` SET `id`=(@i:=@i+1);

ALTER TABLE `student` AUTO_INCREMENT=0;


