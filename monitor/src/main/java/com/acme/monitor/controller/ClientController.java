package com.acme.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.acme.monitor.controller.request.ClientRequest;
import com.acme.monitor.controller.response.BaseResponse;
import com.acme.monitor.controller.response.ClientResponse;
import com.acme.monitor.service.ClientService;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping(path = "{id}")
	public ResponseEntity<?> getById(@PathVariable(name = "id", required = true) int clientId) {

		ClientResponse clientResponse = clientService.getById(clientId);

		return new ResponseEntity<>(clientResponse != null ? new BaseResponse(BaseResponse.SUCCESS, "", clientResponse)
				: new BaseResponse(BaseResponse.ERROR, "No Client Found"), HttpStatus.OK);
	}

	@SuppressWarnings("unused")
	@PostMapping(path = "/save")
	public ResponseEntity<?> saveOrUpdate(@RequestBody ClientRequest clientRequest) {

		ClientResponse clientResponse = (clientRequest.getClient_id() == 0 ? clientService.save(clientRequest)
				: clientService.update(clientRequest));

		if (clientResponse == null) {

			return new ResponseEntity<>(new BaseResponse(BaseResponse.ERROR, "Failed to save/update client"),
					HttpStatus.OK);
		}

		return new ResponseEntity<>(new BaseResponse(BaseResponse.SUCCESS, "", clientResponse), HttpStatus.OK);
	}

}
