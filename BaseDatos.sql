create table cliente (cliente_id integer not null auto_increment, contrasena varchar(255), estado bit, persona_id integer, primary key (cliente_id)) engine=InnoDB;
create table cuenta (cuenta_id integer not null auto_increment, estado bit, num_cuenta bigint, saldo_inicial double precision, saldo_total double precision, tipo_cuenta varchar(255), cliente integer, primary key (cuenta_id)) engine=InnoDB;
create table movimientos (mov_id integer not null auto_increment, fecha date, saldo double precision, tipo_movimiento varchar(255), valor double precision, cuenta integer, primary key (mov_id)) engine=InnoDB;
create table persona (persona_id integer not null auto_increment, direccion varchar(255), edad integer, genero varchar(255), identificacion varchar(255), nombre varchar(255), telefono varchar(255), primary key (persona_id)) engine=InnoDB;
create table retiro (num_cuenta bigint not null, valor_diario double precision, primary key (num_cuenta)) engine=InnoDB;
alter table cliente add constraint FKmc52upywn8gona2iiwwwphb92 foreign key (persona_id) references persona (persona_id);
alter table cuenta add constraint FKoro0dkes1aden3a2f0co20l69 foreign key (cliente) references cliente (cliente_id);
alter table movimientos add constraint FKgpwucwtokq0kuk5xbt8tl9h2m foreign key (cuenta) references cuenta (cuenta_id);