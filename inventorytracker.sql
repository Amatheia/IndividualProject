Food Inventory Tracker

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

ALTER TABLE user_roles ADD CONSTRAINT user_roles_ibfk_1 FOREIGN KEY (role_name, username)
    REFERENCES users(role_name, username) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE TRIGGER role_after_insert AFTER INSERT ON `users` 
    FOR EACH ROW
    INSERT INTO user_roles (username, role_name) VALUES (new.username, new.role_name);

    
create table tasks (
  `task_id` int(12) NOT NULL auto_increment,
  `task_description` varchar(200) NOT NULL,
  `task_date_added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY  (task_id)
);    


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
  `product_id` int(12) NOT NULL auto_increment PRIMARY KEY,
  `add_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `category_id` int(12) NOT NULL,
  `vendor_id` int(12) NOT NULL,
  `product_name` varchar(30) NOT NULL,
  `quantity_ordered` int NOT NULL,
  `weight` numeric(15,4) NOT NULL,
  `per_unit_cost` numeric(15,2) NOT NULL,
  `total_cost` numeric(15,2),
  `order_date` datetime,
  `date_received` datetime,
  `quantity_received` int,
  `paid_not_received` int,
  `current_quantity` int,
  `current_value` numeric(15,2),
  `expiration` varchar(30),
  `notes` varchar(100),
  `active`  TINYINT(1) DEFAULT 0,
  FOREIGN KEY fk_cat(category_id)
  REFERENCES categories(category_id)
  ON UPDATE CASCADE
  ON DELETE RESTRICT,
  FOREIGN KEY fk_vend(vendor_id)
  REFERENCES vendors(vendor_id)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
);	

