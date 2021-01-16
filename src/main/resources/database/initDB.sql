create table task (
    id serial not null primary key,
    title varchar(40) not null,
    task_category varchar(40) not null,
    is_complete boolean,
    is_important boolean
);