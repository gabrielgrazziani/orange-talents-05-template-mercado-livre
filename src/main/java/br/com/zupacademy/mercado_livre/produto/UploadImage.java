package br.com.zupacademy.mercado_livre.produto;

import java.net.URI;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImage {

	List<URI> envia(List<MultipartFile> imagens);

}
