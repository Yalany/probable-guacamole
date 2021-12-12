drop table if exists regions;

create table regions (
    id         int          auto_increment primary key,
    name       varchar(255) not null unique,
    short_name varchar(64)  not null unique
);

insert into regions
    (name, short_name)
values
    ('Adygeya, Respublika',       'RU-AD'),
    ('Altay, Respublika',         'RU-AL'),
    ('Bashkortostan, Respublika', 'RU-BA'),
    ('Buryatiya, Respublika',     'RU-BU'),
    ('Moskva',                    'RU-MOW'),
    ('Sankt-Peterburg',           'RU-SPE'),
    ('Moskovskaya oblast',        'RU-MOS'),
    ('Leningradskaya oblast',     'RU-LEN');

