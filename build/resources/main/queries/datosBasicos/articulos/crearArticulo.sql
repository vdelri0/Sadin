INSERT INTO articulos(codigo, nombre, referencia, presentacion, "unidadDeMedida", "unidadesPorCaja", "codigoDeLinea", "cuentaDeIngreso", "cuentaDeCosto", "promedioDeCosto", "precioDeVenta") 
VALUES(nextval('codigoarticulos'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
