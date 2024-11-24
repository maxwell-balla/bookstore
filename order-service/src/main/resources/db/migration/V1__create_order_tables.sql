create table orders
(
    id                        uuid not null,
    order_number              text not null unique,
    username                  text not null,
    customer_name             text not null,
    customer_email            text not null,
    customer_phone            text not null,
    delivery_address_line1    text not null,
    delivery_address_line2    text,
    delivery_address_city     text not null,
    delivery_address_state    text not null,
    delivery_address_zip_code text not null,
    delivery_address_country  text not null,
    status                    text not null,
    comments                  text,
    created_at                timestamp,
    updated_at                timestamp,
    primary key (id)
);

create table order_items
(
    id       uuid not null,
    code     text not null,
    name     text not null,
    price    numeric not null,
    quantity integer not null,
    primary key (id),
    order_id uuid  not null references orders (id)
);