create table accounts
(
    id   bigint       not null auto_increment,
    name varchar(255) not null,
    primary key (id)
);

create table transactions
(
    id          bigint      not null auto_increment,
    description linestring,
    amount      double      not null,
    type        varchar(50) not null,
    date        date        not null,
    account_id  bigint      not null,
    primary key (id)
);

alter table transactions
    add constraint account_foreign_key
        foreign key (account_id) references accounts (id);