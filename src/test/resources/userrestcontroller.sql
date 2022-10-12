insert into active(id, name)
values
    (1, 'ACTIVE'),
    (2, 'DISABLED');

insert into roles(id, name)
values
    (1, 'ADMIN'),
    (2, 'USER') ;

insert into users("id", "first_name", "last_name", "perstist_date", "active_id", "role_id")
values
    (1, 'Petya', 'Petrov', current_timestamp, 1, 2),
    (2, 'Vasya', 'Vasiolie', current_timestamp 2, 1),
    (3, 'Petya', 'Petrov', current_timestamp, 1, 2),
    (4, 'Vasya', 'Vasiolie', current_timestamp 2, 1),
    (5, 'Petya', 'Petrov', current_timestamp, 1, 2),
    (6, 'Vasya', 'Vasiolie', current_timestamp 2, 1),
    (7, 'Petya', 'Petrov', current_timestamp, 1, 2),
    (8, 'Vasya', 'Vasiolie', current_timestamp 2, 1),
    (9, 'Petya', 'Petrov', current_timestamp, 1, 2),
    (10, 'Vasya', 'Vasiolie', current_timestamp 2, 1),
    (11, 'Petya', 'Petrov', current_timestamp, 1, 2),
    (12, 'Vasya', 'Vasiolie', current_timestamp 2, 1),
    (13, 'Petya', 'Petrov', current_timestamp, 1, 2),
    (14, 'Vasya', 'Vasiolie', current_timestamp 2, 1),
    (15, 'Petya', 'Petrov', current_timestamp, 1, 2),
    (16, 'Vasya', 'Vasiolie', current_timestamp 2, 1),
    (17, 'Petya', 'Petrov', current_timestamp, 1, 2),
    (18, 'Vasya', 'Vasiolie', current_timestamp 2, 1),
    (19, 'Petya', 'Petrov', current_timestamp, 1, 2),
    (20, 'Vasya', 'Vasiolie', current_timestamp 2, 1);

-- Нужен для того чтобы не было конфликта если у нас уже есть данные с таким же айдишником, устанавливает следущее значение айдишника.
-- SELECT setval('user_id_seq', (SELECT MAX(id) FROM users));