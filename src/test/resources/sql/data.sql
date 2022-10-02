insert into active(id, name)
values
    (2, 'yes');

insert into roles(id, name)
values
    (1, 'user');

INSERT INTO public.users (id, about, image, city, date_of_birth, education, email, first_name, is_enable, last_name,
                          password, persist_date, status, active_id, role_id)
    VALUES (1::bigint, '1'::varchar(255), '1'::varchar(255), '1'::varchar(255), '2022-10-09'::date, '1'::varchar(255),
            'admin@'::varchar(255), '1'::varchar(255), 1::integer, '1'::varchar(255), '1'::varchar(255),
            '2022-10-02 15:36:01.000000'::timestamp, '1'::varchar(255), 2::bigint, 1::bigint),

            (2::bigint, '1'::varchar(255), '1'::varchar(255), '1'::varchar(255), '2022-10-09'::date, '1'::varchar(255),
                        'admin2@'::varchar(255), '1'::varchar(255), 1::integer, '1'::varchar(255), '1'::varchar(255),
                        '2022-10-02 15:36:01.000000'::timestamp, '1'::varchar(255), 2::bigint, 1::bigint),
            (3::bigint, '1'::varchar(255), '1'::varchar(255), '1'::varchar(255), '2022-10-09'::date, '1'::varchar(255),
                        'admin3@'::varchar(255), '1'::varchar(255), 1::integer, '1'::varchar(255), '1'::varchar(255),
                        '2022-10-02 15:36:01.000000'::timestamp, '1'::varchar(255), 2::bigint, 1::bigint),
            (4::bigint, '1'::varchar(255), '1'::varchar(255), '1'::varchar(255), '2022-10-09'::date, '1'::varchar(255),
                        'admin4@'::varchar(255), '1'::varchar(255), 1::integer, '1'::varchar(255), '1'::varchar(255),
                        '2022-10-02 15:36:01.000000'::timestamp, '1'::varchar(255), 2::bigint, 1::bigint),
             (5::bigint, '1'::varchar(255), '1'::varchar(255), '1'::varchar(255), '2022-10-09'::date, '1'::varchar(255),
                        'admin5@'::varchar(255), '1'::varchar(255), 1::integer, '1'::varchar(255), '1'::varchar(255),
                        '2022-10-02 15:36:01.000000'::timestamp, '1'::varchar(255), 2::bigint, 1::bigint),
           (6::bigint, '1'::varchar(255), '1'::varchar(255), '1'::varchar(255), '2022-10-09'::date, '1'::varchar(255),
                        'admin6@'::varchar(255), '1'::varchar(255), 1::integer, '1'::varchar(255), '1'::varchar(255),
                        '2022-10-02 15:36:01.000000'::timestamp, '1'::varchar(255), 2::bigint, 1::bigint);

-- Нужен для того чтобы не было конфликта если у нас уже есть данные с таким же айдишником, устанавливает следущее значение айдишника.
-- SELECT setval('user_id_seq', (SELECT MAX(id) FROM users));