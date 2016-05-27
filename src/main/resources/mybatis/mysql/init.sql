DROP TABLE IF EXISTS h_fmt_code;
CREATE TABLE h_fmt_code (
  uuid varchar(40) NOT NULL,
  tranCode varchar(40) NOT NULL,
  msgSeq int(11) NOT NULL,
  requestTime varchar(20) DEFAULT NULL,
  responseTime varchar(20) DEFAULT NULL,
  status varchar(2) NOT NULL,
  diffCode varchar(1) NOT NULL,
  PRIMARY KEY (uuid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;