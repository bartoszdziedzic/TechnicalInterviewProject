package TechnicalInterviewPagePackage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class User {
    String emailAddress;
    String password;
}
