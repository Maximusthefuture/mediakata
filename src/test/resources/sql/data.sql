insert into active(id, name)
values
    (2, 'yes');

insert into roles(id, name)
values
    (1, 'user');

insert into users("id", "first_name", "last_name", "perstist_date", "active_id", "role_id")
values
        (1, 'petya', 'petrov', current_timestamp, 2, 1),
        (2, 'Vasya', 'Vvasiolie', current_timestamp, 2, 1);

-- Нужен для того чтобы не было конфликта если у нас уже есть данные с таким же айдишником, устанавливает следущее значение айдишника.
-- SELECT setval('user_id_seq', (SELECT MAX(id) FROM users));