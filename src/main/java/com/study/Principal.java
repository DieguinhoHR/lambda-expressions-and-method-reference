package com.study;

import com.study.crm.CadastroCliente;
import com.study.crm.Cliente;

import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

public class Principal {

    public static void main(String[] args) {
        var cadastroCliente = new CadastroCliente();
        cadastroCliente.adicionar(new Cliente("João", 30));
        cadastroCliente.adicionar(new Cliente("Maria", 90));
        cadastroCliente.adicionar(new Cliente("Sebastião", 50));
        cadastroCliente.adicionar(new Cliente("Joaquina", 45));
        cadastroCliente.adicionar(new Cliente("Josefina", 25));

        List<Cliente> clientes = cadastroCliente.consultar(c -> c.idade() > 40);

        clientes.sort(Comparator.comparingInt(Cliente::idade));
        clientes.forEach(c -> out.printf("%s - %d%n", c.nome(), c.idade()));
    }
}