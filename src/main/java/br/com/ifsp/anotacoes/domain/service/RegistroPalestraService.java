package br.com.ifsp.anotacoes.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifsp.anotacoes.domain.exception.ServicoException;
import br.com.ifsp.anotacoes.domain.model.Conta;
import br.com.ifsp.anotacoes.domain.model.Evento;
import br.com.ifsp.anotacoes.domain.model.Palestra;
import br.com.ifsp.anotacoes.domain.repository.ContaRepository;
import br.com.ifsp.anotacoes.domain.repository.EventoRepository;
import br.com.ifsp.anotacoes.domain.repository.PalestraRepository;

@Service
public class RegistroPalestraService {

	@Autowired
	private PalestraRepository palestraRepository;
	
	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private EventoRepository eventoRepository;

	public Palestra salvar(Palestra palestra) {

		Conta conta = contaRepository.findById(palestra.getConta().getId())
				.orElseThrow(() -> new ServicoException("Cliente não encontrado"));
		
		Evento evento = eventoRepository.findById(palestra.getEvento().getId())
				.orElseThrow(() -> new ServicoException("Cliente não encontrado"));

		palestra.setConta(conta);
		palestra.setEvento(evento);

		return palestraRepository.save(palestra);
	}
}
