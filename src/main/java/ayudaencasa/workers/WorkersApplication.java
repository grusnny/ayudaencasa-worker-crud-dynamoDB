package ayudaencasa.workers;

import ayudaencasa.workers.entity.Worker;
import ayudaencasa.workers.repository.WorkerRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping(value = "/worker")
public class WorkersApplication {

	@Autowired
	private WorkerRepository repository;

	@GetMapping("/{uId}")
	public Worker GetWorker(@PathVariable String uId){
		return repository.findWorkerById(uId);
	}
	@PostMapping
	public Worker PostWorker(@RequestBody Worker worker){
		return repository.addWorker(worker);
	}
	@PutMapping
	public String UpdateWorker(@RequestBody Worker worker){
		return repository.editWorker(worker);
	}
	@DeleteMapping
	public String DeleteWorker(@RequestBody Worker worker){
		return repository.deleteWorker(worker);
	}
	@GetMapping
	public PaginatedScanList<Worker> GetAllUsers(){
		return repository.findAllWorkers();
	}

	public static void main(String[] args) {
		SpringApplication.run(WorkersApplication.class, args);
	}

}
