package br.com.zupacademy.mercado_livre.produto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class NovasImagensRequest {
	@NotNull
	@Size(min = 1)
	private List<MultipartFile> imagens;

	public NovasImagensRequest(@NotNull @Size(min = 1) List<MultipartFile> imagens) {
		this.imagens = imagens;
	}

	public List<MultipartFile> getImagens() {
		return imagens;
	}
	
}
