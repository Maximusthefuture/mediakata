
insert into active(id, name)
values
    (1, 'ACTIVE'),
    (2, 'DISABLED');

insert into roles(id, name)
values
    (1, 'ADMIN'),
    (2, 'USER') ;

insert into users("id", "first_name", "last_name", "persist_date",  "active_id", "role_id")
values
    (1, 'Petya', 'Petrov',timestamp '2015-01-10 00:51:14' , 1, 2),
    (2, 'Vasya', 'Vasiolie', timestamp '2015-01-10 00:51:14', 2, 1),
    (3, 'Petya', 'NePetov', timestamp '2015-01-10 00:51:14', 1, 2),
    (4, 'Vasya', 'NeVasiolie', timestamp '2015-01-10 00:51:14',2, 1),
    (5, 'Petya', 'Pavlov', timestamp '2015-01-10 00:51:14', 1, 2),
    (6, 'Vasya', 'Vasi', timestamp '2015-01-10 00:51:14', 2, 1),
    (7, 'Petya', 'Faqrtg', timestamp '2015-01-10 00:51:14', 1, 2),
    (8, 'Vasya', 'NeTakoi', timestamp '2015-01-10 00:51:14', 2, 1),
    (9, 'Petya', 'Takoi', timestamp '2015-01-10 00:51:14', 1, 2),
    (10, 'Vasya', 'Prostoi', timestamp '2015-01-10 00:51:14', 2, 1),
    (11, 'Petya', 'NeProstoi', timestamp '2015-01-10 00:51:14', 1, 2),
    (12, 'Vasya', 'Da', timestamp '2015-01-10 00:51:14', 2, 1),
    (13, 'Petya', 'Net', timestamp '2015-01-10 00:51:14', 1, 2),
    (14, 'Vasya', 'Tvoi', timestamp '2015-01-10 00:51:14', 2, 1),
    (15, 'Petya', 'NeTvoi', timestamp '2015-01-10 00:51:14', 1, 2),
    (16, 'Vasya', 'Moi', timestamp '2015-01-10 00:51:14', 2, 1),
    (17, 'Petya', 'Nemoi', timestamp '2015-01-10 00:51:14', 1, 2),
    (18, 'Vasya', 'DaNet', timestamp '2015-01-10 00:51:14', 2, 1),
    (19, 'Petya', 'NetDa', timestamp '2015-01-10 00:51:14', 1, 2),
    (20, 'Vasya', 'Vasiolie', timestamp '2015-01-10 00:51:14', 2, 1);

-- Нужен для того чтобы не было конфликта если у нас уже есть данные с таким же айдишником, устанавливает следущее значение айдишника.
-- SELECT setval('user_id_seq', (SELECT MAX(id) FROM users));