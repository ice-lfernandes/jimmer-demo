
create table book_store(
    id bigint unsigned not null auto_increment primary key,
    name varchar(50) not null,
    website varchar(100)
) engine=innodb;

...

create table book (
    id bigint unsigned not null auto_increment primary key,
    name varchar(50) not null,
    edition integer not null,
    price numeric(10, 2) not null,
    store_id bigint unsigned
) engine=innodb;

...

create table author(
   id bigint unsigned not null auto_increment primary key,
   first_name varchar(25) not null,
   last_name varchar(25) not null,
   gender char(1) not null,
   created_time datetime not null,
   modified_time datetime not null
) engine=innodb;

...

/*
Many-to-many relationship between entities requires join table in ORM implementation.

This table stores many-to-many mapping between books and authors. It is a join table,
not an entity table, so no corresponding entity in the UML diagram above.
*/
create table book_author_mapping(
    book_id bigint unsigned not null,
    author_id bigint unsigned not null
) engine=innodb;

