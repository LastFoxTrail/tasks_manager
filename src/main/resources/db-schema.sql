CREATE DATABASE IF NOT EXISTS tasks_manager;

USE tasks_manager;

CREATE TABLE tasks (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(255) NOT NULL UNIQUE,
    `text` VARCHAR(255) NOT NULL,
    `dead_line` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `date_of_change` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);