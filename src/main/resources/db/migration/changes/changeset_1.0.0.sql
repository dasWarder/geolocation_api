CREATE TABLE location(
    id VARCHAR PRIMARY KEY NOT NULL,
    name VARCHAR NOT NULL,
    address VARCHAR NOT NULL,
    lat FLOAT NOT NULL,
    lng FLOAT NOT NULL
);

CREATE UNIQUE INDEX id_xy ON location(id, lat, lng);
CREATE UNIQUE INDEX name_xy ON location(name, lat, lng);