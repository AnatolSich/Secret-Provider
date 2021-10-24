DROP TABLE IF EXISTS t_user;
DROP TABLE IF EXISTS t_secret;

CREATE TABLE public.secret (
    id INT PRIMARY KEY,
    payload VARCHAR(128) NOT NULL
);

CREATE TABLE public.user
(
    id   INT  PRIMARY KEY,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL
);
