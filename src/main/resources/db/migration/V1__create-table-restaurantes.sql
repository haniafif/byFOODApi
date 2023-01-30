create table restaurant(
    id bigint not null auto_increment,
    name varchar(100) not null,
    customer_rating int not null,
    distance int not null,
    price int not null,
    cuisine_id int not null,

    primary key(id)
);