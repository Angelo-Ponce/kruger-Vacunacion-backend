# kruger-backend
Proyecto Kruger backend

Construcción del proyecto:
1.	Creación de modelos.
2.	Agregar relaciones entre los modelos
3.	Creación de los DTO em el paquete DTO.
4.	Se crea paquete REPO con las interfaces para el uso de JPA.
5.	Se Crea paquete Service con las interfaces del CRUD y los métodos personalizados.
6.	Se Crea paquete Service Impl para implementar los servicios ya creados.
7.	Se crea el paquete Controller con todos los endpoint que se podrán usar dependiendo de los privilegios aplicando acceso de seguridad.

Modo de uso:
1.	Para usar los endpoints se debe generar los tokens de acceso.
	http://localhost:8080/oauth/token 
	a.	Para ADMIN usar el usuario angelo@gmail.com
	b.	Para Empleado usar el usario joel@gmail.com
	c.	Password para ambos 123
2.	Se debe generar el token valido para el uso de las peticiones en el proyecto.
3.	Se puede realizar lo siguiente:
HTTP Method GET:
	a.	http://localhost:8080/employee : todos los empleados.
	b.	http://localhost:8080/vaccinestatus : todos los estados de la vacuna.
	c.	http://localhost:8080/vaccinetype : todos los tipos de vacuna.

HTTP Method POST:
	d.	http://localhost:8080/employee : Guardar empleado.
	e.	http://localhost:8080/vaccinestatus : Guardar estado de la vacuna.
	f.	http://localhost:8080/vaccinetype : Guardar tipo de vacuna.
	g.	http://localhost:8080/oauth/token : obtener token
	h.	http://localhost:8080/employee/employeevaccinestatus : obtener los empleados por estado de vacuna.
	i.	http://localhost:8080/employee/employeevaccinetype : obtener los empleados por tipo de vacuna.
	j.	http://localhost:8080/employee/betweendatevaccine?initialDate=1996-03-11T17:34:11&finalDate=1996-03-11T17:34:11 : obtener los empleados vacunados por rango de fecha.

HTTP Method Put:
	k.	http://localhost:8080/employee : Actualizar empleado.

HTTP Method Delete:
	a.	http://localhost:8080/employee : Eliminar empleado.
	
emial: angeloponcedev@gmail.com
