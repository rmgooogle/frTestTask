package com.fr.testtask.repository;

import com.fr.testtask.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepo extends JpaRepository <Poll,Long> {

}
