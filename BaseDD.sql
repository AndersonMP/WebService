select current_database();
drop table if exists grupo;
create table grupo (
	id_grupo varchar (10) primary key not null,
	nombre varchar(50) not null
);

drop table if exists articulo;
create table articulo (
	id_articulo varchar (10) primary key not null,
	id_grupo varchar (10) not null,
	nombre varchar(50) not null,
	precio_venta money not null,
	precio_compra money not null,
	estado boolean not null,
	constraint articulo_grupo_fk
	foreign key (id_grupo)
	references grupo(id_grupo)
);
drop table if exists registro_movimientos;
create table registro_movimientos (
	id_registro serial primary key,
	id_articulo varchar(10) not null,
	cantidad int not null,
	fecha_movimiento timestamp,
	constraint registro_producto_fk
	foreign key (id_articulo)
	references articulo(id_articulo)
);

insert into grupo(id_grupo,nombre)
values ('C001','Bebidas'),
('C002','Snacks'),
('C003','Golosinas'),
('C004','Lácteos');

insert into articulo (id_articulo,id_grupo,nombre,precio_venta,precio_compra,estado)
values ('P001','C001','Coca cola 300 ml',0.7,0.55,true),
('P002','C001','Coca cola 1000 ml',1,0.8,true),
('P003','C002','Doritos 50g',0.5,0.42,false),
('P004','C003','Manicho',0.25,0.21,true),
('P005','C003','Tango',0.5,0.42,false),
('P006','C002','Rufles',0.21,0.3,true),
('P007','C001','Pony Malta',0.35,0.6,true),
('P008','C002','Golpe',0.18,0.25,false),
('P009','C004','Avena con canela',0.3,0.5,true),
('P0010','C004','Yogurt',0.5,0.7,false);

insert into registro_movimientos (id_articulo,cantidad,fecha_movimiento)
values('P001',10,'2020-10-28 09:45'),
('P002',-3,'2020-10-28 10:49'),
('P001',5,'2020-10-28 12:23'),
('P002',-3,'2020-10-28 10:49'),
('P003',7,'2023-11-28 11:50'),
('P004',-1,'2023-09-28 08:30'),
('P005',8,'2023-07-28 12:33'),
('P005',9,'2023-05-28 08:15'),
('P006',2,'2023-02-28 07:21'),
('P007',1,'2024-01-28 13:30');

select * from grupo;
select * from articulo;
select * from registro_movimientos order by fecha_movimiento asc;

select articulo.id_articulo, articulo.nombre, grupo.nombre, registro_movimientos.cantidad,registro_movimientos.fecha_movimiento
from articulo,grupo, registro_movimientos
where articulo.id_grupo = grupo.id_grupo
and registro_movimientos.id_articulo = articulo.id_articulo
order by registro_movimientos.fecha_movimiento asc;


select * from articulo where estado = true;

select * from registro_movimientos
where fecha_movimiento = '2023-05-28 08:15:00';

select * from registro_movimientos  where fecha_movimiento = '2023-05-28 08:15:00';