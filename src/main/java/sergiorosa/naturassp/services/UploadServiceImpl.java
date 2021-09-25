package sergiorosa.naturassp.services;



import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class UploadServiceImpl implements IUploadService {

	@Override
	public String uploadFile(MultipartFile arquivo) {
		try {
			/*
			 * Intuito disso aqui?
			 * copiar o arquivo recebido via requisicao ppara uma past definida
			 * e retornar o caminho dele. Se der qualquer erro, retornar NULL
			 */
			
			System.out.println("DEBUG - "+arquivo.getOriginalFilename());
			String caminho = "/Users/sergiorosa/Desktop/directory-img";
			Path path = Paths.get(caminho + File.separator + arquivo.getOriginalFilename());
			Files.copy(arquivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("DEBUG - Archived Copied...");
			return path.toString();
//			return arquivo.getOriginalFilename();
			
			
			
					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
