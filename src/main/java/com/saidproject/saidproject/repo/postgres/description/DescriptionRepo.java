package com.saidproject.saidproject.repo.postgres.description;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.repo.api.IDescriptionRepo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DescriptionRepo extends JpaRepository<Description, Integer> {


}
