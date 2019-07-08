package votingapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import votingapi.models.Vote;
import votingapi.services.RabbitMqServce;

@RestController
public class VotingController {

	@Autowired
	private RabbitMqServce mqService;

	@CrossOrigin
	@PostMapping("/voting")
	public ResponseEntity<?> createVote(@RequestBody Vote vote) {
		// validate
		String votedItem = vote.getVotedItem();
		if(vote.getVotedItem() != "Kass" && votedItem != "Koer") {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		this.mqService.sendMessage(vote.getVotedItem());
		
		return new ResponseEntity<>(vote, HttpStatus.OK);
	}
}
