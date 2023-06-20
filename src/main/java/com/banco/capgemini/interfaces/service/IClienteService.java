package com.banco.capgemini.interfaces.service;

import com.banco.capgemini.entities.Cliente;

public interface IClienteService {
	
	public Cliente CadastrarCliente(Cliente cliente);
	public Cliente ConsultarPorId(Long id);
	public Cliente findByCpf(String cpf);
}
