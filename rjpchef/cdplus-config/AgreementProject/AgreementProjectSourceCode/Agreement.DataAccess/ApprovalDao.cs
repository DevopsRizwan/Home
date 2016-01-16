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
   public class ApprovalDao : SQLDataAccess
    {
       public void Insert(ApprovalEntity entity)
       {
           Parameters = new List<SqlParameter>();
           Parameters.Add(new SqlParameter("@ApprovalID", entity.ApprovalID));
           Parameters.Add(new SqlParameter("@AgreementTypeID", entity.AgreementTypeID));
           Parameters.Add(new SqlParameter("@Actions", entity.Actions));
           Parameters.Add(new SqlParameter("@Comments", entity.Comments));
           Parameters.Add(new SqlParameter("@Status", entity.Status));
           Parameters.Add(new SqlParameter("@Action", "EA"));
           ExecCommand(DBCommands.Approval);
       }

       public ApprovalEntity Read(int id, int approvalID)
       {
           Parameters = new List<SqlParameter>();

           Parameters.Add(new SqlParameter("@AgreementTypeID", id));
           Parameters.Add(new SqlParameter("@ApprovalID", approvalID));
           ApprovalEntity entity = null;
           SqlDataReader reader = null;
           try
           {
               Parameters.Add(new SqlParameter("@Action", "R"));
               reader = ExecDataReader(DBCommands.Approval);
               if (reader.Read())
               {
                   entity = new ApprovalEntity();
                   entity.Status = reader["Status"].ToStr();
                   entity.Actions = reader["Actions"].ToStr();
                   entity.Comments = reader["Comments"].ToStr();
                   if (reader.NextResult())
                   {
                       if (reader.Read())
                       {
                           entity.Title = reader["Title"].ToStr();
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
    }
}
