DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS ROLE;
DROP TABLE IF EXISTS POLL;
DROP TABLE IF EXISTS Question_type;
DROP TABLE IF EXISTS Question;
DROP TABLE IF EXISTS Answer;
DROP TABLE IF EXISTS User_Answer;
DROP TABLE IF EXISTS QUESTION_USER_ANSWERS;

CREATE TABLE Answer_type
(
    id          LONG         NOT NULL AUTO_INCREMENT,
    answer_type VARCHAR(254) NOT NULL,
    PRIMARY KEY (id)
);

insert into Answer_type (id, answer_type)
values (1, 'single'),
       (2, 'multi'),
       (3, 'text');

CREATE TABLE POLL
(
    id          LONG         NOT NULL AUTO_INCREMENT,
    name        VARCHAR(254) NOT NULL,
    description VARCHAR(254) NOT NULL,
    START_DATE  DATE,
    END_DATE    DATE,
    PRIMARY KEY (id)
);

insert into POLL (description, name, START_DATE, END_DATE)
values ('first pool','name1', null, null),
       ('second poll','name2', null, null),
       ('third poll','name3', CURRENT_DATE, null),
       ('empty poll','name4', null, null);

CREATE TABLE Question
(
    id             LONG         NOT NULL AUTO_INCREMENT,
    text           VARCHAR(254) NOT NULL,
    answer_type_id BIGINT REFERENCES Answer_type (id),
    poll_id        BIGINT REFERENCES POLL (id),
    PRIMARY KEY (id)
);

INSERT INTO Question (text, poll_id, answer_type_id)
VALUES ('How old are you?', 1, 3),
       ('What is your name?', 2, 1),
       ('Where you from?', 3, 2),
       ('Some question', 1, 3);


CREATE TABLE Answer
(
    id          LONG         NOT NULL AUTO_INCREMENT,
    answer      VARCHAR(254) NOT NULL,
    is_true     BOOL         NOT NULL DEFAULT FALSE,
    question_id BIGINT REFERENCES Question (id)
);

INSERT INTO Answer (answer, is_true, question_id)
VALUES ('Max', false, 2),
       ('Igor', true, 2),
       ('Tomsk', true, 3),
       ('Krasnodar', true, 3),
       ('Moscow', false, 3),
       ('29', true, 1);

CREATE TABLE ROLE
(
    id   LONG         NOT NULL AUTO_INCREMENT,
    name VARCHAR(254) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO ROLE (id, name)
values (1, 'ADMIN'),
       (2, 'USER'),
       (3, 'ANONIM');

CREATE TABLE USER
(
    id       LONG NOT NULL AUTO_INCREMENT,
    username VARCHAR(128),
    password VARCHAR(128),
    role_id  LONG REFERENCES ROLE (id),
    active   BOOL NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id)
);


INSERT INTO USER (username, password, role_id, active)
values ('user', 'user', 2, true),
       ('admin', 'admin', 1, true),
       ('', '', 3, true);

CREATE TABLE User_Answers
(
    id          LONG         NOT NULL AUTO_INCREMENT,
    answer      VARCHAR(254) NOT NULL,
    question_id BIGINT REFERENCES Question (id),
    user_id     BIGINT REFERENCES USER (id)
);

INSERT INTO User_Answers (answer, question_id, user_id)
VALUES ('Max', 1, 1),
       ('Igor', 1, 1),
       ('Tomsk', 3, 1),
       ('Krasnodar', 3, 1),
       ('Moscow', 3, 1),
       ('29', 3, 1);


