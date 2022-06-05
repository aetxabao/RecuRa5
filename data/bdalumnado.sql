SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE DATABASE `bdalumnado` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `bdalumnado`;

CREATE TABLE IF NOT EXISTS `alumnos` (
`idAlumno` int(3) NOT NULL AUTO_INCREMENT,
`nombre` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
`apellido` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
`nota` int(2) NOT NULL,
`pendiente` varchar(2) COLLATE utf8_spanish2_ci NOT NULL,
PRIMARY KEY (`idAlumno`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=8 ;

INSERT INTO `alumnos` (`idAlumno`, `nombre`, `apellido`, `nota`, `pendiente`) VALUES
(1, 'Ana', 'López', 6, 'si'),
(2, 'Luis', 'Lafuente', 4, 'si'),
(3, 'Ignacio', 'Múgica', 8, 'no'),
(4, 'Alberto', 'Osés', 9, 'no'),
(5, 'Elena', 'Santoyo', 3, 'si'),
(6, 'María', 'Urrutia', 6, 'no'),
(7, 'Julia', 'Allo', 4, 'si');

CREATE TABLE IF NOT EXISTS `usuarios` (
`nombre` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
`sal` varchar(128) COLLATE utf8_spanish2_ci NOT NULL,
`hash` varchar(64) COLLATE utf8_spanish2_ci NOT NULL,
PRIMARY KEY (`nombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=8 ;

INSERT INTO `usuarios` (`nombre`, `sal`, `hash`) VALUES
('Elena', '0b446dcd9e1c2b06e8cb9dbda00da2c89be2e246e7df621bb43e3e283462bd5b1050bc3bae2a85bd4909be01fdf1f74196ef3613233fb472af253c14923f68b2', '236279858187404608bd78d9a0dd4808a4120bd3d2d7f150dbb5006b5a0b8bc4'),
('Ignacio', '443e34a8c6f2bb6b0af1bb1453916e2f748415eadd875752747c4219a8a0c405614e141ed592cc3b6603e6ac258f63d912f633601e3334febc4dbc083b14e795', '9bea71a63ecac2b2efe78a001b9929e31a1a190e0391c8172cc2bb62e34e0c10'),
('Alberto', '724cb0ac43e9ddae70babfb0880f19ac1f72f373403389dfd19cd180fcfb2b93f213024d5aca487564633e0ed3ca47535a6fa682ccf280fe7b0a9fae04494000', '0c2e5a13c7c5aae99ac4b06111dd44ae7fe9258f35e05f62ccb5bbaa8d1e4431'),
('Ana', '12f2a414949e60c095069854b8be5689513671b565d6cd389621faeb96470b01df317e58e1ad5842b65b756646ee224e5dbddcbc2aab6118a552de4cbf9079ad', '435db52ea4a85c00f51776c795ce8269240670eca4d416dd2014df76a2486c19'),
('Luis', '3b2cdff10e97e61528d2a4fd85d727debb9cc2fbb489c39983fdb80be796d63bc1801ca70c6967cc9725497b46dab7146a5b5f8f698088b857aa49fb1648d142', '642cba9c626a90e8c965f58dbeba1657fd887c23b8ea285c404ef4a70d9c3485'),
('María', '69fd7a6165ca58100e8e6771b6d5f04f98aad25c3c8533e9a93df5e201c7f633cc4e055ba55e4cd8914f70b94cf2bf7287da03075abad70e8af1b5cb49f9254e', '6bc9176c2fc300c8f65702a50ba449ebbe8afbc23f647b77efd69fc85227e89e'),
('Julia', '2a853bee144f9512561686acdd0836923d8108aa26eabee45697048a110575734699b92b7feb095591a6c0ffb0c646c2e8829fc8b3f08014e29adcf2d149276c', '86a416f17229de04f8d4c385a001c1a40a7107db649b1f79668360022b2f72ca');
