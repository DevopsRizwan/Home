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
    public class EligibilityDao : SQLDataAccess
    {
        public int Insert(EligibilityEntity entity)
        {
            try
            {

                Parameters = new List<SqlParameter>();

                Parameters.Add(new SqlParameter("@EligibilityID", entity.EligibilityID));
                Parameters.Add(new SqlParameter("@AgreementTypeID", entity.AgreementTypeID));
                Parameters.Add(new SqlParameter("@FirstName", entity.FirstName));
                Parameters.Add(new SqlParameter("@LastName", entity.LastName));
                Parameters.Add(new SqlParameter("@SSN", entity.SSN));
                object id = null;

                BeginTrans();
                if (entity.EligibilityID == 0)
                {
                    Parameters.Add(new SqlParameter("@Action", "C"));
                    id = ExecuteScalar(DBCommands.Eligibility);
                }
                else
                {
                    Parameters.Add(new SqlParameter("@Action", "U"));
                    ExecCommand(DBCommands.Eligibility);
                    id = entity.EligibilityID;
                }
                Commit();
                return Convert.ToInt32(id);


                //SqlConnection con = new SqlConnection();
                //SqlCommand cmd = new SqlCommand();
                //cmd.Connection = con;
                //con.Open();
                ////aaa
                ////
                /////
                //con.Close();
            }
            catch
            {
                Rollback();
                throw;
            }
        }

        public void InsertStatus(int eligibilityStatus, int agreementTypeID)
        {
            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@SubmitEligibility", eligibilityStatus));
            Parameters.Add(new SqlParameter("@AgreementTypeID", agreementTypeID));
            Parameters.Add(new SqlParameter("@Action", "SS"));
            ExecCommand(DBCommands.Eligibility);
        }
        public void Delete(int id)
        {

            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@EligibilityID", id));
            Parameters.Add(new SqlParameter("@Action", "D"));
            ExecCommand(DBCommands.Eligibility);
        }

        public void DeleteMyAgreement(int id)
        {

            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@AgreementTypeID", id));
            Parameters.Add(new SqlParameter("@Action", "DA"));
            ExecCommand(DBCommands.Eligibility);
        }
        public EligibilityEntity Read(int eligibilityID)
        {
            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@EligibilityID", eligibilityID));

            EligibilityEntity entity = new EligibilityEntity();
            SqlDataReader reader = null;
            try
            {
                Parameters.Add(new SqlParameter("@Action", "R"));
                reader = ExecDataReader(DBCommands.Eligibility);
                if (reader.Read())
                {
                    entity.EligibilityID = reader["EligibilityID"].ToInt32();
                    entity.FirstName = reader["FirstName"].ToStr();
                    entity.LastName = reader["LastName"].ToStr();
                    entity.SSN = reader["SSN"].ToStr();
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
        public List<EligibilityEntity> ReadList(int agreementID)
        {
            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@AgreementTypeID", agreementID));
            List<EligibilityEntity> list = new List<EligibilityEntity>();
            SqlDataReader reader = null;
            try
            {
                Parameters.Add(new SqlParameter("@Action", "RL"));
                reader = ExecDataReader(DBCommands.Eligibility);
                while (reader.Read())
                {
                    EligibilityEntity entity = new EligibilityEntity();
                    entity.EligibilityID = reader["EligibilityID"].ToInt32();
                    entity.FirstName = reader["FirstName"].ToStr();
                    entity.LastName = reader["LastName"].ToStr();
                    entity.SSN = reader["SSN"].ToStr();

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
