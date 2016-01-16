
CREATE DATABASE IF NOT EXISTS jira CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL PRIVILEGES ON `jira`.* TO 'jirauser'@'localhost';
SET PASSWORD FOR jirauser@localhost=password('jirauser');
FLUSH PRIVILEGES;

