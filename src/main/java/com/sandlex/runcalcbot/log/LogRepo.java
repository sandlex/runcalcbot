package com.sandlex.runcalcbot.log;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface LogRepo extends CrudRepository<LogEntity, Long> {
}
