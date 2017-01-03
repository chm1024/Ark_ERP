package com.micolor.common.dao.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.common.method.datatables.DataTables4Hql;
import com.micolor.common.statics.EnumUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by geyupeng on 15/9/29.
 */
@Repository("baseDAO")
@SuppressWarnings("all")
@Transactional
public class DaoImpl<T> implements DaoService<T> {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Serializable save(T o) {
        return this.getCurrentSession().save(o);
    }

    public void delete(T o) { this.getCurrentSession().delete(o);}

    public MsgBean delete(T [] os ){
        MsgBean msgBean = new MsgBean();
        try{
            for (T o : os) {
                delete(o);
            }
            msgBean.setContent("");
            msgBean.setMsg("删除成功!");
            msgBean.setStatus(EnumUtil.MessageStatus.OK);

        }catch (Exception e){
            msgBean.setMsg("删除失败!");
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return msgBean;
    }

    public void update(T o) {
        this.getCurrentSession().update(o);
    }

    public MsgBean saveOrUpdate(T o) {
        MsgBean msgBean = new MsgBean();
        try{
            this.getCurrentSession().saveOrUpdate(o);
            msgBean.setContent(o);
            msgBean.setMsg("保存成功!");
            msgBean.setStatus(EnumUtil.MessageStatus.OK);
        }catch(Exception e){
            msgBean.setMsg("保存失败!");
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return msgBean;
    }

    /**
     * 无分页列表
     *
     * @param hql
     * @return
     */
    public List<T> find(String hql) {
        return this.getCurrentSession().createQuery(hql).list();
    }

    /**
     * @param hql
     * @param param
     * @return
     */
    public List<T> find(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.list();
    }

    /**
     * @param hql
     * @param param
     * @return
     */
    public List<T> find(String hql, List<Object> param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return q.list();
    }

    public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (rows == null || rows < 1) {
            rows = 10;
        }
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    public List<T> find(String hql, List<Object> param, Integer page, Integer rows) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (rows == null || rows < 1) {
            rows = 10;
        }
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    public T get(Class<T> c, Serializable id) {
        return (T) this.getCurrentSession().get(c, id);
    }

    public T get(String hql, Object[] param) {
        List<T> l = this.find(hql, param);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }

    public T get(String hql, List<Object> param) {
        List<T> l = this.find(hql, param);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }

    public Long count(String hql) {
        return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
    }

    public Long count(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return (Long) q.uniqueResult();
    }

    public Long count(String hql, List<Object> param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return (Long) q.uniqueResult();
    }

    public Integer executeHql(String hql) {
        return this.getCurrentSession().createQuery(hql).executeUpdate();
    }

    public Integer executeHql(String hql, Object[] param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.executeUpdate();
    }

    public Integer executeHql(String hql, List<Object> param) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0; i < param.size(); i++) {
                q.setParameter(i, param.get(i));
            }
        }
        return q.executeUpdate();
    }

    public List find(String hql, DataTables dataTables) {

        List list = null;
        Object[] params = DataTables4Hql.DataTables2Params(dataTables);
        String Hql = DataTables4Hql.DataTables2Hql(hql, dataTables);
        if (dataTables.getLength() != -1) {
            int page = (dataTables.getStart() / dataTables.getLength()) + 1;
            list = find(Hql, params, page, dataTables.getLength());
        } else {
            list = find(Hql, params);
        }
        return list;
    }

    public Long count(String hql, DataTables dataTables) {
        Object[] params = DataTables4Hql.DataTables2Params(dataTables);
        String Hql = DataTables4Hql.DataTables2Hql(hql, dataTables);
        return count(Hql, params);
    }
}
