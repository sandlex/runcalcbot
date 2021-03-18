package com.sandlex.runcalcbot.log;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepo logRepo;

    public void log(Integer personId, String paceBlock, String schema, String result) {
        LogEntity logEntity = new LogEntity();
        logEntity.setPersonId(personId);
        logEntity.setPaceBlock(paceBlock);
        logEntity.setSchema(schema);
        logEntity.setResult(result);
        logRepo.save(logEntity);
    }

}
