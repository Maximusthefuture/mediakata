create sequence if not exists active_seq start with 1 increment by 1;

create sequence if not exists albums_seq start with 1 increment by 1;

create sequence if not exists chats_seq start with 1 increment by 1;

create sequence if not exists groups_seq start with 1 increment by 1;

create sequence if not exists media_seq start with 1 increment by 1;

create sequence if not exists messages_seq start with 1 increment by 1;

create sequence if not exists post_seq start with 1 increment by 1;

create sequence if not exists role_seq start with 1 increment by 1;

create sequence if not exists user_seq start with 1 increment by 1;

create table active
(
    id   bigint not null
        primary key,
    name varchar(255)
);

create table chats
(
    id           bigint not null
        primary key,
    image        varchar(255),
    persist_date timestamp,
    title        varchar(255)
);

create table roles
(
    id   bigint not null
        primary key,
    name varchar(255)
);

create table users
(
    id            bigint    not null
        primary key,
    about         varchar(255),
    image         varchar(255),
    city          varchar(255),
    date_of_birth date,
    education     varchar(255),
    email         varchar(255)
        constraint uk_6dotkott2kjsp8vw4d0m25fb7
            unique,
    first_name    varchar(255),
    is_enable     integer,
    last_name     varchar(255),
    password      varchar(255),
    persist_date timestamp not null,
    status        varchar(255),
    active_id     bigint    not null
        constraint fkl7ve5em3l5axquvrlf5e39dpl
            references active,
    role_id       bigint    not null
        constraint fkp56c1712k691lhsyewcssf40f
            references roles
);

create table albums
(
    id            bigint    not null
        primary key,
    icon          varchar(255),
    persist_date  timestamp not null,
    media_type    integer,
    name          varchar(255),
    user_owner_id bigint
        constraint fkcgps0vjsdhsbhqrjnh3th4b0u
            references users
);

create table groups
(
    id                  bigint    not null
        primary key,
    address_image_group varchar(255),
    description         varchar(255),
    last_redaction_date timestamp not null,
    link_site           varchar(255),
    name                varchar(255),
    persist_date        timestamp not null,
    owner_id            bigint    not null
        constraint fkke9gpecgx7u1oef8lsd9tax3c
            references users
);

create table media
(
    id           bigint    not null
        primary key,
    media_type   integer,
    persist_date timestamp not null,
    url          varchar(255),
    album_id     bigint
        constraint fkkqrdr00pw2v5k3q4tqv76cy6i
            references albums,
    user_id      bigint    not null
        constraint fknd8hh0yn7qvv4pqyk8mg7l1ox
            references users
);

create table messages
(
    id           bigint  not null
        primary key,
    is_unread    integer not null,
    persist_date timestamp,
    message      varchar(255),
    user_id      bigint  not null
        constraint fkpsmh6clh3csorw43eaodlqvkn
            references users
);

create table chats_messages
(
    chat_id    bigint not null
        constraint fkef9q5a0katwu25wrnpgok8e7d
            references chats,
    message_id bigint not null
        constraint uk_bsv8evvp3wdupfmn9hl67y2ex
            unique
        constraint fklex1h42qdsu1hjryg27b0o7pp
            references messages,
    primary key (chat_id, message_id)
);

create table media_message
(
    message_id bigint not null
        constraint fkealyiwcbiqv48qr1uc2f923e4
            references messages,
    media_id   bigint not null
        constraint uk_cg753lq91wvt7idrw38kq2h20
            unique
        constraint fk1m7isd2bt4frykewv4xiqog3i
            references media,
    primary key (message_id, media_id)
);

create table posts
(
    id           bigint    not null
        primary key,
    persist_date timestamp not null,
    text         varchar(1000),
    title        varchar(50),
    user_id      bigint    not null
        constraint fk5lidm6cqbc7u4xhqpxm898qme
            references users
);

create table group_wall
(
    group_id bigint not null
        constraint fkhde1qpuipv4ouvqw02gxruc2h
            references groups,
    post_id  bigint not null
        constraint uk_k0mxoo8evldcjcq1iva6o7bvq
            unique
        constraint fkqkll3lqcxuse5558nxawjgmp4
            references posts,
    primary key (group_id, post_id)
);
