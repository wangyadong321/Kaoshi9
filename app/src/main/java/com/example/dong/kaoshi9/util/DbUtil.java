package com.example.dong.kaoshi9.util;

import com.example.dong.kaoshi9.bean.Bean;
import com.example.dong.kaoshi9.dao.BeanDao;
import com.example.dong.kaoshi9.dao.DaoMaster;
import com.example.dong.kaoshi9.dao.DaoSession;

import java.util.List;

public class DbUtil {
        private static DbUtil dbUtil;
            private final BeanDao beanDao;

            private DbUtil() {
                DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getMyApp(), "you.db");
                DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
                DaoSession daoSession = daoMaster.newSession();
                beanDao = daoSession.getBeanDao();

            }

            public static DbUtil getDbUtil() {
                if (dbUtil==null){
                    synchronized (DbUtil.class){
                        if (dbUtil==null){
                            dbUtil=new DbUtil();
                        }
                    }
                }
                return dbUtil;
            }
            public void insert(Bean bean){
                if (!has(bean))
                beanDao.insertOrReplace(bean);
            }
            public void delete(Bean bean){
                if (has(bean))
                beanDao.delete(bean);
            }
            public List<Bean> query(){
                return beanDao.queryBuilder().list();
            }
            public boolean has(Bean bean){
                List<Bean> list = beanDao.queryBuilder().where(BeanDao.Properties.Title.eq(bean.getTitle())).list();
                if (list!=null&&list.size()>0){
                    return true;
                }
                return false;
            }
}
