
drop table if exists DOBAVLJAC;

drop table if exists FABRIKA;

drop table if exists IZVESTAJ;

drop table if exists KUPAC;

drop table if exists NARUCENSLADOLED;

drop table if exists PORUDZBINA;

drop table if exists PROIZVODNJA;

drop table if exists RECEPT;

drop table if exists SIROVINE;

drop table if exists SIROVINEUSKLADISTU;

drop table if exists SIROVINE_ZA_RECEPT;

drop table if exists SKLADISTE;

drop table if exists TIPIZVESTAJA;

drop table if exists ULOGA;

drop table if exists VRSTA_SLADOLEDA;

drop table if exists ZAPOSLENI;

/*==============================================================*/
/* Table: DOBAVLJAC                                             */
/*==============================================================*/
create table DOBAVLJAC
(
   DOBAVLJACID          int(10) not null auto_increment,
   IME_DOBAVLJACA       varchar(40) not null,
   primary key (DOBAVLJACID)
);

/*==============================================================*/
/* Table: FABRIKA                                               */
/*==============================================================*/
create table FABRIKA
(
   FABRIKAID            int(10) not null auto_increment,
   NAZIV_FABRIKE        varchar(256) not null,
   primary key (FABRIKAID)
);

/*==============================================================*/
/* Table: IZVESTAJ                                              */
/*==============================================================*/
create table IZVESTAJ
(
   IZVESTAJID           int(10) not null auto_increment,
   PROIZVODNJAID        int,
   TIPID                int not null,
   SKLADISTEID          int,
   DATUM                date not null,
   IMESIROVINE          varchar(30),
   KOLICINASIROVINA     int,
   IMEPROIZVODA         varchar(30),
   KOLICINAPROIZVODA    int,
   KOLICINAPROIZVEDENOGSLADOLEDA int,
   KOLICINAUTROSENIHSIROVINA int,
   primary key (IZVESTAJID)
);

/*==============================================================*/
/* Table: KUPAC                                                 */
/*==============================================================*/
create table KUPAC
(
   KUPACID              int(10) not null auto_increment,
   IME_KUPCA            varchar(40) not null,
   primary key (KUPACID)
);

/*==============================================================*/
/* Table: NARUCENSLADOLED                                       */
/*==============================================================*/
create table NARUCENSLADOLED
(
   PORUDZBINAID         int not null,
   SLADOLEDID           int not null,
   primary key (PORUDZBINAID, SLADOLEDID)
);

/*==============================================================*/
/* Table: PORUDZBINA                                            */
/*==============================================================*/
create table PORUDZBINA
(
   PORUDZBINAID         int(10) not null auto_increment,
   KUPACID              int not null,
   IME_NARUCENOG_PROIZVODA varchar(40) not null,
   KOLICINA_NARUCENOG_PROIZVODA int not null,
   VREME_NAR            date not null,
   VREMEISPORUKE        date not null,
   primary key (PORUDZBINAID)
);

/*==============================================================*/
/* Table: PROIZVODNJA                                           */
/*==============================================================*/
create table PROIZVODNJA
(
   PROIZVODNJAID        int(10) not null auto_increment,
   FABRIKAID            int not null,
   NAZIV_PROIZVODNJE    varchar(20) not null,
   primary key (PROIZVODNJAID)
);

/*==============================================================*/
/* Table: RECEPT                                                */
/*==============================================================*/
create table RECEPT
(
   RECEPTID             int(10) not null auto_increment,
   SLADOLEDID           int not null,
   TEKST_RECEPTA        text not null,
   primary key (RECEPTID)
);

/*==============================================================*/
/* Table: SIROVINE                                              */
/*==============================================================*/
create table SIROVINE
(
   SIROVINAID           int(10) not null auto_increment,
   DOBAVLJACID          int,
   NAZIV_SIROVINE       varchar(40) not null,
   primary key (SIROVINAID)
);

/*==============================================================*/
/* Table: SIROVINEUSKLADISTU                                    */
/*==============================================================*/
create table SIROVINEUSKLADISTU
(
   SIROVINAID           int not null,
   SKLADISTEID          int not null,
   KOLICINASIROVINEUSKL int not null,
   primary key (SIROVINAID, SKLADISTEID)
);

/*==============================================================*/
/* Table: SIROVINE_ZA_RECEPT                                    */
/*==============================================================*/
create table SIROVINE_ZA_RECEPT
(
   RECEPTID             int not null,
   SIROVINAID           int not null,
   KOLICSIROVINERECEPT  int not null,
   primary key (RECEPTID, SIROVINAID)
);

/*==============================================================*/
/* Table: SKLADISTE                                             */
/*==============================================================*/
create table SKLADISTE
(
   SKLADISTEID          int(10) not null auto_increment,
   NAMENA               varchar(30) not null,
   primary key (SKLADISTEID)
);

/*==============================================================*/
/* Table: TIPIZVESTAJA                                          */
/*==============================================================*/
create table TIPIZVESTAJA
(
   TIPID                int(10) not null auto_increment,
   OPISTIPA             varchar(200) not null,
   primary key (TIPID)
);

/*==============================================================*/
/* Table: ULOGA                                                 */
/*==============================================================*/
create table ULOGA
(
   ULOGAID              int(10) not null auto_increment,
   NAZIV                varchar(20) not null,
   primary key (ULOGAID)
);

/*==============================================================*/
/* Table: VRSTA_SLADOLEDA                                       */
/*==============================================================*/
create table VRSTA_SLADOLEDA
(
   SLADOLEDID           int(10) not null auto_increment,
   PROIZVODNJAID        int,
   BRENDIRANO_IME       varchar(40) not null,
   CENA                 int not null,
   primary key (SLADOLEDID)
);

/*==============================================================*/
/* Table: ZAPOSLENI                                             */
/*==============================================================*/
create table ZAPOSLENI
(
   ZAPOSLENIID          int(10) not null auto_increment,
   ULOGAID              int not null,
   PROIZVODNJAID        int,
   SKLADISTEID          int,
   IME_ZAPOSLENOG       varchar(40) not null,
   PREZIME_ZAPOSLENOG   varchar(40) not null,
   JMBG                 varchar(13) not null,
   primary key (ZAPOSLENIID)
);

alter table IZVESTAJ add constraint FK_IMA foreign key (TIPID)
      references TIPIZVESTAJA (TIPID) on delete cascade on update cascade;

alter table IZVESTAJ add constraint FK_IZVESTAJPROIZVODNJE foreign key (PROIZVODNJAID)
      references PROIZVODNJA (PROIZVODNJAID) on delete cascade on update cascade;

alter table IZVESTAJ add constraint FK_SKLADISTEIZVESTAJ foreign key (SKLADISTEID)
      references SKLADISTE (SKLADISTEID) on delete cascade on update cascade;

alter table NARUCENSLADOLED add constraint FK_NARUCENSLADOLED foreign key (PORUDZBINAID)
      references PORUDZBINA (PORUDZBINAID) on delete cascade on update cascade;

alter table NARUCENSLADOLED add constraint FK_NARUCENSLADOLED2 foreign key (SLADOLEDID)
      references VRSTA_SLADOLEDA (SLADOLEDID) on delete cascade on update cascade;

alter table PORUDZBINA add constraint FK_KUPACNARUCUJE foreign key (KUPACID)
      references KUPAC (KUPACID) on delete cascade on update cascade;

alter table PROIZVODNJA add constraint FK_RADI foreign key (FABRIKAID)
      references FABRIKA (FABRIKAID) on delete cascade on update cascade;

alter table RECEPT add constraint FK_PRAVISEPO foreign key (SLADOLEDID)
      references VRSTA_SLADOLEDA (SLADOLEDID) on delete cascade on update cascade;

alter table SIROVINE add constraint FK_DOBAVLJACNARUCUJE foreign key (DOBAVLJACID)
      references DOBAVLJAC (DOBAVLJACID) on delete cascade on update cascade;

alter table SIROVINEUSKLADISTU add constraint FK_SIROVINEUSKLADISTU foreign key (SKLADISTEID)
      references SKLADISTE (SKLADISTEID) on delete cascade on update cascade;

alter table SIROVINEUSKLADISTU add constraint FK_SIROVINEUSKLADISTU2 foreign key (SIROVINAID)
      references SIROVINE (SIROVINAID) on delete cascade on update cascade;

alter table SIROVINE_ZA_RECEPT add constraint FK_SIROVINE_ZA_RECEPT foreign key (SIROVINAID)
      references SIROVINE (SIROVINAID) on delete cascade on update cascade;

alter table SIROVINE_ZA_RECEPT add constraint FK_SIROVINE_ZA_RECEPT2 foreign key (RECEPTID)
      references RECEPT (RECEPTID) on delete cascade on update cascade;

alter table VRSTA_SLADOLEDA add constraint FK_PROIZVODNJASLADOLEDA foreign key (PROIZVODNJAID)
      references PROIZVODNJA (PROIZVODNJAID) on delete cascade on update cascade;

alter table ZAPOSLENI add constraint FK_ULOGAZAPOSLENOG foreign key (ULOGAID)
      references ULOGA (ULOGAID) on delete cascade on update cascade;

alter table ZAPOSLENI add constraint FK_ZAPOSLENIUPROIZVODNJI foreign key (PROIZVODNJAID)
      references PROIZVODNJA (PROIZVODNJAID) on delete cascade on update cascade;

alter table ZAPOSLENI add constraint FK_ZAPOSLENIUSKLADISTU foreign key (SKLADISTEID)
      references SKLADISTE (SKLADISTEID) on delete cascade on update cascade;

