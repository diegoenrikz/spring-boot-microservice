
/* AGREGAR INFORMACION*/

INSERT INTO persona (persona_id,direccion, edad, genero, identificacion, nombre, telefono) VALUES(1,'Otavalo sn y principal', 25, 'Masculino', '1785478963', 'Jose Lema', 098254785);

INSERT INTO cliente (cliente_id, contrasena, estado,persona_id) VALUES(1, '1234', 0,1);

INSERT INTO cuenta (cuenta_id, estado, num_cuenta, saldo_inicial, tipo_cuenta, cliente, saldo_total) VALUES(1,0, '265879', 1000, 'Ahorros', 1,1000);

INSERT INTO cuenta (cuenta_id, estado, num_cuenta, saldo_inicial, tipo_cuenta, cliente, saldo_total) VALUES(2,0, '123456', 2000, 'Crédito', 1,2000);

INSERT INTO retiro (num_cuenta, valor_diario) VALUES('265879', 0);
