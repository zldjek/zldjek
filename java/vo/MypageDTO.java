package vo;
/*
create table user_info(
id varchar(20) primary key,
name varchar(20) not null,
passwd varchar(30) not null,
address varchar(100) not null,
phone varchar(40) not null,
emial varchar(40) not null
);
INSERT INTO user_info VALUES('hong','홍길동','1234','부산','010-1111-2345','aaa@aaa.com');
 */
public class MypageDTO {
	private String id;
	private String name;
	private String passwd;
	private String address;
	private String phone;
	private String email;
	
	
	@Override
	public String toString() {
		return "MypageDTO [id=" + id + ", name=" + name + ", passwd=" + passwd + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
