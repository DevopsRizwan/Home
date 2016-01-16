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
    public class WorkDao : SQLDataAccess
    {
        public int Insert(WorkEntity entity)
        {
            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@WorkID", entity.WorkID));
            Parameters.Add(new SqlParameter("@AgreementTypeID", entity.AgreementTypeID));
            Parameters.Add(new SqlParameter("@ServicesProvided", entity.ServicesProvided));
            Parameters.Add(new SqlParameter("@ServiceDescription", entity.ServiceDescription));
            Parameters.Add(new SqlParameter("@GovernmentMarketingServices", entity.GovernmentMarketingServices));
            Parameters.Add(new SqlParameter("@Lobbying", entity.Lobbying));
            Parameters.Add(new SqlParameter("@NonEmpSalesRepresentation", entity.NonEmpSalesRepresentation));
            Parameters.Add(new SqlParameter("@QuoteDocUniqueName", entity.QuoteDocUniqueName));
            Parameters.Add(new SqlParameter("@QuoteDocName", entity.QuoteDocName));

            object id = null;
            if (entity.WorkID == 0)
            {
                Parameters.Add(new SqlParameter("@Action", "C"));
                id = ExecuteScalar(DBCommands.WorkTable);
            }
            else
            {
                Parameters.Add(new SqlParameter("@Action", "U"));
                ExecCommand(DBCommands.WorkTable);
                id = entity.WorkID;
            }
            return Convert.ToInt32(id);

        }

        public void InsertStatus(int workStatus, int agreementTypeID)
        {
            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@SubmitWork", workStatus));
            Parameters.Add(new SqlParameter("@AgreementTypeID", agreementTypeID));
            Parameters.Add(new SqlParameter("@Action", "SS"));
            ExecCommand(DBCommands.WorkTable);
        }
       

        public WorkEntity Read(int agreementID)
        {

            Parameters = new List<SqlParameter>();

            Parameters.Add(new SqlParameter("@AgreementTypeID", agreementID));
            WorkEntity entity = null;
            SqlDataReader reader = null;
            try
            {
                Parameters.Add(new SqlParameter("@Action", "R"));
                reader = ExecDataReader(DBCommands.WorkTable);
                if (reader.Read())
                {
                    entity = new WorkEntity();
                    entity.WorkID =reader["WorkID"].ToInt32();
                    entity.GovernmentMarketingServices = reader["GovernmentMarketingServices"].ToStr();
                    entity.Lobbying = reader["Lobbying"].ToStr();
                    entity.NonEmpSalesRepresentation = reader["NonEmpSalesRepresentation"].ToStr();
                    entity.ServiceDescription = reader["ServiceDescription"].ToStr();
                    entity.ServicesProvided = reader["ServicesProvided"].ToStr();
                    entity.QuoteDocName = reader["QuoteDocName"].ToStr();
                    entity.QuoteDocUniqueName = reader["QuoteDocUniqueName"].ToStr();
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

    }
}