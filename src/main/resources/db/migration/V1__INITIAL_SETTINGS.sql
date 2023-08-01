CREATE TABLE IF NOT EXISTS duration_setting
(
    id
        UUID
        PRIMARY
            KEY,
    duration
        INTEGER
        NOT
            NULL,
    delay
        INTEGER
        NOT
            NULL,
    comment
        TEXT
);

CREATE TABLE IF NOT EXISTS learning_entity
(
    id
        UUID
        PRIMARY
            KEY,
    learning_passage
        TEXT
        NOT
            NULL
        UNIQUE,
    learning_term
        TEXT
        NOT
            NULL
        UNIQUE,
    last_reviewed
        TIMESTAMP,
    reviews_count
        INTEGER,
    comment
        TEXT
);

CREATE TABLE IF NOT EXISTS repeat_setting
(
    id
        UUID
        PRIMARY
            KEY,
    review_order
        INTEGER
        NOT
            NULL
        UNIQUE,
    repeat_day
        INTEGER
        NOT
            NULL
        UNIQUE,
    comment
        TEXT
);

INSERT INTO duration_setting (id, duration, delay)
VALUES (random_uuid(), 10, 2);

INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 1, 0);
INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 2, 1);
INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 3, 2);
INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 4, 3);
INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 5, 4);
INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 6, 5);
INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 7, 10);
INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 8, 15);
INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 9, 21);
INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 10, 28);
INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 11, 42);
INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 12, 70);
INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 13, 100);
INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 14, 180);
INSERT INTO repeat_setting (id, review_order, repeat_day)
VALUES (random_uuid(), 15, 365);