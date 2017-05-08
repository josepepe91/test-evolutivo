package com.jose.prueba.controllers;

/**
 * Created by optimus-desarrollo on 07/05/17.
 */

import com.jose.prueba.entities.Record;
import com.jose.prueba.persistenceServices.RecordService;
import org.postgresql.util.PGmoney;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RecordController {
    public RecordController() {
        super();
    }
    private RecordService recordService;
    private Record record;

    public void requestMoney(String name, BigDecimal amount) {
        Timestamp application_date = new Timestamp(System.currentTimeMillis());
        String state = new String("pending");
        recordService = new RecordService();
        Timestamp delivery_date = new Timestamp(System.currentTimeMillis());
        System.out.print("llegó3: " + name + "-" + amount + "-" + state + "-" + application_date + "-" + delivery_date);
        record = new Record(amount, name, application_date, delivery_date, state);
        try {
            recordService.insertar(record);
        } catch (Exception e) {
            System.out.println("se cayó");
            System.out.println(e);
        }
    }

    public void deliver(int id) {
        Timestamp application_date = new Timestamp(System.currentTimeMillis());
        String state = new String("pending");
        recordService = new RecordService();
        Timestamp delivery_date = new Timestamp(System.currentTimeMillis());

        try {
            record = recordService.buscarPorId(id);
            record.setState("delivered");
            record.setDelivery_date(new Timestamp(System.currentTimeMillis()));
            recordService.actualizar(record);
        } catch (Exception e) {
            System.out.println("se cayó");
            System.out.println(e);
        }
    }

    public List getAll() {
        List<Record> records = new ArrayList<Record>();
        recordService = new RecordService();
        try {
            records = recordService.buscarTodos();
            return records;
        } catch (Exception e) {
            System.out.print(e);
            return records;
        }
    }
}
