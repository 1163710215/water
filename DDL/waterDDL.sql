
use water;drop table if exists MyOrder;
drop table if exists Water;
drop table if exists Customer;
drop table if exists Location;
drop table if exists Delivery;
drop table if exists Information;

create table Information
(
id int8 primary key auto_increment,
type varchar(10) not null check(type in('DELIVERY','CUSTOMER')),
name varchar(20) not null,
phone varchar(12) not null,
sex varchar(1) not null check(sex in('M','F'))
);
create table Delivery
(
id int8 primary key,
foreign key(id)  references Information(id)
);
create table Location
(
locationNum int8 primary key auto_increment,
school varchar(10) not null,
position varchar(20) unique not null,
deliveryId int8 not null,
foreign key (deliveryId) references Delivery(id)
);
create table Customer
(
id int8 primary key,
startTime date not null,
totalTime int8 not null,
cost int8 not null,
locationNum int8 not null,
criticalLocation text not null,
foreign key(locationNum) references Location(locationNum),
foreign key(id)  references Information(id)
);
create table Water
(
type varchar(8) primary key,
cost int8 not null
);
create table MyOrder
(
id int8 primary key auto_increment,
customerId int8 not null,
orderType varchar(8) not null,
orderTime date not null,
isPay char(1) not null check(isPay in('Y','N')),
onDelivery char(1) not null check(isPay in('Y','N')),
foreign key (customerId) references Customer(id),
foreign key (orderType) references Water(type),
key (orderTime desc)
);