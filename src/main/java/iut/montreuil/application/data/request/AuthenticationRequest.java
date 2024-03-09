package iut.montreuil.application.data.request;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AuthenticationRequest {
    private final int MAX_SIZE = 255;

    @NotNull
    @Size(max = MAX_SIZE)
    private String login;

    @NotNull
    @Size(max = MAX_SIZE)
    private String password;

    public byte[] toEncode(){
        return (login + ":" + password).getBytes();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
