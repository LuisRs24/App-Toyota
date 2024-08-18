
CREATE DATABASE BD_TOYOTA;
--
USE BD_TOYOTA;
--
DROP TABLE IF EXISTS tb_almacen;
CREATE TABLE tb_almacen (
  numero_almcn int NOT NULL,
  dir_almcn char(30) NOT NULL,
  fono_almcn char(10) NOT NULL,
  email_almcn varchar(40) NOT NULL,
  cap_almcn varchar(30) NOT NULL,
  dpto_almcn varchar(35) NOT NULL,
  PRIMARY KEY (numero_almcn)
);
--
INSERT INTO tb_almacen VALUES(1,'La Victoria 454','978458714','almT-1@gmail.com','40','Lima');
INSERT INTO tb_almacen VALUES(2,'Los girasoles 2456','974854125','almT-2@gmail.com','20','Ayacucho');
INSERT INTO tb_almacen VALUES(3,'28 de Julio 1735','987478547','almT-3@gmail.com','60','Amazonas');
INSERT INTO tb_almacen VALUES(4,'España 568','987458521','almT-4@gmail.com','25','La Libertad');
INSERT INTO tb_almacen VALUES(5,'Los Caudillos 478','987485961','almT-5@gmail.com','15','Loreto');
INSERT INTO tb_almacen VALUES(6,'Los Incas 4785','925415263','almT-6@gmail.com','20','Cuzco');
INSERT INTO tb_almacen VALUES(7,'Nicolás de Piérola 784','923652854','almT-7@gmail.com','35','Piura');
INSERT INTO tb_almacen VALUES(8,'Los Jazmines 478','965819192','almT-8@gmail.com','50','Madre de Dios');
INSERT INTO tb_almacen VALUES(9,'Av. Los Freznos 658','937182465','almT-9@gmail.com','70','Tacna');
INSERT INTO tb_almacen VALUES(10,'2 de julio 147','961947325','almT-10@gmail.com','30','Cajamarca');
--
SELECT * FROM tb_almacen;
--
--
DROP TABLE IF EXISTS tb_automovil;
CREATE TABLE tb_automovil (
  id_aut char(20) NOT NULL,
  nom_modelo_aut varchar(30) NOT NULL,
  tipomotor_aut varchar(30) NOT NULL,
  cilindros_aut int NOT NULL,
  peso_neto int NOT NULL,
  peso_bruto int NOT NULL,
  tipo_trans_aut varchar(40) NOT NULL,
  gps_aut varchar(10) NOT NULL,
  airbag_aut varchar(10) NOT NULL,
  asientos_aut int NOT NULL,
  combustible_aut varchar(45) NOT NULL,
  año_aut int NOT NULL,
  PRIMARY KEY (id_aut)
);
--
INSERT INTO tb_automovil VALUES('VHT001','4Runner','1GR-FE',6,2238,2812,'Automática','SI','SI',7,'Gas',2021);
INSERT INTO tb_automovil VALUES('VHT002','aGYA','1KR-VE',3,835,1260,'Mecánica','NO','SI',5,'Gasolina',2020);
INSERT INTO tb_automovil VALUES('VHT003','Avanza','2NR-VE',4,1115,1735,'Mecánica','SI','SI',7,'Gas',2021);
INSERT INTO tb_automovil VALUES('VHT004','Corolla','1GR-FE',6,2238,2812,'Automática','SI','SI',7,'Gasolina',2021);
INSERT INTO tb_automovil VALUES('VHT005','Etios','2R-FE',4,1008,1430,'Mecánica','SI','SI',5,'Gas',2019);
INSERT INTO tb_automovil VALUES('VHT006','Fortuner','2TR-FE',4,1875,2510,'Mecánica','SI','SI',7,'Gasolina',2022);
INSERT INTO tb_automovil VALUES('VHT007','Hiace','1GD-FTV Turbo Diesel',4,2175,3300,'Mecánica','SI','SI',3,'Gasolina',2022);
INSERT INTO tb_automovil VALUES('VHT008','Hilux','2GD Turbo Diesel',4,1965,2810,'Mecánica','SI','SI',5,'Gas',2019);
INSERT INTO tb_automovil VALUES('VHT009','Rav4','M20A-FKS',4,1500,2030,'Automática','SI','SI',5,'Gas',2020);
INSERT INTO tb_automovil VALUES('VHT010','Yaris','1NR-FE',4,1075,1550,'MEcánica','SI','SI',5,'Gasolina',2018);
--
SELECT * FROM tb_automovil;
--
--
DROP TABLE IF EXISTS tb_empleado;
CREATE TABLE tb_empleado (
  cod_emple char(20) NOT NULL,
  nombre_emple varchar(30) NOT NULL,
  cargo_emple varchar(45) NOT NULL,
  sueldo_emple int NOT NULL,
  direccion_emple varchar(30) NOT NULL,
  telefono_emple char(10) NOT NULL,
  email_emple varchar(40) NOT NULL,
  PRIMARY KEY (cod_emple)
);
--
INSERT INTO tb_empleado VALUES('EMP001','Arnold Perez Mendoza','Gerente',4000,'Av. Cochabamba 1456','971474147','arnold@gmail.com');
INSERT INTO tb_empleado VALUES('EMP002','Rosa Socorro Asunción','Sub Gerente',3500,'Av. Izaguirre 1456','968520147','rosita@gmail.com');
INSERT INTO tb_empleado VALUES('EMP003','Felicia Puerta Cáceres','Asesor de Ventas',2500,'Av. Paseo de la república 1456','965203215','felica@gmail.com');
INSERT INTO tb_empleado VALUES('EMP004','Sara Portocarrero Mata','Secretaria',2000,'Jr. Bolivar 1478','985401458','sarita@gmail.com');
INSERT INTO tb_empleado VALUES('EMP005','Simón Valqui Inga','Administrador',3300,'Av. Sanchez Carrión 647','960215630','simonVain@gmail.com');
INSERT INTO tb_empleado VALUES('EMP006','Ever Tafúr Jimenez','Administrador RRHH',3600,'Jr. 9 de Julio 471','980125410','evertatafur@gmail.com');
INSERT INTO tb_empleado VALUES('EMP007','Manuel Reyna Chumbe','Vigilante',3100,'Jr. Libertad 147','965248714','manurey@gmail.com');
INSERT INTO tb_empleado VALUES('EMP008','Gerardo Chacón Ramos','Personal Limpieza',1800,'Av. Evitamiento 485','932154875','geraramos@gmail.com');
INSERT INTO tb_empleado VALUES('EMP009','Benito Alvarez Monsón','Asesos Legal',3200,'Jr. 2 de mayo 562','965847256','benitoalvarez@gmail.com');
INSERT INTO tb_empleado VALUES('EMP010','Feliz Valverde Sachún','Ingeniero Mecánico',3300,'Jr. Sucre 456','958412547','felixSachun@gmail.com');
--
SELECT * FROM tb_empleado;
--
--
DROP TABLE IF EXISTS tb_proveedor;
CREATE TABLE tb_proveedor (
  cod_prov int NOT NULL,
  nom_prov varchar(25) NOT NULL,
  dir_prov varchar(30) NOT NULL,
  fono_prov char(10) NOT NULL,
  email_prov varchar(45) NOT NULL,
  PRIMARY KEY (cod_prov)
) ;
--
INSERT INTO tb_proveedor VALUES(01,'Econor','Av. Carrion 457','985471458','econor@gmail.com');
INSERT INTO tb_proveedor VALUES(02,'Mechanic System','Av. La República 144','985412345','mechanicsystem@gmail.com');
INSERT INTO tb_proveedor VALUES(03,'Hrms Chavez','Jr. Ortiz Arrieta 356','985401256','Chavez@gmail.com');
INSERT INTO tb_proveedor VALUES(04,'Repsol','Jr. Bolivar 747','932501458','repsol@gmail.com');
INSERT INTO tb_proveedor VALUES(05,'Blue Light','Los Geranios 895','925841568','bluelight@gmail.com');
INSERT INTO tb_proveedor VALUES(06,'Air Sky','Av. Paseo General 472','902145786','airsky@gmail.com');
INSERT INTO tb_proveedor VALUES(07,'HidroLux','Jr. Los Pericos 784','901247854','hidrolux@gmail.com');
INSERT INTO tb_proveedor VALUES(08,'MotoSystem','Las Hermelindas 265','930269018','motosystem@gmail.com');
INSERT INTO tb_proveedor VALUES(09,'El capi','Av. Ahogados 377','901487251','elcapi@gmail.com');
INSERT INTO tb_proveedor VALUES(010,'TurboPower','Monseñor Arrieta 145','902145586','turbo@gmail.com');
--
SELECT * FROM tb_proveedor;
--
--
DROP TABLE IF EXISTS tb_venta;
CREATE TABLE tb_venta (
  cod_venta int NOT NULL,
  dni_cli int NOT NULL,
  nombres_cli varchar(30) NOT NULL,
  fono_cli char(10) NOT NULL,
  id_aut char(20) NOT NULL,
  fecha_venta date NOT NULL,
  precio_venta int NOT NULL,
  descuento_venta int NOT NULL,
  monto_tot_venta int NOT NULL,
  PRIMARY KEY (cod_venta),
  FOREIGN KEY(id_aut) REFERENCES tb_automovil(id_aut)
) ;
--
INSERT INTO tb_venta VALUES(0001,32145874,'Luis AlfonsoRamos Perez','987458745','VHT010','2022-02-19',60000,1000,59000);
INSERT INTO tb_venta VALUES(0002,65897458,'Jorge Antonio Bravo Calderón','981959684','VHT005','2022-01-08',70000,2000,68000);
INSERT INTO tb_venta VALUES(0003,85425685,'Cecilia Chacón Sanchez','983254158','VHT003','2022-01-13',90000,4000,86000);
INSERT INTO tb_venta VALUES(0004,24585635,'Ana Lucía Ceballos Arévalo','958748595','VHT001','2022-04-09',80000,2000,78000);
INSERT INTO tb_venta VALUES(0005,65263521,'Santiago Hormeño Avila','963258441','VHT006','2022-06-05',150000,3000,147000);
INSERT INTO tb_venta VALUES(0006,95848574,'Maria Celis Tuesta','932544187','VHT004','2022-02-23',65000,1500,63500);
INSERT INTO tb_venta VALUES(0007,54852635,'Leonardo Sanchez Hidalgo','965214478','VHT002','2022-05-17',60000,1000,59000);
INSERT INTO tb_venta VALUES(0008,12548965,'Sofía Huamán Valqui','947485214','VHT009','2022-03-01',60000,1000,59000);
INSERT INTO tb_venta VALUES(0009,62457814,'José Eduardo Silva López','954125632','VHT007','2022-01-24',60000,1000,59000);
INSERT INTO tb_venta VALUES(00010,35264879,'Angélica Jiménez Corcuera','974859634','VHT008','2022-06-14',60000,1000,59000);
--
SELECT * FROM tb_venta;
--
DROP TABLE IF EXISTS tb_usuario;
CREATE TABLE tb_usuario(
cod_usuario char(20) NOT NULL,
clave_usuario varchar(30) NOT NULL,
PRIMARY KEY (cod_usuario)
);
--
INSERT INTO tb_usuario VALUES ('USU001','1111');
INSERT INTO tb_usuario VALUES ('USU002','2222');
INSERT INTO tb_usuario VALUES ('USU003','3333');
INSERT INTO tb_usuario VALUES ('USU004','4444');
--
SELECT * FROM tb_usuario;
--

select*from bd_toyota.tb_venta where MONTH(fecha_venta) = 02;
---
use bd_toyota;
select * from tb_almacen;
--
------- ALMACEN --------
-- Agregar
INSERT INTO tb_almacen VALUES(11,'holi','998798','sfsf','sfs','ssdfs');
-- Actualizar
UPDATE tb_almacen SET dir_almcn='holi', fono_almcn='123', email_almcn='asdasd', cap_almcn='sada',dpto_almcn='dsad' WHERE numero_almcn=11;
-- Eliminar
DELETE FROM tb_almacen WHERE numero_almcn=11;
-- Seleccionar Almacen por numero de almacen
SELECT * FROM 	tb_almacen WHERE numero_almcn=9;
-- Seleccionar Almacen por Departamento
SELECT * FROM tb_almacen WHERE dpto_almcn="Cusco";
-- Listar almacenes 
SELECT * FROM tb_almacen;

------ EMPLEADO -----
-- Agregar
INSERT INTO tb_empleado VALUES('EMP011','Peter','Gerente general',1255,'Los duraznos','985471254','peter@gmail.com');
-- Actualizar
UPDATE tb_empleado SET nombre_emple='Andy', cargo_emple='Mecánico', sueldo_emple=1000, direccion_emple='Jr. Cahuide 145', telefono_emple='954785425', email_emple='andy@gmail.com' WHERE cod_emple='EMP011';
-- Eliminar
DELETE FROM tb_empLeado WHERE cod_emple = 'EMP011';
-- Seleccionar Empleado por código de empleado
SELECT * FROM tb_empleado WHERE cod_emple='EMP004';
-- Listar empleados
SELECT * FROM tb_empleado;

------ PROVEEDOR -----
-- Agregar
INSERT INTO tb_proveedor VALUES(11,'Perico','Jr. Matorral','985471254','perico@gmail.com');
-- Actualizar
UPDATE tb_proveedor SET nom_prov='Calin',dir_prov='Jr. Laureles',fono_prov='985471452',email_prov='carlos@gmail.com' WHERE cod_prov = 11;
-- Eliminar
DELETE FROM tb_proveedor WHERE cod_prov=11;
-- Seleccionar Proveedor por código de proveedor
SELECT * FROM tb_proveedor WHERE cod_prov=2;
-- Seleccionar Proveedor por nombre de proveedor
SELECT * FROM tb_proveedor WHERE nom_prov = 'Simón Valqui Inga';
-- Listar Proveedores
SELECT * FROM tb_proveedor;

------ AUTOMOVIL -----
-- Agregar
INSERT INTO tb_automovil VALUES('VHT011','Veloster2.0','2RT-FR',6,1150,1450,'Automático','NO','SI',2,'Gasolina',2020);
-- Actualizar
UPDATE tb_automovil SET nom_modelo_aut='Veloster', tipomotor_aut='1TR-RF',cilindros_aut=6,peso_neto=1200,peso_bruto=1500,tipo_trans_aut='semiautomático',gps_aut='SI',airbag_aut='SI',asientos_aut=2,combustible_aut='Gas',año_aut=2021 WHERE id_aut='VHT011';
-- ELiminar
DELETE FROM tb_automovil WHERE id_aut = 'VHT011';
-- Seleccionar vehículo por ID de vehículo
SELECT * FROM tb_automovil WHERE id_aut='VHT002';
-- Seleccionar Vehículo por Nombre de Modelo
SELECT * FROM tb_automovil WHERE nom_modelo_aut = "Corolla";
-- Listar vehículos
SELECT * FROM tb_automovil;


------- VENTA --------
-- Agegar
INSERT INTO tb_venta VALUES(11,'54785412','Angelita Celis Mendoza','958741458','VHT009','2022-05-10',65000,1500,63500);
-- Actualizar
UPDATE tb_venta SET dni_cli='24585635',nombres_cli='Anacecilia Chacón Tuesta',fono_cli='984712547',id_aut='VHT006',fecha_venta='2022-06-20',precio_venta=64000,descuento_venta=1500,monto_tot_venta=62500 WHERE cod_venta=11;
-- Eliminar
DELETE FROM tb_venta WHERE cod_venta=11;
-- Seleccionar Venta por código de venta
SELECT * FROM tb_venta WHERE cod_venta=4;
-- Seleccionar Venta por Fecha
SELECT * FROM tb_venta WHERE fecha_venta='2022-01-08';
-- Listar Ventas
SELECT * FROM tb_venta;
---


--
use bd_toyota;


