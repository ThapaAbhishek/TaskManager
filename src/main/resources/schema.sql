CREATE TABLE IF NOT EXISTS TaskManager (
    id INT AUTO_INCREMENT PRIMARY KEY,
    taskTitle VARCHAR(255) NOT NULL,
    taskDescription TEXT,
    taskStatus VARCHAR(50),
    taskCreatedDate DATETIME,
    taskDueDate DATETIME
    );