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
        (2, 'Vasya', 'Vasiolie', current_timestamp 2, 1);

-- Нужен для того чтобы не было конфликта если у нас уже есть данные с таким же айдишником, устанавливает следущее значение айдишника.
-- SELECT setval('user_id_seq', (SELECT MAX(id) FROM users));