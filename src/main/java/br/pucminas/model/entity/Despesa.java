package br.pucminas.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "DESPESAS")
public class Despesa extends AbstractEntity<Long>{
	
	@NotBlank
	@Size(min=3, max=60)
	@Column(name="descricao", nullable=false, unique=true, length=60)
	private String descricao;
	
	@NotNull
	@NumberFormat(style = Style.CURRENCY, pattern= "#,##0.00")
	@Column(name="valor", nullable=false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal valor;
	
	@NotNull
	@DateTimeFormat(iso=ISO.DATE,  pattern= "")
	@Column(name="data", nullable=false, columnDefinition = "DATE")
	private LocalDate data;
	
	@NotNull
	@ManyToOne	
	@JoinColumn(name = "categoria.id")
	private Categoria categoria;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
