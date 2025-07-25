package com.study.crm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CadastroClienteTest {

    @Test
    void deveAdicionarCliente() {
        var cliente = new Cliente("diego", 38);
        var cadastroCliente = new CadastroCliente();

        cadastroCliente.adicionar(cliente);

        Assertions.assertTrue(cadastroCliente.getClientes()
                .contains(cliente));
    }
}