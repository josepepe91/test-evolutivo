package com.jose.prueba.persistenceServices;

import com.jose.prueba.entities.Record;

/**
 * Created by optimus-desarrollo on 07/05/17.
 */
public class RecordService extends BaseService<Record>{
    public RecordService() {
        super(Record.class, RecordService.class);
    }

}
