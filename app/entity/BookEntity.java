package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class BookEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    private String authorName;
    
    private Long serialNumber;
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAuthorName() {
        return authorName;
    }
    
    public Long getSerialNumber() {
        return serialNumber;
    }
    
    public void setId(Long id) {
        this.id = id;
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
    
}
