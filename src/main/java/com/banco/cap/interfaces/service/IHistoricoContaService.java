package com.banco.cap.interfaces.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.banco.cap.entities.HistoricoConta;

@Component
public interface IHistoricoContaService {
	
	public List<HistoricoConta> ConsultarHistoricoPoridConta(Long idConta);
	public double ConsultarSaldoPoridConta(Long idConta);
}
