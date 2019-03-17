create database if not exists shop;

create table goods(
goods_id int primary key comment'商品编号',
goods_name varchar (20) comment'商品名称',
unitprice int comment'商品单价',
category varchar(20) comment'商品类别',
provider varchar(20) comment'供应商'
);

create table if exists customer(
customer_id int primary key comment '客户号',
name varchar(20) comment '姓名',
address varchar(30) comment '地址',
email varchar(30) comment '邮箱',
sex enum('男','女') comment '性别',
card_id bigint comment '身份证'
);

create table purchase(
order_id int primary key comment '订单号',
customer_id int comment '客户号',
goods_id int comment '商品编号',
nums int default 0 comment '购买数量'
foreign key (goods_id) references goods(goods_id),
foreign key(customer_id) references customer(customer_id)
);