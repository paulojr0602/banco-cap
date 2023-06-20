package com.banco.cap.interfaces.service;

import com.banco.cap.entities.Cliente;
import com.banco.cap.entities.ContaCorrente;

public interface IContaCorrenteService {
	
	public ContaCorrente CadastrarConta(ContaCorrente conta);
	public ContaCorrente AbrirConta(Long id);
	public ContaCorrente GerarConta(Cliente cliente);
	public ContaCorrente ConsultarContaPorIdCliente(Long id);
	public ContaCorrente ConsultarContaPorCpf(String cpf);
	
}
