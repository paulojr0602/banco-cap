package com.banco.cap.services.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.cap.entities.HistoricoConta;
import com.banco.cap.entities.Operacao;
import com.banco.cap.interfaces.repository.IContaCorrenteRepository;
import com.banco.cap.interfaces.repository.IHistoricoContaRepository;
import com.banco.cap.interfaces.service.IMovimentoContaService;

@Service
public class DepositarContaCorrente implements IMovimentoContaService{

	@Autowired
	private IHistoricoContaRepository historicoRepository;
	@Autowired 
	private IContaCorrenteRepository contaCorrenteRepository;
	
	public DepositarContaCorrente(IHistoricoContaRepository historicoRepository, IContaCorrenteRepository contaCorrenteRepository) {
		this.historicoRepository = historicoRepository;
		this.contaCorrenteRepository = contaCorrenteRepository;
	}
	
	@Override
	public String MovimentarConta(Operacao movimento) {
		HistoricoConta historico = new HistoricoConta(movimento.getTipoMovimento(), movimento.getData(), contaCorrenteRepository.findById(movimento.getIdConta()).get(), movimento.getValor());
		
		historicoRepository.save(historico);
		
		return String.valueOf(historicoRepository.ConsultarSaldoConta(historico.getContaCorrente().getId()));
	}

	
}
