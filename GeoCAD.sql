CREATE DATABASE geocad;

USE geocad;

CREATE TABLE SignedPlans
(
plan_number VARCHAR(50) NOT NULL PRIMARY KEY,
location VARCHAR(200),
date_surveyed DATE,
origin ENUM('National', 'State'),
surveyor_name VARCHAR(100),
plan_owner VARCHAR(100)
);

CREATE TABLE GISmaps
(
idx INT AUTO_INCREMENT PRIMARY KEY,
plan_number VARCHAR(50) NOT NULL,
FOREIGN KEY (plan_number) REFERENCES SignedPlans(plan_number),
date_created DATE,
surveyor_name VARCHAR(100),
pillar_id VARCHAR(1000),
co_ordinates VARCHAR(10000)
);

CREATE TABLE surveyjobs
(
id INT PRIMARY KEY AUTO_INCREMENT,
department ENUM('Land', 'Bathymetric', 'Swamp', 'Off-shore'),
origin ENUM('National', 'State'),
surveyed_by VARCHAR(100),
cost DOUBLE
);


