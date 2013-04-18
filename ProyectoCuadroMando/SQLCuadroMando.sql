create table almacenes (
    id_almacen varchar(20),
    calle varchar(20),
    numero int(5),
    cod_postal int(5),
    telefono int(5),
    municipio varchar(20),
    provincia varchar(20),
    PRIMARY KEY (id_almacen)
)

create table clientes (
    id_cliente varchar(20),
    dni varchar(20),
    nombre varchar(20),
    apellidos varchar(20),
    calle varchar(20),
    numero int(5),
    cod_postal int(5),
    poblacion varchar(20),
    provincia varchar(20),         
    telefono int(5),
    PRIMARY KEY (id_cliente)
)

create table productos (
    id_producto varchar(20),
    categoria varchar(20),
    precio int(5),  
    ficha_tecnica varchar(20),
    PRIMARY KEY (id_producto)
)

create table tiendas (
    id_tienda varchar(20),
    id_almacen varchar(20),
    calle varchar(20),
    numero int(4),
    cod_postal int(5),
    poblacion varchar(20),
    provincia varchar(20),         
    telefono int(20),
    PRIMARY KEY (id_producto)
)

create table tiendas (
    id_venta varchar(20),
    cliente varchar(20),
    producto varchar(20),
    tienda varchar(20),
    unidades double(5),
    importe double(5),
    fecha date,
    PRIMARY KEY (id_producto)
)
