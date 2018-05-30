package com.ugioni.belezapura;

import com.ugioni.belezapura.model.Cliente;
import com.ugioni.belezapura.rest.AbstractCrudResource;
import com.ugioni.belezapura.services.ClienteService;
import org.jglue.cdiunit.ActivatedAlternatives;
import org.jglue.cdiunit.ProducesAlternative;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ActivatedAlternatives(teste.Mocks.class)
public class teste {

    @Any
    @Inject
    ClienteService clienteService;

    @Test(priority = 1)
    public void test() {
        System.out.println("testes");
    }

    protected class Mocks {

        @Produces
        @Alternative
        @ProducesAlternative
        ClienteService clienteService() {
            ClienteService mock = Mockito.mock(ClienteService.class);
            when(mock.insert(any())).thenReturn(new Cliente());
            return mock;
        }

        @Produces
        @Alternative
        @ProducesAlternative
        AbstractCrudResource abstractCrudResource() {
            AbstractCrudResource mock = Mockito.mock(AbstractCrudResource.class);
            when(mock.insert(any())).thenCallRealMethod();
            return mock;
        }
    }
}
