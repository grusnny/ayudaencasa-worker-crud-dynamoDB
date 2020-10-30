package ayudaencasa.workers;

import ayudaencasa.workers.entity.Worker;
import ayudaencasa.workers.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class WorkersApplication {

	@Autowired
	private WorkerRepository repository;

	@GetMapping("/getworker/{uId}")
	public Worker GetWorker(@PathVariable String uId){
		return repository.findWorkerById(uId);
	}
	@PostMapping("/saveworker")
	public Worker PostWorker(@RequestBody Worker worker){
		return repository.addWorker(worker);
	}
	@PutMapping("/editworker")
	public String UpdateWorker(@RequestBody Worker worker){
		return repository.editWorker(worker);
	}
	@DeleteMapping("/deleteworker")
	public String DeleteWorker(@RequestBody Worker worker){
		return repository.deleteWorker(worker);
	}
	@GetMapping
	public Worker[] GetAllWorker(String uId){
		Worker workers[] = new Worker[0];
		return workers;
	}

	public static void main(String[] args) {
		SpringApplication.run(WorkersApplication.class, args);
	}

}
