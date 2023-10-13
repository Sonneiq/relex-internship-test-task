CREATE TABLE Person (
        id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
        email varchar(319) NOT NULL UNIQUE CHECK (email ~ '^[^@]+@[^@]+\.[^@]{2,}$'),
        password varchar NOT NULL,
        nickname varchar(32) NOT NULL UNIQUE,
        name varchar(32) NOT NULL,
        surname varchar(32) NOT NULL
);

CREATE TABLE Message (
        id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
        sender varchar(32) REFERENCES person (nickname) ON DELETE SET NULL ON UPDATE CASCADE,
        recipient varchar(32) REFERENCES person (nickname) ON DELETE SET NULL ON UPDATE CASCADE,
        text varchar(500)
);
