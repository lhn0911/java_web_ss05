create database JSP_Servlet_DB;
use JSP_Servlet_DB;
create table Categories
(
    catalog_id          int primary key auto_increment,
    catalog_name        varchar(200) not null unique,
    catalog_description text,
    catalog_status      bit
);
DELIMITER &&
create procedure find_all_categories()
begin
    select * from Categories;
end;
DELIMITER &&
DELIMITER &&
create procedure save_catalog(
    name_in varchar(200),
    des_in text,
    status_in bit
)
begin
    insert into Categories(catalog_name, catalog_description, catalog_status)
    values (name_in, des_in, status_in);
end;
DELIMITER &&