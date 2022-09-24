CREATE
SEQUENCE IF NOT EXISTS active_seq START
WITH 1 INCREMENT BY 1;

CREATE
SEQUENCE IF NOT EXISTS albums_seq START
WITH 1 INCREMENT BY 1;

CREATE
SEQUENCE IF NOT EXISTS chats_seq START
WITH 1 INCREMENT BY 1;

CREATE
SEQUENCE IF NOT EXISTS groups_seq START
WITH 1 INCREMENT BY 1;

CREATE
SEQUENCE IF NOT EXISTS media_seq START
WITH 1 INCREMENT BY 1;

CREATE
SEQUENCE IF NOT EXISTS messages_seq START
WITH 1 INCREMENT BY 1;

CREATE
SEQUENCE IF NOT EXISTS post_seq START
WITH 1 INCREMENT BY 1;

CREATE
SEQUENCE IF NOT EXISTS role_seq START
WITH 1 INCREMENT BY 1;

CREATE
SEQUENCE IF NOT EXISTS user_seq START
WITH 1 INCREMENT BY 1;

CREATE TABLE active
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_active PRIMARY KEY (id)
);

CREATE TABLE albums
(
    id            BIGINT NOT NULL,
    name          VARCHAR(255),
    icon          VARCHAR(255),
    user_owner_id BIGINT,
    media_type    INTEGER,
    persist_date  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_albums PRIMARY KEY (id)
);

CREATE TABLE chats
(
    id           BIGINT NOT NULL,
    title        VARCHAR(255),
    image        VARCHAR(255),
    persist_date TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_chats PRIMARY KEY (id)
);

CREATE TABLE chats_messages
(
    chat_id    BIGINT NOT NULL,
    message_id BIGINT NOT NULL,
    CONSTRAINT pk_chats_messages PRIMARY KEY (chat_id, message_id)
);

CREATE TABLE group_wall
(
    group_id BIGINT NOT NULL,
    post_id  BIGINT NOT NULL,
    CONSTRAINT pk_group_wall PRIMARY KEY (group_id, post_id)
);

CREATE TABLE groups
(
    id                  BIGINT NOT NULL,
    name                VARCHAR(255),
    last_redaction_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    persist_date        TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    link_site           VARCHAR(255),
    description         VARCHAR(255),
    address_image_group VARCHAR(255),
    owner_id            BIGINT NOT NULL,
    CONSTRAINT pk_groups PRIMARY KEY (id)
);

CREATE TABLE media
(
    id           BIGINT NOT NULL,
    url          VARCHAR(255),
    user_id      BIGINT NOT NULL,
    media_type   INTEGER,
    persist_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    album_id     BIGINT,
    CONSTRAINT pk_media PRIMARY KEY (id)
);

CREATE TABLE media_message
(
    media_id   BIGINT NOT NULL,
    message_id BIGINT NOT NULL,
    CONSTRAINT pk_media_message PRIMARY KEY (media_id, message_id)
);

CREATE TABLE messages
(
    id           BIGINT  NOT NULL,
    message      VARCHAR(255),
    is_unread    BOOLEAN NOT NULL,
    persist_date TIMESTAMP WITHOUT TIME ZONE,
    user_id      BIGINT  NOT NULL,
    CONSTRAINT pk_messages PRIMARY KEY (id)
);

CREATE TABLE posts
(
    id           BIGINT NOT NULL,
    title        VARCHAR(50),
    text         VARCHAR(1000),
    user_id      BIGINT NOT NULL,
    persist_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_posts PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE users
(
    id            BIGINT NOT NULL,
    email         VARCHAR(255),
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    date_of_birth date,
    about         VARCHAR(255),
    status        VARCHAR(255),
    image         VARCHAR(255),
    password      VARCHAR(255),
    education     VARCHAR(255),
    city          VARCHAR(255),
    active_id     BIGINT NOT NULL,
    is_enable     BOOLEAN,
    perstist_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    role_id       BIGINT NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE chats_messages
    ADD CONSTRAINT uc_chats_messages_message UNIQUE (message_id);

ALTER TABLE group_wall
    ADD CONSTRAINT uc_group_wall_post UNIQUE (post_id);

ALTER TABLE media_message
    ADD CONSTRAINT uc_media_message_media UNIQUE (media_id);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE albums
    ADD CONSTRAINT FK_ALBUMS_ON_USER_OWNER FOREIGN KEY (user_owner_id) REFERENCES users (id);

ALTER TABLE groups
    ADD CONSTRAINT FK_GROUPS_ON_OWNER FOREIGN KEY (owner_id) REFERENCES users (id);

ALTER TABLE media
    ADD CONSTRAINT FK_MEDIA_ON_ALBUM FOREIGN KEY (album_id) REFERENCES albums (id);

ALTER TABLE media
    ADD CONSTRAINT FK_MEDIA_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE messages
    ADD CONSTRAINT FK_MESSAGES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE posts
    ADD CONSTRAINT FK_POSTS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_ACTIVE FOREIGN KEY (active_id) REFERENCES active (id);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE chats_messages
    ADD CONSTRAINT fk_chames_on_chat FOREIGN KEY (chat_id) REFERENCES chats (id);

ALTER TABLE chats_messages
    ADD CONSTRAINT fk_chames_on_message FOREIGN KEY (message_id) REFERENCES messages (id);

ALTER TABLE group_wall
    ADD CONSTRAINT fk_growal_on_group FOREIGN KEY (group_id) REFERENCES groups (id);

ALTER TABLE group_wall
    ADD CONSTRAINT fk_growal_on_post FOREIGN KEY (post_id) REFERENCES posts (id);

ALTER TABLE media_message
    ADD CONSTRAINT fk_medmes_on_media FOREIGN KEY (media_id) REFERENCES media (id);

ALTER TABLE media_message
    ADD CONSTRAINT fk_medmes_on_message FOREIGN KEY (message_id) REFERENCES messages (id);