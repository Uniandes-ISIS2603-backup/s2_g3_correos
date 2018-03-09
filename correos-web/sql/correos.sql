/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  a.silvag
 * Created: 8/03/2018
 */


delete from PagoEntity;
delete from CuentaBancariaEntity;
delete from EventoEntity;


insert into PagoEntity(id,name,valor,fecha) values (10001,'Pago 001', 3455,'10/10/1998');
insert into PagoEntity(id,name,valor,fecha) values (10002,'Pago 002', 3456,'10/10/1998');
insert into PagoEntity(id,name,valor,fecha) values (10003,'Pago 003', 3457,'10/10/1998');
insert into PagoEntity(id,name,valor,fecha) values (10004,'Pago 004', 3458,'10/10/1998');

insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10001,'Tarjeta1','39749179739479','Aval','Visa');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10002,'Tarjeta2','479871973947992','GNC','Visa');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10003,'Tarjeta3','02840820767780','Bancolombia','american express');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10004,'Tarjeta4','20384080808000802','SilvaBank','maestro');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10005,'Tarjeta5','17730740208028084','Colpatria','MasterCard');

insert into EventoEntity(id,name, ubicacion,detalle) values (10001,'Evento1','4.60278;;;-73.064902','Voy retrasado con el pedido');
insert into EventoEntity(id,name, ubicacion,detalle) values (10002,'Evento2','4.60278;;;-74.064902','Hay mucho trancon y hay lluvia');
insert into EventoEntity(id,name, ubicacion,detalle) values (10003,'Evento3','6.60278;;;-74.064902','Listo perfecto llego en 5');
insert into EventoEntity(id,name, ubicacion,detalle) values (10004,'Evento4','4.60278;;;-78.064902','voy por la 7ta con 75');
insert into EventoEntity(id,name, ubicacion,detalle) values (10005,'Evento5','5.60278;;;-74.064902','cambio de ruta debido a manifestacion');