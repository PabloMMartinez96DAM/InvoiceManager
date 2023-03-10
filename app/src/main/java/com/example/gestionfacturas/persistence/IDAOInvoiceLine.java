package com.example.gestionfacturas.persistence;


import com.example.gestionfacturas.models.InvoiceLineModel;

import java.util.ArrayList;

public abstract class IDAOInvoiceLine {
    public abstract ArrayList<InvoiceLineModel> getByInvoiceId(int id);
    public abstract double getTotal(int id);
    public static IDAOInvoiceLine getInstance(){

        if(AppConfig.mode == "MEMORY"){
            return new DAOMemoryInvoiceLine();
        }
        if(AppConfig.mode =="FIREBASE" ){
            //return new DAOFirebaseClient()
        }

        if(AppConfig.mode =="SQLLITE" ){
            //return new DAOSqliteClient()
        }
        return null;

    }


}
