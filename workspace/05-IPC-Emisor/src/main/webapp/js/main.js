function lanzarEvento() {
	Liferay.fire('planTravel', // Nombre del evento
	{ // Objeto JSON
		origin : 'pune',
		destination : 'mumbai'
	});
	
	document.cookie = "nombre=juan";
}