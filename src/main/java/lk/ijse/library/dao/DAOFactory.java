package lk.ijse.library.dao;

import lk.ijse.library.bo.custom.impl.SupplierBOImpl;
import lk.ijse.library.dao.custom.impl.*;


public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }
    private static DAOFactory getDaoFactory(){
        return(daoFactory == null ) ?daoFactory =new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        AUTOR,BOOK,DONETION,EXIBITION,ISSUSE,MEMBER,PUBLISHER,RETURN,SUPPLIER,USER
    }
    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case AUTOR:
                return new AutorDAOImpl();
            case BOOK:
                return new BookDAOImpl();
            case DONETION:
                return new DonetionDAOImpl();
            case EXIBITION:
                return new ExibitionDAOImpl();
            case ISSUSE:
                return new IssuseDAOImpl();
            case MEMBER:
                return new MemberDAOImpl();
            case PUBLISHER:
                return new PublisherDAOImpl();
            case RETURN:
                return new ReturnDAOImpl();
            case SUPPLIER:
                return new SuplierDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
