create table if not exists js_framework(
     id serial primary key,
     name varchar not null,
     version bigint not null ,
     date timestamp with time zone,
     reating int not null
)
