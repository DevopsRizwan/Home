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
    public class AgreementDao : SQLDataAccess
    {
        public int Insert(AgreementTypeEntity entity)
        {
            Parameters = new List<SqlParameter>();

            Parameters.Add(new SqlParameter("@UserID", entity.UserID));
            Parameters.Add(new SqlParameter("@Title", entity.Title));
            Parameters.Add(new SqlParameter("@AgreementTypeID", entity.AgreementTypeID));
            Parameters.Add(new SqlParameter("@AgreementType", entity.AgreementType));
            Parameters.Add(new SqlParameter("@BusinessTypeID", entity.BusinessTypeID));
            Parameters.Add(new SqlParameter("@WorkType", entity.WorkType));
            Parameters.Add(new SqlParameter("@VendorID", entity.VendorID));
            Parameters.Add(new SqlParameter("@USTaxIdentificationNo", entity.USTaxIdentificationNo));
            Parameters.Add(new SqlParameter("@UNIQUENo", entity.UNIQUENo));
            Parameters.Add(new SqlParameter("@TechnicalInformation", entity.TechnicalInformation));


            object id = null;
            if (entity.AgreementTypeID == 0)
            {
                Parameters.Add(new SqlParameter("@Action", "C"));
                id = ExecuteScalar(DBCommands.AgreementType);
            }
            else
            {
                Parameters.Add(new SqlParameter("@Action", "U"));
                ExecCommand(DBCommands.AgreementType);
                id = entity.AgreementTypeID;
            }
            return Convert.ToInt32(id);
        }
        public void InsertStatus(int agreementTypeStatus, int agreementTypeID)
        {
            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@SubmitAgreement", agreementTypeStatus));
            Parameters.Add(new SqlParameter("@AgreementTypeID", agreementTypeID));
            Parameters.Add(new SqlParameter("@Action", "SS"));
            ExecCommand(DBCommands.AgreementType);
        }
        //public void Delete(int id)
        //{
        //    Parameters = new List<SqlParameter>();
        //    Parameters.Add(new SqlParameter("@UserID", id));
        //    ExecCommand("USP_Delete_Users");
        //}
        public AgreementTypeEntity Read(int id)
        {
            Parameters = new List<SqlParameter>();

            Parameters.Add(new SqlParameter("@AgreementTypeID", id));
            AgreementTypeEntity entity = null;
            SqlDataReader reader = null;
            try
            {
                Parameters.Add(new SqlParameter("@Action", "R"));
                reader = ExecDataReader(DBCommands.AgreementType);
                if (reader.Read())
                {
                    entity = new AgreementTypeEntity();
                    if (reader["Title"] != DBNull.Value)
                        entity.Title = reader["Title"].ToStr();

                    if (reader["UserID"] != DBNull.Value)
                        entity.UserID = Convert.ToInt32(reader["UserID"]);

                    entity.UserID = reader["UserID"].ToInt32();
                    entity.AgreementType = reader["AgreementType"].ToStr();
                    entity.BusinessTypeID = reader["BusinessTypeID"].ToInt32();
                    entity.WorkType = reader["WorkType"].ToStr();

                    entity.VendorID = reader["VendorID"].ToInt32();
                    entity.USTaxIdentificationNo = reader["USTaxIdentificationNo"].ToStr();
                    entity.UNIQUENo = reader["UNIQUENo"].ToStr();
                    entity.TechnicalInformation = reader["TechnicalInformation"].ToStr();
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
        public AgreementTypeEntity ReadTitle(int id)
        {
            Parameters = new List<SqlParameter>();

            Parameters.Add(new SqlParameter("@AgreementTypeID", id));
            AgreementTypeEntity entity = null;
            SqlDataReader reader = null;
            try
            {
                Parameters.Add(new SqlParameter("@Action", "RT"));
                reader = ExecDataReader(DBCommands.AgreementType);

                if (reader.Read())
                {
                    entity = new AgreementTypeEntity();

                    entity.Email = reader["Email"].ToStr();
                    while (reader.NextResult())
                    {
                        if (reader.Read())
                        {
                            entity.Title = reader["Title"].ToStr();
                            //entity.AgreementType = reader["AgreementType"].ToString();
                            //entity.BusinessTypeID = Convert.ToInt32(reader["BusinessTypeID"]);
                            //entity.WorkType = reader["WorkType"].ToString();
                        }
                    }
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


        public List<AgreementTypeEntity> ReadSearchItem(AgreementTypeEntity searchEntity)
        {
            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@Title", searchEntity.Title));
            Parameters.Add(new SqlParameter("@AgreementType", searchEntity.AgreementType));
            Parameters.Add(new SqlParameter("@BusinessTypeID", searchEntity.BusinessTypeID));
            List<AgreementTypeEntity> list = new List<AgreementTypeEntity>();
            AgreementTypeEntity entity = null;
            SqlDataReader reader = null;
            try
            {
                reader = ExecDataReader(DBCommands.Search);
                while (reader.Read())
                {

                    entity = new AgreementTypeEntity();
                    entity.Title = reader["Title"].ToStr();
                    // entity.UserID = reader["UserID"].ToInt32();
                    entity.AgreementType = reader["AgreementType"].ToStr();
                    entity.BusinessType = reader["BusinessType"].ToStr();
                    entity.Status = reader["Status"].ToStr();
                    entity.WorkType = reader["WorkType"].ToStr();
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

        public List<AgreementTypeEntity> ReadList()
        {
            List<AgreementTypeEntity> list = new List<AgreementTypeEntity>();
            SqlDataReader reader = null;
            try
            {
                reader = ExecDataReader("USP_DDLBusinessType");
                while (reader.Read())
                {
                    AgreementTypeEntity entity = new AgreementTypeEntity();
                    entity.BusinessTypeID = Convert.ToInt32(reader["BusinessTypeID"]);
                    entity.BusinessType = reader["BusinessType"].ToStr();
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
