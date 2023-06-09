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
                return (SuperDAO) new AutorDAOImpl();
            case BOOK:
                return (SuperDAO) new BookDAOImpl();
            case DONETION:
                return (SuperDAO) new DonetionDAOImpl();
            case EXIBITION:
                return (SuperDAO) new ExibitionDAOImpl();
            case ISSUSE:
                return (SuperDAO) new IssuseDAOImpl();
            case MEMBER:
                return (SuperDAO) new MemberDAOImpl();
            case PUBLISHER:
                return (SuperDAO) new PublisherDAOImpl();
            case RETURN:
                return (SuperDAO) new ReturnDAOImpl();
            case SUPPLIER:
                return (SuperDAO) new SuplierDAOImpl();
            case USER:
                return (SuperDAO) new UserDAOImpl();
            default:
                return null;
        }
    }
}
