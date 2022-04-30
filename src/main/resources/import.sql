
/* AGREGAR INFORMACION*/

INSERT INTO persona (persona_id,direccion, edad, genero, identificacion, nombre, telefono) VALUES(1,'Otavalo sn y principal', 25, 'Masculino', '1785478963', 'Jose Lema', 098254785);

INSERT INTO cliente (cliente_id, contrasena, estado,persona_id) VALUES(1, '1234', 0,1);

INSERT INTO cuenta (cuenta_id, estado, num_cuenta, saldo_inicial, tipo_cuenta, cliente) VALUES(1,0, '585545', 1000, 'Ahorros', 1);

INSERT INTO movimientos (fecha, saldo, tipo_movimiento, valor, cuenta) VALUES ('2022-04-28', 1000, 'Debito', 100, 1);