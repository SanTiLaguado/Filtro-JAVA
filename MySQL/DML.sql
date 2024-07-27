USE sgpzf;

INSERT INTO sgpzf.gender (id, name) VALUES (1, 'Masculino');
INSERT INTO sgpzf.gender (id, name) VALUES (2, 'Femenino');
INSERT INTO sgpzf.gender (id, name) VALUES (3, 'No binario');
INSERT INTO sgpzf.gender (id, name) VALUES (4, 'Prefiero no decirlo');
INSERT INTO sgpzf.gender (id, name) VALUES (5, 'Otro');

INSERT INTO sgpzf.country (id, name) VALUES (1, 'Argentina');
INSERT INTO sgpzf.country (id, name) VALUES (2, 'Bolivia');
INSERT INTO sgpzf.country (id, name) VALUES (3, 'Brasil');
INSERT INTO sgpzf.country (id, name) VALUES (4, 'Chile');
INSERT INTO sgpzf.country (id, name) VALUES (5, 'Colombia');
INSERT INTO sgpzf.country (id, name) VALUES (6, 'Costa Rica');
INSERT INTO sgpzf.country (id, name) VALUES (7, 'Cuba');
INSERT INTO sgpzf.country (id, name) VALUES (8, 'Ecuador');
INSERT INTO sgpzf.country (id, name) VALUES (9, 'El Salvador');
INSERT INTO sgpzf.country (id, name) VALUES (10, 'Guatemala');
INSERT INTO sgpzf.country (id, name) VALUES (11, 'Honduras');
INSERT INTO sgpzf.country (id, name) VALUES (12, 'México');
INSERT INTO sgpzf.country (id, name) VALUES (13, 'Nicaragua');
INSERT INTO sgpzf.country (id, name) VALUES (14, 'Panamá');
INSERT INTO sgpzf.country (id, name) VALUES (15, 'Paraguay');
INSERT INTO sgpzf.country (id, name) VALUES (16, 'Perú');
INSERT INTO sgpzf.country (id, name) VALUES (17, 'Puerto Rico');
INSERT INTO sgpzf.country (id, name) VALUES (18, 'República Dominicana');

INSERT INTO sgpzf.country (id, name) VALUES (19, 'Uruguay');
INSERT INTO sgpzf.country (id, name) VALUES (20, 'Venezuela');

-- Argentina
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (1, 'Buenos Aires', 1);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (2, 'Córdoba', 1);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (3, 'Santa Fe', 1);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (4, 'Mendoza', 1);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (5, 'Tucumán', 1);
-- Bolivia
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (6, 'La Paz', 2);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (7, 'Santa Cruz', 2);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (8, 'Cochabamba', 2);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (9, 'Oruro', 2);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (10, 'Potosí', 2);

-- Brasil
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (11, 'São Paulo', 3);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (12, 'Rio de Janeiro', 3);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (13, 'Minas Gerais', 3);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (14, 'Bahia', 3);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (15, 'Paraná', 3);
-- Chile
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (16, 'Santiago', 4);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (17, 'Valparaíso', 4);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (18, 'Concepción', 4);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (19, 'Antofagasta', 4);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (20, 'La Serena', 4);
-- Colombia
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (21, 'Amazonas', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (22, 'Antioquia', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (23, 'Arauca', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (24, 'Atlántico', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (25, 'Bolívar', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (26, 'Boyacá', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (27, 'Caldas', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (28, 'Caquetá', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (29, 'Casanare', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (30, 'Cauca', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (31, 'Cesar', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (32, 'Chocó', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (33, 'Córdoba', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (34, 'Cundinamarca', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (35, 'Guainía', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (36, 'Guaviare', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (37, 'Huila', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (38, 'La Guajira', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (39, 'Magdalena', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (40, 'Meta', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (41, 'Nariño', 5);

INSERT INTO sgpzf.region (id, name, idcountry) VALUES (42, 'Norte de Santander',
5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (43, 'Putumayo', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (44, 'Quindío', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (45, 'Risaralda', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (46, 'San Andrés y
Providencia', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (47, 'Santander', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (48, 'Sucre', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (49, 'Tolima', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (50, 'Valle del Cauca', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (51, 'Vaupés', 5);
INSERT INTO sgpzf.region (id, name, idcountry) VALUES (52, 'Vichada', 5);

INSERT INTO sgpzf.city (id, name, idregion) VALUES (1, 'Leticia', 21);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (2, 'Puerto Nariño', 21);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (3, 'Medellín', 22);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (4, 'Bello', 22);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (5, 'Itagüí', 22);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (6, 'Envigado', 22);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (7, 'Apartadó', 22);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (8, 'Arauca', 23);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (9, 'Arauquita', 23);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (10, 'Saravena', 23);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (11, 'Tame', 23);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (17, 'Cartagena', 25);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (18, 'Magangué', 25);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (19, 'Turbaco', 25);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (20, 'El Carmen de Bolívar',
25);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (21, 'Arjona', 25);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (22, 'Tunja', 26);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (23, 'Sogamoso', 26);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (24, 'Duitama', 26);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (25, 'Chiquinquirá', 26);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (26, 'Puerto Boyacá', 26);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (32, 'Florencia', 28);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (33, 'Morelia', 28);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (34, 'San Vicente del Caguán',
28);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (35, 'Puerto Rico', 28);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (36, 'Curillo', 28);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (37, 'Yopal', 29);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (38, 'Aguazul', 29);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (39, 'Villanueva', 29);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (40, 'Monterrey', 29);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (41, 'Tauramena', 29);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (42, 'Popayán', 30);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (43, 'Santander de Quilichao',
30);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (44, 'Puerto Tejada', 30);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (45, 'Patía', 30);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (46, 'Piendamó', 30);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (47, 'Valledupar', 31);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (48, 'Aguachica', 31);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (49, 'Agustín Codazzi', 31);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (50, 'Bosconia', 31);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (51, 'Curumaní', 31);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (52, 'Quibdó', 32);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (53, 'Istmina', 32);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (54, 'Tadó', 32);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (55, 'Condoto', 32);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (56, 'El Carmen de Atrato',
32);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (57, 'Montería', 33);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (58, 'Cereté', 33);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (59, 'Sahagún', 33);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (60, 'Lorica', 33);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (61, 'Montelíbano', 33);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (62, 'Bogotá', 34);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (63, 'Soacha', 34);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (64, 'Girardot', 34);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (65, 'Zipaquirá', 34);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (66, 'Facatativá', 34);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (67, 'Inírida', 35);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (68, 'San José del Guaviare',
36);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (69, 'Calamar', 36);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (70, 'Neiva', 37);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (71, 'Garzón', 37);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (72, 'Pitalito', 37);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (73, 'La Plata', 37);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (74, 'Campoalegre', 37);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (75, 'Riohacha', 38);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (76, 'Maicao', 38);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (77, 'Uribia', 38);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (78, 'San Juan del Cesar',
38);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (79, 'Fonseca', 38);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (80, 'Santa Marta', 39);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (81, 'Ciénaga', 39);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (82, 'Fundación', 39);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (83, 'El Banco', 39);
INSERT INTO sgpzf.city (id, name, idregion) VALUES (84, 'Plato', 39);