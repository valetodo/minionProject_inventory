/*==============================================================*/
/* Table: CATEGORY                                              */
/*==============================================================*/
create table CATEGORY
(
   ID_CATEGORY          int not null auto_increment  comment '',
   NAME_CATEGORY        varchar(100)  comment '',
   MEASUREMENT          float  comment '',
   primary key (ID_CATEGORY)
);

/*==============================================================*/
/* Table: CONSUME                                               */
/*==============================================================*/
create table CONSUME
(
   ID_CONSUME           int not null auto_increment  comment '',
   EXPIRATION           date  comment '',
   primary key (ID_CONSUME)
);

/*==============================================================*/
/* Table: DURABLE                                               */
/*==============================================================*/
create table DURABLE
(
   ID_DURABLE           int not null auto_increment  comment '',
   SIZE_DURABLE         int  comment '',
   WEIGH_DURABLE        int  comment '',
   primary key (ID_DURABLE)
);

/*==============================================================*/
/* Table: HISTORY                                               */
/*==============================================================*/
create table HISTORY
(
   ID_HISTORY           int not null auto_increment  comment '',
   ID_PRODUCT           int  comment '',
   DATE_HISTORY         timestamp  comment '',
   QUANTITY_INI         int  comment '',
   QUANTITY_FINAL       int  comment '',
   primary key (ID_HISTORY)
);

/*==============================================================*/
/* Table: INVENTORY                                             */
/*==============================================================*/
create table INVENTORY
(
   ID_INVENTORY         int not null auto_increment  comment '',
   NAME_INVENTORY       varchar(100)  comment '',
   DATE_INVETORY        timestamp  comment '',
   primary key (ID_INVENTORY)
);

/*==============================================================*/
/* Table: PRODUCT                                               */
/*==============================================================*/
create table PRODUCT
(
   ID_PRODUCT           int not null auto_increment  comment '',
   ID_DURABLE           int  comment '',
   ID_CONSUME           int  comment '',
   ID_CATEGORY          int  comment '',
   NAME_PRODUCT_        varchar(50)  comment '',
   PRICE                int  comment '',
   STATUS               char(50)  comment '',
   LOCATION             char(50)  comment '',
   QUANTITY             int  comment '',
   STOCK                int  comment '',
   primary key (ID_PRODUCT)
);

/*==============================================================*/
/* Table: PRODUCT_BRAND                                         */
/*==============================================================*/
create table PRODUCT_BRAND
(
   ID_BRAND             int not null auto_increment  comment '',
   ID_PRODUCT           int  comment '',
   NAME_BRAND           varchar(50)  comment '',
   ORIGIN_BRAND         varchar(50)  comment '',
   primary key (ID_BRAND)
);

/*==============================================================*/
/* Table: PRODUCT_INVENTORY                                     */
/*==============================================================*/
create table PRODUCT_INVENTORY
(
   ID_PRODUCT           int not null  comment '',
   ID_INVENTORY         int not null  comment '',
   primary key (ID_PRODUCT, ID_INVENTORY)
);

alter table HISTORY add constraint FK_HISTORY_PRODUCT_H_PRODUCT foreign key (ID_PRODUCT)
      references PRODUCT (ID_PRODUCT) on delete restrict on update restrict;

alter table PRODUCT add constraint FK_PRODUCT_PRODUCT_C_CATEGORY foreign key (ID_CATEGORY)
      references CATEGORY (ID_CATEGORY) on delete restrict on update restrict;

alter table PRODUCT add constraint FK_PRODUCT_PRODUCT_C_CONSUME foreign key (ID_CONSUME)
      references CONSUME (ID_CONSUME) on delete restrict on update restrict;

alter table PRODUCT add constraint FK_PRODUCT_PRODUCT_D_DURABLE foreign key (ID_DURABLE)
      references DURABLE (ID_DURABLE) on delete restrict on update restrict;

alter table PRODUCT_BRAND add constraint FK_PRODUCT__BRAND_PRO_PRODUCT foreign key (ID_PRODUCT)
      references PRODUCT (ID_PRODUCT) on delete restrict on update restrict;

alter table PRODUCT_INVENTORY add constraint FK_PRODUCT__PRODUCT_I_PRODUCT foreign key (ID_PRODUCT)
      references PRODUCT (ID_PRODUCT) on delete restrict on update restrict;

alter table PRODUCT_INVENTORY add constraint FK_PRODUCT__PRODUCT_I_INVENTOR foreign key (ID_INVENTORY)
      references INVENTORY (ID_INVENTORY) on delete restrict on update restrict;

