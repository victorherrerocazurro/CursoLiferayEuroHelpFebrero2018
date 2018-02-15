create table SB_Puja (
	uuid_ VARCHAR(75) null,
	pujaId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	valorPuja DOUBLE,
	idSubasta LONG
);

create table SB_Subasta (
	uuid_ VARCHAR(75) null,
	subastaId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	nombreProducto VARCHAR(75) null,
	descripcion VARCHAR(75) null,
	precioMinimo DOUBLE,
	fechaFin DATE null,
	pujaMaxima LONG
);