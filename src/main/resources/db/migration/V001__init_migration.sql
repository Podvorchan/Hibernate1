CREATE SCHEMA IF NOT EXISTS my_university;

-- Создание последовательности
CREATE SEQUENCE IF NOT EXISTS my_university.my_university_id_seq;

-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_university.student
(
    id integer NOT NULL DEFAULT next-val('my_university.my_university_id_seq'),
    name             text NOT NULL,
    email            text NOT NULL,
    PRIMARY KEY (id)
    );

-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_university.mark
(
    id integer NOT NULL DEFAULT next-val('my_university.my_university_id_seq'),
    student_id    integer NOT NULL
    discipline       text NOT NULL,
    value            text NOT NULL
    PRIMARY KEY (id)
    );