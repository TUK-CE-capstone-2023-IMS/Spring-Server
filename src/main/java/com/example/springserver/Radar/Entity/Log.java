Managerpackage com.example.springserver.Radar.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userid;
    private String password;
    private String name;
    private String age;
    private String sex;
    private String phone;
    private String email;
    private String address;
    private String etc;
}
