CREATE TABLE `groups` (
  `groupid` char(2) NOT NULL default '',
  `groupname` varchar(100) default NULL,
  PRIMARY KEY  (`groupid`)
) TYPE=MyISAM;

CREATE TABLE `emailaddress` (
  `emailaddress` varchar(50) NOT NULL default '',
  `firstname` varchar(60) NOT NULL default '',
  `middlename` varchar(20) NOT NULL default '',
  `lastname` varchar(60) NOT NULL default '',
  `homephoneno` varchar(10) NOT NULL default '',
  `workphoneno` varchar(10) NOT NULL default '',
  `mobileno` varchar(10) NOT NULL default '',
  `groupid` char(3) NOT NULL default '',
  PRIMARY KEY  (`emailaddress`)
) TYPE=MyISAM;

insert into groups(`groupid`,`groupname`) values ('1','friends');
insert into groups(`groupid`,`groupname`) values ('14','TrainingFolks');
insert into groups(`groupid`,`groupname`) values ('3','OldFriends');
insert into groups(`groupid`,`groupname`) values ('11','ClassMates');
insert into groups(`groupid`,`groupname`) values ('10','Friendolds');


insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('nrn@n.com','Raj','X','LLL','8998999999','999999999','666666666','8');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('d@d.com','d','dm','dm','88888888','0999999','9999999','8');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('a@a.com','a1','b','b','11111111','22222222','33333333','7');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('b@b.com','b','a','c','11111111','33333333','44444444','9');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('admin@kk.com','admin','','test','890900099','890900099','890900099','7');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('ab@b.com','','','','','','','7');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('ab@a.com','','','','','','','7');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('a@b.com','','','','','','','7');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('naidu@n.com','nn','nn','nn','9879987979','989898999','987989999','7');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('add@ad.com','add','a','a','987908908','987908798','98890809','7');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('useecm@yahoo.com','userem','m','l','5108999999','99999999','9999999','7');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('neeraj@yahoo.com','nee','n','nnn','7989879887','9879879879','989898','7');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('kjhaskdj@yahoo.com','jhkjh','kjhkj','kjkjhk','','','','7');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('asdasd@yahoo.com','kjkjhkj','kjjkjh','kjhkj','9898798','9887987','9898','7');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('test@yahoo.com','jkasd','kjkj','kjjkj','099098','09809809','099809','7');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('test2@ecm.org','test2','m2','l2','987987987','9879870987','9879879890','7');
insert into emailaddress(`emailaddress`,`firstname`,`middlename`,`lastname`,`homephoneno`,`workphoneno`,`mobileno`,`groupid`) values ('user2@ecm.org','user2','lkl','lkjlk','70989898','989898998','9889898898','7');



