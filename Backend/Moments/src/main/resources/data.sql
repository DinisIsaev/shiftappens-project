DROP TABLE IF EXISTS users_events;
DROP TABLE IF EXISTS photos;
DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS users;


CREATE TABLE users (
                       id     SERIAL,
                       name     VARCHAR(512) NOT NULL,
                       email     VARCHAR(512) NOT NULL,
                       password VARCHAR(512) NOT NULL,
                       PRIMARY KEY(id)
);

CREATE TABLE events (
                        id         SERIAL,
                        name     VARCHAR(512) NOT NULL,
                        place     VARCHAR(512) NOT NULL,
                        data     DATE NOT NULL,
                        description VARCHAR(1000) NOT NULL,
                        exposure     INTEGER NOT NULL DEFAULT 0,
                        users_id     INTEGER NOT NULL,
                        PRIMARY KEY(id)
);

CREATE TABLE photos (
                        id     BIGSERIAL,
                        path     VARCHAR(512) NOT NULL,
                        likes     INTEGER NOT NULL DEFAULT 0,
                        events_id INTEGER NOT NULL,
                        users_id     INTEGER NOT NULL,
                        PRIMARY KEY(id)
);

CREATE TABLE users_events (
                              users_id     INTEGER,
                              events_id INTEGER,
                              PRIMARY KEY(users_id,events_id)
);

ALTER TABLE users ADD UNIQUE (name, email);
ALTER TABLE events ADD CONSTRAINT events_fk1 FOREIGN KEY (users_id) REFERENCES users(id);
ALTER TABLE photos ADD UNIQUE (path);
ALTER TABLE photos ADD CONSTRAINT photos_fk1 FOREIGN KEY (events_id) REFERENCES events(id);
ALTER TABLE photos ADD CONSTRAINT photos_fk2 FOREIGN KEY (users_id) REFERENCES users(id);
ALTER TABLE users_events ADD CONSTRAINT users_events_fk1 FOREIGN KEY (users_id) REFERENCES users(id);
ALTER TABLE users_events ADD CONSTRAINT users_events_fk2 FOREIGN KEY (events_id) REFERENCES events(id);



-- Insert users
INSERT INTO users (name, email, password) VALUES
                                                        ('Alice Smith', 'alice@example.com', 'alice123'),
                                                        ('Bob Johnson', 'bob@example.com', 'bob123'),
                                                        ('Charlie Brown', 'charlie@example.com', 'charlie123'),
                                                        ('Diana Prince', 'diana@example.com', 'wonderwoman'),
                                                        ('Ethan Hunt', 'ethan@example.com', 'mission123');

-- Insert events
INSERT INTO events (name, place, data, description, exposure, users_id) VALUES
                                                                            ('Spring Picnic', 'Central Park', '2025-05-10', 'A relaxing day in the park', 1, 1),
                                                                            ('Tech Meetup', 'Silicon Valley', '2025-06-20', 'Annual tech networking event', 1, 2);

-- Insert photos
INSERT INTO photos (path, likes, events_id, users_id) VALUES
                                                          ('photos/picnic1.jpg', 15, 1, 1),
                                                          ('photos/picnic2.jpg', 10, 1, 3),
                                                          ('photos/tech1.jpg', 20, 2, 2),
                                                          ('photos/tech2.jpg', 5, 2, 4),
                                                          ('photos/tech3.jpg', 7, 2, 5);

-- Insert users_events (many-to-many)
INSERT INTO users_events (users_id, events_id) VALUES
                                                   (1, 1),
                                                   (2, 1),
                                                   (3, 1),
                                                   (2, 2),
                                                   (4, 2),
                                                   (5, 2);