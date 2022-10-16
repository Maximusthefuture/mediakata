insert into active(id, name)
values
    (1, 'ACTIVE'),
    (2, 'DISABLED');

insert into roles(id, name)
values
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER') ;

INSERT into users  (id, first_name, last_name, city, email, date_of_birth, about, persist_date, image, education,  active_id, role_id)
values (1, 'Anny', 'Smith', 'Best', 'donna@mail.com', '1994-07-16', 'Writing the criminal',  current_timestamp, 'http://someapi.com/avatar?id=1', 'university', 1, 1);
values (2, 'Jack', 'Brown', 'Late', 'keymap@gmail.com', '1998-03-12', 'Writing',  current_timestamp, 'http://someapi.com/avatar?id=2', 'university', 2, 2);
values (3, 'Kenny', 'Maccormic', 'South_Park', 'kenny_was_killed@gmail.com', '1992-02-12', 'Restarting',  current_timestamp, 'http://someapi.com/avatar?id=3', 'school', 2, 2);
values (4, 'Kail', 'Broflowski', 'South_Park', 'they_are_bustards@gmail.com', '1993-03-12', 'Не быть или быть',  current_timestamp, 'http://someapi.com/avatar?id=4', 'school', 1, 2);
values (5, 'Eric', 'Cartman', 'South_Park', 'keymap1@gmail.com', '1994-04-12', 'Поросеночек',  current_timestamp, 'http://someapi.com/avatar?id=5', 'school', 1, 1);
values (6, 'Stan', 'Marche', 'South_Park', 'keymap2@gmail.com', '1995-05-12', 'Listening Lorde',  current_timestamp, 'http://someapi.com/avatar?id=6', 'school', 1, 1);
values (7, 'Token', 'Black', 'South_Park', 'keymap3@gmail.com', '1996-06-12', 'Люблю кфс',  current_timestamp, 'http://someapi.com/avatar?id=7', 'school', 1, 2);
