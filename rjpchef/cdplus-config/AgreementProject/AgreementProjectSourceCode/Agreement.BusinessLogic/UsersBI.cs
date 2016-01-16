/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Agreement.BusinessEntity;
using Agreement.DataAccess;

namespace Agreement.BusinessLogic
{
    public class UsersBI
    {
        public void Insert(UsersEntity entity)
        {

            //logic goes here

            UsersDao UserDao = new UsersDao();
            UserDao.Insert(entity);
        }

        //public void Update(UsersEntity entity)
        //{
        //    UsersDao UserDao = new UsersDao();
        //    UserDao.Update(entity);

        //}
        public void Delete(int ID)
        {
            UsersDao UserDao = new UsersDao();
            UserDao.Delete(ID);
        }

        public UsersEntity ReadUsers(UsersEntity entity)
        {

            //logic goes here

            UsersDao UserDao = new UsersDao();
            return UserDao.ReadUsers(entity);
        }
        public UsersEntity Read(int id)
        {
            UsersDao UserDao = new UsersDao();
            return UserDao.Read(id);
        }
        public List<UsersEntity> ReadList()
        {
            UsersDao UserDao = new UsersDao();
            return UserDao.ReadList();
        }

        public List<UsersEntity> GetApproverList()
        {
            UsersDao UserDao = new UsersDao();
            return UserDao.GetApproverList();
        }

    }
}
