
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Author:  a.silvag
 * Created: 8/03/2018
 */
delete from clienteentity_envioentity;

delete from clienteentity_reservaentity;

delete from clienteentity_tarjetacreditoentity;

delete from zonaentity_mensajeroentity;

delete from mensajeroentity_calificacionentity;

delete from MensajeroEntity_TransporteEntity;

delete from EnvioEntity_PaqueteEntity;

delete from ZonaEntity;

delete from CalificacionEntity;

delete from ReservaEntity;

delete from TransporteEntity;

delete from PagoEntity;

delete from EventoEntity;



delete from PaqueteEntity;

delete from EnvioEntity;
delete from BonoEntity;

delete from DetallePaqueteEntity;

delete from MensajeroEntity;

delete from TarjetaCreditoEntity;

delete from ClienteEntity;

delete from CuentaBancariaEntity;

insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10001,'Tarjeta1','39749179739479','Aval','Visa');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10002,'Tarjeta2','479871973947992','GNC','Visa');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10003,'Tarjeta3','02840820767780','Bancolombia','american express');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10004,'Tarjeta4','20384080808000802','SilvaBank','maestro');
insert into CuentaBancariaEntity(id,name,numero,banco,tipoTarjeta) values (10005,'Tarjeta5','17730740208028084','Colpatria','MasterCard');

insert into ClienteEntity(id,name,nombre) values (10001,'Cliente1','Pepe Perez');
insert into ClienteEntity(id,name,nombre) values (10002,'Cliente2','Juana Ramirez');
insert into ClienteEntity(id,name,nombre) values (10003,'Cliente3','Cesar Noseque');
insert into ClienteEntity(id,name,nombre) values (10004,'Cliente4','David Leon');
insert into ClienteEntity(id,name,nombre) values (10005,'Cliente5','Felipe Nieto');

insert into TarjetaCreditoEntity(id,name,numero,fechaDeVencimiento,securityCode,cliente_id) values (10001,'TarjetaCredito1','1234123412341234','2020-10-10 00:00:00',123,10001);
insert into TarjetaCreditoEntity(id,name,numero,fechaDeVencimiento,securityCode,cliente_id) values (10002,'TarjetaCredito2','2345234523452345','2020-10-12 00:00:00',123,10002);
insert into TarjetaCreditoEntity(id,name,numero,fechaDeVencimiento,securityCode,cliente_id) values (10003,'TarjetaCredito3','3456345634563456','2020-10-11 00:00:00',123,10003);
insert into TarjetaCreditoEntity(id,name,numero,fechaDeVencimiento,securityCode,cliente_id) values (10004,'TarjetaCredito4','4567456745674567','2020-11-10 00:00:00',123,10004);
insert into TarjetaCreditoEntity(id,name,numero,fechaDeVencimiento,securityCode,cliente_id) values (10005,'TarjetaCredito5','5678567856785678','2020-10-10 00:00:00',123,10005);

insert into MensajeroEntity(id,calificacionPromedio,celular,correo,name,nombre,ocupado,cuenta_id) values (10001,0.0,'3124456739','mensajero10001@correo.com', null,'Mensaero10001',0,10001);
insert into MensajeroEntity(id,calificacionPromedio,celular,correo,name,nombre,ocupado,cuenta_id) values (10002,0.0,'3124456733','mensajero10002@correo.com', null,'Mensaero10002',0,10002);
insert into MensajeroEntity(id,calificacionPromedio,celular,correo,name,nombre,ocupado,cuenta_id) values (10003,0.0,'3124456734','mensajero10003@correo.com', null,'Mensaero10003',0,10003);
insert into MensajeroEntity(id,calificacionPromedio,celular,correo,name,nombre,ocupado,cuenta_id) values (10004,0.0,'3124456735','mensajero10004@correo.com', null,'Mensaero10004',0,10004);
insert into MensajeroEntity(id,calificacionPromedio,celular,correo,name,nombre,ocupado,cuenta_id) values (10005,0.0,'3124456736','mensajero10005@correo.com', null,'Mensaero10005',0,10005);

insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10001,0,6,null,'carro');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10002,0,7,null,'moto');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10003,0,8,null,'camion');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10004,0,9,null,'carro');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10005,0,10,null,'carro');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10006,0,2,null,'cicla');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10007,0,8,null,'camion');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10008,0,9,null,'carro');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (10009,0,10,null,'carro');
insert into TransporteEntity(id,activo,capacidad,name,tipo) values (100010,0,2,null,'cicla');

insert into mensajeroentity_transporteentity(mensajeroentity_id,transportes_id) values(10001,10001);
insert into mensajeroentity_transporteentity(mensajeroentity_id,transportes_id) values(10001,10002);
insert into mensajeroentity_transporteentity(mensajeroentity_id,transportes_id) values(10002,10003);
insert into mensajeroentity_transporteentity(mensajeroentity_id,transportes_id) values(10002,10004);
insert into mensajeroentity_transporteentity(mensajeroentity_id,transportes_id) values(10003,10005);
insert into mensajeroentity_transporteentity(mensajeroentity_id,transportes_id) values(10003,10006);
insert into mensajeroentity_transporteentity(mensajeroentity_id,transportes_id) values(10004,10007);
insert into mensajeroentity_transporteentity(mensajeroentity_id,transportes_id) values(10004,10008);
insert into mensajeroentity_transporteentity(mensajeroentity_id,transportes_id) values(10005,10009);
insert into mensajeroentity_transporteentity(mensajeroentity_id,transportes_id) values(10005,100010);

insert into EnvioEntity(name,id,horaInicio,horaFinal,estado,direccionEntrega,direccionRecogida,cliente_id) values ('Envio_001',10001,10000,10001,'ESTADO_INICIAL','calle 114 #30-40','calle 116 # 40-20',10001);
insert into EnvioEntity(name,id,horaInicio,horaFinal,estado,direccionEntrega,direccionRecogida,cliente_id) values ('Envio_002',10002,10010,10011,'ATRASADO','calle 124 #30-40A','calle 16B # 40-20',10002);
insert into EnvioEntity(name,id,horaInicio,horaFinal,estado,direccionEntrega,direccionRecogida,cliente_id) values ('Envio_003',10003,20517,34923,'LLEGANDO','carrera 12 #84-47','calle 167C # 9-18A',10003);
insert into EnvioEntity(name,id,horaInicio,horaFinal,estado,direccionEntrega,direccionRecogida,cliente_id) values ('Envio_004',10004,12801,15403,'ESTADO_INICIAL','carrera 80A #30-16','carrera 94B # 17B-9',10004);

insert into Envioentity_Paqueteentity(envio_id,paquete_id) values(10001,10001);
insert into Envioentity_Paqueteentity(envio_id,paquete_id) values(10004,10004);
insert into Envioentity_Paqueteentity(envio_id,paquete_id) values(10003,10002);
insert into Envioentity_Paqueteentity(envio_id,paquete_id) values(10002,10003);

insert into ReservaEntity (id,fecha,hora,CLIENTE_ID) values(10001, '2020-10-11 03:00:00','3PM',10005);
insert into ReservaEntity (id,fecha,hora,CLIENTE_ID) values(10002, '2020-10-12 10:00:00','3PM',10004);
insert into ReservaEntity (id,fecha,hora,CLIENTE_ID) values(10003, '2020-10-13 24:00:00','3PM',10003);
insert into ReservaEntity (id,fecha,hora,CLIENTE_ID) values(10004, '2020-10-14 07:00:00','3PM',10002);
insert into ReservaEntity (id,fecha,hora,CLIENTE_ID) values(10005, '2020-10-15 02:34:22','3PM',10001);
insert into ReservaEntity (id,fecha,hora,CLIENTE_ID) values(10006, '2020-10-16 01:00:00','3PM',10002);
insert into ReservaEntity (id,fecha,hora,CLIENTE_ID) values(10007, '2020-10-17 09:00:00','3PM',10001);
insert into ReservaEntity (id,fecha,hora,CLIENTE_ID) values(10008, '2020-10-18 15:00:00','3PM',10003);
insert into ReservaEntity (id,fecha,hora,CLIENTE_ID) values(10009, '2020-10-19 22:00:00','3PM',10004);
insert into ReservaEntity (id,fecha,hora,CLIENTE_ID) values(100010,'2020-10-20 11:00:00','3PM',10005);

insert into PaqueteEntity(name,id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values ('Paquete_001',10001,40.2,'FRAGIL',40,57,62,10001);
insert into PaqueteEntity(name,id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values ('Paquete_002',10002,8.0,'FRAGIL',21,11,7,10002);
insert into PaqueteEntity(name,id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values ('Paquete_002',10003,29.6,'RIGIDO',104,3,82,10003);
insert into PaqueteEntity(name,id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values ('Paquete_004',10004,1,'MALEABLE',1,27,44,10004);
insert into PaqueteEntity(name,id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values ('Paquete_005',10005,2,'GARY',40,57,62,10002);
insert into PaqueteEntity(name,id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values ('Paquete_006',10006,3,'BABYJESUSCRY',21,11,7,10002);
insert into PaqueteEntity(name,id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values ('Paquete_007',10007,4,'LOL',104,3,82,10003);
insert into PaqueteEntity(name,id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values ('Paquete_008',10008,5,'MALEABLE',1,27,44,10004);

insert into BonoEntity(id,name, descripcion, descuento, condicion, fechaDeVencimiento,cliente_id) Values (10001,'Bono1','Bono del 50% en cualquier envio',0.5,'Sin redimir','2001-10-10 00:00:00',10001); 
insert into BonoEntity(id,name, descripcion, descuento, condicion, fechaDeVencimiento,cliente_id) Values (10002,'Bono2','Bono del 60% en cualquier envio',0.6,'Redimido','2002-11-11 00:00:00',10002);
insert into BonoEntity(id,name, descripcion, descuento, condicion, fechaDeVencimiento,cliente_id) Values (10003,'Bono3','Bono del 70% en cualquier envio',0.7,'Sin redimir','2003-11-11 00:00:00',10003);
insert into BonoEntity(id,name, descripcion, descuento, condicion, fechaDeVencimiento,cliente_id) Values (10004,'Bono4','Bono del 80% en cualquier envio',0.8,'Redimido','2004-11-11 00:00:00',10004);

insert into DetallePaqueteEntity(id,name,mensaje) Values (10001,'Detalle1','Paquete 10cm x 10cm; Es fragil');
insert into DetallePaqueteEntity(id,name,mensaje) Values (10002,'Detalle2','Paquete 100cm x 100cm; Se debe llevar refrigerado');
insert into DetallePaqueteEntity(id,name,mensaje) Values (10003,'Detalle3','Paquete 200cm x 150cm; No se puede dejar enfriar');
insert into DetallePaqueteEntity(id,name,mensaje) Values (10004,'Detalle4','Paquete 55cm x 65cm; No tiene algun cuidado especial');

insert into PagoEntity(id,name,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10001,'Pago 001', 3455,'1998-10-10 00:00:00',10001,10001);
insert into PagoEntity(id,name,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10002,'Pago 002', 3456,'1998-10-10 00:00:00',10001,10001);
insert into PagoEntity(id,name,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10003,'Pago 003', 3457,'1998-10-10 00:00:00',10003,10003);
insert into PagoEntity(id,name,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10004,'Pago 004', 3458,'1998-10-10 00:00:00',10004,10004);

insert into EventoEntity(id,name, ubicacion,detalle,envio_id) values (10001,'Evento1',4.60278,'Voy retrasado con el pedido',10001);
insert into EventoEntity(id,name, ubicacion,detalle,envio_id) values (10002,'Evento2',4.60278,'Hay mucho trancon y hay lluvia',10001);
insert into EventoEntity(id,name, ubicacion,detalle,envio_id) values (10003,'Evento3',4.60278,'Listo perfecto llego en 5',10001);
insert into EventoEntity(id,name, ubicacion,detalle,envio_id) values (10004,'Evento4',4.60278,'voy por la 7ta con 75',10001);

insert into calificacionentity (id, calificacion, comentario) values (10001, 1, 'Pickerin');
insert into calificacionentity (id, calificacion, comentario) values (10002, 2, 'Abrahams');
insert into calificacionentity (id, calificacion, comentario) values (10003, 3, 'Embleton');
insert into calificacionentity (id, calificacion, comentario) values (10004, 4, 'Kitchenside');
insert into calificacionentity (id, calificacion, comentario) values (10005, 0, 'Crowder');
insert into calificacionentity (id, calificacion, comentario) values (10006, 1, 'Sherred');
insert into calificacionentity (id, calificacion, comentario) values (10007, 2, 'Garett');
insert into calificacionentity (id, calificacion, comentario) values (10008, 3, 'Henriquet');
insert into calificacionentity (id, calificacion, comentario) values (10009, 4, 'Gwilliam');
insert into calificacionentity (id, calificacion, comentario) values (100010, 0, 'Killiner');

insert into zonaentity (id, latitud, longitud) values (1, 83.675301197, 85.612882277);
insert into zonaentity (id, latitud, longitud) values (2, 50.661495434, 39.682739485);
insert into zonaentity (id, latitud, longitud) values (3, 7.156283441, 76.334171346);
insert into zonaentity (id, latitud, longitud) values (4, 77.952697908, 12.251084291);
insert into zonaentity (id, latitud, longitud) values (5, 23.662406476, 36.543882914);
insert into zonaentity (id, latitud, longitud) values (6, 7.610821747, 71.088546272);
insert into zonaentity (id, latitud, longitud) values (7, 53.45973534, 13.973007123);
insert into zonaentity (id, latitud, longitud) values (8, 22.786189884, 10.173581667);
insert into zonaentity (id, latitud, longitud) values (9, 58.803844881, 22.486051588);
insert into zonaentity (id, latitud, longitud) values (10, 31.283228616, 15.765712135);

insert into mensajeroentity_calificacionentity(mensajeroentity_id, calificaciones_id) values(10001,10001);
insert into mensajeroentity_calificacionentity(mensajeroentity_id, calificaciones_id) values(10001,10002);
insert into mensajeroentity_calificacionentity(mensajeroentity_id, calificaciones_id) values(10002,10003);
insert into mensajeroentity_calificacionentity(mensajeroentity_id, calificaciones_id) values(10002,10004);
insert into mensajeroentity_calificacionentity(mensajeroentity_id, calificaciones_id) values(10003,10005);
insert into mensajeroentity_calificacionentity(mensajeroentity_id, calificaciones_id) values(10003,10006);
insert into mensajeroentity_calificacionentity(mensajeroentity_id, calificaciones_id) values(10004,10007);
insert into mensajeroentity_calificacionentity(mensajeroentity_id, calificaciones_id) values(10004,10008);
insert into mensajeroentity_calificacionentity(mensajeroentity_id, calificaciones_id) values(10005,10009);
insert into mensajeroentity_calificacionentity(mensajeroentity_id, calificaciones_id) values(10005,100010);
