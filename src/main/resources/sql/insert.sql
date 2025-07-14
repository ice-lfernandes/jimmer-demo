 insert into book(id, name, edition, price, store_id) values
    (1, 'Learning GraphQL', 1, 50, 1),
    (2, 'Learning GraphQL', 2, 55, 1),
    (3, 'Learning GraphQL', 3, 51, 1),

    (4,'Effective TypeScript', 1, 73, 1),
    (5, 'Effective TypeScript', 2, 69, 1),
    (6, 'Effective TypeScript', 3, 88, 1),

    (7, 'Programming TypeScript', 1, 47.5, 1),
    (8, 'Programming TypeScript', 2, 45, 1),
    (9, 'Programming TypeScript', 3, 48, 1),

    (10, 'GraphQL in Action', 1, 80, 2),
    (11, 'GraphQL in Action', 2, 81, 2),
    (12, 'GraphQL in Action', 3, 80, 2)
;

insert into author(id, first_name, last_name, gender, created_time, modified_time) values
    (1, 'Eve', 'Procello', 'F', now(), now()),
    (2, 'Alex', 'Banks', 'M', now(), now()),
    (3, 'Dan', 'Vanderkam', 'M', now(), now()),
    (4, 'Boris', 'Cherny', 'M', now(), now()),
    (5, 'Samer', 'Buna', 'M', now(), now())
;

insert into book_store(id, name) values
    (1, 'O''REILLY'),
    (2, 'MANNING')
;

insert into book_author_mapping(book_id, author_id) values
    (1, 1),
    (2, 1),
    (3, 1),

    (1, 2),
    (2, 2),
    (3, 2),

    (4, 3),
    (5, 3),
    (6, 3),

    (7, 4),
    (8, 4),
    (9, 4),

    (10, 5),
    (11, 5),
    (12, 5)
;