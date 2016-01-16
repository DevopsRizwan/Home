/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Agreement.BusinessEntity;
using System.Data.SqlClient;


namespace Agreement.DataAccess
{
    public class UsersDao : SQLDataAccess
    {
        public void Insert(UsersEntity entity)
        {
            Parameters = new List<SqlParameter>();

            Parameters.Add(new SqlParameter("@UserID", entity.UserID));
            Parameters.Add(new SqlParameter("@FirstName", entity.FirstName));
            Parameters.Add(new SqlParameter("@LastName", entity.LastName));
            Parameters.Add(new SqlParameter("@PhoneNo", entity.PhoneNo));
            Parameters.Add(new SqlParameter("@Email", entity.Email));
            Parameters.Add(new SqlParameter("@EmpID", entity.EmpID));
            Parameters.Add(new SqlParameter("@UserName", entity.UserName));
            Parameters.Add(new SqlParameter("@Password", entity.Password));
            Parameters.Add(new SqlParameter("@UserType", entity.UserType));
            if (entity.UserID == 0)
            {
                Parameters.Add(new SqlParameter("@Action", "C"));
                ExecCommand(DBCommands.Users);
            }
            else
            {
                Parameters.Add(new SqlParameter("@Action", "U"));
                ExecCommand(DBCommands.Users);
            }

        }

        //public void Update(UsersEntity entity)
        //{
        //    Parameters = new List<SqlParameter>();

        //    Parameters.Add(new SqlParameter("@UserID", entity.UserID));
        //    Parameters.Add(new SqlParameter("@FirstName", entity.FirstName));
        //    Parameters.Add(new SqlParameter("@LastName", entity.LastName));
        //    Parameters.Add(new SqlParameter("@PhoneNo", entity.PhoneNo));
        //    Parameters.Add(new SqlParameter("@Email", entity.Email));
        //    Parameters.Add(new SqlParameter("@EmpID", entity.EmpID));
        //    Parameters.Add(new SqlParameter("@UserName", entity.UserName));
        //    Parameters.Add(new SqlParameter("@Password", entity.Password));
        //    Parameters.Add(new SqlParameter("@UserType", entity.UserType));
        //    ExecCommand("USP_Update_Users");
        //}
        public void Delete(int id)
        {
            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@UserID", id));
            Parameters.Add(new SqlParameter("@Action", "D"));
            ExecCommand(DBCommands.Users);
        }
        public UsersEntity Read(int id) //why we wright UserEntity 
        {
            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@UserID", id));
            UsersEntity entity = new UsersEntity();
            SqlDataReader reader = null;
            try
            {
                Parameters.Add(new SqlParameter("@Action", "R"));
                reader = ExecDataReader(DBCommands.Users);
                if (reader.Read())
                {
                    entity.UserID = reader["UserID"].ToInt32();
                    entity.FirstName = reader["FirstName"].ToStr();
                    entity.LastName = reader["LastName"].ToStr();
                    entity.PhoneNo = reader["PhoneNo"].ToStr();
                    entity.Email = reader["Email"].ToStr();
                    entity.EmpID = reader["EmpID"].ToStr();
                    entity.UserName = reader["UserName"].ToStr();
                    entity.Password = reader["Password"].ToStr();
                    entity.UserType = reader["UserType"].ToStr();
                }
            }
            finally
            {
                if (reader != null)
                {
                    reader.Close();
                    reader.Dispose();
                }
            }

            return entity;

        }


        public UsersEntity ReadUsers(UsersEntity userentity) //why we wright UserEntity 
        {
            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@UserName", userentity.UserName));
            Parameters.Add(new SqlParameter("@Password", userentity.Password));
            UsersEntity entity = null;
            SqlDataReader reader = null;
            try
            {

                Parameters.Add(new SqlParameter("@Action", "RL"));
                reader = ExecDataReader(DBCommands.Users);
                if (reader.Read())
                {
                    entity = new UsersEntity();
                    entity.UserID = Convert.ToInt32(reader["UserID"]);
                    entity.FirstName = reader["FirstName"].ToString();
                    entity.LastName = reader["LastName"].ToString();
                    entity.FullName = entity.FirstName + ", " + entity.LastName;
                    entity.PhoneNo = reader["PhoneNo"].ToString();
                    entity.Email = reader["Email"].ToString();
                    entity.EmpID = reader["EmpID"].ToString();
                    entity.UserName = reader["UserName"].ToString();
                    entity.UserType = reader["UserType"].ToString();
                }
            }
            finally
            {
                if (reader != null)
                {
                    reader.Close();
                    reader.Dispose();
                }
            }

            return entity;

        }


        public List<UsersEntity> GetApproverList()
        {
            Parameters = new List<SqlParameter>();
            List<UsersEntity> list = new List<UsersEntity>();
            SqlDataReader reader = null;
            try
            {
                Parameters.Add(new SqlParameter("@Action", "GET_APPROVERS"));
                reader = ExecDataReader(DBCommands.Users);
                while (reader.Read())
                {
                    UsersEntity entity = new UsersEntity();
                    entity.UserID = Convert.ToInt32(reader["UserID"]);
                    entity.FullName = reader["FirstName"].ToString() + " " + reader["LastName"].ToString();
                    list.Add(entity);
                }

            }
            finally
            {
                if (reader != null)
                {
                    reader.Close();
                    reader.Dispose();
                }
            }
            return list;
        }

        public List<UsersEntity> ReadList()
        {
            Parameters = new List<SqlParameter>();
            List<UsersEntity> list = new List<UsersEntity>();
            SqlDataReader reader = null;
            try
            {
                Parameters.Add(new SqlParameter("@Action", "LL"));
                reader = ExecDataReader(DBCommands.Users);
                while (reader.Read())
                {
                    UsersEntity entity = new UsersEntity();
                    entity.UserID = Convert.ToInt32(reader["UserID"]);
                    entity.FirstName = reader["FirstName"].ToString();
                    entity.LastName = reader["LastName"].ToString();
                    entity.PhoneNo = reader["PhoneNo"].ToString();
                    entity.Email = reader["Email"].ToString();
                    entity.EmpID = reader["EmpID"].ToString();
                    entity.UserName = reader["UserName"].ToString();
                    entity.Password = reader["Password"].ToString();
                    entity.UserType = reader["UserType"].ToString();


                    list.Add(entity);
                }

            }
            finally
            {
                if (reader != null)
                {
                    reader.Close();
                    reader.Dispose();
                }
            }
            return list;
        }
    }
}

