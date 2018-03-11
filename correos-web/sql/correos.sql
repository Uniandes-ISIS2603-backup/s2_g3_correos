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

delete from EnvioEntity;

delete from PaqueteEntity;

insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10001,'Tarjeta1','39749179739479','Aval','Visa');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10002,'Tarjeta2','479871973947992','GNC','Visa');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10003,'Tarjeta3','02840820767780','Bancolombia','american express');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10004,'Tarjeta4','20384080808000802','SilvaBank','maestro');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10005,'Tarjeta5','17730740208028084','Colpatria','MasterCard');

insert into PagoEntity(id,name,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10001,'Pago 001', 3455,'10/10/1998',10001,10001);
insert into PagoEntity(id,name,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10002,'Pago 002', 3456,'10/10/1998',10001,10001);
insert into PagoEntity(id,name,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10003,'Pago 003', 3457,'10/10/1998',10003,10003);
insert into PagoEntity(id,name,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10004,'Pago 004', 3458,'10/10/1998',10004,10004);

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

insert into PaqueteEntity(name,id,peso,tipo,dimensionA,dimensionB,dimensionC) values ('Paquete_001',10001,40.2,'FRAGIL',40,57,62);
insert into PaqueteEntity(name,id,peso,tipo,dimensionA,dimensionB,dimensionC) values ('Paquete_002',10002,8.0,'FRAGIL',21,11,7);
insert into PaqueteEntity(name,id,peso,tipo,dimensionA,dimensionB,dimensionC) values ('Paquete_002',10003,29.6,'RIGIDO',104,3,82);
insert into PaqueteEntity(name,id,peso,tipo,dimensionA,dimensionB,dimensionC) values ('Paquete_004',10004,103.1,'MALEABLE',1,27,44);

insert into EnvioEntity(name,id,horaInicio,horaFinal,estado,direccionEntrega,direccionRecogida) values ('Envio_001',10001,10000,10001,'ESTADO_INICIAL','calle 114 #30-40','calle 116 # 40-20');
insert into EnvioEntity(name,id,horaInicio,horaFinal,estado,direccionEntrega,direccionRecogida) values ('Envio_002',10002,10010,10011,'ATRASADO','calle 124 #30-40A','calle 16B # 40-20');
insert into EnvioEntity(name,id,horaInicio,horaFinal,estado,direccionEntrega,direccionRecogida) values ('Envio_003',10003,20517,34923,'LLEGANDO','carrera 12 #84-47','calle 167C # 9-18A');
insert into EnvioEntity(name,id,horaInicio,horaFinal,estado,direccionEntrega,direccionRecogida) values ('Envio_004',10004,12801,15403,'ESTADO_INICIAL','carrera 80A #30-16','carrera 94B # 17B-9');

insert into PaqueteEntity_DetallePaqueteEntity(PaqueteEntity_id,Detalle_id) values(10001,10001);
insert into PaqueteEntity_DetallePaqueteEntity(PaqueteEntity_id,Detalle_id) values(10002,10003);
insert into PaqueteEntity_DetallePaqueteEntity(PaqueteEntity_id,Detalle_id) values(10003,10010);
insert into PaqueteEntity_DetallePaqueteEntity(PaqueteEntity_id,Detalle_id) values(10004,10005);