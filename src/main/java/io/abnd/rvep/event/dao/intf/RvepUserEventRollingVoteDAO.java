package io.abnd.rvep.event.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.RvepUserEventRollingVote;

@Repository
public interface RvepUserEventRollingVoteDAO extends JpaRepository<RvepUserEventRollingVote, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepUserEventRollingVote findById(int id);
	
}