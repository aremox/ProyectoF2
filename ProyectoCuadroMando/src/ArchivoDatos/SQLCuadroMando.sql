create table almacenes (
    id_almacen varchar(20),
    calle varchar(20),
    numero INTEGER,
    cod_postal INTEGER,
    telefono INTEGER,
    municipio varchar(20),
    provincia varchar(20),
    PRIMARY KEY (id_almacen)
);

create table clientes (
    id_cliente varchar(20),
    dni varchar(20),
    nombre varchar(20),
    apellidos varchar(20),
    calle varchar(20),
    numero INTEGER,
    cod_postal INTEGER,
    poblacion varchar(20),
    provincia varchar(20),         
    telefono INTEGER,
    PRIMARY KEY (id_cliente)
);

create table productos (
    id_producto varchar(20),
    categoria varchar(20),
    precio INTEGER,  
    ficha_tecnica varchar(20),
    PRIMARY KEY (id_producto)
);

create table tiendas (
    id_tienda varchar(20),
    id_almacen varchar(20),
    calle varchar(20),
    numero INTEGER,
    cod_postal INTEGER,
    poblacion varchar(20),
    provincia varchar(20),         
    telefono INTEGER,
    PRIMARY KEY (id_producto)
);

create table ventas (
    id_venta varchar(20),
    cliente varchar(20),
    producto varchar(20),
    tienda varchar(20),
    unidades INTEGER,
    importe DECIMAL(10,2),
    fecha date,
    PRIMARY KEY (id_producto)
);

alter table ventas
add FOREIGN KEY (TIENDA) REFERENCES TIENDAS;
