Food Product Tracker

create table users (
    `user_id` int(12) NOT NULL auto_increment,
    `role_name` varchar(30) NOT NULL,
    `first_name` varchar(25),
    `last_name` varchar(30),
    `username` varchar(25) NOT NULL,
    `password` varchar(40) NOT NULL,	
    `date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY  (user_id)    
);

ALTER TABLE users ADD CONSTRAINT constr_roles UNIQUE (role_name, username);

create table user_roles (
   `username` varchar(25) NOT NULL,
    `role_name` varchar(30) NOT NULL,
    PRIMARY KEY (username, role_name)
);

ALTER TABLE user_roles ADD FOREIGN KEY (role_name, username) 
REFERENCES users(role_name, username);


create table categories (
  `category_id` int(12) NOT NULL auto_increment,
  `category_name` varchar(25) NOT NULL,
  `description` varchar(50),
  PRIMARY KEY  (category_id)
);


create table vendors (
  `vendor_id` int(12) NOT NULL auto_increment,
  `vendor_name` varchar(40) NOT NULL,
  `contact_name` varchar(50),
  `address` varchar(60),
  `city` varchar(30),
  `state_province` varchar(30),
  `postal_code` varchar(12),
  `phone` varchar(15),
  PRIMARY KEY  (vendor_id)
);

create table products (
  `product_id` int(12) NOT NULL auto_increment,
  `add_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `category_name` varchar(25),
  `vendor_name` varchar(40),
  `product_name` varchar(30) NOT NULL,
  `quantity_ordered` int NOT NULL,
  `weight` int NOT NULL,
  `per_unit_cost` numeric(15,2) NOT NULL,
  `total_cost` numeric(15,2),
  `order_date` datetime,
  `date_received` datetime,
  `quantity_received` int,
  `paid_not_received` int,
  `current_quantity` int,
  `current_value` numeric(15,2),
  `expiration_date` datetime,
  `notes` varchar(100),
  `active`  TINYINT(1) DEFAULT 0,
  PRIMARY KEY  (product_id)
);

INSERT INTO categories (category_name, description) VALUES ("Green Tea", "green teas");
INSERT INTO vendors (vendor_name, contact_name, address, city, state_province, postal_code, phone)
	VALUES ("Royal Coffee", "Jim Johnson", "325 Spaight St", "Madison", "WI", "53719", "608-535-2756");
	
INSERT INTO products (add_date, category_name, vendor_name, product_name, quantity_ordered, weight, per_unit_cost)
	VALUES (NOW(), "Coffee", "Royal Coffee", "Indonesian Bali Blue Moon", "5", "60", "3.50");	

