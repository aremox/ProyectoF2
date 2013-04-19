create table almacenes (
    id_almacen varchar(20),
    calle varchar(50),
    numero numeric(15),
    cod_postal numeric(15),
    telefono numeric(15),
    municipio varchar(20),
    provincia varchar(20),
    PRIMARY KEY (id_almacen)
);

create table clientes (
    id_cliente varchar(20),
    dni varchar(20),
    nombre varchar(20),
    apellidos varchar(20),
    calle varchar(50),
    numero numeric(15),
    cod_postal numeric(15),
    poblacion varchar(20),
    provincia varchar(20),         
    telefono numeric(15),
    PRIMARY KEY (id_cliente)
);

create table productos (
    id_producto varchar(20),
    categoria varchar(20),
    precio numeric(15,2),  
    ficha_tecnica varchar(20),
    PRIMARY KEY (id_producto)
);

create table tiendas (
    id_tienda varchar(20),
    id_almacen varchar(20),
    calle varchar(50),
    numero numeric(15),
    cod_postal numeric(15),
    poblacion varchar(20),
    provincia varchar(20),         
    telefono numeric(15),
    PRIMARY KEY (id_tienda)
);

create table ventas (
    id_venta varchar(20),
    cliente varchar(20),
    producto varchar(20),
    tienda varchar(20),
    unidades numeric(15),
    importe DECIMAL(10,2),
    fecha date,
    PRIMARY KEY (id_producto)
);

alter table ventas
add FOREIGN KEY (TIENDA) REFERENCES TIENDAS;
