package com.banco.cap.interfaces.service;

import com.banco.cap.entities.Cliente;

public interface IClienteService {
	
	public Cliente CadastrarCliente(Cliente cliente);
	public Cliente ConsultarPorId(Long id);
	public Cliente findByCpf(String cpf);
}
