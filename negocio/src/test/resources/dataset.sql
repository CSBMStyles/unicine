/*
    NOTE: El dataset es necesario para la ejecución de las pruebas unitarias, entonces hay que tener en cuenta unos puntos importantes:

    1. El dataset constituye un orden, de tal manera que se buscaria insertar primero los datos de las tablas que no tienen dependencias y luego las tablas que tienen dependencias de ellas.

    2. Los datos quee se insertan tienen igualmente un orden que debe seguirse segun como esta en la base de datos, entonces para es se consulta la tabla a tratar luego se insertan los datos.
*/

insert into administrador values (1003496468, "Barrera", "Cristian", "fe5i/PFsjWU0/+4VjImKacbXbnsiQ07+L49lGB5bq4fQ5u5lMiNXljo0s+oSV73N", "cristianbarrera100@gmail.com");

insert into administrador_teatro values (1119000000, "Bello", "Jhon", "fe5i/PFsjWU0/+4VjImKacbXbnsiQ07+L49lGB5bq4fQ5u5lMiNXljo0s+oSV73N", "jhona.belloc@uqvirtual.edu.co");
insert into administrador_teatro values (1228000000, "Camacho", "Maria", "fe5i/PFsjWU0/+4VjImKacbXbnsiQ07+L49lGB5bq4fQ5u5lMiNXljo0s+oSV73N", "mariaf.camachog@uqvirtual.edu.co");
insert into administrador_teatro values (1337000000, "Barrera", "Cristian", "fe5i/PFsjWU0/+4VjImKacbXbnsiQ07+L49lGB5bq4fQ5u5lMiNXljo0s+oSV73N", "cristians.barreram@uqvirtual.edu.co");
insert into administrador_teatro values (1446000000, "Barragan", "Alejandro", "fe5i/PFsjWU0/+4VjImKacbXbnsiQ07+L49lGB5bq4fQ5u5lMiNXljo0s+oSV73N", "henrya.barraganp@uqvirtual.edu.co");
insert into administrador_teatro values (1557000000, "Restrepo", "Rodolfo", "fe5i/PFsjWU0/+4VjImKacbXbnsiQ07+L49lGB5bq4fQ5u5lMiNXljo0s+oSV73N", "rodolfo.restrepo@uqvirtual.edu.com");
insert into administrador_teatro values (1657000800, "Quintero", "Jose", "fe5i/PFsjWU0/+4VjImKacbXbnsiQ07+L49lGB5bq4fQ5u5lMiNXljo0s+oSV73N", "jose.quintero@uqvirtual.edu.com");

insert into cliente values (1009000011, 1, "Rodrigez", "Pepe", "fe5i/PFsjWU0/+4VjImKacbXbnsiQ07+L49lGB5bq4fQ5u5lMiNXljo0s+oSV73N", "pepe@hotmail.com");
insert into cliente values (1008000022, 0, "Perez", "Juan", "fe5i/PFsjWU0/+4VjImKacbXbnsiQ07+L49lGB5bq4fQ5u5lMiNXljo0s+oSV73N", "juan@outlook.com");
insert into cliente values (1007000033, 0, "Gomez", "Luis", "fe5i/PFsjWU0/+4VjImKacbXbnsiQ07+L49lGB5bq4fQ5u5lMiNXljo0s+oSV73N", "luis@yahoo.com");
insert into cliente values (1006000044, 1, "Martinez", "Maria", "fe5i/PFsjWU0/+4VjImKacbXbnsiQ07+L49lGB5bq4fQ5u5lMiNXljo0s+oSV73N", "maria@gmail.com");
insert into cliente values (1005000055, 0, "Lopez", "Luisa", "fe5i/PFsjWU0/+4VjImKacbXbnsiQ07+L49lGB5bq4fQ5u5lMiNXljo0s+oSV73N", "luisa@google.com");

insert into ciudad values (1,"Armenia");
insert into ciudad values (2,"Pereira");
insert into ciudad values (3,"Cali");
insert into ciudad values (4,"Bogota");
insert into ciudad values (5,"Choco");

insert into distribucion_silla values (10, 8, 1, 80, "https://res.cloudinary.com/dwu4xtiun/image/upload/v1668099880/unicine/clientes/cliente1_zfhe3z.jpg");
insert into distribucion_silla values (12, 8, 2, 96, "https://res.cloudinary.com/dwu4xtiun/image/upload/v1668099880/unicine/clientes/cliente1_zfhe3z.jpg");
insert into distribucion_silla values (14, 8, 3, 112, "https://res.cloudinary.com/dwu4xtiun/image/upload/v1668099880/unicine/clientes/cliente1_zfhe3z.jpg");
insert into distribucion_silla values (10, 8, 4, 80, "https://res.cloudinary.com/dwu4xtiun/image/upload/v1668099880/unicine/clientes/cliente1_zfhe3z.jpg");
insert into distribucion_silla values (14, 8, 5, 112, "https://res.cloudinary.com/dwu4xtiun/image/upload/v1668099880/unicine/clientes/cliente1_zfhe3z.jpg");

insert into teatro values (1119000000, 5, 1, "3185469257", "Carrera 14 # 4-6 Norte");
insert into teatro values (1228000000, 4, 2, "3185749321", "Calle 3 # 1 A 24 Sur");
insert into teatro values (1228000000, 4, 3, "3124720846", "Calle 16 4-2 Centro");
insert into teatro values (1446000000, 3, 4, "3001247585", "Carrera 7 # B 12-13 Sur");
insert into teatro values (1557000000, 2, 5, "3186347896", "Carrera 9 # 4-7 Oeste");
insert into teatro values (1657000800, 1, 6, "3178532410", "Calle 4 # 4-2 Sur");

insert into sala values (2, 1, 5, "Atlantis", "XD");
insert into sala values (1, 2, 5, "FLoresta", "DOS_DIMENSIONES");
insert into sala values (1, 3, 4, "Gran Plaza Bosa", "IMAX");
insert into sala values (1, 4, 6, "Altavista", "IMAX");
insert into sala values (3, 5, 3, "Multiplaza", "XD");
insert into sala values (4, 6, 2, "Parque Colonia", "DOS_DIMENSIONES");
insert into sala values (5, 7, 1, "Plaza Imperial", "DX4");
insert into sala values (1, 8, 1, "Colon", "IMAX");

insert into horario values (1, "2024-12-14T20:00:00", "2024-12-14T22:00:00", "20:00");
insert into horario values (2, "2024-12-15T21:00:00", "2024-12-15T23:00:00", "21:00");
insert into horario values (3, "2024-12-16T22:00:00", "2024-12-16T23:00:00", "22:00");
insert into horario values (4, "2024-12-17T20:00:00", "2024-12-17T22:00:00", "20:00");
insert into horario values (5, "2024-12-22T20:00:00", "2024-12-22T22:00:00", "20:00");
insert into horario values (6, "2024-12-24T20:00:00", "2024-12-24T23:00:00", "20:00");

insert into horario_dias values (0, 1);
insert into horario_dias values (1, 1);
insert into horario_dias values (2, 1);
insert into horario_dias values (3, 1);
insert into horario_dias values (4, 1);
insert into horario_dias values (5, 1);
insert into horario_dias values (6, 1);
insert into horario_dias values (0, 2);
insert into horario_dias values (1, 2);
insert into horario_dias values (2, 2);
insert into horario_dias values (3, 2);
insert into horario_dias values (4, 2);
insert into horario_dias values (5, 2);
insert into horario_dias values (6, 2);
insert into horario_dias values (0, 3);
insert into horario_dias values (1, 3);
insert into horario_dias values (2, 3);
insert into horario_dias values (3, 3);
insert into horario_dias values (4, 3);
insert into horario_dias values (5, 3);
insert into horario_dias values (6, 3);
insert into horario_dias values (0, 4);
insert into horario_dias values (1, 4);
insert into horario_dias values (2, 4);
insert into horario_dias values (3, 4);
insert into horario_dias values (4, 4);
insert into horario_dias values (5, 4);
insert into horario_dias values (6, 4);
insert into horario_dias values (0, 5);
insert into horario_dias values (1, 5);
insert into horario_dias values (2, 5);
insert into horario_dias values (3, 5);
insert into horario_dias values (4, 5);
insert into horario_dias values (5, 5);
insert into horario_dias values (6, 5);
insert into horario_dias values (0, 6);
insert into horario_dias values (1, 6);
insert into horario_dias values (2, 6);
insert into horario_dias values (3, 6);
insert into horario_dias values (4, 6);
insert into horario_dias values (5, 6);
insert into horario_dias values (6, 6);

insert into pelicula values (1, 4.2, "Pinocho", "https://www.youtube.com/embed/TITv1TNi5mI", "PROXIMO_ESTRENO", "En un pueblo italiano, el títere de madera Pinocho cobra vida gracias al Hada Azul. Pinocho se esfuerza por comportarse como un niño de carne y hueso, pero su vida da un giro al abandonar a su padre para unirse a un circo.");
insert into pelicula values (2, 3.5, "Dragon Ball: Super Hero", "https://www.youtube.com/embed/lXLPVQ-WrU4", "EN_CARTELERA", "La malvada organización Red Ribbon Army se reforma con nuevos y más poderosos androides, Gamma {1} y Gamma {2} para buscar venganza.");
insert into pelicula values (3, 4.0, "Smile", "https://www.youtube.com/embed/yhKiQGJop_8", "EN_CARTELERA", "Después de ser testigo de un extraño y traumático accidente que involucró a una paciente, la Dr. Rose Cotter (Sosie Bacon) empieza a experimentar sucesos aterradores que no puede explicarse. A medida que el terror comienza a apoderarse de su vida, Rose debe enfrentarse a su pasado para sobrevivir y escapar de su horrible nueva realidad.");
insert into pelicula values (4, 4.5, "Minions", "https://www.youtube.com/embed/W27moupirnI", "EN_CARTELERA", "En los años 70, Gru crece siendo un gran admirador de <<Los salvajes seis>>, un supergrupo de villanos. Para demostrarles que puede ser malvado, Gru idea un plan con la esperanza de formar parte de la banda. Por suerte, cuenta con la ayuda de sus fieles seguidores, los Minions, siempre dispuestos a sembrar el caos.");
insert into pelicula values (5, 4.1, "Encanto", "https://www.youtube.com/embed/SAH_W9q_brE", "PROXIMO_ESTRENO", "En lo alto de las montañas de Colombia hay un lugar encantado llamado Encanto. Aquí, en una casa mágica, vive la extraordinaria familia Madrigal donde todos tienen habilidades fantásticas.");

insert into pelicula_repartos values(1, "Tom Hanks");
insert into pelicula_repartos values(1, "Cynthia Erivo");
insert into pelicula_repartos values(1, "Luke Evans");
insert into pelicula_repartos values(2, "Masako Nozawa");
insert into pelicula_repartos values(2, "Toshio Furukawa");
insert into pelicula_repartos values(2, "Ryō Horikawa");
insert into pelicula_repartos values(2, "Yūko Minaguchi");
insert into pelicula_repartos values(3, "Sosie Bacon");
insert into pelicula_repartos values(3, "Jessie T Usher");
insert into pelicula_repartos values(4, "Sandra Bullock");
insert into pelicula_repartos values(4, "Jon Hamm");
insert into pelicula_repartos values(4, "Michael Keaton");
insert into pelicula_repartos values(5, "Stephanie Beatriz");
insert into pelicula_repartos values(5, "María Cecilia Botero");
insert into pelicula_repartos values(5, "John Leguizamo");

insert into pelicula_imagenes values(1, "https://res.cloudinary.com/dwu4xtiun/image/upload/v1667875113/unicine/peliculas/pinocho_wehtj2.jpg","unicine/peliculas/pinocho_wehtj2");
insert into pelicula_imagenes values(2, "https://res.cloudinary.com/dwu4xtiun/image/upload/v1667775208/unicine/peliculas/Dragon_Ball_Super_Super_Hero_kgaa1r.jpg","unicine/peliculas/Dragon_Ball_Super_Super_Hero_kgaa1r");
insert into pelicula_imagenes values(3, "https://res.cloudinary.com/dwu4xtiun/image/upload/v1667775212/unicine/peliculas/Smile_dl13uz.jpg","unicine/peliculas/Smile_dl13uz");
insert into pelicula_imagenes values(4, "https://res.cloudinary.com/dwu4xtiun/image/upload/v1667775203/unicine/peliculas/Minions_gqwkoe.jpg","unicine/peliculas/Minions_gqwkoe");
insert into pelicula_imagenes values(5, "https://res.cloudinary.com/dwu4xtiun/image/upload/v1667775197/unicine/peliculas/Encanto_fhr4vu.jpg","unicine/peliculas/Encanto_fhr4vu");

insert into pelicula_generos values (1, 1);
insert into pelicula_generos values (2, 1);
insert into pelicula_generos values (4, 1);
insert into pelicula_generos values (4, 2);
insert into pelicula_generos values (5, 2);
insert into pelicula_generos values (1, 2);
insert into pelicula_generos values (3, 3);
insert into pelicula_generos values (6, 3);
insert into pelicula_generos values (8, 3);
insert into pelicula_generos values (8, 4);
insert into pelicula_generos values (9, 4);
insert into pelicula_generos values (9, 5);
insert into pelicula_generos values (10, 5);
insert into pelicula_generos values (12, 5);

insert into funcion values (1, 1, 1, 7000, 6);
insert into funcion values (2, 2, 2, 6500, 5);
insert into funcion values (3, 3, 3, 6800, 4);
insert into funcion values (4, 4, 4, 6800, 3);
insert into funcion values (5, 5, 5, 7100, 2);
insert into funcion values (6, 6, 4, 6800, 1);
insert into funcion values (1, 7, 3, 10000, 8);

insert into cliente_imagenes values (1009000011,"https://res.cloudinary.com/dwu4xtiun/image/upload/v1668099880/unicine/clientes/cliente1_zfhe3z.jpg", "unicine/clientes/cliente1_zfhe3z");
insert into cliente_imagenes values (1008000022,"https://res.cloudinary.com/dwu4xtiun/image/upload/v1668099880/unicine/clientes/cliente2_rpyvof.jpg", "unicine/clientes/cliente2_rpyvof");
insert into cliente_imagenes values (1007000033,"https://res.cloudinary.com/dwu4xtiun/image/upload/v1668099880/unicine/clientes/cliente3_nad9sh.jpg", "unicine/clientes/cliente3_nad9sh");
insert into cliente_imagenes values (1006000044,"https://res.cloudinary.com/dwu4xtiun/image/upload/v1668100350/unicine/clientes/cliente4_jspbf9.jpg", "unicine/clientes/cliente4_jspbf9");
insert into cliente_imagenes values (1005000055,"https://res.cloudinary.com/dwu4xtiun/image/upload/v1668099880/unicine/clientes/cliente5_akhhrd.jpg", "unicine/clientes/cliente5_akhhrd");

insert into cliente_telefonos values (1009000011, "3146832477");
insert into cliente_telefonos values (1009000011, "3008245984");
insert into cliente_telefonos values (1008000022, "3176857415");
insert into cliente_telefonos values (1007000033, "3126845287");
insert into cliente_telefonos values (1006000044, "3139847645");
insert into cliente_telefonos values (1005000055, "3101036478");

insert into cupon values (0.15, 1, "2022-12-25T20:00:00", "Primer registro", "Cupon del 15% de descuento por registrarse por primera vez en nuestra plataforma");
insert into cupon values (0.1, 2, "2022-12-19T15:45:00", "Primera compra", "Cupon del 10% de descuento por realizar una primera compra por medio de nuestra plataforma");

insert into confiteria values (1, 15000, "Combo para niños");
insert into confiteria values (2, 49900, "Combo para dos");
insert into confiteria values (3, 29800, "Crispeta + Dos Gaseosas");
insert into confiteria values (4, 19900, "Gaseosa + Perro caliente + Crispeta + KitKat");
insert into confiteria values (5, 6000, "Nevado de arequipe");

insert into confiteria_imagenes values (1,"https://res.cloudinary.com/dwu4xtiun/image/upload/v1667927564/unicine/confiteria/combo_ni%C3%B1os_ydpbay.jpg", "unicine/confiteria/combo_ni%C3%B1os_ydpbay");
insert into confiteria_imagenes values (2,"https://res.cloudinary.com/dwu4xtiun/image/upload/v1667927565/unicine/confiteria/combo_para_dos_r5rvxp.jpg", "unicine/confiteria/combo_para_dos_r5rvxp");
insert into confiteria_imagenes values (3,"https://res.cloudinary.com/dwu4xtiun/image/upload/v1667927564/unicine/confiteria/crispeta_2gaseosas_vnrpli.jpg", "unicine/confiteria/crispeta_2gaseosas_vnrpli");
insert into confiteria_imagenes values (4,"https://res.cloudinary.com/dwu4xtiun/image/upload/v1667927565/unicine/confiteria/combo_para_dos_r5rvxp.jpg", "unicine/confiteria/combo_para_dos_r5rvxp");
insert into confiteria_imagenes values (5,"https://res.cloudinary.com/dwu4xtiun/image/upload/v1667927565/unicine/confiteria/nevado_arequipe_afpfeo.jpg", "unicine/confiteria/nevado_arequipe_afpfeo");

insert into cupon_cliente values (1005000055, 1, 1, 1);
insert into cupon_cliente values (1006000044, 2, 0, 2);
insert into cupon_cliente values (1006000044, 1, 1, 3);
insert into cupon_cliente values (1007000033, 2, 1, 4);
insert into cupon_cliente values (1008000022, 1, 0, 5);

insert into compra values (1008000022, 1, 6, 1, 17000, "2024-12-20T18:32:25", "2024-12-21T20:00:00", "NEQUI");
insert into compra values (1007000033, 2, 5, 2, 59800, "2024-12-15T14:47:41", "2024-12-15T20:00:00", "VISA");
insert into compra values (1006000044, 3, 4, 3, 24000, "2024-12-16T19:12:04", "2024-12-20T20:00:00", "NEQUI");
insert into compra values (1005000055, 4, 3, 4, 54800, "2024-12-17T15:32:07", "2024-12-25T20:00:00", "MASTERCARD");
insert into compra values (1008000022, 5, 2, 5, 72000, "2024-12-16T20:30:12", "2024-12-29T20:00:00", "DAVIPLATA");

insert into compra_confiteria values (1, 5, 1, 6000, 2);
insert into compra_confiteria values (1, 4, 2, 15000, 1);
insert into compra_confiteria values (2, 2, 3, 29900, 2);
insert into compra_confiteria values (3, 1, 4, 24000, 1);
insert into compra_confiteria values (4, 3, 5, 54800, 1);
insert into compra_confiteria values (5, 1, 6, 24000, 3);

insert into entrada values (5, 1, 2, 1, 17000);
insert into entrada values (4, 2, 4, 2, 59800);
insert into entrada values (3, 3, 5, 3, 24000);
insert into entrada values (4, 4, 2, 4, 54800);
insert into entrada values (5, 4, 2, 5, 54800);
insert into entrada values (5, 5, 3, 6, 72000);