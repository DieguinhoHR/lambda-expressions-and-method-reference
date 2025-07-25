package com.study.crm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CadastroClienteTest {

    private Cliente cliente;
    private CadastroCliente cadastroCliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("ryu", 38);
        cadastroCliente = new CadastroCliente();
    }

    @Test
    void deveAdicionarCliente() {
        cadastroCliente.adicionar(cliente);
        assertTrue(cadastroCliente.getClientes().contains(cliente));
    }

    @Test
    void deveListarClientes() {
        cadastroCliente.adicionar(cliente);

        assertEquals(1, cadastroCliente.getClientes().size());
        assertTrue(cadastroCliente.getClientes().contains(cliente));
    }

    @Test
    void deveDispararExcecaoParaClienteNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> cadastroCliente.adicionar(null));
    }

    @Test
    void deveConsultarCliente() {
        Filtro<Cliente> filtro = new Filtro<Cliente>() {
            @Override
            public boolean avaliar(Cliente cliente) {
                return cliente.idade() > 18;
            }
        };
        cadastroCliente.adicionar(cliente);
        List<Cliente> clientes = cadastroCliente.consultar(filtro);

        assertTrue(cadastroCliente.getClientes().contains(cliente));
        assertEquals("ryu", clientes.get(0).nome());
        assertEquals(38, clientes.get(0).idade());
    }
}