
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

insert into CuentaBancariaEntity(id,numero,banco,tipoTarjeta) values (10001,'39749179739479','Aval','Visa');
insert into CuentaBancariaEntity(id,numero,banco,tipoTarjeta) values (10002,'479871973947992','GNC','Visa');
insert into CuentaBancariaEntity(id,numero,banco,tipoTarjeta) values (10003,'02840820767780','Bancolombia','american express');
insert into CuentaBancariaEntity(id,numero,banco,tipoTarjeta) values (10004,'20384080808000802','SilvaBank','maestro');
insert into CuentaBancariaEntity(id,numero,banco,tipoTarjeta) values (10005,'17730740208028084','Colpatria','MasterCard');

insert into ClienteEntity(id,nombre,correo,telefono) values (10001,'Pepe Perez','usuario1@uniandes.edu.co','3111111111');
insert into ClienteEntity(id,nombre,correo,telefono) values (10002,'Juana Ramirez','usuario2@uniandes.edu.co','3222222222');
insert into ClienteEntity(id,nombre,correo,telefono) values (10003,'Cesar Noseque','usuario3@uniandes.edu.co','3333333333');
insert into ClienteEntity(id,nombre,correo,telefono) values (10004,'David Leon','usuario4@uniandes.edu.co','3444444444');
insert into ClienteEntity(id,nombre,correo,telefono) values (10005,'Felipe Nieto','usuario5@uniandes.edu.co','3555555555');
insert into ClienteEntity(id,nombre,correo,telefono) values (10006,'Pipe Diaz','usuario6@uniandes.edu.co','3666666666');
insert into ClienteEntity(id,nombre,correo,telefono) values (10007,'Juan Rodriguez','usuario7@uniandes.edu.co','3777777777');
insert into ClienteEntity(id,nombre,correo,telefono) values (10008,'Rubby Casallas','usuario8@uniandes.edu.co','3888888888');
insert into ClienteEntity(id,nombre,correo,telefono) values (10009,'Andres Mejia','usuario9@uniandes.edu.co','3999999999');
insert into ClienteEntity(id,nombre,correo,telefono) values (10010,'Daniel Torres','usuario10@uniandes.edu.co','3000000000');

insert into TarjetaCreditoEntity(id,numero,mes,año,cliente_id) values (10001,'1234123412341234','01','2021',10001);
insert into TarjetaCreditoEntity(id,numero,mes,año,cliente_id) values (10002,'2345234523452345','02','2022',10002);
insert into TarjetaCreditoEntity(id,numero,mes,año,cliente_id) values (10003,'3456345634563456','03','2023',10003);
insert into TarjetaCreditoEntity(id,numero,mes,año,cliente_id) values (10004,'4567456745674567','04','2024',10004);
insert into TarjetaCreditoEntity(id,numero,mes,año,cliente_id) values (10005,'5678567856785678','05','2025',10005);
insert into TarjetaCreditoEntity(id,numero,mes,año,cliente_id) values (10006,'1234123412341234','06','2026',10005);
insert into TarjetaCreditoEntity(id,numero,mes,año,cliente_id) values (10007,'2345234523452345','07','2027',10003);
insert into TarjetaCreditoEntity(id,numero,mes,año,cliente_id) values (10008,'3456345634563456','08','2028',10004);
insert into TarjetaCreditoEntity(id,numero,mes,año,cliente_id) values (10009,'4567456745674567','09','2029',10002);
insert into TarjetaCreditoEntity(id,numero,mes,año,cliente_id) values (10010,'5678567856785678','10','2030',10001);


insert into MensajeroEntity(id,calificacionPromedio,celular,correo,nombre,ocupado,cuenta_id) values (10001,0.0,'3124456739','mensajero10001@correo.com','Mensaero10001',0,10001);
insert into MensajeroEntity(id,calificacionPromedio,celular,correo,nombre,ocupado,cuenta_id) values (10002,0.0,'3124456733','mensajero10002@correo.com', 'Mensaero10002',0,10002);
insert into MensajeroEntity(id,calificacionPromedio,celular,correo,nombre,ocupado,cuenta_id) values (10003,0.0,'3124456734','mensajero10003@correo.com','Mensaero10003',0,10003);
insert into MensajeroEntity(id,calificacionPromedio,celular,correo,nombre,ocupado,cuenta_id) values (10004,0.0,'3124456735','mensajero10004@correo.com', 'Mensaero10004',0,10004);
insert into MensajeroEntity(id,calificacionPromedio,celular,correo,nombre,ocupado,cuenta_id) values (10005,0.0,'3124456736','mensajero10005@correo.com', 'Mensaero10005',0,10005);

insert into TransporteEntity(id,activo,capacidad,tipo) values (10001,0,6,'carro');
insert into TransporteEntity(id,activo,capacidad,tipo) values (10002,0,7,'moto');
insert into TransporteEntity(id,activo,capacidad,tipo) values (10003,0,8,'camion');
insert into TransporteEntity(id,activo,capacidad,tipo) values (10004,0,9,'carro');
insert into TransporteEntity(id,activo,capacidad,tipo) values (10005,0,10,'carro');
insert into TransporteEntity(id,activo,capacidad,tipo) values (10006,0,2,'cicla');
insert into TransporteEntity(id,activo,capacidad,tipo) values (10007,0,8,'camion');
insert into TransporteEntity(id,activo,capacidad,tipo) values (10008,0,9,'carro');
insert into TransporteEntity(id,activo,capacidad,tipo) values (10009,0,10,'carro');
insert into TransporteEntity(id,activo,capacidad,tipo) values (100010,0,2,'cicla');

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

insert into EnvioEntity(id,horaInicio,horaFinal,estado,direccionEntrega,direccionRecogida,cliente_id,fecha) values (10001,10000,10001,'ESTADO_INICIAL','calle 114 #30-40','calle 116 # 40-20',10001,'2001-10-10 00:00:00');
insert into EnvioEntity(id,horaInicio,horaFinal,estado,direccionEntrega,direccionRecogida,cliente_id,fecha) values (10002,10010,10011,'ATRASADO','calle 124 #30-40A','calle 16B # 40-20',10002,'2001-10-10 00:00:00');
insert into EnvioEntity(id,horaInicio,horaFinal,estado,direccionEntrega,direccionRecogida,cliente_id,fecha) values (10003,20517,34923,'LLEGANDO','carrera 12 #84-47','calle 167C # 9-18A',10003,'2002-10-10 00:00:00');
insert into EnvioEntity(id,horaInicio,horaFinal,estado,direccionEntrega,direccionRecogida,cliente_id,fecha) values (10004,12801,15403,'ESTADO_INICIAL','carrera 80A #30-16','carrera 94B # 17B-9',10004,'2003-10-10 00:00:00');

insert into Envioentity_Paqueteentity(envio_id,paquete_id) values(10001,10001);
insert into Envioentity_Paqueteentity(envio_id,paquete_id) values(10004,10004);
insert into Envioentity_Paqueteentity(envio_id,paquete_id) values(10003,10002);
insert into Envioentity_Paqueteentity(envio_id,paquete_id) values(10002,10003);

insert into ReservaEntity (id,fecha,horaInicio,horaFinal,direccionEntrega,direccionRecogida,estado,CLIENTE_ID) values(10001, '2020-10-11 03:00:00',10000,10001,'calle 114 #30-40','calle 116 # 40-20','ESTADO_INICIAL',10005);
insert into ReservaEntity (id,fecha,horaInicio,horaFinal,direccionEntrega,direccionRecogida,estado,CLIENTE_ID) values(10002, '2020-10-11 03:00:00',10000,10001,'calle 114 #30-40','calle 116 # 40-20','ESTADO_INICIAL',10005);
insert into ReservaEntity (id,fecha,horaInicio,horaFinal,direccionEntrega,direccionRecogida,estado,CLIENTE_ID) values(10003, '2020-10-11 03:00:00',10000,10001,'calle 114 #30-40','calle 116 # 40-20','ESTADO_INICIAL',10005);
insert into ReservaEntity (id,fecha,horaInicio,horaFinal,direccionEntrega,direccionRecogida,estado,CLIENTE_ID) values(10004, '2020-10-11 03:00:00',10000,10001,'calle 114 #30-40','calle 116 # 40-20','ESTADO_INICIAL',10005);
insert into ReservaEntity (id,fecha,horaInicio,horaFinal,direccionEntrega,direccionRecogida,estado,CLIENTE_ID) values(10005, '2020-10-11 03:00:00',10000,10001,'calle 114 #30-40','calle 116 # 40-20','ESTADO_INICIAL',10005);
insert into ReservaEntity (id,fecha,horaInicio,horaFinal,direccionEntrega,direccionRecogida,estado,CLIENTE_ID) values(10006, '2020-10-11 03:00:00',10000,10001,'calle 114 #30-40','calle 116 # 40-20','ESTADO_INICIAL',10005);
insert into ReservaEntity (id,fecha,horaInicio,horaFinal,direccionEntrega,direccionRecogida,estado,CLIENTE_ID) values(10007, '2020-10-11 03:00:00',10000,10001,'calle 114 #30-40','calle 116 # 40-20','ESTADO_INICIAL',10005);
insert into ReservaEntity (id,fecha,horaInicio,horaFinal,direccionEntrega,direccionRecogida,estado,CLIENTE_ID) values(10008, '2020-10-11 03:00:00',10000,10001,'calle 114 #30-40','calle 116 # 40-20','ESTADO_INICIAL',10005);


insert into PaqueteEntity(id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values (10001,40.2,'FRAGIL',40,57,62,10001);
insert into PaqueteEntity(id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values (10002,8.0,'FRAGIL',21,11,7,10002);
insert into PaqueteEntity(id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values (10003,29.6,'RIGIDO',104,3,82,10003);
insert into PaqueteEntity(id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values (10004,1,'MALEABLE',1,27,44,10004);
insert into PaqueteEntity(id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values (10005,2,'GARY',40,57,62,10002);
insert into PaqueteEntity(id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values (10006,3,'BABYJESUSCRY',21,11,7,10002);
insert into PaqueteEntity(id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values (10007,4,'LOL',104,3,82,10003);
insert into PaqueteEntity(id,peso,tipo,dimensionA,dimensionB,dimensionC,envio_id) values (10008,5,'MALEABLE',1,27,44,10004);

insert into BonoEntity(id, descripcion, descuento, condicion, fechaDeVencimiento,cliente_id) Values (10001,'Bono del 50% en cualquier envio',0.5,'Sin redimir','2001-10-10 00:00:00',10001); 
insert into BonoEntity(id, descripcion, descuento, condicion, fechaDeVencimiento,cliente_id) Values (10002,'Bono del 60% en cualquier envio',0.6,'Redimido','2002-11-11 00:00:00',10002);
insert into BonoEntity(id, descripcion, descuento, condicion, fechaDeVencimiento,cliente_id) Values (10003,'Bono del 70% en cualquier envio',0.7,'Sin redimir','2003-11-11 00:00:00',10003);
insert into BonoEntity(id, descripcion, descuento, condicion, fechaDeVencimiento,cliente_id) Values (10004,'Bono del 80% en cualquier envio',0.8,'Redimido','2004-11-11 00:00:00',10004);

insert into DetallePaqueteEntity(id,mensaje) Values (10001,'Paquete 10cm x 10cm; Es fragil');
insert into DetallePaqueteEntity(id,mensaje) Values (10002,'Paquete 100cm x 100cm; Se debe llevar refrigerado');
insert into DetallePaqueteEntity(id,mensaje) Values (10003,'Paquete 200cm x 150cm; No se puede dejar enfriar');
insert into DetallePaqueteEntity(id,mensaje) Values (10004,'Paquete 55cm x 65cm; No tiene algun cuidado especial');

insert into PagoEntity(id,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10001, 3455,'1998-10-10 00:00:00',10001,10001);
insert into PagoEntity(id,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10002, 3456,'1998-10-10 00:00:00',10001,10001);
insert into PagoEntity(id,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10003, 3457,'1998-10-10 00:00:00',10003,10003);
insert into PagoEntity(id,valor,fecha, tarjetaCredito_id, cuentaBancaria_id) values (10004, 3458,'1998-10-10 00:00:00',10004,10004);

insert into EventoEntity(id, ubicacion,detalle,envio_id) values (10001,4.60278,'Voy retrasado con el pedido',10001);
insert into EventoEntity(id, ubicacion,detalle,envio_id) values (10002,4.60278,'Hay mucho trancon y hay lluvia',10001);
insert into EventoEntity(id, ubicacion,detalle,envio_id) values (10003,4.60278,'Listo perfecto llego en 5',10001);
insert into EventoEntity(id, ubicacion,detalle,envio_id) values (10004,4.60278,'voy por la 7ta con 75',10001);

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
