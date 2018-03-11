/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  a.silvag
 * Created: 8/03/2018
 */

delete from ReservaEntity;

delete from MensajeroEntity_TransporteEntity;

delete from MensajeroEntity;

delete from TransporteEntity;

delete from CuentaBancariaEntity;

delete from PagoEntity;

delete from EventoEntity;

insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10001,'Tarjeta1','39749179739479','Aval','Visa');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10002,'Tarjeta2','479871973947992','GNC','Visa');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10003,'Tarjeta3','02840820767780','Bancolombia','american express');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10004,'Tarjeta4','20384080808000802','SilvaBank','maestro');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10005,'Tarjeta5','17730740208028084','Colpatria','MasterCard');

insert into PagoEntity(id,name,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10001,'Pago 001', 3455,'1998-10-10 00:00:00',10001,10001);
insert into PagoEntity(id,name,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10002,'Pago 002', 3456,'1998-10-10 00:00:00',10001,10001);
insert into PagoEntity(id,name,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10003,'Pago 003', 3457,'1998-10-10 00:00:00',10003,10003);
insert into PagoEntity(id,name,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10004,'Pago 004', 3458,'1998-10-10 00:00:00',10004,10004);

insert into EventoEntity(id,name, ubicacion,detalle,envio_id) values (10001,'Evento1','4.60278;;;-73.064902','Voy retrasado con el pedido',10001);
insert into EventoEntity(id,name, ubicacion,detalle,envio_id) values (10002,'Evento2','4.60278;;;-74.064902','Hay mucho trancon y hay lluvia',10002);
insert into EventoEntity(id,name, ubicacion,detalle,envio_id) values (10003,'Evento3','6.60278;;;-74.064902','Listo perfecto llego en 5',10003);
insert into EventoEntity(id,name, ubicacion,detalle,envio_id) values (10004,'Evento4','4.60278;;;-78.064902','voy por la 7ta con 75',10004);
insert into EventoEntity(id,name, ubicacion,detalle,envio_id) values (10005,'Evento5','5.60278;;;-74.064902','cambio de ruta debido a manifestacion',10005);

insert into MensajeroEntity(id,calificacionPromedio,celular,correo,name,nombre,cuenta_id) values (10001,0.0,'3124456739','mensajero10001@correo.com', null,'Mensaero10001',10001);
insert into MensajeroEntity(id,calificacionPromedio,celular,correo,name,nombre,cuenta_id) values (10002,0.0,'3124456733','mensajero10002@correo.com', null,'Mensaero10002',10002);
insert into MensajeroEntity(id,calificacionPromedio,celular,correo,name,nombre,cuenta_id) values (10003,0.0,'3124456734','mensajero10003@correo.com', null,'Mensaero10003',10003);
insert into MensajeroEntity(id,calificacionPromedio,celular,correo,name,nombre,cuenta_id) values (10004,0.0,'3124456735','mensajero10004@correo.com', null,'Mensaero10004',10004);
insert into MensajeroEntity(id,calificacionPromedio,celular,correo,name,nombre,cuenta_id) values (10005,0.0,'3124456736','mensajero10005@correo.com', null,'Mensaero10005',10005);

insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10001,0,'6kg',null,'carro');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10002,0,'7kg',null,'moto');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10003,0,'8kg',null,'camion');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10004,0,'9kg',null,'carro');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10005,0,'10kg',null,'carro');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10006,0,'2kg',null,'cicla');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10007,0,'8kg',null,'camion');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10008,0,'9kg',null,'carro');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10009,0,'10kg',null,'carro');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (100010,0,'2kg',null,'cicla');


insert into MensajeroEntity_TransporteEntity(MensajeroEntity_id,Transportes_id) values(10001,10001);
insert into MensajeroEntity_TransporteEntity(MensajeroEntity_id,Transportes_id) values(10001,10002);
insert into MensajeroEntity_TransporteEntity(MensajeroEntity_id,Transportes_id) values(10002,10003);
insert into MensajeroEntity_TransporteEntity(MensajeroEntity_id,Transportes_id) values(10002,10004);
insert into MensajeroEntity_TransporteEntity(MensajeroEntity_id,Transportes_id) values(10003,10005);
insert into MensajeroEntity_TransporteEntity(MensajeroEntity_id,Transportes_id) values(10003,10006);
insert into MensajeroEntity_TransporteEntity(MensajeroEntity_id,Transportes_id) values(10004,10007);
insert into MensajeroEntity_TransporteEntity(MensajeroEntity_id,Transportes_id) values(10004,10008);
insert into MensajeroEntity_TransporteEntity(MensajeroEntity_id,Transportes_id) values(10005,10009);
insert into MensajeroEntity_TransporteEntity(MensajeroEntity_id,Transportes_id) values(10005,100010);

