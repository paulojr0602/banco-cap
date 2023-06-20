package com.banco.cap.interfaces.service;

import javax.xml.bind.ValidationException;
import org.springframework.stereotype.Component;

import com.banco.cap.entities.Operacao;

@Component
public interface IMovimentoContaService {
	
	public String MovimentarConta(Operacao historico) throws ValidationException;

}
