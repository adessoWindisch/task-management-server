CREATE TABLE IF NOT EXISTS `employee`
(
    `employee_id`   int AUTO_INCREMENT PRIMARY KEY,
    `org_id`        varchar(10)  NOT NULL,
    `first_name`    varchar(20)  NOT NULL,
    `last_name`     varchar(20)  NOT NULL,
    `email`         varchar(100) NULL,
    `mobile_number` varchar(20) NULL ,
    `created_at`    date         NOT NULL,
    `created_by`    varchar(20)  NOT NULL,
    `updated_at`    date        DEFAULT NULL,
    `updated_by`    varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `tasks`
(
    `task_id`          int AUTO_INCREMENT PRIMARY KEY,
    `employee_id`      int          NOT NULL,
    `task_type`        varchar(20)  NOT NULL,
    `task_description` varchar(100) NOT NULL,
    `task_status`      varchar(20)  NOT NULL,
    `task_priority`    varchar(20)  NOT NULL,
    `task_start_date`  date         NOT NULL,
    `task_end_date`    date         NOT NULL,
    `created_at`       date         NOT NULL,
    `created_by`       varchar(20)  NOT NULL,
    `updated_at`       date        DEFAULT NULL,
    `updated_by`       varchar(20) DEFAULT NULL
);
