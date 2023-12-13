package br.com.alura.clean.arch.app.exception;

import br.com.alura.clean.arch.cross.utils.BusinessCode;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@RegisterForReflection
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {


    private final BusinessCode businessCode;


    public BusinessException(final BusinessCode bc) {

        this.businessCode = bc;

    }

}
