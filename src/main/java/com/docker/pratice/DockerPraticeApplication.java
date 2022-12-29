package com.docker.pratice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@RestController
public class DockerPraticeApplication<T> {
	
	@Autowired
	private PdfService<T> pdfService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employee")
	public List<Employee> getUser(){
		return employeeRepository.findAll();
	}
	
	@PostMapping("/uploadpdf")
    public T saveCandidate(@RequestPart("file") MultipartFile file) {
        T saveCandidates = pdfService.saveCandidates(file);
        return saveCandidates;
    }

	@PostMapping("/employee")
	public Employee saveUser(@RequestBody Employee employee){
		return employeeRepository.save(employee);
	}
	public static void main(String[] args) {
		SpringApplication.run(DockerPraticeApplication.class, args);
	}

}
