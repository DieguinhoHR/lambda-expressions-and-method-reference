package com.study.crm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CadastroCliente {

    private final List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void adicionar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException();
        }
        clientes.add(cliente);
    }

    public List<Cliente> consultar(Filtro<Cliente> filtro) {
        List<Cliente> clientesFiltrados = new ArrayList<>();

        for (Cliente cliente : clientes) {
            if (filtro.avaliar(cliente)) {
                clientesFiltrados.add(cliente);
            }
        }

        return clientesFiltrados;
    }
}
