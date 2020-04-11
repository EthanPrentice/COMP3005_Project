-- BOOKS
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Adventure', '200', '60', 'Lord of the Rings Trilogy Set');
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Business', '150', '35', 'Cracking the Tech Career');
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Business', '650', '40', 'Cracking the Coding Interview');
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Fiction', '100', '25', 'Harry Potter and The Philosopher\'s Stone');
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Fiction', '160', '25', 'Harry Potter and The Chamber of Secrets');
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Fiction', '170', '25', 'Harry Potter and The Prizoner of Azkaban');
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Fiction', '250', '25', 'Harry Potter and The Goblet of Fire');
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Fiction', '295', '30', 'Harry Potter and The Order of the Pheonix');
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Fiction', '305', '30', 'Harry Potter and the Half Blood Prince');
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Fiction', '310', '35', 'Harry Potter and the Dealthy Hallows');
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Dystopian', '340', '20', 'The Hunger Games');
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Dystopian', '400', '20', 'Catching Fire');
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Dystopian', '385', '20', 'Mockingjay');
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Dystopian', '410', '35', 'The Maze Runner');
INSERT INTO `bookstore`.`book` (`genre`, `page_count`, `price`, `name`) VALUES ('Science Fiction', '365', '30', 'The Giver');

-- NAMES
INSERT INTO `bookstore`.`name` (`first`, `middle`, `last`, `prefix`) VALUES ('John', 'Ronald Reuel', 'Tolkien', 'Mr.');
INSERT INTO `bookstore`.`name` (`first`, `middle`, `last`, `prefix`) VALUES ('Gayle', '', 'Laakmann McDowell', 'Mrs.');
INSERT INTO `bookstore`.`name` (`first`, `last`, `prefix`) VALUES ('Joanne', 'Rowling', 'Mrs.');
INSERT INTO `bookstore`.`name` (`first`, `last`, `prefix`) VALUES ('Suzanne', 'Collins', 'Mrs.');
INSERT INTO `bookstore`.`name` (`first`, `last`, `prefix`) VALUES ('James', 'Dashner', 'Mr.');
INSERT INTO `bookstore`.`name` (`first`, `last`, `prefix`) VALUES ('Lois', 'Lowry', 'Mrs.');

-- AUTHORS
INSERT INTO `bookstore`.`author` () VALUES ();
INSERT INTO `bookstore`.`author` () VALUES ();
INSERT INTO `bookstore`.`author` () VALUES ();
INSERT INTO `bookstore`.`author` () VALUES ();
INSERT INTO `bookstore`.`author` () VALUES ();
INSERT INTO `bookstore`.`author` () VALUES ();

-- AUTHOR NAMES
INSERT INTO `bookstore`.`author_name` (`author_id`, `name_id`) VALUES ('1', '1');
INSERT INTO `bookstore`.`author_name` (`author_id`, `name_id`) VALUES ('2', '2');
INSERT INTO `bookstore`.`author_name` (`author_id`, `name_id`) VALUES ('3', '3');
INSERT INTO `bookstore`.`author_name` (`author_id`, `name_id`) VALUES ('4', '4');
INSERT INTO `bookstore`.`author_name` (`author_id`, `name_id`) VALUES ('5', '5');
INSERT INTO `bookstore`.`author_name` (`author_id`, `name_id`) VALUES ('6', '6');

-- WRITTEN BY
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('1', '1');
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('2', '2');
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('2', '3');
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('3', '4');
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('3', '5');
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('3', '6');
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('3', '7');
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('3', '8');
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('3', '9');
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('3', '10');
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('4', '11');
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('4', '12');
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('4', '13');
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('5', '14');
INSERT INTO `bookstore`.`written_by` (`author_id`, `book_id`) VALUES ('6', '15');

-- PUBLISHERS
INSERT INTO `bookstore`.`publisher` (`publisher_name`) VALUES ('Allen & Unwin');
INSERT INTO `bookstore`.`publisher` (`publisher_name`) VALUES ('CareerCup');
INSERT INTO `bookstore`.`publisher` (`publisher_name`) VALUES ('Wiley');
INSERT INTO `bookstore`.`publisher` (`publisher_name`) VALUES ('Bloomsbury');
INSERT INTO `bookstore`.`publisher` (`publisher_name`) VALUES ('Scholastic Corporation');
INSERT INTO `bookstore`.`publisher` (`publisher_name`) VALUES ('Dell Publishing');
INSERT INTO `bookstore`.`publisher` (`publisher_name`) VALUES ('Houghton Mifflin Harcourt');

-- PUBLISHED BY
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('1', '1');
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('2', '2');
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('3', '3');
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('4', '4');
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('5', '4');
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('6', '4');
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('7', '4');
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('8', '4');
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('9', '4');
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('10', '4');
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('11', '5');
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('12', '5');
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('13', '5');
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('14', '6');
INSERT INTO `bookstore`.`published_by` (`book_id`, `publisher_id`) VALUES ('15', '7');

-- PURCHASE ORDERS
INSERT INTO `bookstore`.`purchase_order` (`date_ordered`, `received`, `quantity`, `price_per_unit`) VALUES ('2020-03-23', '1', '20', '14');
INSERT INTO `bookstore`.`purchase_order` (`date_ordered`, `received`, `quantity`, `price_per_unit`) VALUES ('2020-04-01', '0', '10', '13');
INSERT INTO `bookstore`.`purchase_order` (`date_ordered`, `received`, `quantity`, `price_per_unit`) VALUES ('2020-03-20', '1', '12', '16');
INSERT INTO `bookstore`.`purchase_order` (`date_ordered`, `received`, `quantity`, `price_per_unit`) VALUES ('2020-03-20', '1', '15', '12');
INSERT INTO `bookstore`.`purchase_order` (`date_ordered`, `received`, `quantity`, `price_per_unit`) VALUES ('2020-03-24', '1', '6', '15');
INSERT INTO `bookstore`.`purchase_order` (`date_ordered`, `received`, `quantity`, `price_per_unit`) VALUES ('2020-03-25', '1', '23', '16');
INSERT INTO `bookstore`.`purchase_order` (`date_ordered`, `received`, `quantity`, `price_per_unit`) VALUES ('2020-04-01', '1', '10', '14');
INSERT INTO `bookstore`.`purchase_order` (`date_ordered`, `received`, `quantity`, `price_per_unit`) VALUES ('2020-04-01', '0', '20', '12');
INSERT INTO `bookstore`.`purchase_order` (`date_ordered`, `received`, `quantity`, `price_per_unit`) VALUES ('2020-03-18', '1', '6', '41');

-- BOOK IN PO
INSERT INTO `bookstore`.`book_in_po` (`po_id`, `book_id`) VALUES ('1', '3');
INSERT INTO `bookstore`.`book_in_po` (`po_id`, `book_id`) VALUES ('2', '11');
INSERT INTO `bookstore`.`book_in_po` (`po_id`, `book_id`) VALUES ('3', '2');
INSERT INTO `bookstore`.`book_in_po` (`po_id`, `book_id`) VALUES ('4', '3');
INSERT INTO `bookstore`.`book_in_po` (`po_id`, `book_id`) VALUES ('5', '5');
INSERT INTO `bookstore`.`book_in_po` (`po_id`, `book_id`) VALUES ('6', '6');
INSERT INTO `bookstore`.`book_in_po` (`po_id`, `book_id`) VALUES ('7', '7');
INSERT INTO `bookstore`.`book_in_po` (`po_id`, `book_id`) VALUES ('8', '15');
INSERT INTO `bookstore`.`book_in_po` (`po_id`, `book_id`) VALUES ('9', '1');

-- BANK ACCOUNTS
INSERT INTO `bookstore`.`bank_account` (`bank_num`,`branch_num`,`account_num`) VALUES ('004','00153','143297653');
INSERT INTO `bookstore`.`bank_account` (`bank_num`,`branch_num`,`account_num`) VALUES ('004','00073','754001501');
INSERT INTO `bookstore`.`bank_account` (`bank_num`,`branch_num`,`account_num`) VALUES ('006','00093','185601582');
INSERT INTO `bookstore`.`bank_account` (`bank_num`,`branch_num`,`account_num`) VALUES ('002','01002','548021693');
INSERT INTO `bookstore`.`bank_account` (`bank_num`,`branch_num`,`account_num`) VALUES ('004','00204','513654802');
INSERT INTO `bookstore`.`bank_account` (`bank_num`,`branch_num`,`account_num`) VALUES ('002','00027','150420648');
INSERT INTO `bookstore`.`bank_account` (`bank_num`,`branch_num`,`account_num`) VALUES ('002','00931','510200489');

-- PUB TO BANK ACCS
INSERT INTO `bookstore`.`publisher_bank_acc` (`bank_acc_id`, `publisher_id`) VALUES ('1', '1');
INSERT INTO `bookstore`.`publisher_bank_acc` (`bank_acc_id`, `publisher_id`) VALUES ('2', '2');
INSERT INTO `bookstore`.`publisher_bank_acc` (`bank_acc_id`, `publisher_id`) VALUES ('3', '3');
INSERT INTO `bookstore`.`publisher_bank_acc` (`bank_acc_id`, `publisher_id`) VALUES ('4', '4');
INSERT INTO `bookstore`.`publisher_bank_acc` (`bank_acc_id`, `publisher_id`) VALUES ('5', '5');
INSERT INTO `bookstore`.`publisher_bank_acc` (`bank_acc_id`, `publisher_id`) VALUES ('6', '6');
INSERT INTO `bookstore`.`publisher_bank_acc` (`bank_acc_id`, `publisher_id`) VALUES ('7', '7');

-- USERS
INSERT INTO `bookstore`.`user` (`username`, `password`, `is_admin`, `email`) VALUES ('EthanP', 'COMP3005', '1', 'ethanprentice@cmail.carleton.ca');
INSERT INTO `bookstore`.`user` (`username`, `password`, `is_admin`, `email`) VALUES ('KurtK', 'a_password', '0', 'kurt@carleton.ca');
INSERT INTO `bookstore`.`user` (`username`, `password`, `is_admin`, `email`) VALUES ('RileyD', 'another_one', '0', 'riley@carleton.ca');
INSERT INTO `bookstore`.`user` (`username`, `password`, `is_admin`, `email`) VALUES ('BusinessPartner', 'secure_pwd', '1', 'business@partner.com');
INSERT INTO `bookstore`.`user` (`username`, `password`, `is_admin`, `email`) VALUES ('SomeJoe', 'yeehaw', '0', 'joe@some.com');
INSERT INTO `bookstore`.`user` (`username`, `password`, `is_admin`, `email`) VALUES ('SomeShmoe', 'password123', '0', 'schmoe@some.com');

-- PHONE TYPE
INSERT INTO `bookstore`.`phone_type` (`type`) VALUES ('CELL');
INSERT INTO `bookstore`.`phone_type` (`type`) VALUES ('HOME');
INSERT INTO `bookstore`.`phone_type` (`type`) VALUES ('WORK');
INSERT INTO `bookstore`.`phone_type` (`type`) VALUES ('CORPORATE');
INSERT INTO `bookstore`.`phone_type` (`type`) VALUES ('OTHER');

-- PHONE NUMBERS
INSERT INTO `bookstore`.`phone` (`region`, `number`) VALUES ('1', '8005558484');
INSERT INTO `bookstore`.`phone` (`region`, `number`) VALUES ('1', '8005556242');
INSERT INTO `bookstore`.`phone` (`region`, `number`) VALUES ('1', '6135556125');
INSERT INTO `bookstore`.`phone` (`region`, `number`) VALUES ('1', '8005551002');
INSERT INTO `bookstore`.`phone` (`region`, `number`) VALUES ('1', '7335556055');
INSERT INTO `bookstore`.`phone` (`region`, `number`) VALUES ('1', '8005554020');
INSERT INTO `bookstore`.`phone` (`region`, `number`) VALUES ('1', '8005553614');
INSERT INTO `bookstore`.`phone` (`region`, `number`) VALUES ('1', '8005554747');
INSERT INTO `bookstore`.`phone` (`region`, `number`) VALUES ('1', '2265554496');
INSERT INTO `bookstore`.`phone` (`region`, `number`) VALUES ('1', '6135552048');
INSERT INTO `bookstore`.`phone` (`region`, `number`) VALUES ('1', '5195550230');
INSERT INTO `bookstore`.`phone` (`region`, `number`) VALUES ('1', '5195554000');
INSERT INTO `bookstore`.`phone` (`region`, `number`) VALUES ('1', '5195559642');

-- PHONE IS TYPE
INSERT INTO `bookstore`.`phone_is_type` (`phone_id`, `phone_type_id`) VALUES ('1', '4');
INSERT INTO `bookstore`.`phone_is_type` (`phone_id`, `phone_type_id`) VALUES ('2', '4');
INSERT INTO `bookstore`.`phone_is_type` (`phone_id`, `phone_type_id`) VALUES ('3', '4');
INSERT INTO `bookstore`.`phone_is_type` (`phone_id`, `phone_type_id`) VALUES ('4', '4');
INSERT INTO `bookstore`.`phone_is_type` (`phone_id`, `phone_type_id`) VALUES ('5', '4');
INSERT INTO `bookstore`.`phone_is_type` (`phone_id`, `phone_type_id`) VALUES ('6', '4');
INSERT INTO `bookstore`.`phone_is_type` (`phone_id`, `phone_type_id`) VALUES ('7', '4');
INSERT INTO `bookstore`.`phone_is_type` (`phone_id`, `phone_type_id`) VALUES ('8', '1');
INSERT INTO `bookstore`.`phone_is_type` (`phone_id`, `phone_type_id`) VALUES ('9', '1');
INSERT INTO `bookstore`.`phone_is_type` (`phone_id`, `phone_type_id`) VALUES ('10', '2');
INSERT INTO `bookstore`.`phone_is_type` (`phone_id`, `phone_type_id`) VALUES ('11', '3');
INSERT INTO `bookstore`.`phone_is_type` (`phone_id`, `phone_type_id`) VALUES ('12', '5');
INSERT INTO `bookstore`.`phone_is_type` (`phone_id`, `phone_type_id`) VALUES ('13', '5');

-- PUBLISHER HAS PHONE
INSERT INTO `bookstore`.`publisher_phone` (`publisher_id`, `phone_id`) VALUES ('1', '1');
INSERT INTO `bookstore`.`publisher_phone` (`publisher_id`, `phone_id`) VALUES ('2', '2');
INSERT INTO `bookstore`.`publisher_phone` (`publisher_id`, `phone_id`) VALUES ('3', '3');
INSERT INTO `bookstore`.`publisher_phone` (`publisher_id`, `phone_id`) VALUES ('4', '4');
INSERT INTO `bookstore`.`publisher_phone` (`publisher_id`, `phone_id`) VALUES ('5', '5');
INSERT INTO `bookstore`.`publisher_phone` (`publisher_id`, `phone_id`) VALUES ('6', '6');
INSERT INTO `bookstore`.`publisher_phone` (`publisher_id`, `phone_id`) VALUES ('7', '7');

-- USER HAS PHONE
INSERT INTO `bookstore`.`user_phone` (`phone_id`, `user_id`) VALUES ('8', '1');
INSERT INTO `bookstore`.`user_phone` (`phone_id`, `user_id`) VALUES ('9', '2');
INSERT INTO `bookstore`.`user_phone` (`phone_id`, `user_id`) VALUES ('10', '3');
INSERT INTO `bookstore`.`user_phone` (`phone_id`, `user_id`) VALUES ('11', '4');
INSERT INTO `bookstore`.`user_phone` (`phone_id`, `user_id`) VALUES ('12', '5');
INSERT INTO `bookstore`.`user_phone` (`phone_id`, `user_id`) VALUES ('13', '6');

-- ADDRESS
INSERT INTO `bookstore`.`address` (`street_num`, `street`, `city`, `country`, `postal_code`) VALUES ('26', 'Boswell Street', 'London', 'England', 'WC1N 3JZ');
INSERT INTO `bookstore`.`address` (`street_num`, `street`, `city`, `state`, `country`, `postal_code`) VALUES ('123', 'Sesame Street', 'New York City', 'NY', 'United States', '10021');
INSERT INTO `bookstore`.`address` (`street_num`, `street`, `city`, `state`, `country`, `postal_code`) VALUES ('90', 'Eglinton Ave. E.', 'Toronto', 'ON', 'Canada', 'M4P 2Y3');
INSERT INTO `bookstore`.`address` (`unit`, `street_num`, `street`, `city`, `state`, `country`, `postal_code`) VALUES ('5', '1385', 'Broadway', 'New York City', 'NY', 'United States', '10018');
INSERT INTO `bookstore`.`address` (`street_num`, `street`, `city`, `state`, `country`, `postal_code`) VALUES ('604', 'King Street', 'Toronto', 'ON', 'Canada', 'M5V 1E1');
INSERT INTO `bookstore`.`address` (`street_num`, `street`, `city`, `state`, `country`, `postal_code`) VALUES ('1745', 'Broadway', 'New York City', 'NY', 'United States', '10019');
INSERT INTO `bookstore`.`address` (`street_num`, `street`, `city`, `state`, `country`, `postal_code`) VALUES ('125', 'High Street', 'Boston', 'MA', 'United States', '02110');
INSERT INTO `bookstore`.`address` (`street_num`, `street`, `city`, `state`, `country`, `postal_code`) VALUES ('6301', 'Silver Dart Drive', 'Mississauga', 'ON', 'Canada', 'L5P 1B2');
INSERT INTO `bookstore`.`address` (`street_num`, `street`, `city`, `state`, `country`, `postal_code`) VALUES ('1000', 'Airport Parkway', 'Ottawa', 'ON', 'Canada', 'K1V 9B4');
INSERT INTO `bookstore`.`address` (`street_num`, `street`, `city`, `state`, `country`, `postal_code`) VALUES ('145', 'Merivale', 'Nepean', 'ON', 'Canada', 'K2G 3N4');
INSERT INTO `bookstore`.`address` (`street_num`, `street`, `city`, `state`, `country`, `postal_code`) VALUES ('400', 'Palladium', 'Kanata', 'ON', 'Canada', 'K2V 1E2');
INSERT INTO `bookstore`.`address` (`street_num`, `street`, `city`, `state`, `country`, `postal_code`) VALUES ('55', 'Beaver Creek Road', 'Richmond Hill', 'ON', 'Canada', 'L4V 1E8');

-- PUBLISHER HAS ADDRESS
INSERT INTO `bookstore`.`publisher_address` (`address_id`, `publisher_id`) VALUES ('1', '1');
INSERT INTO `bookstore`.`publisher_address` (`address_id`, `publisher_id`) VALUES ('2', '2');
INSERT INTO `bookstore`.`publisher_address` (`address_id`, `publisher_id`) VALUES ('3', '3');
INSERT INTO `bookstore`.`publisher_address` (`address_id`, `publisher_id`) VALUES ('4', '4');
INSERT INTO `bookstore`.`publisher_address` (`address_id`, `publisher_id`) VALUES ('5', '5');
INSERT INTO `bookstore`.`publisher_address` (`address_id`, `publisher_id`) VALUES ('6', '6');
INSERT INTO `bookstore`.`publisher_address` (`address_id`, `publisher_id`) VALUES ('7', '7');

-- SHIPPING FACILITY
INSERT INTO `bookstore`.`shipping_facility` (`location_name`) VALUES ('Toronto Pearson Airport');
INSERT INTO `bookstore`.`shipping_facility` (`location_name`) VALUES ('Ottawa International Airport');
INSERT INTO `bookstore`.`shipping_facility` (`location_name`) VALUES ('Nepean Sorting Facility');
INSERT INTO `bookstore`.`shipping_facility` (`location_name`) VALUES ('Kanata Sorting Facility');
INSERT INTO `bookstore`.`shipping_facility` (`location_name`) VALUES ('Toronto Distribution Center');

-- SHIPPING FACILITY HAS ADDRESS
INSERT INTO `bookstore`.`shipping_fac_address` (`address_id`, `location_id`) VALUES ('8', '1');
INSERT INTO `bookstore`.`shipping_fac_address` (`address_id`, `location_id`) VALUES ('9', '2');
INSERT INTO `bookstore`.`shipping_fac_address` (`address_id`, `location_id`) VALUES ('10', '3');
INSERT INTO `bookstore`.`shipping_fac_address` (`address_id`, `location_id`) VALUES ('11', '4');
INSERT INTO `bookstore`.`shipping_fac_address` (`address_id`, `location_id`) VALUES ('12', '5');

-- ORDERS
INSERT INTO `bookstore`.`order` (`placed_date`, `shipped_date`, `estimate_delivery`) VALUES ('2020-03-29', '2020-03-31', '2020-04-05');
INSERT INTO `bookstore`.`order` (`placed_date`, `shipped_date`, `estimate_delivery`) VALUES ('2020-03-31', '2020-04-02', '2020-04-07');
INSERT INTO `bookstore`.`order` (`placed_date`, `estimate_delivery`) VALUES ('2020-04-01', '2020-04-08');

-- ORDER USERS
INSERT INTO `bookstore`.`user_order` (`user_id`, `order_id`) VALUES ('2', '1');
INSERT INTO `bookstore`.`user_order` (`user_id`, `order_id`) VALUES ('3', '2');
INSERT INTO `bookstore`.`user_order` (`user_id`, `order_id`) VALUES ('4', '3');

-- ORDER LOCATIONS
INSERT INTO `bookstore`.`order_at` (`order_id`, `location_id`) VALUES ('1', '1');
INSERT INTO `bookstore`.`order_at` (`order_id`, `location_id`) VALUES ('2', '2');
INSERT INTO `bookstore`.`order_at` (`order_id`, `location_id`) VALUES ('3', '5');

-- SOLD ITEMS
INSERT INTO `bookstore`.`sold_item` (`price_per_unit`, `quantity`) VALUES ('30', '1');
INSERT INTO `bookstore`.`sold_item` (`price_per_unit`, `quantity`) VALUES ('25', '1');
INSERT INTO `bookstore`.`sold_item` (`price_per_unit`, `quantity`) VALUES ('32', '1');
INSERT INTO `bookstore`.`sold_item` (`price_per_unit`, `quantity`) VALUES ('18', '2');
INSERT INTO `bookstore`.`sold_item` (`price_per_unit`, `quantity`) VALUES ('55', '1');
INSERT INTO `bookstore`.`sold_item` (`price_per_unit`, `quantity`) VALUES ('20', '2');

-- BOOK SOLD
INSERT INTO `bookstore`.`book_sold` (`sold_item_id`, `book_id`) VALUES ('1', '2');
INSERT INTO `bookstore`.`book_sold` (`sold_item_id`, `book_id`) VALUES ('2', '5');
INSERT INTO `bookstore`.`book_sold` (`sold_item_id`, `book_id`) VALUES ('3', '2');
INSERT INTO `bookstore`.`book_sold` (`sold_item_id`, `book_id`) VALUES ('4', '7');
INSERT INTO `bookstore`.`book_sold` (`sold_item_id`, `book_id`) VALUES ('5', '1');
INSERT INTO `bookstore`.`book_sold` (`sold_item_id`, `book_id`) VALUES ('6', '6');

-- SOLD ITEM IN ORDER
INSERT INTO `bookstore`.`item_in_order` (`sold_item_id`, `order_id`) VALUES ('1', '1');
INSERT INTO `bookstore`.`item_in_order` (`sold_item_id`, `order_id`) VALUES ('2', '1');
INSERT INTO `bookstore`.`item_in_order` (`sold_item_id`, `order_id`) VALUES ('3', '2');
INSERT INTO `bookstore`.`item_in_order` (`sold_item_id`, `order_id`) VALUES ('4', '3');
INSERT INTO `bookstore`.`item_in_order` (`sold_item_id`, `order_id`) VALUES ('5', '3');
INSERT INTO `bookstore`.`item_in_order` (`sold_item_id`, `order_id`) VALUES ('6', '3');

-- CARTS
INSERT INTO `bookstore`.`cart` () VALUES ();
INSERT INTO `bookstore`.`cart` () VALUES ();
INSERT INTO `bookstore`.`cart` () VALUES ();
INSERT INTO `bookstore`.`cart` () VALUES ();
INSERT INTO `bookstore`.`cart` () VALUES ();
INSERT INTO `bookstore`.`cart` () VALUES ();

-- USER CARTS
INSERT INTO `bookstore`.`user_cart` (`cart_id`, `user_id`) VALUES ('1', '1');
INSERT INTO `bookstore`.`user_cart` (`cart_id`, `user_id`) VALUES ('2', '2');
INSERT INTO `bookstore`.`user_cart` (`cart_id`, `user_id`) VALUES ('3', '3');
INSERT INTO `bookstore`.`user_cart` (`cart_id`, `user_id`) VALUES ('4', '4');
INSERT INTO `bookstore`.`user_cart` (`cart_id`, `user_id`) VALUES ('5', '5');
INSERT INTO `bookstore`.`user_cart` (`cart_id`, `user_id`) VALUES ('6', '6');

-- CART ITEMS
INSERT INTO `bookstore`.`cart_item` (`quantity`) VALUES ('1');
INSERT INTO `bookstore`.`cart_item` (`quantity`) VALUES ('1');

-- IN CART
INSERT INTO `bookstore`.`in_cart` (`cart_item_id`, `cart_id`) VALUES ('1', '1');
INSERT INTO `bookstore`.`in_cart` (`cart_item_id`, `cart_id`) VALUES ('2', '1');

-- BOOK IN ITEM
INSERT INTO `bookstore`.`book_in_item` (`cart_item_id`, `book_id`) VALUES ('1', '2');
INSERT INTO `bookstore`.`book_in_item` (`cart_item_id`, `book_id`) VALUES ('2', '3');


-- SUPPLIER PRICING
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('20', '0.21');
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('10', '0.18');
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('12', '0.24');
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('9', '0.12');
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('5', '0.3');
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('12', '0.1');
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('15', '0');
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('15', '0');
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('12', '0.2');
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('10', '0.1');
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('12', '0.1');
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('8', '0.13');
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('8', '0.13');
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('9', '0.23');
INSERT INTO `bookstore`.`supplier_pricing` (`purchase_price`, `publisher_rate`) VALUES ('7', '0.2');

-- BOOK TO SUPPLER PRICING
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('1', '1');
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('2', '2');
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('3', '3');
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('4', '4');
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('5', '5');
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('6', '6');
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('7', '7');
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('8', '8');
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('9', '9');
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('10', '10');
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('11', '11');
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('12', '12');
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('13', '13');
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('14', '14');
INSERT INTO `bookstore`.`book_supp_pricing` (`supplier_pricing`, `book_pricing`) VALUES ('15', '15');
