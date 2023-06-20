package com.banco.cap.services;

import javax.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.cap.entities.Cliente;
import com.banco.cap.entities.Operacao;
import com.banco.cap.enumerators.TipoMovimento;
import com.banco.cap.interfaces.repository.IContaCorrenteRepository;
import com.banco.cap.interfaces.repository.IHistoricoContaRepository;
import com.banco.cap.interfaces.service.IClienteService;
import com.banco.cap.interfaces.service.IMovimentoContaService;
import com.banco.cap.services.classes.DepositarContaCorrente;
import com.banco.cap.services.classes.SacarContaCorrente;

@Service
public class MovimentoContaService implements IMovimentoContaService {
	
	@Autowired
	private IHistoricoContaRepository historicoRepository;
	private IClienteService clienteService;
	@Autowired
	private IContaCorrenteRepository contaCorrenteRepository;
			
	public MovimentoContaService(IHistoricoContaRepository historicoRepository, IClienteService clienteService, IContaCorrenteRepository contaCorrenteRepository) {
		super();
		this.historicoRepository = historicoRepository;
		this.clienteService = clienteService;
		this.contaCorrenteRepository = contaCorrenteRepository;
	}

	@Override
	public String MovimentarConta(Operacao movimento) throws ValidationException {
		
		try {
			Cliente cliente = clienteService.findByCpf(movimento.getCpf());
			if(cliente == null) {
				return "Cliente não encontrado.";
			}
		} catch (Exception e) {
			return "Cliente não encontrado.";
		}
		
		//Configura a ação para executar 
		if (movimento.getTipoMovimento() == TipoMovimento.DEPOSITO) {
			DepositarContaCorrente depositar = new DepositarContaCorrente(historicoRepository, contaCorrenteRepository);
			return String.valueOf(depositar.MovimentarConta(movimento));
		} else {
			SacarContaCorrente sacar = new SacarContaCorrente(historicoRepository, contaCorrenteRepository);
			return String.valueOf(sacar.MovimentarConta(movimento));
		}		 
	}	
}
