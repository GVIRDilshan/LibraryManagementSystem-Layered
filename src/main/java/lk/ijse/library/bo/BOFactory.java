package lk.ijse.library.bo;

import lk.ijse.library.bo.custom.IssuseBO;
import lk.ijse.library.bo.custom.impl.*;
import lk.ijse.library.dao.SuperDAO;
import lk.ijse.library.dao.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    private static BOFactory getBoFactory(){
        return(boFactory == null ) ? boFactory = new BOFactory() : boFactory;
    }
    public enum BOTypes{
        AUTOR,BOOK,DONETION,EXIBITION,ISSUSE,MEMBER,PUBLISHER,RETURN,SUPPLIER,USER
    }
    public SuperBO getBO(BOFactory.BOTypes boTypes){
        switch (boTypes) {
            case AUTOR:
                return (SuperBO) new AutorBOImpl();
            case BOOK:
                return (SuperBO) new BookBOImpl();
            case DONETION:
                return (SuperBO) new DonetionDAOImpl();
            case EXIBITION:
                return (SuperBO) new ExibitionBOImpl();
            case ISSUSE:
                return (SuperBO) new IssuseBOImpl();
            case MEMBER:
                return (SuperBO) new MemberBOImpl();
            case PUBLISHER:
                return (SuperBO) new PublisherBOImpl();
            case RETURN:
                return (SuperBO) new ReturnBOImpl();
            case SUPPLIER:
                return (SuperBO) new SupplierBOImpl();
            case USER:
                return (SuperBO) new UserBOImpl();
            default:
                return null;
        }
    }
}
