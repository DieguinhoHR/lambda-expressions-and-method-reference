package com.study.crm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CadastroClienteTest {

    public static final int MAIOR_DE_IDADE = 18;
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
    void deveConsultarClienteComIdadeAcimaDe18Anos() {
        cadastroCliente.adicionar(cliente);
        List<Cliente> clientes = cadastroCliente.consultar(c -> c.idade() > MAIOR_DE_IDADE);

        assertTrue(cadastroCliente.getClientes().contains(cliente));
        assertEquals("ryu", clientes.get(0).nome());
        assertEquals(38, clientes.get(0).idade());
    }
}