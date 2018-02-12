Liferay.on(
		'planTravel',		//Nombre del evento
		function(event) {	//Funcion manejadora que recibe el objeto JSON
			alert(event.origin + "-" + event.destination);
    	}
);

alert(document.cookie);