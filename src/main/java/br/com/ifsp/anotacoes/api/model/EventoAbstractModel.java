package br.com.ifsp.anotacoes.api.model;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventoAbstractModel {

	@NotNull
	private Long id;

}
