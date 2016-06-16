var sn = {
	"timestamp" : 1466062106205,
	"status" : 500,
	"error" : "Internal Server Error",
	"exception" : "org.springframework.dao.DataIntegrityViolationException",
	"message" : "\r\n### Error updating database. Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column 'password' cannot be null\r\n### The error may involve com.xyf.boot.domain.mapper.fixed.UserMapper.updateByPrimaryKey-Inline\r\n### The error occurred while setting parameters\r\n### SQL: update h_user set user_name = ?, password = ?, position = ?, email = ?, mobil_phone = ?, status = ?, lang = ?, theme = ?, error_login_times = ?, remark = ? where user_code = ?\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column 'password' cannot be null\n; SQL []; Column 'password' cannot be null; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column 'password' cannot be null",
	"path" : "/user/modify"
}