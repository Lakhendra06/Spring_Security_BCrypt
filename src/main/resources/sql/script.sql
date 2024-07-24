create table users (
    id int not null auto_increment,
    username varchar(50) not null,
    password varchar(50) not null,
    enabled int not null,
    primary key (id)
);

create table authorities(
    id int not null auto_increment,
    username varchar(50) not null,
    authority varchar(50) not null,
    primary key (id)
);

insert into users values (null,'happy','12345','1');
insert into authorities values (null,'happy','write');

create table customer (
    id int not null auto_increment,
    email varchar(45) not null,
    pwd varchar(100) not null,
    role varchar(45) not null,
    primary key (id)
);
insert into customer values (null,'lakhendra08@gmail.com','12345','admin');