package dto;

public class BookDto {
    
    
    private String name;
    
    private String authorName;
    
    private Long serialNumber;
    
    public String getName() {
	return name;
    }
    
    public String getAuthorName() {
	return authorName;
    }
    
    public Long getSerialNumber() {
	return serialNumber;
    }
    
    public void setName(String name) {
	this.name = name;
    }
    
    public void setAuthorName(String authorName) {
	this.authorName = authorName;
    }
    
    public void setSerialNumber(Long serialNumber) {
	this.serialNumber = serialNumber;
    }
    
    @Override
    public String toString() {
	
	return
		new StringBuilder().append("Name: ").append(name).append(" ").append("Author Name: ").append(authorName)
			.append(" ").append("Serial Number: ").append(serialNumber).toString();
	
    }
}
