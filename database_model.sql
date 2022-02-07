CREATE OR REPLACE TYPE ChassisModel_Type as OBJECT(
chassisModelID number(8),
length_ number(8,2));
/
CREATE TABLE ChassisModel_Table of ChassisModel_Type;

alter table ChassisModel_Table
add(constraint ChassisModelID_pk primary key (ChassisModelID));

CREATE OR REPLACE TYPE Model_Type FORCE as OBJECT(
modelID number(8),
modelName Varchar2(25),
ChassisModelref REF ChassisModel_Type)
not final;
/
CREATE TABLE Model_Table of Model_Type;

alter table Model_Table
add(constraint ModelID_pk primary key (ModelID));

CREATE OR REPLACE TYPE TruckModel_Type UNDER Model_Type (
truckModelID number(8),
truckModelName Varchar2(35),
towingCapacity number(8),
noOfRearAxles number(2));
/
CREATE TABLE TruckModel_Table of TruckModel_Type; 

alter table TruckModel_Table
add(constraint TruckModel_ModelID_pk primary key (ModelID));

CREATE OR REPLACE TYPE BusVariantModels_Type under Model_Type(
busVariantModelID number(8),
modelNarianrModelName Varchar2(35),
width number(8,2),
engineModel varchar(25),
transmissionModel varchar(25));
/
CREATE TABLE BusVariantModels_Table of BusVariantModels_Type;

alter table BusVariantModels_Table
add(constraint BusVariantModels_ModelID_pk primary key (ModelID));

Drop Table Company_Table;


CREATE OR REPLACE TYPE Company_Type as OBJECT(
companyID number(8),
companyName Varchar2(25),
MEMBER FUNCTION numberOFBuses RETURN number);
/

CREATE OR REPLACE TYPE BODY Company_Type AS
MEMBER FUNCTION numberOFBuses RETURN number IS
N number;
BEGIN
Select count(E.BusID) into N from Bus_table E where e.companyref.CompanyID=self.CompanyID;
Return N;
END numberOFBuses ; 
END;
/  
  
CREATE TABLE Company_Table of Company_Type;

alter table Company_Table
add(constraint CompanyID_pk primary key (CompanyID));

CREATE OR REPLACE TYPE Bus_Type FORCE as OBJECT(
busID number(8),
manufacturingDate Date,
purchaseDate Date,
registrationNo Varchar2(15),
engineNo Varchar2(25),
CompanyRef REF Company_Type,
BusVariantModelRef REF BusVariantModels_Type );
/
CREATE TABLE Bus_Table OF Bus_Type;

alter table Bus_Table
add(constraint BusID_pk primary key (BusID));

CREATE OR REPLACE TYPE Accessorys_Type as OBJECT(
accessoryID number(8),
accessoryType Varchar(25),
quantity number(8),
BusVariantModelREf REF BusVariantModels_Type );
/
CREATE TABLE Accessorys_Table of Accessorys_Type;

alter table Accessorys_Table
add(constraint accessoryID_pk primary key (AccessoryID));

INSERT INTO CHASSISMODEL_TABLE
values (1, 20);
INSERT INTO CHASSISMODEL_TABLE
values (2, 30);
INSERT INTO CHASSISMODEL_TABLE
values (3, 35);

INSERT INTO MODEL_TABLE
Select 1,'Toyota' , REF(C) From ChassisModel_Table C where C.chassisModelID=1;
INSERT INTO MODEL_TABLE
Select 2,'Mazda', REF(C) FROM ChassisModel_Table C where C.chassisModelID=2;
INSERT INTO MODEL_TABLE
Select 3,'Subaru', REF(C) FROM ChassisModel_Table C where C.chassisModelID=3;

INSERT INTO busvariantmodels_table
select f.*,1,'City BUS',67,'Long Haul','78long' from Model_Table f where f.ModelID=1 ; 
INSERT INTO busvariantmodels_table
select f.*,2,'Lag BUS',68,'Short Haul','2bcegs678' from Model_Table f where f.ModelID=2 ; 
INSERT INTO busvariantmodels_table
select f.*,3,'Eko Bus',69,'Haul','3cdfht789' from Model_Table f where f.ModelID=3 ; 

INSERT INTO TRUCKMODEL_TABLE
select g.*,1,'Jaguar',20,4 from model_table g where  g.ModelID=1;
INSERT INTO TRUCKMODEL_TABLE
select g.*,2,'HunchBack',30,5 from model_table g where  g.ModelID=2;
INSERT INTO TRUCKMODEL_TABLE
select g.*,3,'Caterpillar',35,6 from model_table g where  g.ModelID=3;

INSERT INTO COMPANY_TABLE
values( 1, 'Southern Metro');
INSERT INTO COMPANY_TABLE
values( 2, 'Northern Buses');
INSERT INTO COMPANY_TABLE
values( 3, 'Western Line');

INSERT INTO accessorys_table
select 1,'headlight', 2, REF(D) from busvariantmodels_table D where D.ModelID=1;
INSERT INTO accessorys_table
select 2,'Tyres', 4, REF(D) from busvariantmodels_table D where D.ModelID=2;
INSERT INTO accessorys_table
select 3,'CarSeats', 3, REF(D) from busvariantmodels_table D where D.ModelID=3;

INSERT INTO BUS_TABLE 
Select 1,TO_DATE('25/October/2000','DD/MON/YY'),TO_DATE('25/November/2000','DD/MON/YY'),'99AA','12keh897l',REF(A), REF(B) 
From Company_Table A, BusVariantModels_Table B where A.companyID=1 and B.modelID=1;
INSERT INTO BUS_TABLE 
Select 2,TO_DATE('25/October/1999','DD/MON/YY'),TO_DATE('25/November/1999','DD/MON/YY'),'88AA','13keh897l',REF(A), REF(B) 
From Company_Table A, BusVariantModels_Table B where A.companyID=2 and B.modelID=2;
INSERT INTO BUS_TABLE
Select 3,TO_DATE('25/October/1988','DD/MON/YY'),TO_DATE('25/November/1988','DD/MON/YY'),'77AA','14keh897l',REF(A), REF(B) 
From Company_Table A, BusVariantModels_Table B where A.companyID=3 and B.modelID=3;
INSERT INTO BUS_TABLE
Select 4,TO_DATE('25/October/1997','DD/MON/YY'),TO_DATE('25/November/1997','DD/MON/YY'),'66bb','15keh8972',REF(A), REF(B) 
From Company_Table A, BusVariantModels_Table B where A.companyID=1 and B.modelID=1;
INSERT INTO BUS_TABLE
Select 5,TO_DATE('25/October/1996','DD/MON/YY'),TO_DATE('25/November/1996','DD/MON/YY'),'55CC','16keh8973',REF(A), REF(B) 
From Company_Table A, BusVariantModels_Table B where A.companyID=2 and B.modelID=2;
INSERT INTO BUS_TABLE
Select 6,TO_DATE('25/October/1985','DD/MON/YY'),TO_DATE('25/November/1985','DD/MON/YY'),'44NN','17keh89790',REF(A), REF(B) 
From Company_Table A, BusVariantModels_Table B where A.companyID=3 and B.modelID=3;



Select C.CompanyID, C.CompanyName,C.numberOFBuses() from Company_Table C;

