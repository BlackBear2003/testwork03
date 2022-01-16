package dao;

/**
 * 自定义异常
 */
class DAOException extends RuntimeException {


    public DAOException()
    {
        super();
    }

    public DAOException(String messege,Throwable cause)
    {
        super(messege,cause);
    }

    public DAOException(String messege)
    {
        super(messege);
    }

    public DAOException(Throwable cause)
    {
        super(cause);
    }



}
