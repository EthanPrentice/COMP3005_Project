-- -----------------------------------------------------
-- Schema bookstore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bookstore` DEFAULT CHARACTER SET latin1 ;
USE `bookstore` ;

-- -----------------------------------------------------
-- Table `bookstore`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`address` (
  `address_id` INT(11) NOT NULL AUTO_INCREMENT,
  `unit` VARCHAR(5) NULL DEFAULT NULL,
  `street_num` INT(11) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NULL DEFAULT NULL,
  `country` VARCHAR(45) NOT NULL,
  `postal_code` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`address_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`author` (
  `author_id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`author_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`name`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`name` (
  `name_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first` VARCHAR(45) NOT NULL,
  `middle` VARCHAR(45) NULL DEFAULT NULL,
  `last` VARCHAR(45) NOT NULL,
  `prefix` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`name_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`author_name`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`author_name` (
  `author_id` INT(11) NOT NULL,
  `name_id` INT(11) NOT NULL,
  PRIMARY KEY (`author_id`),
  INDEX `fk_author_name_name_idx` (`name_id` ASC),
  CONSTRAINT `fk_author_name_author`
    FOREIGN KEY (`author_id`)
    REFERENCES `bookstore`.`author` (`author_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_author_name_name`
    FOREIGN KEY (`name_id`)
    REFERENCES `bookstore`.`name` (`name_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`bank_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`bank_account` (
  `bank_acc_id` INT(11) NOT NULL AUTO_INCREMENT,
  `bank_num` CHAR(3) NOT NULL,
  `branch_num` CHAR(5) NOT NULL,
  `account_num` CHAR(9) NOT NULL,
  PRIMARY KEY (`bank_acc_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`billing_addr`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`billing_addr` (
  `billing_info_id` INT(11) NOT NULL,
  `address_id` INT(11) NOT NULL,
  PRIMARY KEY (`billing_info_id`),
  INDEX `billing_addr_billing_idx` (`address_id` ASC),
  CONSTRAINT `billing_addr_addr`
    FOREIGN KEY (`address_id`)
    REFERENCES `bookstore`.`address` (`address_id`),
  CONSTRAINT `billing_addr_billing`
    FOREIGN KEY (`address_id`)
    REFERENCES `bookstore`.`address` (`address_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`billing_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`billing_info` (
  `billing_info_id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`billing_info_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`billing_name`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`billing_name` (
  `billing_info_id` INT(11) NOT NULL,
  `name_id` INT(11) NOT NULL,
  INDEX `billing_name_name_idx` (`name_id` ASC),
  INDEX `billing_name_billing_idx` (`billing_info_id` ASC),
  CONSTRAINT `billing_name_billing`
    FOREIGN KEY (`billing_info_id`)
    REFERENCES `bookstore`.`billing_info` (`billing_info_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `billing_name_name`
    FOREIGN KEY (`name_id`)
    REFERENCES `bookstore`.`name` (`name_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`book` (
  `book_id` INT(11) NOT NULL AUTO_INCREMENT,
  `genre` VARCHAR(45) NOT NULL,
  `page_count` INT(11) NULL DEFAULT NULL,
  `price` INT(11) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`book_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`cart_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`cart_item` (
  `cart_item_id` INT(11) NOT NULL AUTO_INCREMENT,
  `quantity` INT(11) NOT NULL,
  PRIMARY KEY (`cart_item_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`book_in_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`book_in_item` (
  `cart_item_id` INT(11) NOT NULL,
  `book_id` INT(11) NOT NULL,
  PRIMARY KEY (`cart_item_id`),
  INDEX `book_in_item_book_idx` (`book_id` ASC),
  CONSTRAINT `book_in_item_book`
    FOREIGN KEY (`book_id`)
    REFERENCES `bookstore`.`book` (`book_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `book_in_item_item`
    FOREIGN KEY (`cart_item_id`)
    REFERENCES `bookstore`.`cart_item` (`cart_item_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`purchase_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`purchase_order` (
  `po_id` INT(11) NOT NULL AUTO_INCREMENT,
  `date_ordered` DATE NOT NULL,
  `received` TINYINT(4) NOT NULL DEFAULT '0',
  `quantity` INT(11) NOT NULL,
  `price_per_unit` INT(11) NOT NULL,
  PRIMARY KEY (`po_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`book_in_po`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`book_in_po` (
  `po_id` INT(11) NOT NULL,
  `book_id` INT(11) NOT NULL,
  PRIMARY KEY (`po_id`),
  INDEX `fk_book_in_po_book_idx` (`book_id` ASC),
  CONSTRAINT `fk_book_in_po_book`
    FOREIGN KEY (`book_id`)
    REFERENCES `bookstore`.`book` (`book_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_book_in_po_po`
    FOREIGN KEY (`po_id`)
    REFERENCES `bookstore`.`purchase_order` (`po_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`sold_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`sold_item` (
  `sold_item_id` INT(11) NOT NULL AUTO_INCREMENT,
  `price_per_unit` INT(11) NOT NULL,
  `quantity` INT(11) NOT NULL,
  `publisher_rate` DECIMAL(3,2) NOT NULL,
  PRIMARY KEY (`sold_item_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`book_sold`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`book_sold` (
  `sold_item_id` INT(11) NOT NULL,
  `book_id` INT(11) NOT NULL,
  PRIMARY KEY (`sold_item_id`),
  INDEX `book_sold_book_idx` (`book_id` ASC),
  CONSTRAINT `book_sold_book`
    FOREIGN KEY (`book_id`)
    REFERENCES `bookstore`.`book` (`book_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `book_sold_item`
    FOREIGN KEY (`sold_item_id`)
    REFERENCES `bookstore`.`sold_item` (`sold_item_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`supplier_pricing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`supplier_pricing` (
  `supplier_pricing_id` INT(11) NOT NULL AUTO_INCREMENT,
  `purchase_price` DECIMAL(6,2) NOT NULL,
  `publisher_rate` DECIMAL(3,2) NOT NULL,
  PRIMARY KEY (`supplier_pricing_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`book_supp_pricing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`book_supp_pricing` (
  `supplier_pricing_id` INT(11) NOT NULL,
  `book_id` INT(11) NOT NULL,
  PRIMARY KEY (`supplier_pricing_id`),
  INDEX `fk_book_supp_pricing_book_idx` (`book_id` ASC),
  CONSTRAINT `fk_book_supp_pricing_book`
    FOREIGN KEY (`book_id`)
    REFERENCES `bookstore`.`book` (`book_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_book_supp_pricing_pricing`
    FOREIGN KEY (`supplier_pricing_id`)
    REFERENCES `bookstore`.`supplier_pricing` (`supplier_pricing_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`cart` (
  `cart_id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cart_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`in_cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`in_cart` (
  `cart_item_id` INT(11) NOT NULL,
  `cart_id` INT(11) NOT NULL,
  PRIMARY KEY (`cart_item_id`),
  INDEX `in_cart_cart_idx` (`cart_id` ASC),
  CONSTRAINT `in_cart_cart`
    FOREIGN KEY (`cart_id`)
    REFERENCES `bookstore`.`cart` (`cart_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `in_cart_item`
    FOREIGN KEY (`cart_item_id`)
    REFERENCES `bookstore`.`cart_item` (`cart_item_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`order` (
  `order_id` INT(11) NOT NULL AUTO_INCREMENT,
  `placed_date` DATETIME NOT NULL,
  `shipped_date` DATETIME NULL DEFAULT NULL,
  `estimated_delivery` DATETIME NULL DEFAULT NULL,
  `delivered` TINYINT(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`item_in_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`item_in_order` (
  `sold_item_id` INT(11) NOT NULL,
  `order_id` INT(11) NOT NULL,
  PRIMARY KEY (`sold_item_id`),
  INDEX `item_in_order_item_idx` (`order_id` ASC),
  CONSTRAINT `fk_item_in_order_item`
    FOREIGN KEY (`sold_item_id`)
    REFERENCES `bookstore`.`sold_item` (`sold_item_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `item_in_order_item`
    FOREIGN KEY (`order_id`)
    REFERENCES `bookstore`.`order` (`order_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`shipping_facility`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`shipping_facility` (
  `location_id` INT(11) NOT NULL AUTO_INCREMENT,
  `location_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`location_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`order_at`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`order_at` (
  `order_id` INT(11) NOT NULL,
  `location_id` INT(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_order_at_ship_fac_idx` (`location_id` ASC),
  CONSTRAINT `fk_order_at_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `bookstore`.`order` (`order_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_at_ship_fac`
    FOREIGN KEY (`location_id`)
    REFERENCES `bookstore`.`shipping_facility` (`location_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`order_billing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`order_billing` (
  `billing_info_id` INT(11) NOT NULL,
  `order_id` INT(11) NOT NULL,
  PRIMARY KEY (`billing_info_id`),
  INDEX `order_billing_order_idx` (`order_id` ASC),
  CONSTRAINT `order_billing_billing`
    FOREIGN KEY (`billing_info_id`)
    REFERENCES `bookstore`.`billing_info` (`billing_info_id`),
  CONSTRAINT `order_billing_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `bookstore`.`order` (`order_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`shipping_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`shipping_info` (
  `shipping_info_id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`shipping_info_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`order_shipping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`order_shipping` (
  `shipping_info_id` INT(11) NOT NULL,
  `order_id` INT(11) NOT NULL,
  PRIMARY KEY (`shipping_info_id`),
  INDEX `order_shipping_order_idx` (`order_id` ASC),
  CONSTRAINT `order_shipping_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `bookstore`.`order` (`order_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `order_shipping_shipping`
    FOREIGN KEY (`shipping_info_id`)
    REFERENCES `bookstore`.`shipping_info` (`shipping_info_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`phone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`phone` (
  `phone_id` INT(11) NOT NULL AUTO_INCREMENT,
  `region` INT(11) NOT NULL,
  `number` CHAR(10) NOT NULL,
  PRIMARY KEY (`phone_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`phone_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`phone_type` (
  `phone_type_id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`phone_type_id`),
  UNIQUE INDEX `type_UNIQUE` (`type` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`phone_is_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`phone_is_type` (
  `phone_id` INT(11) NOT NULL,
  `phone_type_id` INT(11) NOT NULL,
  PRIMARY KEY (`phone_id`),
  INDEX `fk_phone_is_type_type_idx` (`phone_type_id` ASC),
  CONSTRAINT `fk_phone_is_type_phone`
    FOREIGN KEY (`phone_id`)
    REFERENCES `bookstore`.`phone` (`phone_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_phone_is_type_type`
    FOREIGN KEY (`phone_type_id`)
    REFERENCES `bookstore`.`phone_type` (`phone_type_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`publisher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`publisher` (
  `publisher_id` INT(11) NOT NULL AUTO_INCREMENT,
  `publisher_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`publisher_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`published_by`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`published_by` (
  `book_id` INT(11) NOT NULL,
  `publisher_id` INT(11) NOT NULL,
  PRIMARY KEY (`book_id`),
  INDEX `fk_published_by_pub_idx` (`publisher_id` ASC),
  CONSTRAINT `fk_published_by_book`
    FOREIGN KEY (`book_id`)
    REFERENCES `bookstore`.`book` (`book_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_published_by_pub`
    FOREIGN KEY (`publisher_id`)
    REFERENCES `bookstore`.`publisher` (`publisher_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`publisher_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`publisher_address` (
  `address_id` INT(11) NOT NULL,
  `publisher_id` INT(11) NOT NULL,
  PRIMARY KEY (`address_id`),
  INDEX `fk_pub_addr_pub_idx` (`publisher_id` ASC),
  CONSTRAINT `fk_pub_addr_addr`
    FOREIGN KEY (`address_id`)
    REFERENCES `bookstore`.`address` (`address_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_pub_addr_pub`
    FOREIGN KEY (`publisher_id`)
    REFERENCES `bookstore`.`publisher` (`publisher_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`publisher_bank_acc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`publisher_bank_acc` (
  `bank_acc_id` INT(11) NOT NULL,
  `publisher_id` INT(11) NOT NULL,
  PRIMARY KEY (`bank_acc_id`),
  UNIQUE INDEX `publisher_id_UNIQUE` (`publisher_id` ASC),
  UNIQUE INDEX `bank_acc_id_UNIQUE` (`bank_acc_id` ASC),
  CONSTRAINT `fk_pub_bank_acc_account`
    FOREIGN KEY (`bank_acc_id`)
    REFERENCES `bookstore`.`bank_account` (`bank_acc_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_pub_bank_acc_pub`
    FOREIGN KEY (`publisher_id`)
    REFERENCES `bookstore`.`publisher` (`publisher_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`publisher_phone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`publisher_phone` (
  `publisher_id` INT(11) NOT NULL,
  `phone_id` INT(11) NOT NULL,
  PRIMARY KEY (`phone_id`),
  INDEX `fk_pub_phone_pub_idx` (`publisher_id` ASC),
  CONSTRAINT `fk_pub_phone_phone`
    FOREIGN KEY (`phone_id`)
    REFERENCES `bookstore`.`phone` (`phone_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_pub_phone_pub`
    FOREIGN KEY (`publisher_id`)
    REFERENCES `bookstore`.`publisher` (`publisher_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`shipping_addr`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`shipping_addr` (
  `shipping_info_id` INT(11) NOT NULL,
  `address_id` INT(11) NOT NULL,
  PRIMARY KEY (`shipping_info_id`),
  INDEX `shipping_addr_addr_idx` (`address_id` ASC),
  CONSTRAINT `shipping_addr_addr`
    FOREIGN KEY (`address_id`)
    REFERENCES `bookstore`.`address` (`address_id`),
  CONSTRAINT `shipping_addr_shipping`
    FOREIGN KEY (`shipping_info_id`)
    REFERENCES `bookstore`.`shipping_info` (`shipping_info_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`shipping_fac_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`shipping_fac_address` (
  `address_id` INT(11) NOT NULL,
  `location_id` INT(11) NOT NULL,
  PRIMARY KEY (`location_id`),
  INDEX `ship_fac_addr_addr_idx` (`address_id` ASC),
  CONSTRAINT `ship_fac_addr_addr`
    FOREIGN KEY (`address_id`)
    REFERENCES `bookstore`.`address` (`address_id`),
  CONSTRAINT `ship_fac_addr_ship_fac`
    FOREIGN KEY (`location_id`)
    REFERENCES `bookstore`.`shipping_facility` (`location_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`shipping_name`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`shipping_name` (
  `shipping_info_id` INT(11) NOT NULL,
  `name_id` INT(11) NOT NULL,
  PRIMARY KEY (`shipping_info_id`),
  INDEX `shipping_name_name_idx` (`name_id` ASC),
  CONSTRAINT `shipping_name_name`
    FOREIGN KEY (`name_id`)
    REFERENCES `bookstore`.`name` (`name_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `shipping_name_shipping`
    FOREIGN KEY (`shipping_info_id`)
    REFERENCES `bookstore`.`shipping_info` (`shipping_info_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`user` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `is_admin` TINYINT(4) NOT NULL DEFAULT '0',
  `email` VARCHAR(70) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`user_billing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`user_billing` (
  `user_id` INT(11) NOT NULL,
  `billing_info_id` INT(11) NOT NULL,
  PRIMARY KEY (`billing_info_id`),
  INDEX `user_billing_billing_idx` (`billing_info_id` ASC),
  INDEX `user_billing_user` (`user_id` ASC),
  CONSTRAINT `user_billing_billing`
    FOREIGN KEY (`billing_info_id`)
    REFERENCES `bookstore`.`billing_info` (`billing_info_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `user_billing_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `bookstore`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`user_cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`user_cart` (
  `cart_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`cart_id`),
  INDEX `user_cart_user_idx` (`user_id` ASC),
  CONSTRAINT `user_cart_cart`
    FOREIGN KEY (`cart_id`)
    REFERENCES `bookstore`.`cart` (`cart_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `user_cart_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `bookstore`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`user_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`user_order` (
  `user_id` INT(11) NOT NULL,
  `order_id` INT(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `user_order_user_idx` (`user_id` ASC),
  CONSTRAINT `user_order_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `bookstore`.`order` (`order_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `user_order_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `bookstore`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`user_phone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`user_phone` (
  `phone_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`phone_id`),
  INDEX `fk_user_phone_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_phone_phone`
    FOREIGN KEY (`phone_id`)
    REFERENCES `bookstore`.`phone` (`phone_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_user_phone_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `bookstore`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`user_shipping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`user_shipping` (
  `user_id` INT(11) NOT NULL,
  `shipping_info_id` INT(11) NOT NULL,
  PRIMARY KEY (`shipping_info_id`),
  INDEX `user_shipping_shipping_idx` (`shipping_info_id` ASC),
  INDEX `user_shipping_user` (`user_id` ASC),
  CONSTRAINT `user_shipping_shipping`
    FOREIGN KEY (`shipping_info_id`)
    REFERENCES `bookstore`.`shipping_info` (`shipping_info_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `user_shipping_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `bookstore`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookstore`.`written_by`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`written_by` (
  `author_id` INT(11) NOT NULL,
  `book_id` INT(11) NOT NULL,
  PRIMARY KEY (`author_id`, `book_id`),
  INDEX `fk_written_by_book_idx` (`book_id` ASC),
  CONSTRAINT `fk_written_by_author`
    FOREIGN KEY (`author_id`)
    REFERENCES `bookstore`.`author` (`author_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_written_by_book`
    FOREIGN KEY (`book_id`)
    REFERENCES `bookstore`.`book` (`book_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

USE `bookstore` ;

-- -----------------------------------------------------
-- Placeholder table for view `bookstore`.`inventory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`inventory` (`book_id` INT, `quantity` INT, `pending_orders` INT);

-- -----------------------------------------------------
-- Placeholder table for view `bookstore`.`prev_month_sales_report`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`prev_month_sales_report` (`book_id` INT, `title` INT, `quantity_sold` INT, `revenue` INT);

-- -----------------------------------------------------
-- Placeholder table for view `bookstore`.`sales_report`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookstore`.`sales_report` (`book_id` INT, `profit` INT, `sales` INT, `purchase_cost` INT, `publisher_cost` INT, `total_cost` INT, `total_sold` INT, `total_purchased` INT);

-- -----------------------------------------------------
-- View `bookstore`.`inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bookstore`.`inventory`;
USE `bookstore`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `bookstore`.`inventory` AS select `bookstore`.`book`.`book_id` AS `book_id`,(ifnull(`received_po`.`quantity`,0) - ifnull(`bookstore`.`sold_item`.`quantity`,0)) AS `quantity`,ifnull(`pending_po`.`quantity`,0) AS `pending_orders` from (((((`bookstore`.`book` left join `bookstore`.`book_in_po` on((`bookstore`.`book_in_po`.`book_id` = `bookstore`.`book`.`book_id`))) left join `bookstore`.`purchase_order` `received_po` on(((`received_po`.`po_id` = `bookstore`.`book_in_po`.`po_id`) and (`received_po`.`received` = 1)))) left join `bookstore`.`purchase_order` `pending_po` on(((`pending_po`.`po_id` = `bookstore`.`book_in_po`.`po_id`) and (`pending_po`.`received` = 0)))) left join `bookstore`.`book_sold` on((`bookstore`.`book_sold`.`book_id` = `bookstore`.`book`.`book_id`))) left join `bookstore`.`sold_item` on((`bookstore`.`sold_item`.`sold_item_id` = `bookstore`.`book_sold`.`sold_item_id`))) group by `bookstore`.`book`.`book_id`;

-- -----------------------------------------------------
-- View `bookstore`.`prev_month_sales_report`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bookstore`.`prev_month_sales_report`;
USE `bookstore`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `bookstore`.`prev_month_sales_report` AS select `bookstore`.`book`.`book_id` AS `book_id`,`bookstore`.`book`.`title` AS `title`,ifnull(`t`.`total_sold`,0) AS `quantity_sold`,ifnull(`t`.`revenue`,0) AS `revenue` from (`bookstore`.`book` left join (select `bookstore`.`book`.`book_id` AS `book_id`,sum(ifnull(`bookstore`.`sold_item`.`quantity`,0)) AS `total_sold`,sum((ifnull(`bookstore`.`sold_item`.`quantity`,0) * ifnull(`bookstore`.`sold_item`.`price_per_unit`,0))) AS `revenue` from ((((`bookstore`.`book` left join `bookstore`.`book_sold` on((`bookstore`.`book_sold`.`book_id` = `bookstore`.`book`.`book_id`))) left join `bookstore`.`sold_item` on((`bookstore`.`sold_item`.`sold_item_id` = `bookstore`.`book_sold`.`sold_item_id`))) left join `bookstore`.`item_in_order` on((`bookstore`.`item_in_order`.`sold_item_id` = `bookstore`.`book_sold`.`sold_item_id`))) left join `bookstore`.`order` on((`bookstore`.`order`.`order_id` = `bookstore`.`item_in_order`.`order_id`))) where ((month(`bookstore`.`order`.`placed_date`) = (month(now()) - 1)) or isnull(`bookstore`.`item_in_order`.`order_id`)) group by `bookstore`.`book`.`book_id`) `t` on((`t`.`book_id` = `bookstore`.`book`.`book_id`)));

-- -----------------------------------------------------
-- View `bookstore`.`sales_report`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bookstore`.`sales_report`;
USE `bookstore`;
CREATE OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `bookstore`.`sales_report` AS
  select `t`.`book_id` AS `book_id`,
  (`t`.`sales` - (`t`.`purchase_cost` + `t`.`publisher_cost`)) AS `profit`,
  `t`.`sales` AS `sales`,
  `t`.`purchase_cost` AS `purchase_cost`,
  `t`.`publisher_cost` AS `publisher_cost`,
  (`t`.`purchase_cost` + `t`.`publisher_cost`) AS `total_cost`,
  `t`.`total_sold` AS `total_sold`,`t`.`total_purchased` AS `total_purchased`
  from (
    select `bookstore`.`book`.`book_id` AS `book_id`,
      sum((ifnull(`bookstore`.`sold_item`.`price_per_unit`,0) * ifnull(`bookstore`.`sold_item`.`quantity`,0))) AS `sales`,
      sum((ifnull(`po`.`price_per_unit`,0) * ifnull(`po`.`quantity`,0))) AS `purchase_cost`,
      sum(((ifnull(`bookstore`.`sold_item`.`publisher_rate`,0) * ifnull(`bookstore`.`sold_item`.`price_per_unit`,0)) * ifnull(`bookstore`.`sold_item`.`quantity`,0))) AS `publisher_cost`,
      sum(ifnull(`bookstore`.`sold_item`.`quantity`,0)) AS `total_sold`,
      sum(ifnull(`po`.`quantity`,0)) AS `total_purchased`

    from (
      (((`bookstore`.`book` left join `bookstore`.`book_in_po` on((`bookstore`.`book_in_po`.`book_id` = `bookstore`.`book`.`book_id`))) left join `bookstore`.`purchase_order` `po` on((`po`.`po_id` = `bookstore`.`book_in_po`.`po_id`))) left join `bookstore`.`book_sold` on((`bookstore`.`book_sold`.`book_id` = `bookstore`.`book`.`book_id`))) left join `bookstore`.`sold_item` on((`bookstore`.`sold_item`.`sold_item_id` = `bookstore`.`book_sold`.`sold_item_id`))) group by `bookstore`.`book`.`book_id`) `t`;
USE `bookstore`;


-- -----------------------------------------------------------------
-- All our triggers are only used to clean up tables where there are no FKs for cascading
-- Even then, triggers don't activate FK delete cascades, so we need more triggers
-- -----------------------------------------------------------------

-- -----------------------------------------------------------------
-- When a book is deleted we also delete book_supp_pricing
-- book_supp_pricing also has a trigger to delete supplier_pricing
-- -----------------------------------------------------------------
DELIMITER $$
USE `bookstore`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `bookstore`.`book_BEFORE_DELETE`
BEFORE DELETE ON `bookstore`.`book`
FOR EACH ROW
BEGIN
	DELETE FROM `bookstore`.`book_supp_pricing` WHERE `bookstore`.`book_supp_pricing`.`book_id` = OLD.`book_id`;
END$$

-- -----------------------------------------------------------------
-- When a book is deleted we also delete book_supp_pricing
-- book_supp_pricing also has a trigger to delete supplier_pricing
-- -----------------------------------------------------------------
USE `bookstore`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `bookstore`.`cart_BEFORE_DELETE`
BEFORE DELETE ON `bookstore`.`cart`
FOR EACH ROW
BEGIN
	DELETE FROM `bookstore`.`in_cart` WHERE `bookstore`.`in_cart`.`cart_id` = OLD.`cart_id`;
END$$

-- ----------------------------------------------------------------------------
-- When a in_cart is deleted we also delete cart_item
-- cart also has a trigger to in_cart, but delete cascades will not activate for cart_item from it
-- ----------------------------------------------------------------------------
USE `bookstore`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `bookstore`.`in_cart_AFTER_DELETE`
AFTER DELETE ON `bookstore`.`in_cart`
FOR EACH ROW
BEGIN
	DELETE FROM `bookstore`.`cart_item` WHERE `bookstore`.`cart_item`.`cart_item_id` = `OLD`.`cart_item_id`;
END$$


USE `bookstore`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `bookstore`.`publisher_BEFORE_DELETE`
BEFORE DELETE ON `bookstore`.`publisher`
FOR EACH ROW
BEGIN
	DELETE FROM `bookstore`.`publisher_phone` WHERE `bookstore`.`publisher_phone`.`publisher_id` = OLD.`publisher_id`;
    DELETE FROM `bookstore`.`publisher_address` WHERE `bookstore`.`publisher_address`.`publisher_id` = OLD.`publisher_id`;
    DELETE FROM `bookstore`.`publisher_bank_acc` WHERE `bookstore`.`publisher_bank_acc`.`publisher_id` = OLD.`publisher_id`;
END$$


USE `bookstore`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `bookstore`.`publisher_address_AFTER_DELETE`
AFTER DELETE ON `bookstore`.`publisher_address`
FOR EACH ROW
BEGIN
	DELETE FROM `bookstore`.`address` WHERE `bookstore`.`address`.`address_id` = OLD.`address_id`;
END$$


USE `bookstore`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `bookstore`.`publisher_bank_acc_BEFORE_DELETE`
BEFORE DELETE ON `bookstore`.`publisher_bank_acc`
FOR EACH ROW
BEGIN
	DELETE FROM `bookstore`.`bank_account` WHERE `bookstore`.`bank_account`.`bank_acc_id` = OLD.`bank_acc_id`;
END$$

-- ------------------------------------------------------------------------------------
-- When a publisher_phone is deleted we also delete the phone row
-- Since triggers aren't triggered by cascade deletes we need a trigger on publisher as well
-- ------------------------------------------------------------------------------------
USE `bookstore`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `bookstore`.`publisher_phone_AFTER_DELETE`
AFTER DELETE ON `bookstore`.`publisher_phone`
FOR EACH ROW
BEGIN
	DELETE FROM `bookstore`.`phone` WHERE `bookstore`.`phone`.`phone_id` = OLD.`phone_id`;
END$$

-- ------------------------------------------------------------------------------------
-- When a user is deleted we also delete the user_phone
-- Since triggers aren't triggered by cascade deletes we need this to trigger the next trigger
-- ------------------------------------------------------------------------------------
USE `bookstore`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `bookstore`.`user_BEFORE_DELETE`
BEFORE DELETE ON `bookstore`.`user`
FOR EACH ROW
BEGIN
	DELETE FROM `bookstore`.`user_phone` WHERE `bookstore`.`user_phone`.`user_id` = OLD.`user_id`;
END$$

-- ------------------------------------------------------------------------------------
-- When a user_phone is deleted we also delete the phone row
-- Since triggers aren't triggered by cascade deletes we need a trigger on user as well
-- ------------------------------------------------------------------------------------
USE `bookstore`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `bookstore`.`user_phone_AFTER_DELETE`
AFTER DELETE ON `bookstore`.`user_phone`
FOR EACH ROW
BEGIN
	DELETE FROM `bookstore`.`phone` WHERE `bookstore`.`phone`.`phone_id` = OLD.`phone_id`;
END$$
