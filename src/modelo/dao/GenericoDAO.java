package modelo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.*;

/**
 *
 * @author Marcos Victor
 */
public class GenericoDAO{

    private static Session sessao;
    private Transaction transacao;
    private Class classe;

    public GenericoDAO(Class classe) {
        this.classe = classe;
    }

    public void salvarObj(Object obj) throws Exception {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(obj);
        sessao.flush();
        transacao.commit();
        sessao.close();
    }

    public void alterarObj(Object obj) throws Exception {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        sessao.update(obj);
        sessao.flush();
        transacao.commit();
        sessao.close();

    }

    public void deletarObj(Object obj) throws Exception {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        sessao.delete(obj);
        sessao.flush();
        transacao.commit();
        sessao.close();

    }

    public List listarObjs() throws Exception {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

        List objts = null;
        Criteria selectAll = sessao.createCriteria(classe);
        transacao.commit();
        objts = selectAll.list();
        sessao.flush();
        sessao.close();
        return objts;
    }
    
    public Object pegarId(Integer id){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        
        Object objt = (Object) sessao.load(classe, id);
        System.out.println(objt.toString());
        transacao.commit();
        sessao.flush();
        sessao.close();
        return objt;
    }
    
    //para não gera novas intancias, veja isso depois.
    public static void singletonDAO(){
    }
}
