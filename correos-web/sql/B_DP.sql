/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  t.vargas
 * Created: 11/03/2018
 */

delete from BonoEntity;

delete from DetallePaqueteEntity;

insert into BonoEntity(id,name, descripcion, descuento, condicion, fechaDeVencimiento) Values (10001,'Bono1','Bono del 50% en cualquier envio',0.5,'Sin redimir','11/11/2000'); 
insert into BonoEntity(id,name, descripcion, descuento, condicion, fechaDeVencimiento) Values (10002,'Bono2','Bono del 60% en cualquier envio',0.6,'Redimido','11/11/2001');
insert into BonoEntity(id,name, descripcion, descuento, condicion, fechaDeVencimiento) Values (10003,'Bono3','Bono del 70% en cualquier envio',0.7,'Sin redimir','11/11/2002');
insert into BonoEntity(id,name, descripcion, descuento, condicion, fechaDeVencimiento) Values (10004,'Bono4','Bono del 80% en cualquier envio',0.8,'Redimido','11/11/2003');

insert into DetallePaqueteEntity(id,name,mensaje) Values (10001,'Detalle1','Paquete 10cm x 10cm; Es fragil');
insert into DetallePaqueteEntity(id,name,mensaje) Values (10002,'Detalle2','Paquete 100cm x 100cm; Se debe llevar refrigerado');
insert into DetallePaqueteEntity(id,name,mensaje) Values (10003,'Detalle3','Paquete 200cm x 150cm; No se puede dejar enfriar');
insert into DetallePaqueteEntity(id,name,mensaje) Values (10004,'Detalle4','Paquete 55cm x 65cm; No tiene algun cuidado especial');