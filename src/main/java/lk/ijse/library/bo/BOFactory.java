package lk.ijse.library.bo;

import lk.ijse.library.bo.custom.IssuseBO;
import lk.ijse.library.bo.custom.impl.*;
import lk.ijse.library.dao.SuperDAO;
import lk.ijse.library.dao.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return(boFactory == null ) ? boFactory = new BOFactory() : boFactory;
    }
    
    public enum BOTypes{
        AUTOR,BOOK,DONETION,EXIBITION,ISSUSE,MEMBER,PUBLISHER,RETURN,SUPPLIER,USER
    }
    public SuperBO getBO(BOFactory.BOTypes boTypes){
        switch (boTypes) {
            case AUTOR:
                return new AutorBOImpl();
            case BOOK:
                return new BookBOImpl();
            case DONETION:
                return new DonetionBOImpl();
            case EXIBITION:
                return new ExibitionBOImpl();
            case ISSUSE:
                return new IssuseBOImpl();
            case MEMBER:
                return new MemberBOImpl();
            case PUBLISHER:
                return new PublisherBOImpl();
            case RETURN:
                return new ReturnBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }
}
