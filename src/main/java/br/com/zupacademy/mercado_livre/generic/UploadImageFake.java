package br.com.zupacademy.mercado_livre.generic;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.zupacademy.mercado_livre.produto.UploadImage;

@Component
@Profile("dev")
public class UploadImageFake implements UploadImage {

	@Override
	public List<URI>envia(List<MultipartFile> imagens) {
		List<URI> urls = new ArrayList<>();
		for(MultipartFile file: imagens) {
			String fileName = file.getOriginalFilename();
			String url = formatarUrl(fileName);
			try {
				urls.add(new URI(url));
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}
		return urls;
	}

	private String formatarUrl(String fileName) {
		String url;
		if(fileName != null) {
			fileName = fileName.split("\\.")[0];
			url = String.format("http://fakelink/imagem/%s-%s", fileName,UUID.randomUUID());				
		}else {
			url = String.format("http://fakelink/imagem/%s",UUID.randomUUID());								
		}
		return url;
	}

}
