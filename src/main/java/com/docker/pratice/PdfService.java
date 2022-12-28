package com.docker.pratice;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PdfService<T> {

	public T saveCandidates(MultipartFile file) {

		try {

			// processing and uploading file
			if (!file.getContentType().equalsIgnoreCase("application/pdf")) {
				// if file is not pdf
				return (T) ((T) file.getOriginalFilename() + " should has .pdf extension only");

			} else {
				// upload file to folder and update the name to contact
				Path path = Paths.get("src\\main\\resources\\static" + File.separator + file.getOriginalFilename());
				System.out.println(path);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("image is uploaded");
			}

			return (T) "Done";

		} catch (Exception e) {
			e.printStackTrace();
			return (T) "Something went wrong";
		}
	}

}
