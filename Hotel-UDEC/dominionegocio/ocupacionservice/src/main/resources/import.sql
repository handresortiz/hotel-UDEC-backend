 INSERT INTO tipo("nombre") VALUES('Clasica Doble');
 INSERT INTO tipo("nombre") VALUES('Clasica Triple');
 INSERT INTO tipo("nombre") VALUES('Clasica Cuadruple');
 INSERT INTO tipo("nombre") VALUES('Individual Estandar');
 INSERT INTO tipo("nombre") VALUES('Estandar Doble');
 INSERT INTO tipo("nombre") VALUES('Suite Clasica Doble');
 INSERT INTO tipo("nombre") VALUES('Suite Clasica Triple');
 INSERT INTO tipo("nombre") VALUES('Suite Clasica Cuadruple');


  INSERT INTO estado("nombre","color") VALUES('Reservado','#C3FF33'); 
  INSERT INTO estado("nombre","color") VALUES('Mantenimiento','#3345FF');
  INSERT INTO estado("nombre","color") VALUES('Disponible','#39E671');
  INSERT INTO estado("nombre","color") VALUES('Ocupado','#F14040');


  INSERT INTO habitacion("id","numero_camas","observacion","piso","id_estado","id_tipo") VALUES(1,2,'Primera habitacion',1,1,1);
  INSERT INTO habitacion("piso","id_estado","id_tipo","id","numero_camas","observacion") VALUES(2,2,2,2,4,'Segunda habitacion');
  INSERT INTO habitacion("id","numero_camas","observacion","piso","id_estado","id_tipo") VALUES(3,3,'Tercera habitacion',1,3,3);
  INSERT INTO habitacion("id","numero_camas","observacion","piso","id_estado","id_tipo") VALUES(4,3,'Cuarta habitacion',1,4,4);
  INSERT INTO habitacion("id","numero_camas","observacion","piso","id_estado","id_tipo") VALUES(5,5,'Quinta habitacion',2,2,2);

  INSERT INTO cliente("sexo","telefono","tipo_documento","nombres","apellidos","id") VALUES('M','3102249965','C.C','Karol','Rodriguez',12345);

 INSERT INTO cliente("id","apellidos","nombres","sexo","telefono","tipo_documento") VALUES(67890,'Triana','Lorena','M','3219874312','C.C');


  INSERT INTO reserva("id_habitacion","id_cliente","precio","fecha_salida","fecha_entrada","observacion","id","estado") VALUES(1,12345,160000,'2021-11-07','2021-11-07','Reserva para el usuario con id 12345',1,false);

  INSERT INTO reserva("id","fecha_entrada","fecha_salida","observacion","id_cliente","precio","id_habitacion","estado") VALUES(2,'2021-11-07','2021-11-09','Se realizo reserva para la persona con id 67890',67890,165000,2,false);


INSERT INTO reserva("id","fecha_entrada","fecha_salida","observacion","precio","id_cliente","id_habitacion","estado") VALUES(3,'2021-11-07','2021-11-11','Se agrego una reserva al cliente con id 12345',120000,12345,4,true);