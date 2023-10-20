CREATE TABLE `konsumen` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`nama` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`alamat` TEXT NOT NULL COLLATE 'latin1_swedish_ci',
	`kota` VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	`provinsi` VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	`tgl_registrasi` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`status` VARCHAR(1) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `id` (`id`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;